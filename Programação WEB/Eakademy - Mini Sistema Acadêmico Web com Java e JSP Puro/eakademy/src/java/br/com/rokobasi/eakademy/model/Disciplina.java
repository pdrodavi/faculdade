package br.com.rokobasi.eakademy.model;

public class Disciplina {
    
    public Long id;
    public Long id_curso;
    public String nome;

    public Disciplina() {
    }

    public Disciplina(Long id, Long id_curso, String nome) {
        this.id = id;
        this.id_curso = id_curso;
        this.nome = nome;
    }

    public Disciplina(Long id, String nome) {
        this.id_curso = id;
        this.nome = nome;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id) {
        this.id_curso = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

