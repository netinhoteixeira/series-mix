package br.upis.ltpiv.turma352.series_mix.exception.database;

public class DisconnectDatabaseException extends DatabaseException {

    private static final long serialVersionUID = 1L;

    public DisconnectDatabaseException(String msg) {
        super(msg);
    }

    public DisconnectDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}
