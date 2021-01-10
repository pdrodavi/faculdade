package analise;

import com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi;
import image.mapping.Image;
import jai.ImageType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import removeme.ImageConverter;

public class AnalisaSerial {

    public static void main(String[] args) throws IOException {

        // 1º - RODA O SPLIT
        // 2º - RODA O CONVERT
        // 3º - RODA O COMPARAR
        
        // pegando a imagem JPG e repartindo
        String dirOriginalJPG = "images/paciente1.jpg";
        //ImageConverter.splitImage(dirOriginalJPG, 4);

        String dirSplitJPG = "images/splitsJPG";

        // abrindo pasta splitsJPGpaciente1
        File file = new File(dirSplitJPG);
        File[] arquivos = file.listFiles(); // listando as imagens em lista

        //convertendo em em tiff
        for (File fileTmp : arquivos) {
            convertTiff("images/splitsJPG/" + fileTmp.getName());
        }
        
        
        // pegando imagens tif e comparando
        String pathImageTif = "images/paciente_tiff_HEMOGLOBIN.tif";
        Image imageTIFcomparate = new Image(Image.componentExtract(pathImageTif), 255);
        
        for (File fileTmp : arquivos) {
            if(fileTmp.getName().contains(".tif")){
                String pathSPLITTIF = fileTmp.getAbsolutePath();
                // CÓDIGO PARA COMPARAÇÃO AQUI
                Image img = new Image(Image.componentExtract(pathSPLITTIF), 255);
                System.out.println("Distância Euclidiana: " + img.compareEuclideanDistance(imageTIFcomparate));
            }
        }
        
        //Image imageTIFFComparate = new Image(Image.componentExtract(patchImageTIFF), 255);
        //Image img = new Image(Image.componentExtract(path), 255);
        //img.compareCosineSimilarity(imageTIFFComparate);

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
    
    public static void serialExecutor(String pathIMGjpg) throws IOException{
        

        // abrindo diretório que contém as imagens tif
        File fileJPG = new File(pathIMGjpg);
        // convertendo em em tif
        convertTiff(pathIMGjpg); // retorna a saída do arquivo gravado
            
        
        // pegando imagens tif e comparando
        String pathImageTif = "images/paciente_tiff_HEMOGLOBIN.tif";
        Image imageTIFcomparate = new Image(Image.componentExtract(pathImageTif), 255);
        
        
        String dirSplitJPG = "images/splitsJPG";
        // abrindo pasta splitsJPGpaciente1
        File file = new File(dirSplitJPG);
        File[] arquivos = file.listFiles(); // listando as imagens em lista
        
        // comparando distância euclidiana
        for (File fileTmp : arquivos) {
            if(fileTmp.getName().contains(".tif")){
                String pathSPLITTIF = fileTmp.getAbsolutePath();
                // CÓDIGO PARA COMPARAÇÃO AQUI
                Image img = new Image(Image.componentExtract(pathSPLITTIF), 255);
                System.out.println("Distância Euclidiana da imagem " + fileTmp.getName() + ":" + img.compareEuclideanDistance(imageTIFcomparate));
            }
        }
    	
    }
    
}
