package analise;

import com.github.jaiimageio.impl.plugins.tiff.TIFFImageWriterSpi;
import image.mapping.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class Analisa {

    public static void main(String[] args) throws ExecutionException {

        int cont = 0;
        int cont2 = 0;
        boolean control = true;

        while (control) {

            long start = System.currentTimeMillis();

            // conversão
            ExecutorService executorConvert = Executors.newCachedThreadPool();

            List<Callable<String>> listOfCallable = Arrays.asList(
                    () -> convert("images/splitsJPG/paciente100.jpg"),
                    () -> convert("images/splitsJPG/paciente101.jpg"),
                    () -> convert("images/splitsJPG/paciente110.jpg"),
                    () -> convert("images/splitsJPG/paciente111.jpg"));
            try {

                List<Future<String>> futures = executorConvert.invokeAll(listOfCallable);

                for (Future<String> future : futures) {
                    System.out.println(future.get());
                    cont++;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executorConvert.shutdown();
            }

            long end = System.currentTimeMillis();
            System.out.println("\n TEMPO FINAL DE OONVERSÃO:" + (end - start));

            // comparação
            if (cont == 4) {

                long start2 = System.currentTimeMillis();

                ExecutorService executorCompare = Executors.newCachedThreadPool();

                List<Callable<String>> listOfCallable2 = Arrays.asList(
                        () -> distanceEuclidian("images/splitsJPG/paciente100.tiff"),
                        () -> distanceEuclidian("images/splitsJPG/paciente101.tiff"),
                        () -> distanceEuclidian("images/splitsJPG/paciente110.tiff"),
                        () -> distanceEuclidian("images/splitsJPG/paciente111.tiff"));

                try {

                    List<Future<String>> futures = executorCompare.invokeAll(listOfCallable2);

                    for (Future<String> future : futures) {
                        System.out.println(future.get());
                        cont2++;

                        if (cont2 == 4) {
                            control = false;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    executorCompare.shutdown();
                }

                long end2 = System.currentTimeMillis();
                System.out.println("\n TEMPO FINAL DE COMPARAÇÃO:" + (end - start));

            } // end if

        } // end while

    } // end main

    public static String convert(String pathIMGjpg) {
        // abrindo diretório que contém as imagens tif
        File file = new File(pathIMGjpg);
        // convertendo em em tif
        String retorno = convertTiff(pathIMGjpg); // retorna a saída do arquivo gravado
        return retorno;
    }

    public static String distanceEuclidian(String pathIMG) throws IOException {

        String pathImageTif = "images/paciente_tiff_HEMOGLOBIN.tif";
        Image imageTIFcomparate = new Image(Image.componentExtract(pathImageTif), 255);

        Image img = new Image(Image.componentExtract(pathIMG), 255);
        //System.out.println("Distância Euclidiana: " + img.compareEuclideanDistance(imageTIFcomparate));

        String retorno = String.valueOf("Distância Euclidiana " + pathIMG + ": " + img.compareEuclideanDistance(imageTIFcomparate));

        return retorno;
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

}
