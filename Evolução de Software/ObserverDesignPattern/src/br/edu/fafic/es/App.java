
package br.edu.fafic.es;

public class App {
    public static void main(String[] args) {
        
        CarroRoubado roubado = new CarroRoubado();
        CarroPolicia policia = new CarroPolicia();
        CarroPolicia policia1 = new CarroPolicia();
        CarroPolicia policia2 = new CarroPolicia();
        
        roubado.addObserver(policia);
        roubado.addObserver(policia1);
        roubado.addObserver(policia2);
        
        roubado.frente();
        roubado.esquerda();
        roubado.frente();
        roubado.direita();
        roubado.para();
        
        
    }
    
}
