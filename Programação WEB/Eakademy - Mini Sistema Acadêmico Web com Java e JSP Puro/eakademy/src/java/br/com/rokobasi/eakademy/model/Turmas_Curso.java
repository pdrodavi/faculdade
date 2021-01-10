package br.com.rokobasi.eakademy.model;

public class Turmas_Curso {
    
    public Long id;
    public String sigla;
    public Long periodo;
    public String nomeCurso;

    public Turmas_Curso() {
    }

    public Turmas_Curso(Long id, String sigla, Long periodo, String nomeCurso) {
        this.id = id;
        this.sigla = sigla;
        this.periodo = periodo;
        this.nomeCurso = nomeCurso;
    }
    

    public Turmas_Curso(String sigla, Long periodo, String nomeCurso) {
        this.sigla = sigla;
        this.periodo = periodo;
        this.nomeCurso = nomeCurso;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long periodo) {
        this.periodo = periodo;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

