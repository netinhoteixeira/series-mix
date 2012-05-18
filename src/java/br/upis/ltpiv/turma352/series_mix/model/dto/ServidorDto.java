package br.upis.ltpiv.turma352.series_mix.model.dto;

public class ServidorDto {

    private int id;
    private EpisodioDto episodio;
    private String nome;
    private String endereco;
    private String situacao;

    public ServidorDto() {
        this.episodio = new EpisodioDto();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}