package br.upis.ltpiv.turma352.series_mix.model.dto;

import java.sql.Date;

public class UsuarioDto {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private NivelDto nivel;
    private Date dataCadastro;

    public UsuarioDto() {
        this.nivel = new NivelDto();
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NivelDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelDto nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}