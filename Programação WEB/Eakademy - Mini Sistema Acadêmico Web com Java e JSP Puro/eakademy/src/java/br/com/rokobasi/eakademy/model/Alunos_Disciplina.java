package br.com.rokobasi.eakademy.model;

public class Alunos_Disciplina {
    
    private Long id_aluno;
    private String nomeAluno;
    private Long id_disciplina;

    public Alunos_Disciplina() {
    }

    public Alunos_Disciplina(Long id_aluno, String nomeAluno, Long id_disciplina) {
        this.id_aluno = id_aluno;
        this.nomeAluno = nomeAluno;
        this.id_disciplina = id_disciplina;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    @Override
    public String toString() {
        return "Alunos_Disciplina{" + "id_aluno=" + id_aluno + ", nomeAluno=" + nomeAluno + ", id_disciplina=" + id_disciplina + '}';
    }
    
    
    
    
}
