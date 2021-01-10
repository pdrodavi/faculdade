package br.com.photopdi.dominio;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.Raster;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import javax.swing.JOptionPane;

public class Filtros {

    // filtro tons de cinza - início
    
    public BufferedImage tonsDeCinza(BufferedImage imagem) {

        int width = imagem.getWidth();
        int height = imagem.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int p = imagem.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //ccalculando a média
                int avg = (r + g + b) / 3;

                //substituindo os valores rgb pelo da média (tons de cinza)
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                imagem.setRGB(x, y, p);

            }
        }

        return imagem;
    }

    // filtro tons de cinza - final
    
    // filto negativo - início
    
    public BufferedImage negativo(BufferedImage imagem) {

        int width = imagem.getWidth();
        int height = imagem.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = imagem.getRGB(i, j);               //a cor inversa é dado por 255 menos o valor da cor                 
                int r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
                int g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
                int b = 255 - (int) (rgb & 0x000000FF);
                Color color = new Color(r, g, b);
                imagem.setRGB(i, j, color.getRGB());

            }
        }
        return imagem;
    }

    // filtro negativo - final
    
    // filtro de binarização - início
    
    public BufferedImage binarizacao(BufferedImage imagem) {
        
        
         int width = imagem.getWidth();
        int height = imagem.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = imagem.getRGB(i, j);
                int r = (int) ((rgb & 0x00FF0000) >>> 16);
                int g = (int) ((rgb & 0x0000FF00) >>> 8);
                int b = (int) (rgb & 0x000000FF);
                int media = (r + g + b) / 3;
                Color white = new Color(255, 255, 255);
                Color black = new Color(0, 0, 0);
                //como explicado no artigo, no threshold definimos um limiar,
                //que é um valor "divisor de águas"
                //pixels com valor ABAIXO do limiar viram pixels PRETOS,
                //pixels com valor ACIMA do limiar viram pixels BRANCOS
                if (media < 150) {
                    imagem.setRGB(i, j, black.getRGB());
                } else {
                    imagem.setRGB(i, j, white.getRGB());
                }
            }
        }

        return imagem;
    }

    // filtro de binarização - final
    
    // filtro de suavização - início
    
    public BufferedImage suavizacao(BufferedImage imagem) {
        
         // Cria imagem de saida com mesmo tamanho e tipo da imagem de entrada

        BufferedImage ima_out  = new BufferedImage(imagem.getWidth(),imagem.getHeight(),imagem.getType());

    // Recupera matriz das imagens de entrada e saida

        Raster raster = imagem.getRaster(); // declara e instancia objeto raster soh para leitura
        WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita

    // Processa valores da imagem de entrada e armazena na imagem de saida

        double valornr, valorng, valornb;
        int[] v = new int[9];

        for(int y=1; y<imagem.getHeight()-1; y++)
            for(int x=1; x<imagem.getWidth()-1; x++){

//            Aplica Filtro de Mediana 3x3

                LeJanela3x3(raster,v,x,y,0);
                valornr = CalcMediana(9,v);

                LeJanela3x3(raster,v,x,y,1);
                valorng = CalcMediana(9,v);

                LeJanela3x3(raster,v,x,y,2);
                valornb = CalcMediana(9,v);

                wraster.setSample(x,y,0,(int)(valornr+.5));
                wraster.setSample(x,y,1,(int)(valorng+.5));
                wraster.setSample(x,y,2,(int)(valornb+.5));

            }

        return ima_out;


//        BufferedImage ima_out = new BufferedImage(imagem.getWidth(), imagem.getHeight(), imagem.getType());
//        // Recupera matriz das imagens de entrada e saida
//
//        Raster raster = imagem.getRaster(); // declara e instancia objeto raster soh para leitura
//        WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita
//
//        // Processa valores da imagem de entrada e armazena na imagem de saida
//        double valornr, valorng, valornb;
//
//        int[] v = new int[9];
//
//        for (int y = 1; y < imagem.getHeight() - 1; y++) {
//            for (int x = 1; x < imagem.getWidth() - 1; x++) {
//                // Aplica Filtro de Mediana 3x3
//                LeJanela3x3(raster, v, x, y, 0);
//
//                valornr = CalcMediana(9, v);
//
//                LeJanela3x3(raster, v, x, y, 1);
//
//                valorng = CalcMediana(9, v);
//                LeJanela3x3(raster, v, x, y, 2);
//
//                valornb = CalcMediana(9, v);
//
//                wraster.setSample(x, y, 0, (int) (valornr + .5));
//                wraster.setSample(x, y, 1, (int) (valorng + .5));
//                wraster.setSample(x, y, 2, (int) (valornb + .5));
//
//            }
//        }
//
//        return imagem;
    }
    
    // filtro de suavização - final
    
    // filtro de passa alta - início

    public BufferedImage passaAlta(BufferedImage imagem) {

        Filtros ImagemCinza = new Filtros();
        BufferedImage imgAltCinza = ImagemCinza.tonsDeCinza(imagem);
        
        Filtros ImagemNegativa = new Filtros();
        BufferedImage imgAlt = ImagemNegativa.negativo(imgAltCinza);

        Filtros ImagemFinal = new Filtros();
        BufferedImage imgAltFinal = ImagemFinal.brilho(imgAlt, 2);

        return imagem;
    }
    
    // filtro de passa alta - final
    
    // filtro brilho - início

    public BufferedImage brilho(BufferedImage imagem, float num) {
        
     boolean contrastInc = true;   
     float scaleFactor = num;
     float offset = 10;

        BufferedImage biSrc = imagem;
        BufferedImage biDest = biSrc;
        if (contrastInc) {
            if (scaleFactor < 2) {
                scaleFactor = scaleFactor + 0.1f;
            }
        }
       
        RescaleOp rescale = new RescaleOp(scaleFactor, offset, null);
        rescale.filter(biSrc, biDest);
        BufferedImage bi = biDest;
        return bi;
        
        
    }
    
    // filtro brilho - final
    
    // métodos para filtro constraste - início

    public BufferedImage contraste(BufferedImage imagem, int num) {
        
         byte[] tableContrast = contrastScale(num);

        ByteLookupTable blt = new ByteLookupTable(0, tableContrast);
        LookupOp lookupOp = new LookupOp(blt, null);
        lookupOp.filter(imagem, imagem);
        return imagem;
      
    }
   
        private static double currentContrast = 0.0f;
        private static byte[] contrastTable = null;

    private static byte[] contrastScale(double scale) {
        if (scale <= 0) {
            scale = 1.0;
        }
        if (contrastTable == null) {
            contrastTable = new byte[256];
        }
        if (currentContrast != scale || currentContrast == 0) {
            currentContrast = scale;
            for (int i = 0; i < 256; i++) {
                int val = (int) Math.round(255.0 * Math.pow(((double) i / 255.0), (scale)));
                if (val > 255) {
                    val = 255;
                }
                if (val < 0) {
                    val = 0;
                }
                contrastTable[i] = (byte) val;
            }
        }
        return contrastTable;
    }

    // métodos para filtro constraste - final
    
    // método para filtro de suavização - início
    
    public double CalcMediana(int npts, int[] v) {
        int aux;
        // Ordena em ordem crescente os elementos do vetor
        for (int i = 0; i < npts - 1; i++) {
            for (int j = i + 1; j < npts; j++) {
                if (v[i] > v[j]) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        // Define o valor da mediana
        if ((npts % 2) == 0) {
            return ((double) v[npts / 2]);
        } else {
            return ((double) ((v[npts / 2] + v[npts / 2 + 1]) / 2.));
        }
    }

    public void LeJanela3x3(Raster raster, int[] v, int x, int y, int banda) {
//    System.out.println("Banda: " + banda);
        v[0] = raster.getSample(x - 1, y - 1, banda);
        v[1] = raster.getSample(x, y - 1, banda);
        v[2] = raster.getSample(x + 1, y - 1, banda);
        v[3] = raster.getSample(x - 1, y, banda);
        v[4] = raster.getSample(x, y, banda);
        v[5] = raster.getSample(x + 1, y, banda);
        v[6] = raster.getSample(x - 1, y + 1, banda);
        v[7] = raster.getSample(x, y + 1, banda);
        v[8] = raster.getSample(x + 1, y + 1, banda);
    }

    // método para filtro de suavização - final
    
    // filtro de paleta de cores

    public BufferedImage paleta(BufferedImage imagem){
        
         int width = imagem.getWidth();
        int height = imagem.getHeight();
        
        
                int red =Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade do Canal RED: "));
                int green =Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade do Canal GREEN: "));
                int blue =Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade do Canal BLUE: "));
               
                
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = imagem.getRGB(i, j);
                int r = (int) ((rgb & 0x00FF0000) >>> 16);
                int g = (int) ((rgb & 0x0000FF00) >>> 8);
                int b = (int) (rgb & 0x000000FF);
                int media = (r + g + b) / 3;
                
                Color white = new Color(red, green, blue);
                Color black = new Color(0, 0, 0);
                //como explicado no artigo, no threshold definimos um limiar,
                //que é um valor "divisor de águas"
                //pixels com valor ABAIXO do limiar viram pixels PRETOS,
                //pixels com valor ACIMA do limiar viram pixels BRANCOS
                if (media < 150) {
                    imagem.setRGB(i, j, black.getRGB());
                } else {
                    imagem.setRGB(i, j, white.getRGB());
                }
            }
        }
        
        return imagem;
    }

    // métodos para histograma
    
    int[] calculaHistograma(BufferedImage img){
        int[] histograma = new int[256];
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color color = new Color(img.getRGB(x, y));
                int red = color.getRed();
                histograma[red] += 1;
            }
        }
        return histograma;
    }

    public int[] calculaHistogramaAcumulado(int[] histograma) {
        int[] acumulado = new int[256];
        acumulado[0] = histograma[0];
        for(int i=1;i < histograma.length;i++) {

            acumulado[i] = histograma[i] + acumulado[i-1];
        }
        return acumulado;
    }

    private int menorValor(int[] histograma) {
        for(int i=0; i <histograma.length; i++) {
            if(histograma[i] != 0){
                return histograma[i];
            }
        }
        return 0;
    }

    private int[] calculaMapadeCores(int[] histograma, int pixels) {
        int[] mapaDeCores = new int[256];
        int[] acumulado = calculaHistogramaAcumulado(histograma);
        float menor = menorValor(histograma);
        for(int i=0; i < histograma.length; i++) {
            mapaDeCores[i] = Math.round(((acumulado[i] - menor) / (pixels - menor)) * 255);
        }
        return mapaDeCores;
    }
    
    // filtro histograma

    public BufferedImage equalizacao(BufferedImage img) {
        //2.1- calcular histograma
        int[] histograma = calculaHistograma(img);
        //2.2- calcular novo mapa de cores
        int[] mapaDeCores = calculaMapadeCores(histograma, img.getWidth() * img.getHeight());
        //2.3- atualizar palheta de cores da imagem
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color color = new Color(img.getRGB(x, y));
                int tom = color.getRed();
                int newTom = mapaDeCores[tom];
                Color newColor = new Color(newTom, newTom, newTom);
                out.setRGB(x, y, newColor.getRGB());
            }
        }
        //2.4- retornar imagem processada
        return out;
    }

}
    

