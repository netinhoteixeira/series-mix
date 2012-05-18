package br.upis.ltpiv.turma352.series_mix.exception.database;

public class UpdateDatabaseException extends DatabaseException {

    public UpdateDatabaseException(String msg) {
        super(msg);
    }

    public UpdateDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}