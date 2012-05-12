package br.upis.ltpiv.turma352.series_mix.exception.database;

public class SelectDatabaseException extends DatabaseException {
	private static final long serialVersionUID = 1L;

	public SelectDatabaseException(String msg) {
		super(msg);
	}
	
	public SelectDatabaseException(String msg, DatabaseException e) {
		super(msg, e);
	}
}
