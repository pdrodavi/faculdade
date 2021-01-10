package br.com.pedrodavi.pilha.classes;

public class Pilha {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Pilha() {

        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;

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

    public void empilhar(int numero) {

        if ((numero % 2) == 0) {

            inserirNoTopo(numero);

        } else {
        
            desempilhar();
            
        }

    }

    public void desempilhar() {

        if (tamanho == 0) {

            System.out.println("Pilha Vazia");

        } else {

            removerDoTopo();

        }

    }

    public void inserirInicio(int numero) {

        No no = new No(numero);

        if (tamanho == 0) {

            this.primeiro = no;
            this.ultimo = no;

        } else {

            no.setProx(primeiro);
            this.primeiro = no;

        }

        this.tamanho++;
    }

    public void inserirNoTopo(int num) {

        if (tamanho == 0) {

            inserirInicio(num);

        } else {

            No novoNo = new No(num);
            this.ultimo.setProx(novoNo);
            this.ultimo = novoNo;
            novoNo.setProx(null);
            this.tamanho++;

        }

    }

    public int tamanho() {
        return this.tamanho;
    }

    public No pegaNo(int posicao) {

        No atual = primeiro;

        for (int i = 1; i < posicao; i++) {
            atual = atual.getProx();
        }

        return atual;

        /* segunda alternativa 
        
        No atual = primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProx();
        }

        return atual;
        
         */
    }

    public String imprimir() {
        No atual = this.primeiro;
        String resp = "[";
        for (int i = 0; i < this.tamanho; i++) {

            resp += atual.getNum();
            atual = atual.getProx();
            resp += ", ";

        }

        resp += "]";

        return resp;

    }

    public void removerDoTopo() {

        No penultimo = pegaNo(tamanho - 1);
        penultimo.setProx(null);
        ultimo = penultimo;
        this.tamanho--;

        /* segunda alternativa
        
        No penultimo = pegaNo(tamanho - 2); 
        penultimo.setProx(null);
        ultimo = penultimo;
        this.tamanho--;
        
         */
    }

    public boolean verifica(int numero) {

        No atual = this.primeiro;

        for (int i = 0; i < this.tamanho; i++) {

            if (atual.getNum() == numero) {

                System.out.println("Elemento Existe: " + atual.getNum());
                return true;

            }

            atual = atual.getProx();

        }

        System.out.println("Elemento não existe");
        return false;

    }
    
    public void retornaTopo() {

        System.out.println("Topo: " + ultimo.getNum());

    }

}
