package br.upis.ltpiv.turma352.series_mix.exception.database;

public class ConnectDatabaseException extends DatabaseException {

    public ConnectDatabaseException(String msg) {
        super(msg);
    }

    public ConnectDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}