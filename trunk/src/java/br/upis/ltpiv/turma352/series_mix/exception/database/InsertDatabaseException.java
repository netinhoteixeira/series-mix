package br.upis.ltpiv.turma352.series_mix.exception.database;

public class InsertDatabaseException extends DatabaseException {

    public InsertDatabaseException(String msg) {
        super(msg);
    }

    public InsertDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}