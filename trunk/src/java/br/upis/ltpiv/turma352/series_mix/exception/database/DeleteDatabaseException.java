package br.upis.ltpiv.turma352.series_mix.exception.database;

public class DeleteDatabaseException extends DatabaseException {

    public DeleteDatabaseException(String msg) {
        super(msg);
    }

    public DeleteDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}