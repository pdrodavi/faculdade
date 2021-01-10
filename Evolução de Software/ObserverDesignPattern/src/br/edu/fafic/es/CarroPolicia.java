
package br.edu.fafic.es;

import java.util.Observable;
import java.util.Observer;

public class CarroPolicia implements Carro, Observer {

    @Override
    public void frente() {
        System.out.println("Carro da polícia segue em frente.");
    }

    @Override
    public void direita() {
        System.out.println("Carro da polícia vira a direita.");
    }

    @Override
    public void esquerda() {
        System.out.println("Carro da polícia vira a esquerda.");
    }

    @Override
    public void para() {
        System.out.println("Carro da polícia para.");
    }

    @Override
    public void update(Observable o, Object arg) {
        String acao = String.valueOf(arg);
        
        switch(acao){
            case "frente" : this.frente();
            break;
            
            case "direita" : this.direita();
            break;
            
            case "esquerda" : this.esquerda();
            break;
            
            case "para" : this.para();
            break;
        }
    }
    
}
