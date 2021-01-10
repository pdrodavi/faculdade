package br.com.pedrodavi.listaduplamenteencadeada.classes;

public class No {

    private int numero;
    private No proximo;
    private No anterior;

    public No(int num) {

        this.numero = num;
        this.proximo = null;
        this.anterior = null;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

}
