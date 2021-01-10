package br.com.rokobasi.eakademy.model;

public class AlunoDisciplinaNota {
    
    private Long id;
    private Long id_aluno;
    private Long id_disciplina;
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double media;
    private String situacao;

    public AlunoDisciplinaNota() {
    }
    
    public AlunoDisciplinaNota(Long id, Long aluno, Long disciplina, Double nota1, Double nota2, Double nota3) {
        this.id = id;
        this.id_aluno = aluno;
        this.id_disciplina = disciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public AlunoDisciplinaNota(Long id, Double nota1, Double nota2, Double nota3) {
        this.id = id;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public AlunoDisciplinaNota(Long id, Long aluno, Long disciplina, Double nota1, Double nota2, Double nota3, Double media, String situacao) {
        this.id = id;
        this.id_aluno = aluno;
        this.id_disciplina = disciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = media;
        this.situacao = situacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAluno() {
        return id_aluno;
    }

    public void setAluno(Long aluno) {
        this.id_aluno = aluno;
    }

    public Long getDisciplina() {
        return id_disciplina;
    }

    public void setDisciplina(Long disciplina) {
        this.id_disciplina = disciplina;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "AlunoDisciplinaNota{" + "id=" + id + ", aluno=" + id_aluno + ", disciplina=" + id_disciplina + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", media=" + media + ", situacao=" + situacao + '}';
    }
    
}
