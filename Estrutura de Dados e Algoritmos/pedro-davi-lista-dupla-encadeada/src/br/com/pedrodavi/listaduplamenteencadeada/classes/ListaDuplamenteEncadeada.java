package br.com.pedrodavi.listaduplamenteencadeada.classes;

public class ListaDuplamenteEncadeada {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {

        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;

    }
    
    public void inserir(int numero){
        
        if ((numero % 2) == 0) {

            System.out.println("Número par não é permitido!");

        } else {
            
            if (tamanho == 0){
        
            inserirInicio(numero);
            System.out.println("Inserido com sucesso!");
            
            } else {
            
                inserirFinal(numero);
                System.out.println("Inserido com sucesso!");
                
            }
        }
    
    }

    public void inserirInicio(int num) {

        No no = new No(num);

        if (tamanho == 0) {

            this.primeiro = no;
            this.ultimo = no;

        } else {

            no.setProximo(this.primeiro);
            this.primeiro.setAnterior(no);
            this.primeiro = no;

        }

        this.tamanho++;

    }

    public void inserirFinal(int num) {

        No no = new No(num);

        if (this.tamanho == 0) {

            inserirInicio(num);

        } else {

            this.ultimo.setProximo(no);
            no.setAnterior(this.ultimo);
            this.ultimo = no;
            this.tamanho++;

        }

    }

    public No pegaNo(int posicao) {

        No atual = primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;

    }

    public String imprimir() {
        No atual = this.primeiro;
        String resp = "[";
        for (int i = 0; i < this.tamanho; i++) {

            resp += atual.getNumero();
            atual = atual.getProximo();
            resp += ", ";

        }

        resp += "]";

        return resp;

    }

    public int tamanho() {

        return this.tamanho;

    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
