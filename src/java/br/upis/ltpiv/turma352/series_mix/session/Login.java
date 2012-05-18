package br.upis.ltpiv.turma352.series_mix.session;

import br.upis.ltpiv.turma352.series_mix.model.dto.NivelDto;

/**
 * Classe criada para armazenar os atributos do usuário logado.
 */
public class Login {

    private int id;
    private String nome;
    private String email;
    private NivelDto nivel;

    public Login() {
        this.nivel = new NivelDto();
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
}