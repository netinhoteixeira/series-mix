package br.upis.ltpiv.turma352.series_mix.model.dao;

import br.upis.ltpiv.turma352.series_mix.exception.database.ConnectDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.DisconnectDatabaseException;
import java.sql.*;

public class DatabaseDao {

    private String url = "jdbc:mysql://localhost/";
    private String banco = "series_mix";
    private String usuario = "root";
    private String senha = "";
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection(Connection connection) throws DatabaseException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + banco, usuario, senha);
        } catch (SQLException ex) {
            throw new ConnectDatabaseException("Não foi possível se conectar ao banco de dados! " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectDatabaseException("Não foi possível se conectar ao banco de dados! " + ex.getMessage());
        }

        return connection;
    }

    public void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws DatabaseException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new DisconnectDatabaseException("Não foi possível fechar a conexão com o banco de dados! " + ex.getMessage());
        }

    }
}