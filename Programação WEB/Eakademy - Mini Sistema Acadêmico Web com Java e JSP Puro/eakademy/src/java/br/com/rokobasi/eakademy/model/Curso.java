package br.com.rokobasi.eakademy.model;

public class Curso {
    
    private Long id;
    private String nome;
    private String area;

    public Curso() {
    }

    public Curso(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    public Curso(Long id, String nome, String area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", area=" + area + '}';
    }
    
}
