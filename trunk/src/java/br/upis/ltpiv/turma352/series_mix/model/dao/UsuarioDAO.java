package br.upis.ltpiv.turma352.series_mix.model.dao;

import br.upis.ltpiv.turma352.series_mix.GeneralFunctions;
import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.InsertDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.SelectDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.UpdateDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.database.DeleteDatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.EmailInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.LoginInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet res;
    private String sql;
    private DatabaseDAO banco = new DatabaseDAO();
    private GeneralFunctions function = new GeneralFunctions();

    public UsuarioDAO() throws DatabaseException {
        con = banco.getConnection(con);
    }

    public UsuarioDTO loginUsuario(UsuarioDTO us) throws DatabaseException, ValidationException {

        UsuarioDTO user = new UsuarioDTO();

        this.sql = "SELECT COUNT(*) FROM usuario WHERE (usuario_email = ?) AND (usuario_senha = MD5(?))";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, us.getEmail());
            this.ps.setString(2, us.getSenha());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) == 1) {
                this.sql = "SELECT usuario_codigo, usuario_nome, usuario_nivel FROM usuario WHERE (usuario_email = ?)";
                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, us.getEmail());
                this.res = this.ps.executeQuery();
                res.next();

                user = new UsuarioDTO(res.getInt(1),
                        res.getString(2),
                        res.getInt(3));

                user.setEmail(us.getEmail());

            } else {
                throw new LoginInvalidoException("Login inválido.");
            }
        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível efetuar o login.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return user;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO us) throws DatabaseException, EmailInvalidoException {

        this.sql = "SELECT COUNT(*) FROM usuario WHERE (usuario_nome = ?) AND (usuario_email = ?)";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, us.getNome());
            this.ps.setString(2, us.getEmail());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) > 0) {

                this.sql = "INSERT INTO usuario(usuario_nivel, usuario_nome, usuario_email, usuario_senha, usuario_data_cadastro) VALUES(?,?,?,MD5(?),SYSDATE())";

                this.ps = this.con.prepareStatement(sql);
                this.ps.setInt(1, us.getNivel());
                this.ps.setString(2, us.getNome());
                this.ps.setString(3, us.getEmail());
                this.ps.setString(4, us.getSenha());

                this.ps.execute();
            } else {
                throw new EmailInvalidoException("E-mail ou nome de usuário já cadastrado.");
            }
        } catch (SQLException e) {
            throw new InsertDatabaseException("Não foi possível cadastrar o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return us;
    }

    public ArrayList<UsuarioDTO> pesquisarUsuario(UsuarioDTO us) throws DatabaseException, ValidationException {

        ArrayList<UsuarioDTO> list = new ArrayList<UsuarioDTO>();

        this.sql = "SELECT usuario_codigo, usuario_nome, usuario_email, usuario_nivel FROM usuario "
                + "WHERE (usuario_nome LIKE ?) "
                + "OR (usuario_email LIKE ?) "
                + "ORDER BY usuario_nivel, usuario_nome, usuario_email ASC";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, "%" + us.getEmail() + "%");
            this.ps.setString(2, "%" + us.getSenha() + "%");

            this.res = this.ps.executeQuery();

            while (res.next()) {
                list.add(new UsuarioDTO(res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        function.nivelUsuario((int) res.getInt(4))));
            }

            if (list.isEmpty()) {
                throw new SelectDatabaseException("A busca não retornou nenhum resultado");
            }

        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível localizar os usuários.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return list;
    }

    public UsuarioDTO pesquisarIdUsuario(UsuarioDTO us) throws DatabaseException {

        this.sql = "SELECT usuario_nome, usuario_email, usuario_nivel FROM usuario "
                + "WHERE (usuario_codigo = ?)";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, us.getCodigo());

            this.res = this.ps.executeQuery();

            while (res.next()) {
                us.setNome(res.getString(1));
                us.setEmail(res.getString(2));
                us.setNivel(res.getInt(3));
            }

        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível resgatar os atributos do usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return us;
    }

    public UsuarioDTO alterarUsuario(UsuarioDTO us) throws DatabaseException, EmailInvalidoException {

        this.sql = "SELECT COUNT(*) FROM usuario WHERE (usuario_nome = ?) AND (usuario_email = ?) AND (usuario_codigo <> ?)";
        System.out.println(this.sql);
        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, us.getNome());
            this.ps.setString(2, us.getEmail());
            this.ps.setInt(3, us.getCodigo());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) > 0) {

                this.sql = "UPDATE usuario SET usuario_nivel = ?, usuario_nome = ?, usuario_email = ? "
                        + "WHERE usuario_codigo = ?";

                this.ps = this.con.prepareStatement(sql);
                this.ps.setInt(1, us.getNivel());
                this.ps.setString(2, us.getNome());
                this.ps.setString(3, us.getEmail());
                this.ps.setInt(4, us.getCodigo());

                this.ps.execute();
            } else {
                throw new EmailInvalidoException("E-mail ou nome de usuário já cadastrado.");
            }
        } catch (SQLException e) {
            throw new UpdateDatabaseException("Não foi possível alterar o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return us;
    }

    public UsuarioDTO excluirUsuario(UsuarioDTO us) throws DatabaseException {

        UsuarioDTO user = new UsuarioDTO();

        this.sql = "DELETE FROM usuario WHERE usuario_codigo = ?";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, us.getCodigo());

            this.ps.execute();

        } catch (SQLException e) {
            throw new DeleteDatabaseException("Não foi possível excluir o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return user;
    }
}