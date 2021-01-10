package br.com.rokobasi.eakademy.model;

public class Professor_Turma {
    
    public Long id;
    public String siglaTurma;
    public int periodoTurma;

    public Professor_Turma() {
    }

    public Professor_Turma(String siglaTurma, int periodoTurma) {
        this.siglaTurma = siglaTurma;
        this.periodoTurma = periodoTurma;
    }

    public Professor_Turma(Long id, String siglaTurma, int periodoTurma) {
        this.id = id;
        this.siglaTurma = siglaTurma;
        this.periodoTurma = periodoTurma;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

