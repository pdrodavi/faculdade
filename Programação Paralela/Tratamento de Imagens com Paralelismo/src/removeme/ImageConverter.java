package removeme;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.stream.ImageOutputStream;

import com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi;

public class ImageConverter {

	public static void main(String[] args) {
		
		String input = "images/converter/teste1.jpg";

		
		//ImageConverter.resizeFile(espelho, input, output);

		ImageConverter.convertTiff(input);
		
		//ImageConverter.splitImage(output, 64);
	}	
        
        //converte uma imagem jpg em tif. Param: Path eh o caminho do arquivo
	public static String convertTiff(String path) {
		
		BufferedImage image;
		String output = "";
                
		try {
			image = ImageIO.read(new File(path));
			
			TIFFImageWriterSpi tiffspi = new TIFFImageWriterSpi();
                        ImageWriter writer = tiffspi.createWriterInstance();

                        ImageWriteParam param = writer.getDefaultWriteParam();
                        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);


                        /* Caso queira colocar em formato TIFF com modo de compressao
                        param.setCompressionType("JPEG");
                        param.setCompressionQuality(1);
                        */

                        output = path.replaceAll("jpg", "tiff");

                        File fOutputFile = new File(output);
                        ImageOutputStream ios = ImageIO.createImageOutputStream(fOutputFile);
                        writer.setOutput(ios);
                        writer.write(null, new IIOImage(image, null, null), param);
			
			//ImageIO.write(image, "tiff", new File(output));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return output;
	}
	

	
        //Converte uma imagem jpg em Tif, aplicando um recorte quadrático 
	public static String convertTiffAndCrop(String path) {
		
		BufferedImage image, outImage;
		String output = "";
		try {
			image = ImageIO.read(new File(path));

			output = path.replaceAll("jpg", "tif");
			
			if(image.getHeight() < image.getWidth()) {  //se a largura for maior que a altura, corta o quadrado com base na altura
				outImage = ImageConverter.cropHorizontal(image, image.getHeight());
			}else if (image.getHeight() > image.getWidth()) {  //se a altura for maior que a largura, corta o quadrado com base na largura
				outImage = ImageConverter.cropVertical(image, image.getWidth());
			}else { 										// se a imagem for quadrada, apenas converte em formato Tif
				outImage = image;
			}
			
			ImageIO.write(outImage, "tiff", new File(output));

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return output;
	}
        
        //Reparte uma imagem quadrada em novas imagens e salva todas dentro de uma pasta criada no diretório filePath
	public static List<String> splitImage(String filePath, int quantidade) {

		List<String> filesName = new ArrayList<String>();
		File file = new File(filePath);
		
		String nameFile = file.getName().split("\\.")[0];
		String newPath = file.getParentFile().getAbsolutePath() + "\\splitsJPG";
		
                
		if (!new File(newPath).mkdirs()) {
                        
                        try{
                            System.out.println("Já existe uma pasta criada!");
                        } catch (Exception e){
                        
                        }
			//throw new RuntimeException( "Não foi possível criar a pasta destino das imagens divididas. Talvez a pasta já exista!");
		}
	
		double slices = Math.sqrt(quantidade);
			
		if ( slices % 1 != 0) {
			throw new RuntimeException("O número deve ser um quadrado perfeito!");
		}
		
		int tamPadrao =  (int) slices;
		
		
		try {
			
			BufferedImage originalImgage = ImageIO.read(file);

			//total width and total height of an image
			int tWidth = originalImgage.getWidth();
			int tHeight = originalImgage.getHeight();

			
			//width and height of each piece
			int eWidth = tWidth / tamPadrao;
			int eHeight = tHeight / tamPadrao;
		
			int x = 0;
			int y = 0;

			for (int i = 0; i < tamPadrao; i++) {
				y = 0;
				for (int j = 0; j < tamPadrao; j++) {
					try {
						//System.out.println("parte da imagem: "+i+" "+j);
						BufferedImage SubImgage = originalImgage.getSubimage(y, x, eWidth, eHeight);
						File outputfile = new File(newPath +"/" + nameFile + i + j + ".jpg");
						ImageIO.write(SubImgage, "jpg", outputfile);
					
						filesName.add(outputfile.getAbsolutePath());
						
						y += eWidth;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				x += eHeight;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filesName;

	}
	
	public static BufferedImage cropHorizontal(BufferedImage image, int h) {
		int width = image.getWidth();

		// Coordinates of the image's middle
		int xc = (width - h) / 2;

		BufferedImage croppedImage = image.getSubimage(xc, 0, h,  h );
		return croppedImage;
	}
	
	public static BufferedImage cropVertical(BufferedImage image, int w) {
		
		int height = image.getHeight();

		// Coordinates of the image's middle
		int yc = (height - w) / 2;

		BufferedImage croppedImage = image.getSubimage(0, yc, w,  w );
		return croppedImage;

	}
	
	public static BufferedImage cropProporcional(BufferedImage image, double amount, int x, int y, int w, int h) {
		int height = image.getHeight();
		int width = image.getWidth();

		int targetWidth = (int)(width * amount);
		int targetHeight = (int)(height * amount);
		// Coordinates of the image's middle
		int xc = (width - targetHeight) / 2;
		int yc = (height - targetHeight) / 2;

		// Crop
		//        System.out.println("\n" + width + "-"+ height );
		//        System.out.println("\n" + xc + "-"+ yc + "-"+ targetWidth + "-"+ targetHeight);

		BufferedImage croppedImage = image.getSubimage(xc, 0, w,  h );
		return croppedImage;

	}

	public static BufferedImage resize(BufferedImage inputImage, int scaledWidth, int scaledHeight)
					throws IOException {


		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth,
				scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		
		return outputImage;
	}
	
	public static String resizeFile(String espelhoPath, String inputImagePath, String outputImagePath) {

		int tamanhoPadrao = 0;
		File inputFile = new File(inputImagePath);
		File espelhoFile = new File(espelhoPath);
		
		BufferedImage inputImage = null;
		BufferedImage espelhoImage = null;
		
		try {
			
			inputImage = ImageIO.read(inputFile);
			espelhoImage = ImageIO.read(espelhoFile);
			
			tamanhoPadrao = espelhoImage.getHeight();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// creates output image
		BufferedImage outputImage = new BufferedImage(tamanhoPadrao, tamanhoPadrao, BufferedImage.TYPE_INT_RGB);

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, tamanhoPadrao, tamanhoPadrao, null);
		g2d.dispose();

		// writes to output file
		try {
			ImageIO.write(outputImage, "tif", new File(outputImagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outputImagePath;
	}


}
