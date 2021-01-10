package jai;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.JEditorPane;
import javax.swing.Renderer;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.PNGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codecimpl.JPEGImageEncoder;
import com.sun.media.jai.codecimpl.PNGImageEncoder;
import com.sun.media.jai.codecimpl.TIFFImageEncoder;

public final class ImageConverter {
	
	private static String fileInExtension;
	private static ImageType imageInType;
	private static PlanarImage planarImageIn;
	private static ByteArrayOutputStream out;
	
	public static void imageConvert(File imageIn, File imageOut, ImageType imageOutType){
		/* Getting the extension from fileIn */
		String extension = getExtension(imageIn.getAbsolutePath()).toUpperCase();
		setFileInExtension(extension);
		setImageInType(getFileInExtension());

		try {
			convert(imageIn, imageInType, imageOut, imageOutType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void convert(File imageIn, ImageType imageInType, File imageOut, ImageType imageOutType) throws IOException{
		/* Declaring the Decoders */
		ImageDecoder imageInDecoder = null;
		ImageEncoder imageOutEncoder = null;
		try {
			/* 
			 * The steps to convert the image are:
			 * 1. Create the Decoder to the ImageIn (the image that will be converted).
			 * 2. Decode the imageIn to a planarImage.
			 * 3. Create the encoder.
			 * 4. Encode and Write the file at the specified path. 
			 */
			
			/* Creating the Decoder for the imageInType*/
			imageInDecoder = getCorrectDecoder(imageInType, imageIn);
			
			/* Creating the image */
			RenderedImage renderedImage = imageInDecoder.decodeAsRenderedImage();
			planarImageIn = JAI.create("fileload", imageIn.getAbsolutePath());
			
			/* Creating the Encoder */
			imageOutEncoder = getCorrectEncoder(imageOutType);
			
			/* Encoding and writing File */
			imageOutEncoder.encode(renderedImage);
			byte [] Image = out.toByteArray();
			out.flush();
			
			FileOutputStream fileOutputStream = new FileOutputStream(imageOut.getAbsolutePath());
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
			
			writeImage(Image, bufferedOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeImage(byte[] image, BufferedOutputStream bufferedOutputStream) throws IOException{
		try {
			bufferedOutputStream.write(image);
			bufferedOutputStream.close();
			System.out.println("OUTPUT: "+new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ImageEncoder getCorrectEncoder(ImageType imageOutType){
		out = new ByteArrayOutputStream();
		
		if (imageOutType.getType().equals("PNG")){
			PNGEncodeParam pngEncodeParam = PNGEncodeParam.getDefaultEncodeParam(planarImageIn);
			PNGImageEncoder pngImageEncoder = new PNGImageEncoder(out, pngEncodeParam);
			return pngImageEncoder;
		} 
		
		else if (imageOutType.getType().equals("TIF")){
			TIFFEncodeParam TiffEncodeParam = new TIFFEncodeParam();
			/* Tiff CompressionParam is a Bitonal File using Compression Level 4 */
			TiffEncodeParam.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
			TIFFImageEncoder tiffImageEncoder = new TIFFImageEncoder(out, TiffEncodeParam);
			return tiffImageEncoder;
		} 
		
		else if (imageOutType.getType().equals("JPG")){
			JPEGEncodeParam JpegEncodeParam = new JPEGEncodeParam();
			JPEGImageEncoder jpegImageEncoder = new JPEGImageEncoder(out, JpegEncodeParam);
			return jpegImageEncoder;
		}
		return null;
	}
	
	private static ImageDecoder getCorrectDecoder(ImageType imageInType, File imageIn) throws IOException{
		ImageDecoder decoder = null;
		if (imageInType.getType().equals("JPG")){
			decoder = ImageCodec.createImageDecoder("JPEG", imageIn, null);	
		} else if (imageInType.getType().equals("PNG")){
			decoder = ImageCodec.createImageDecoder("PNG", imageIn, null);
		} else if (imageInType.getType().equals("TIF")){
			TIFFEncodeParam TiffEncodeParam = new TIFFEncodeParam();
			/* Tiff CompressionParam is a Bitonal File using Compression Level 4 */
			TiffEncodeParam.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
			decoder = ImageCodec.createImageDecoder("TIFF", imageIn, TiffEncodeParam);
		}
		return decoder;
	}
	
	/* Method to get Extension from Files */
	public static String getExtension(String absolutePath){
		int index = absolutePath.lastIndexOf(".")+1;
		String ext = absolutePath.substring(index);
		return ext;
	}
	
	private static String getFileInExtension() {
		return fileInExtension;
	}

	private static void setFileInExtension(String fileInExt) {
		fileInExtension = fileInExt;
	}
	
	private static void setImageInType(String fileInExtension) {
		/* Setting the value for ImageInType (Enum) */
		for (ImageType imageType: ImageType.values()){
			if (imageType.getType().equals(fileInExtension.toUpperCase())){
				imageInType = imageType;
			}
		}
	}
}
