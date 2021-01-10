package br.com.rokobasi.eakademy.model;

public class Vestibular {
    
    private Long id;
    private String nome;
    private String data;

    public Vestibular() {
    }

    public Vestibular(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public Vestibular(Long id, String nome, String data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vestibular{" + "id=" + id + ", nome=" + nome + ", data=" + data + '}';
    }
    
    
}

