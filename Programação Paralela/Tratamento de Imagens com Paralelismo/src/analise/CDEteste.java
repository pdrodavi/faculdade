package analise;

import static analise.Analisa.convert;
import static analise.Analisa.convertTiff;
import static analise.Analisa.distanceEuclidian;
import image.mapping.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static javafx.scene.input.KeyCode.T;
import removeme.ImageConverter;

public class CDEteste {

    public static void main(String[] args) throws ExecutionException, IOException {

        // imagem pra splitar, imagem para comparar e a quantidade de pedaços da imagem a ser splitada
        analisadorEuclidianaParalelo("images/paciente1.jpg", "images/paciente_tiff_HEMOGLOBIN.tif", 4);
        //analisadorEuclidianaSerial("images/paciente1.jpg", "images/paciente_tiff_HEMOGLOBIN.tif", 4);
    }

    public static void analisadorEuclidianaParalelo(String pathJPGoriginal, String pathTIFcomparate, int qntdDivisaoIMG) throws ExecutionException {

        // apenas converter e comparar que devem ser paralelos
        // chamar método split
        // pegando a imagem JPG e repartindo
        ImageConverter.splitImage(pathJPGoriginal, qntdDivisaoIMG);

        int cont = 0;
        int cont2 = 0;
        boolean control = true;

        String pathIMGtifCOMPARATE = pathTIFcomparate;

        while (control) {

            //long start = System.currentTimeMillis();
//            List<Callable<String>> listOfCallable = Arrays.asList(
//                    () -> convert("images/splitsJPG/paciente100.jpg"),
//                    () -> convert("images/splitsJPG/paciente101.jpg"),
//                    () -> convert("images/splitsJPG/paciente110.jpg"),
//                    () -> convert("images/splitsJPG/paciente111.jpg"));
            // conversão
            ExecutorService executorConvert = Executors.newCachedThreadPool();

            try {
                

                // teste
                List<Callable<String>> listOfCallableTeste = null;
                File file = new File("images/splitsJPG/");
                File[] arquivos = file.listFiles(); // listando as imagens em lista
                List<Callable<String>> l = new ArrayList<>();

                for (File fileTmp : arquivos) {
                    if (fileTmp.getName().contains(".jpg")) {
                        l.add(() -> convert("images/splitsJPG/" + fileTmp.getName()));
                        //System.out.println("LISTA: " + l.toString());
                        //listOfCallableTeste = Arrays.asList(() -> convert("images/splitsJPG/" + fileTmp.getName()));
                        //listOfCallableTeste.add(() -> convert("images/splitsJPG/" + fileTmp.getName()));
                    }
                }
                
                
                
                List<Future<String>> futures = executorConvert.invokeAll(l);

                for (Future<String> future : futures) {
                    System.out.println(future.get());
                    cont++;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executorConvert.shutdown();
            }

            //long end = System.currentTimeMillis();
            //System.out.println("\n TEMPO FINAL DE CONVERSÃO:" + (end - start));
            // comparação
            if (cont == qntdDivisaoIMG) {
                
                //long start2 = System.currentTimeMillis();
                ExecutorService executorCompare = Executors.newCachedThreadPool();

                // criar método para pegar as imagens tif e armazenar na lsita callable
//                List<Callable<String>> listOfCallable2 = Arrays.asList(
//                        () -> distanceEuclidian("images/splitsJPG/paciente100.tiff", pathIMGtifCOMPARATE),
//                        () -> distanceEuclidian("images/splitsJPG/paciente101.tiff", pathIMGtifCOMPARATE),
//                        () -> distanceEuclidian("images/splitsJPG/paciente110.tiff", pathIMGtifCOMPARATE),
//                        () -> distanceEuclidian("images/splitsJPG/paciente111.tiff", pathIMGtifCOMPARATE));
                try {

                    List<Callable<String>> listOfCallableTeste2 = null;
                    File file = new File("images/splitsJPG/");
                    File[] arquivos = file.listFiles(); // listando as imagens em lista
                    List<Callable<String>> l2 = new ArrayList<>();

                    for (File fileTmp : arquivos) {
                        if (fileTmp.getName().contains(".tif")) {
                            //listOfCallableTeste2 = Arrays.asList(() -> distanceEuclidian("images/splitsJPG/" + fileTmp.getName(), pathIMGtifCOMPARATE));
                            l2.add(() -> distanceEuclidian("images/splitsJPG/" + fileTmp.getName(), pathIMGtifCOMPARATE));
                        }
                    }

                    List<Future<String>> futures = executorCompare.invokeAll(l2);

                    for (Future<String> future : futures) {
                        System.out.println(future.get());
                        cont2++;

                        if (cont2 == qntdDivisaoIMG) {
                            control = false;
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    executorCompare.shutdown();
                }

                //long end2 = System.currentTimeMillis();
                //System.out.println("\n TEMPO FINAL DE COMPARAÇÃO:" + (end2 - start2));
                //System.out.println("\n TEMPO TOTAL EM PARALELO: " + (end + start) + (end2 - start2));
            } // end if

        } // end while

    }

    public static void analisadorEuclidianaSerial(String pathJPGoriginal, String pathTIFcomparate, int qntdDivisaoIMG) throws IOException {

        // chamar método split
        // pegando a imagem JPG e repartindo
        ImageConverter.splitImage(pathJPGoriginal, qntdDivisaoIMG);

        String dirSplitJPG = "images/splitsJPG";

        // abrindo pasta splitsJPGpaciente1
        File file = new File(dirSplitJPG);
        File[] arquivos = file.listFiles(); // listando as imagens em lista

        //convertendo em em tiff
        //long start = System.currentTimeMillis();
        for (File fileTmp : arquivos) {
            convert("images/splitsJPG/" + fileTmp.getName());
        }
        //long end = System.currentTimeMillis();
        //System.out.println("\n TEMPO DE CONVERSÃO SERIAL:" + (end - start));

        // pegando imagens tif e comparando
        String pathImageTif = pathTIFcomparate;
        Image imageTIFcomparate = new Image(Image.componentExtract(pathImageTif), 255);

        //long start2 = System.currentTimeMillis();
        for (File fileTmp : arquivos) {
            if (fileTmp.getName().contains(".tif")) {
                String pathSPLITTIF = fileTmp.getAbsolutePath();
                // CÓDIGO PARA COMPARAÇÃO AQUI
                Image img = new Image(Image.componentExtract(pathSPLITTIF), 255);
                System.out.println("Distância Euclidiana: " + img.compareEuclideanDistance(imageTIFcomparate));
            }
        }
        //long end2 = System.currentTimeMillis();
        //System.out.println("\n TEMPO DE COMPARAÇÃO SERIAL:" + (end2 - start2));

        //System.out.println("\n TEMPO FINAL DO CÓDIGO SERIAL:" + (end - start) + (end2 + start2));
    }

    public static String convert(String pathIMGjpg) {
        // abrindo diretório que contém as imagens tif
        File file = new File(pathIMGjpg);
        // convertendo em em tif
        String retorno = convertTiff(pathIMGjpg); // retorna a saída do arquivo gravado
        return retorno;
    }

    public static String distanceEuclidian(String pathIMG, String pathTIFcomparate) throws IOException {

        String pathImageTif = pathTIFcomparate;
        //String pathImageTif = "images/paciente_tiff_HEMOGLOBIN.tif";
        Image imageTIFcomparate = new Image(Image.componentExtract(pathImageTif), 255);

        Image img = new Image(Image.componentExtract(pathIMG), 255);
        //System.out.println("Distância Euclidiana: " + img.compareEuclideanDistance(imageTIFcomparate));

        String retorno = String.valueOf("Distância Euclidiana " + pathIMG + ": " + img.compareEuclideanDistance(imageTIFcomparate));

        return retorno;
    }

}
