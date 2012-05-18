package br.upis.ltpiv.turma352.series_mix.model.dto;

import java.util.Date;

public class EpisodioDto {

    private int id;
    private TemporadaDto temporada;
    private int numero;
    private String nome;
    private Date lancamento;
    private Date postagem;
    private long visita;

    public EpisodioDto() {
        this.temporada = new TemporadaDto();
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getPostagem() {
        return postagem;
    }

    public void setPostagem(Date postagem) {
        this.postagem = postagem;
    }

    public TemporadaDto getTemporada() {
        return temporada;
    }

    public void setTemporada(TemporadaDto temporada) {
        this.temporada = temporada;
    }

    public long getVisita() {
        return visita;
    }

    public void setVisita(long visita) {
        this.visita = visita;
    }
}