package br.com.pedrodavi.fila.classes;

public class No {

    private Aluno aluno;
    private No prox;

    public No(Aluno aluno) {

        this.aluno = aluno;
        this.prox = null;

    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

}
