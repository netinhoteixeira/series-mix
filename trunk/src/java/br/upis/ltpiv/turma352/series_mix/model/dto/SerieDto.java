package br.upis.ltpiv.turma352.series_mix.model.dto;

import java.util.Date;

public class SerieDto {

    private int id;
    private String nome;
    private String sinopse;
    private String duracao;
    private String situacao;
    private Date lancamento;
    private Date cancelamento;

    public Date getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(Date cancelamento) {
        this.cancelamento = cancelamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}