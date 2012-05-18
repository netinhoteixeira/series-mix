package br.upis.ltpiv.turma352.series_mix.model.dto;

import java.util.Date;

public class ComentarioDto {

    private int id;
    private TemporadaDto temporada;
    private UsuarioDto usuario;
    private EpisodioDto episodio;
    private String mensagem;
    private Date postagem;

    public ComentarioDto() {
        this.temporada = new TemporadaDto();
        this.usuario = new UsuarioDto();
        this.episodio = new EpisodioDto();
    }

    public EpisodioDto getEpisodio() {
        return episodio;
    }

    public void setEpisodio(EpisodioDto episodio) {
        this.episodio = episodio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}