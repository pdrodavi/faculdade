package com.applicado.pedrodavi.applicado.modelo;

import java.io.Serializable;

public class Atividade implements Serializable {

    private int id;
    private String Atividade;
    private String Disciplina;
    private String Assunto;
    private String prazo;
    private String forma;
    private String anotacoes;

    public Atividade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtividade() {
        return Atividade;
    }

    public void setAtividade(String atividade) {
        Atividade = atividade;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        Disciplina = disciplina;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        Assunto = assunto;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return Atividade.toString();
    }
}
