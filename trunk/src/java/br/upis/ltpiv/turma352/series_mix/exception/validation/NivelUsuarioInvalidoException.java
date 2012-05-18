package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class NivelUsuarioInvalidoException extends ValidationException {

    public NivelUsuarioInvalidoException(String msg) {
        super(msg);
    }

    public NivelUsuarioInvalidoException(String msg, ValidationException e) {
        super(msg, e);
    }
}