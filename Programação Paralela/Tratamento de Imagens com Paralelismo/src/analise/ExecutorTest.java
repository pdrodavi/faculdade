package analise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import com.sun.jmx.snmp.tasks.ThreadService;

import image.mapping.Image;
import removeme.TesteHistogram;

public class ExecutorTest{
    public static void main(String args[]){
    	
    	String pasta = "images/processamentoPesado/";
    	
    	long start = System.currentTimeMillis();
    	
    	//ExecutorTest.serialExecutor(pasta);
    	ExecutorTest.parallelExecutor(pasta, start);
    	
    	long end = System.currentTimeMillis();
    	System.out.println("\n TEMPO FINAL:" + (end - start));
    	
    	
    }   
    
    public static void serialExecutor(String pasta){
    	List<String> listaArquivos = ExecutorTest.listAllFiles(pasta);
    	for(String arquivoNome: listaArquivos) {
    		ExecutorTest.processamentoTarefa(arquivoNome);
    	}
    	
    }
    
    public static void parallelExecutor(String pasta, long tempoInicial){

    	List<String> listaArquivos = ExecutorTest.listAllFiles(pasta);
  //  	System.out.println("Qtde processadores:" + Runtime.getRuntime().availableProcessors());
    	
        ExecutorService executor= Executors.newFixedThreadPool(4);
        try{
        	for(String arquivoNome: listaArquivos) {
        		executor.execute(new MyRunnable(arquivoNome, tempoInicial));
        	}
        }catch(Exception err){
            err.printStackTrace();
        }
        executor.shutdown(); 
    } 
    
    
    public static List<String> listAllFiles(String path){
    	List<String> arquivos = new ArrayList<String>();
        try(Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(
            		filePath -> {
            			if(Files.isRegularFile(filePath)) {
            				//System.out.println(filePath.getParent() +"\\"+ filePath.getFileName());
            				arquivos.add(filePath.getParent() +"\\"+ filePath.getFileName());
            			}
            		});
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return arquivos;
    }
    
    public static void processamentoTarefa(String path){
        
    	TesteHistogram.printHistogramFromFile(path);

    	Image image;
		try {
			
			image = new Image(Image.componentExtract(path), 255);
	    	System.out.println(image.compareCosineSimilarity(image));
	    	System.out.println(image.compareEuclideanDistance(image));
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
}

class MyRunnable implements Runnable{
    String path;
    long timeElapsedInicial;
    public MyRunnable(String i, long tempoInicial){
        this.path = i;
        this.timeElapsedInicial = tempoInicial;
    }
    public void run(){
        try{

        	ExecutorTest.processamentoTarefa(path);
        	System.out.println("Run: "+ Thread.currentThread().getName() + "- Path:" + path + " - Demorei:" + (System.currentTimeMillis() - this.timeElapsedInicial)); 

        }catch(Exception err){
            err.printStackTrace();
        }
    }
}