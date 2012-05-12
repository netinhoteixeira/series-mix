package br.upis.ltpiv.turma352.series_mix.exception.database;

public class InsertDatabaseException extends DatabaseException {

    private static final long serialVersionUID = 1L;

    public InsertDatabaseException(String msg) {
        super(msg);
    }

    public InsertDatabaseException(String msg, DatabaseException e) {
        super(msg, e);
    }
}
