package br.com.pedrodavi.fila.classes;

public class Fila {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Fila() {

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

    public void inserir(Aluno aluno) {

        No no = new No(aluno);

        if (tamanho == 0) {

            this.primeiro = no;
            this.ultimo = no;

        } else if (tamanho == 0) {

            this.inserir(aluno);

        } else {

            No novoNo = new No(aluno);
            this.ultimo.setProx(novoNo);
            this.ultimo = novoNo;

        }

        this.tamanho++;

    }

    public void remover() {

        primeiro = primeiro.getProx();

        this.tamanho--;

    }

    public void retornaTopo() {

        System.out.println("Topo: " + primeiro.getAluno().toString());

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

    }

    public String imprimir() {
        No atual = this.primeiro;
        String resp = "[";
        for (int i = 0; i < this.tamanho; i++) {

            resp += atual.getAluno().getNome();
            atual = atual.getProx();
            resp += ", ";

        }

        resp += "]";

        return resp;

    }

    public boolean verifica(int matricula) {

        No atual = this.primeiro;

        for (int i = 0; i < this.tamanho; i++) {

            if (atual.getAluno().getMatricula() == matricula) {

                System.out.println("Elemento Existe: " + atual.getAluno().toString());
                return true;

            }

            atual = atual.getProx();

        }

        System.out.println("Elemento não existe");
        return false;

    }

}
