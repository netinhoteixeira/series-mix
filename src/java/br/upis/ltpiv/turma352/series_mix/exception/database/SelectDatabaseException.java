package br.upis.ltpiv.turma352.series_mix.exception.database;

public class SelectDatabaseException extends DatabaseException {

    public SelectDatabaseException(String msg) {
        super(msg);
    }

    public SelectDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}