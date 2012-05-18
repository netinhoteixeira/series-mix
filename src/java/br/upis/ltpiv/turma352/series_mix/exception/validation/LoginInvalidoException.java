package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class LoginInvalidoException extends ValidationException {

    public LoginInvalidoException(String msg) {
        super(msg);
    }

    public LoginInvalidoException(String msg, ValidationException e) {
        super(msg, e);
    }
}