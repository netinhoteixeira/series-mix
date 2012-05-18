package br.upis.ltpiv.turma352.series_mix.model.dto;

public class TemporadaDto {

    private int id;
    private SerieDto serie;
    private int numero;
    private byte[] capa;
    private String trailer;
    private boolean _final;

    public TemporadaDto() {
        this.serie = new SerieDto();
    }

    public boolean isFinal() {
        return _final;
    }

    public void setFinal(boolean _final) {
        this._final = _final;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public SerieDto getSerie() {
        return serie;
    }

    public void setSerie(SerieDto serie) {
        this.serie = serie;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}