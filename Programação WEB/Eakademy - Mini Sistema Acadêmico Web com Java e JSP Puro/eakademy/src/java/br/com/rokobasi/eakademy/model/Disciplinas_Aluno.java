package br.com.rokobasi.eakademy.model;

public class Disciplinas_Aluno {
    
    private Long id;
    private String nomeDisciplina;

    public Disciplinas_Aluno() {
    }

    public Disciplinas_Aluno(Long id, String nomeDisciplina) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    
}
