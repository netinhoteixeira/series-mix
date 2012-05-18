package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class SenhaInvalidaException extends ValidationException {

    public SenhaInvalidaException(String msg) {
        super(msg);
    }

    public SenhaInvalidaException(String msg, ValidationException e) {
        super(msg, e);
    }
}