
package br.edu.fafic.es;

import java.util.Observable;

public class CarroRoubado extends Observable implements Carro {

    private String acao;
    
    @Override
    public void frente() {
        acao = "frente";
        System.out.println("Carro roubado segue em frente...");
        this.mudaEstado();
    }

    @Override
    public void direita() {
        acao = "direita";
        System.out.println("Carro roubado vira a direita...");
        this.mudaEstado();
    }

    @Override
    public void esquerda() {
        acao = "esquerda";
        System.out.println("Carro roubado vira a esquerda...");
        this.mudaEstado();
    }

    @Override
    public void para() {
        acao = "para";
        System.out.println("Carro roubado parou...");
        this.mudaEstado();
    }
    
        
    public void mudaEstado(){
        setChanged();
        notifyObservers(acao);
        
    }
    
}
