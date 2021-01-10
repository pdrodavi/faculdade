package br.com.pedrodavi.pilha.classes;

public class No {
    
    private int num;
    private No prox;
    
    public No (int numero){
    
        this.num = numero;
        this.prox = null;
        
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
}
