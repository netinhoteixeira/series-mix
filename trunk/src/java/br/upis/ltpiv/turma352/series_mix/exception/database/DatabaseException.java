package br.upis.ltpiv.turma352.series_mix.exception.database;

public class DatabaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String msg, Exception e) {
        super(msg, e);
    }
}