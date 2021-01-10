package br.com.rokobasi.eakademy.model;

public class Disciplinas_Professor {
    
    private Long id_disciplina;
    private String nomeDisciplina;

    public Disciplinas_Professor() {
    }

    public Disciplinas_Professor(Long id_disciplina, String nomeDisciplina) {
        this.id_disciplina = id_disciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    
}
