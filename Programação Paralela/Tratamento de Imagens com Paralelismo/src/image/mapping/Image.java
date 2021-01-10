package image.mapping;

import image.Histogram;

import java.util.Map;

import space.Coordinate;
import space.CosineSimilarity;
import space.Distance;
import Jama.Matrix;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import space.EuclideanDistance;

public class Image {
    
	private Matrix[] layers;
	private Matrix[] hsv;
	private String label;
	private Coordinate[] coordinate;
	private Histogram histogram; 
	
	public Image(Matrix[] layers, int maxValue) {
		this.layers = layers;
		this.hsv = rgbTohsv(normalize(layers));
		histogram = new Histogram(layers, maxValue);
		this.coordinate = mapImage(histogram);
	}

	private Matrix[] rgbTohsv(Matrix[] rgb) {
		double[][] h = new double[rgb[0].getRowDimension()][rgb[0].getColumnDimension()];
		double[][] s = new double[rgb[0].getRowDimension()][rgb[0].getColumnDimension()];
		double[][] v = new double[rgb[0].getRowDimension()][rgb[0].getColumnDimension()];
		
		for (int i = 0; i < h.length; i++) {
			for (int j = 0; j < h[0].length; j++) {
				double r = rgb[0].get(i, j);
				double g = rgb[1].get(i, j);
				double b = rgb[2].get(i, j);
				double max = Math.max(r, Math.max(g, b));
				double min = Math.min(r, Math.min(g, b));

				if (max == min) {
					h[i][j] = 0;
				} else if (max == r) {
					if (g >= b) {
						h[i][j] = 60 * ((g - b) / (max - min));		
					} else {
						h[i][j] = 60 * ((g - b) / (max - min)) + 360;
					}
				} else if (max == g) {
					h[i][j] = 60 * ((b - r) / (max - min)) + 120;
				} else if (max == b) {
					h[i][j] = 60 * ((r - g) / (max - min)) + 240;
				} else {
					h[i][j] = 0;
				}
				
				s[i][j] = (max - min) / max;
				v[i][j] = max;
			}
		}
		
		return new Matrix[] { new Matrix(h), new Matrix(s), new Matrix(v) };
	}

	private Matrix[] normalize(Matrix[] layers2) {
		Matrix[] result = new Matrix[layers2.length];
		
		
		for (int i = 0; i < result.length; i++) {
			double[][] matrix = new double[layers2[i].getRowDimension()][layers2[i].getColumnDimension()];
			
			for (int j = 0; j < matrix.length; j++) {
				for (int j2 = 0; j2 < matrix[0].length; j2++) {
					matrix[j][j2] = layers2[i].get(j, j2) / 255;
				}
			}
			
			result[i] = new Matrix(matrix);
		}
		
		return result;
	}

//	private Coordinate[] mapImage(Histogram histogram) {
//		double[] rAxis = new double[256];
//		Map<Integer, Integer> rMap = histogram.getRColorMap();
//		
//		for (int i = 0; i < rAxis.length; i++) {
//			Integer value = rMap.get(i); 
//			
//			if (value == null) {
//				value = 0;
//			}
//			
//			rAxis[i] = value;  
//		}
//		
//		double[] gAxis = new double[256];
//		Map<Integer, Integer> gMap = histogram.getGColorMap();
//		
//		for (int i = 0; i < gAxis.length; i++) {
//			Integer value = gMap.get(i); 
//			
//			if (value == null) {
//				value = 0;
//			}
//			
//			gAxis[i] = value;  
//		}
//		
//		double[] bAxis = new double[256];
//		Map<Integer, Integer> bMap = histogram.getBColorMap();
//		
//		for (int i = 0; i < bAxis.length; i++) {
//			Integer value = bMap.get(i); 
//			
//			if (value == null) {
//				value = 0;
//			}
//			
//			bAxis[i] = value;  
//		}
//		
//		return new Coordinate[] { new Coordinate(rAxis), new Coordinate(gAxis), new Coordinate(bAxis) };
//	}

	private Coordinate[] mapImage(Histogram histogram) {
		double[] rAxis = new double[256];
		Map<Integer, Integer> rMap = histogram.getRColorMap();
		
		for (int i = 0; i < rAxis.length; i++) {
			Integer value = rMap.get(i); 
			
			if (value == null) {
				value = 0;
			}
			
			rAxis[i] = (value > 0) ? 1 : 0;  
		}
		
		double[] gAxis = new double[256];
		Map<Integer, Integer> gMap = histogram.getGColorMap();
		
		for (int i = 0; i < gAxis.length; i++) {
			Integer value = gMap.get(i); 
			
			if (value == null) {
				value = 0;
			}
			
			gAxis[i] = (value > 0) ? 1 : 0;  
		}
		
		double[] bAxis = new double[256];
		Map<Integer, Integer> bMap = histogram.getBColorMap();
		
		for (int i = 0; i < bAxis.length; i++) {
			Integer value = bMap.get(i); 
			
			if (value == null) {
				value = 0;
			}
			
			bAxis[i] = (value > 0) ? 1 : 0;  
		}
		
		return new Coordinate[] { new Coordinate(rAxis), new Coordinate(gAxis), new Coordinate(bAxis) };
	}

	public double compare(Image image) {
            
		double result = 0;
		Distance distance = new CosineSimilarity();
		
		Coordinate[] coordinates = image.getCoordinate();
		for (int i = 0; i < coordinates.length; i++) {
			result += distance.measure(this.coordinate[i], coordinates[i]);
		}

		return result / coordinates.length;
	}
        
        	public double compareCosineSimilarity(Image image) {
		double result = 0;
		CosineSimilarity distance = new CosineSimilarity();
		
		Coordinate[] coordinates = image.getCoordinate();
		for (int i = 0; i < coordinates.length; i++) {
			result += distance.measure(this.coordinate[i], coordinates[i]);
		}

		return result / coordinates.length;
	}
	
	public double compareEuclideanDistance(Image image) {

		EuclideanDistance dist = new EuclideanDistance();
		double avg = 0;
		
		for (int i = 0; i < this.coordinate.length; i++) {
			avg += dist.measure(this.getCoordinate()[i], image.getCoordinate()[i]);	
		}
		
		return avg /= this.coordinate.length;
	}
        
        public static Matrix[] componentExtract(String fileName)
			throws IOException {
		File file = new File(fileName);
		SeekableStream stream = new FileSeekableStream(file);

		TIFFDecodeParam param = null;

		ImageDecoder dec = ImageCodec.createImageDecoder("tiff", stream, param);
		Raster decRaster = dec.decodeAsRaster();

		Matrix r = new Matrix(new double[decRaster.getHeight()][decRaster.getWidth()]);
		Matrix g = new Matrix(new double[decRaster.getHeight()][decRaster.getWidth()]);
		Matrix b = new Matrix(new double[decRaster.getHeight()][decRaster.getWidth()]);

		for (int i = 0; i < decRaster.getHeight(); i++) {
			for (int j = 0; j < decRaster.getWidth(); j++) {
				double[] pixelChannels = new double[3];
				pixelChannels = decRaster.getPixel(i, j, pixelChannels);

				r.set(i, j, pixelChannels[0]);
				g.set(i, j, pixelChannels[1]);
				b.set(i, j, pixelChannels[2]);
			}
		}
		
		return new Matrix[] { r, g, b};
	}

	
	public Matrix[] getLayers() {
		return layers;
	}

	public Histogram getHistogram() {
		return histogram;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Coordinate[] getCoordinate() {
		return coordinate;
	}

	public boolean hasCoordinate() {
		return (coordinate == null) ? false : true;
	}
	
	public boolean isInside(Coordinate coordinate) {
		return coordinate.equals(this.coordinate);
	}
}
