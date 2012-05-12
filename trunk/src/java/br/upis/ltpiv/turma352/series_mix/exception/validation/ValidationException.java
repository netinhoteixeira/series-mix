package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class ValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(String msg, Exception e) {
        super(msg, e);
    }
}