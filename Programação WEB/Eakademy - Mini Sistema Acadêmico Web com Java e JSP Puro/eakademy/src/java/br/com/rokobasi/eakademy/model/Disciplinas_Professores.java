package br.com.rokobasi.eakademy.model;

public class Disciplinas_Professores {
    
    public String nomeDisciplina;
    public String nomeProfessor;

    public Disciplinas_Professores() {
    }

    public Disciplinas_Professores(String nomeDisciplina, String nomeProfessor) {
        this.nomeDisciplina = nomeDisciplina;
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    
    
    
}