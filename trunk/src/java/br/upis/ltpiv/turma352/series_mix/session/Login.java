package br.upis.ltpiv.turma352.series_mix.session;

public class Login {

    //Classe criada para armazenar os atributos do usuário logado
    int id;
    int nivel;
    String name;
    String email;

    public Login() {
    }

    public Login(int id, int nivel, String name, String email) {
        this.id = id;
        this.nivel = nivel;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}