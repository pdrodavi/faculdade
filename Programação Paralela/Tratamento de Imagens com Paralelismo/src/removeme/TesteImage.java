package removeme;

import image.mapping.Image;

import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.media.jai.PlanarImage;

import space.Coordinate;
import space.Distance;
import space.EuclideanDistance;
import Jama.Matrix;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

public class TesteImage {


	public static void main(String[] args) throws IOException {
		String filename01 = "images/skin_HEMOGLOBIN.tif";
		String filename02 = "images/paciente_tiff.tif";
		
		//filename01 = ImageConverter.convertTiffAndCrop(filename01);
		//filename02 = ImageConverter.convertTiffAndCrop(filename02);
		
		Image image01 = new Image(Image.componentExtract(filename01), 255);
		Image image02 = new Image(Image.componentExtract(filename02), 255);
		
		double similarityCosine = image01.compareCosineSimilarity(image02);
		System.out.printf("\nSIMILARIDADE COSENO: %s -> %s: %.2f%%\n", filename01, filename02, (similarityCosine * 100));

		double euclidean = image01.compareEuclideanDistance(image02);
		System.out.printf("\nDistância Euclidiana: %s -> %s: %.2f\n", filename01, filename02, euclidean);
		
	}

	

	
	
}
