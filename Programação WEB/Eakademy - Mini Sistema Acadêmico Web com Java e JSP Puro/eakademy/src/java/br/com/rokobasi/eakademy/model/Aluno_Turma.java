package br.com.rokobasi.eakademy.model;

public class Aluno_Turma {
    
    private String nomeAluno;
    private String siglaTurma;
    private int periodo;

    public Aluno_Turma() {
    }

    public Aluno_Turma(String nomeAluno, String siglaTurma, int periodo) {
        this.nomeAluno = nomeAluno;
        this.siglaTurma = siglaTurma;
        this.periodo = periodo;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public void setSiglaTurma(String siglaTurma) {
        this.siglaTurma = siglaTurma;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
    
}
