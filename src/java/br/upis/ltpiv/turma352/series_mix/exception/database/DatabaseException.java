package br.upis.ltpiv.turma352.series_mix.exception.database;

public class DatabaseException extends Exception {

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String msg, Exception e) {
        super(msg, e);
    }
}