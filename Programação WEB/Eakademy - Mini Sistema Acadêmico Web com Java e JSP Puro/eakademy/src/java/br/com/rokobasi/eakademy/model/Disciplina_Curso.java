package br.com.rokobasi.eakademy.model;

public class Disciplina_Curso {
    
    public Long id;
    public String nomeDisciplina;
    public String nomeCurso;

    public Disciplina_Curso() {
    }

    public Disciplina_Curso(Long id, String nomeDisciplina, String nomeCurso) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
        this.nomeCurso = nomeCurso;
    }

    public Disciplina_Curso(String nomeDisciplina, String nomeCurso) {
        this.nomeDisciplina = nomeDisciplina;
        this.nomeCurso = nomeCurso;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
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
