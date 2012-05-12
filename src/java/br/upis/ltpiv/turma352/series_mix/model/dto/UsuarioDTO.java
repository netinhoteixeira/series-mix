package br.upis.ltpiv.turma352.series_mix.model.dto;

import java.sql.Date;

public class UsuarioDTO {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private int nivel;
    private String nmNivel;
    private Date dataCadastro;

    //Métodos construtores da classe UsuarioDTO utilizados durante a aplicação
    public UsuarioDTO() {
    }

    //Busca por ID
    public UsuarioDTO(int codigo) {
        this.codigo = codigo;
    }

    //Login
    public UsuarioDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //Resultado do Login
    public UsuarioDTO(int codigo, String nome, int nivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.nivel = nivel;
    }

    //Cadastro
    public UsuarioDTO(String nome, String email, String senha, int nivel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }

    //Alteração
    public UsuarioDTO(int codigo, String nome, String email, int nivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
    }
    
    //Resultado das Buscas
    public UsuarioDTO(int codigo, String nome, String email, String nmNivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.nmNivel = nmNivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNmNivel() {
        return nmNivel;
    }

    public void setNmNivel(String nmNivel) {
        this.nmNivel = nmNivel;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}