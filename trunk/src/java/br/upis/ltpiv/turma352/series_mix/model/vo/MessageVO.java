package br.upis.ltpiv.turma352.series_mix.model.vo;

public class MessageVO {

    //Classe criada para retornar as respostas das requisições feitas pelo usuário
    private String message;
    private String type;

    public MessageVO() {
    }

    public MessageVO(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
