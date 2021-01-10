package br.com.rokobasi.eakademy.model;

public class Turma {
    
    public Long id;
    public Long id_curso;
    public int periodo;
    public String sigla;

    public Turma() {
    }

    public Turma(Long id, Long id_curso, int periodo, String sigla) {
        this.id = id;
        this.id_curso = id_curso;
        this.periodo = periodo;
        this.sigla = sigla;
    }
    

    public Turma(Long id_curso, int periodo, String sigla) {
        this.id_curso = id_curso;
        this.periodo = periodo;
        this.sigla = sigla;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

