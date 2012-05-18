package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class ValidationException extends Exception {

    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(String msg, Exception e) {
        super(msg, e);
    }
}