package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class EmailInvalidoException extends ValidationException {

    private static final long serialVersionUID = 1L;

    public EmailInvalidoException(String msg) {
        super(msg);
    }

    public EmailInvalidoException(String msg, ValidationException e) {
        super(msg, e);
    }
}
