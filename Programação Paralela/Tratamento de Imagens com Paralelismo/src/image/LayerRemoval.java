package image;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.fastica.FastICA;
import org.fastica.FastICAException;

import Jama.Matrix;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

public class LayerRemoval {
	private static int shade = 16;
	private static int hemoglobin = 10;
	private static int melanin = 4;
	private static int flesh = 32;
	private Matrix[] melaninLayer;
	private Matrix[] hemoglobinLayer;
	private Raster decoderRaster;
	private Raster finalRaster;

	public LayerRemoval(String fileName) throws IOException {
		File file = new File(fileName);
		SeekableStream stream = new FileSeekableStream(file);
		
		TIFFDecodeParam param = null;
		ImageDecoder dec = ImageCodec.createImageDecoder("tiff", stream, param);
		this.decoderRaster = dec.decodeAsRaster();
		
		melaninLayer = componentExtract(melanin, fileName, stream);
		hemoglobinLayer = componentExtract(hemoglobin, fileName, stream);
	}

	public Matrix[] getMelaninLayer() {
		return melaninLayer;
	}

	public Matrix[] getHemoglobinLayer() {
		return hemoglobinLayer;
	}
	
	public Raster getDecoderRaster() {
		return decoderRaster;
	}
	
	public Raster getFinalRaster() {
		return finalRaster;
	}

	private Matrix[] componentExtract(int option, String fileName, SeekableStream stream) throws IOException {
		Matrix r = new Matrix(new double[decoderRaster.getHeight()][decoderRaster
				.getWidth()]);
		Matrix g = new Matrix(new double[decoderRaster.getHeight()][decoderRaster
				.getWidth()]);
		Matrix b = new Matrix(new double[decoderRaster.getHeight()][decoderRaster
				.getWidth()]);

		for (int i = 0; i < decoderRaster.getHeight(); i++) {
			for (int j = 0; j < decoderRaster.getWidth(); j++) {
				double[] pixelChannels = new double[3];
				pixelChannels = decoderRaster.getPixel(i, j, pixelChannels);

				r.set(i, j, pixelChannels[0] / 255);
				g.set(i, j, pixelChannels[1] / 255);
				b.set(i, j, pixelChannels[2] / 255);
			}
		}

		int dotIndex = fileName.indexOf('.');
		String finalFileName = fileName.substring(0, dotIndex);
		String extension = fileName.substring(dotIndex);

		// Component rate
		int c1_amount = 0;
		int c2_amount = 0;
		int c0_amount = 0;
		int Cshade_amount = 0;

		if ((option & shade) != 0) {
			Cshade_amount = 1;

			finalFileName += "_SHADE";
		}
		if ((option & hemoglobin) != 0) {
			c1_amount = 1;
			c0_amount = 1;

			finalFileName += "_HEMOGLOBIN";
		}
		if ((option & melanin) != 0) {
			c2_amount = 1;
			Cshade_amount = 1;

			finalFileName += "_MELANIN";
		}
		if ((option & flesh) != 0) {
			c2_amount = 1;
			c0_amount = 1;

			finalFileName += "_FLESH";
		}

		// Log
		Matrix rL = log(r);
		Matrix gL = log(g);
		Matrix bL = log(b);

		Matrix s = conc(rL.transpose().getRowPackedCopy(), gL.transpose()
				.getRowPackedCopy(), bL.transpose().getRowPackedCopy());

		/*
		 * Image Analysis to find mixing matrix
		 */

		double[][] separatingMatrix = fastICA(s.getArray());

		for (int i = 0; i < separatingMatrix.length; i++) {
			for (int j = 0; j < separatingMatrix[0].length; j++) {
				separatingMatrix[i][j] = Math.abs(separatingMatrix[i][j]);
			}
		}

		new Matrix(separatingMatrix).print(1, 3);

		double[] c_bas1 = new double[3];
		double[] c_bas2 = new double[3];

		for (int i = 0; i < separatingMatrix.length; i++) {
			c_bas1[i] = separatingMatrix[i][0];
			c_bas2[i] = separatingMatrix[i][1];
		}

		// Component extract
		Matrix compSynM = conc(c_bas1, c_bas2, new double[] { 1, 1, 1 })
				.transpose();

		Matrix compExtM = compSynM.inverse();
		Matrix componentMatrix = compExtM.times(s);
		double[][] component = componentMatrix.getArray();

		double[] minComp = minComp(component);

		// Component changing process

		for (int i = 0; i < component[0].length; i++) {
			component[0][i] = c0_amount * minComp[0]
					+ (component[0][i] - minComp[0]) * c1_amount;
			component[1][i] = c0_amount * minComp[1]
					+ (component[1][i] - minComp[1]) * c2_amount;
			component[2][i] = Cshade_amount * component[2][i];
		}

		// Component synthesis
		Matrix sp = compSynM.times(new Matrix(component));
		double[][] spExp = exp(sp).getArray();

		double[] rp = new double[spExp[0].length];
		double[] gp = new double[spExp[0].length];
		double[] bp = new double[spExp[0].length];

		for (int i = 0; i < spExp[0].length; i++) {
			rp[i] = spExp[0][i];
			gp[i] = spExp[1][i];
			bp[i] = spExp[2][i];
		}

		// Reshape
		Matrix rReshaped = new Matrix(reshape(rp, r.getColumnDimension()))
				.transpose();
		Matrix gReshaped = new Matrix(reshape(gp, g.getColumnDimension()))
				.transpose();
		Matrix bReshaped = new Matrix(reshape(bp, b.getColumnDimension()))
				.transpose();

		// Re-encoding
		File newFile = new File(finalFileName + extension);
		saveToFile(decoderRaster, rReshaped, gReshaped, bReshaped, newFile);
		
		return new Matrix[] { rReshaped.times(255), gReshaped.times(255), bReshaped.times(255) };
	}

	private void saveToFile(Raster decRaster, Matrix rReshaped,
			Matrix gReshaped, Matrix bReshaped, File newFile)
			throws FileNotFoundException, IOException {
		OutputStream outputStream = new FileOutputStream(newFile);

		ImageEncoder codec = ImageCodec.createImageEncoder("tiff",
				outputStream, null);

		WritableRaster encRaster = decRaster.createCompatibleWritableRaster();

		for (int i = 0; i < rReshaped.getRowDimension(); i++) {
			for (int j = 0; j < rReshaped.getColumnDimension(); j++) {
				encRaster.setPixel(i, j, new double[] { rReshaped.get(i, j) * 255,
						gReshaped.get(i, j) * 255, bReshaped.get(i, j) * 255 });
			}
		}

		ColorModel colorModel = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_sRGB), false, false,
				Transparency.OPAQUE, DataBuffer.TYPE_FLOAT);
		codec.encode(encRaster, colorModel);
		
		this.finalRaster = encRaster;
	}

	private double[][] fastICA(double[][] s) {
		try {
			System.out.print(s.length + " x ");
			System.out.println(s[0].length);

			FastICA ica = new FastICA(s, 2);

			return ica.getMixingMatrix();
		} catch (FastICAException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Matrix log(Matrix matrix) {
		double[][] result = new double[matrix.getRowDimension()][matrix
				.getColumnDimension()];

		for (int i = 0; i < matrix.getRowDimension(); i++) {
			for (int j = 0; j < matrix.getColumnDimension(); j++) {
				result[i][j] = -Math.log(matrix.get(i, j));
			}
		}

		return new Matrix(result);
	}

	private static Matrix exp(Matrix matrix) {
		double[][] result = new double[matrix.getRowDimension()][matrix
				.getColumnDimension()];

		for (int i = 0; i < matrix.getRowDimension(); i++) {
			for (int j = 0; j < matrix.getColumnDimension(); j++) {
				result[i][j] = Math.exp(-matrix.get(i, j));
			}
		}

		return new Matrix(result);
	}

	private static double[][] reshape(double[] array, int size) {
		double[][] result = new double[array.length / size][size];

		int counter = 0;
		int line = 0;
		for (int i = 0; i < array.length; i++) {
			if (counter == size) {
				counter = 0;
				line++;
			}

			result[line][counter] = array[i];
			counter++;
		}

		return result;
	}

	private static Matrix conc(double[] arg1, double[] arg2, double[] arg3) {
		if (arg1.length != arg2.length && arg2.length != arg3.length) {
			throw new RuntimeException("arrays with different length.");
		}

		double[][] result = new double[3][arg1.length];

		for (int i = 0; i < arg1.length; i++) {
			result[0][i] = arg1[i];
		}
		for (int i = 0; i < arg2.length; i++) {
			result[1][i] = arg2[i];
		}
		for (int i = 0; i < arg3.length; i++) {
			result[2][i] = arg3[i];
		}

		return new Matrix(result);
	}

	private static double[] minComp(double[][] matrix) {
		double[] result = new double[2];

		double min1 = Double.MAX_VALUE;
		double min2 = Double.MAX_VALUE;

		for (int i = 0; i < matrix[0].length; i++) {
			double current = matrix[0][i];

			if (current < min1) {
				min1 = current;
			}

			double current2 = matrix[1][i];

			if (current2 < min2) {
				min2 = current2;
			}
		}

		result[0] = min1;
		result[1] = min2;

		return result;
	}

}
