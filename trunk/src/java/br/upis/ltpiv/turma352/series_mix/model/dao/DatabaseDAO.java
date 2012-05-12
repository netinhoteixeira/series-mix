package br.upis.ltpiv.turma352.series_mix.model.dao;

import br.upis.ltpiv.turma352.series_mix.exception.database.ConnectDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.DisconnectDatabaseException;
import java.sql.*;

public class DatabaseDAO {

    private String url = "jdbc:mysql://localhost/";
    private String banco = "series_mix";
    private String usuario = "root";
    private String senha = "";
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection(Connection con) throws DatabaseException {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + banco, usuario, senha);
        } catch (SQLException e) {
            throw new ConnectDatabaseException("Não foi possível se conectar ao banco de dados!");
        } catch (ClassNotFoundException e) {
            throw new ConnectDatabaseException("Não foi possível se conectar ao banco de dados!");
        }
        return con;

    }

    public void closeConnection(Connection c, PreparedStatement p, ResultSet r) throws DatabaseException {

        try {
            if (r != null) {
                r.close();
            }
            if (!p.equals(null)) {
                p.close();
            }
            if (!c.equals(null)) {
                c.close();
            }
        } catch (SQLException e) {
            throw new DisconnectDatabaseException("Não foi possível fechar a conexão com o banco de dados!");
        }

    }
}