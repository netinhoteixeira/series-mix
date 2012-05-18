package br.upis.ltpiv.turma352.series_mix.exception.database;

public class DisconnectDatabaseException extends DatabaseException {

    public DisconnectDatabaseException(String msg) {
        super(msg);
    }

    public DisconnectDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}