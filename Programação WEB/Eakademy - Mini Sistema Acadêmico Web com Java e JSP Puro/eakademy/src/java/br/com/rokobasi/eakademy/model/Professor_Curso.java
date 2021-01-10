package br.com.rokobasi.eakademy.model;

public class Professor_Curso {
    
    public String nomeProfessor;
    public String nomeCurso;

    public Professor_Curso() {
    }

    public Professor_Curso(String nomeProfessor, String nomeCurso) {
        this.nomeProfessor = nomeProfessor;
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

}
