package br.upis.ltpiv.turma352.series_mix.exception.validation;

public class NivelUsuarioInvalidoException extends ValidationException {

    private static final long serialVersionUID = 1L;

    public NivelUsuarioInvalidoException(String msg) {
        super(msg);
    }

    public NivelUsuarioInvalidoException(String msg, ValidationException e) {
        super(msg, e);
    }
}
