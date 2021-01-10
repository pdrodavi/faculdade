package br.com.rokobasi.eakademy.model;

public class Professores_Turmas {
    
    public String nomeProfessor;
    public String siglaTurma;
    public int periodoTurma;

    public Professores_Turmas() {
    }

    public Professores_Turmas(String nomeProfessor, String siglaTurma, int periodoTurma) {
        this.nomeProfessor = nomeProfessor;
        this.siglaTurma = siglaTurma;
        this.periodoTurma = periodoTurma;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public void setSiglaTurma(String siglaTurma) {
        this.siglaTurma = siglaTurma;
    }

    public int getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(int periodoTurma) {
        this.periodoTurma = periodoTurma;
    }

    
    
    
    
}

