package br.upis.ltpiv.turma352.series_mix.model.dao;

import br.upis.ltpiv.turma352.series_mix.exception.database.*;
import br.upis.ltpiv.turma352.series_mix.exception.validation.EmailInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.LoginInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet res;
    private String sql;
    private DatabaseDao banco = new DatabaseDao();

    public UsuarioDao() throws DatabaseException {
        con = banco.getConnection(con);
    }

    public UsuarioDto acessar(UsuarioDto usuario) throws DatabaseException, ValidationException {
        this.sql = "SELECT COUNT(*) FROM usuario WHERE (Email = ?) AND (Senha = MD5(?))";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setString(2, usuario.getSenha());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) == 1) {
                this.sql = "SELECT u.id, u.Nome, u.Nivel, n.Nome FROM usuario u INNER JOIN nivel n ON (n.id = u.Nivel) WHERE (Email = ?)";
                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, usuario.getEmail());
                this.res = this.ps.executeQuery();

                if (res.next()) {
                    usuario.setId(res.getInt(1));
                    usuario.setNome(res.getString(2));
                    usuario.getNivel().setId(res.getInt(3));
                    usuario.getNivel().setNome(res.getString(4));
                }
            } else {
                throw new LoginInvalidoException("Login inválido.");
            }
        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível efetuar o login.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return usuario;
    }

    public void cadastrar(UsuarioDto usuario) throws DatabaseException, EmailInvalidoException {
        this.sql = "SELECT COUNT(*) FROM usuario WHERE (Nome = ?) AND (Email = ?)";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, usuario.getNome());
            this.ps.setString(2, usuario.getEmail());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) == 0) {
                this.sql = "INSERT INTO usuario (Nome, Email, Senha, Nivel, Cadastro) VALUES (?, ?, MD5(?), ?, NOW())";

                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, usuario.getNome());
                this.ps.setString(2, usuario.getEmail());
                this.ps.setString(3, usuario.getSenha());
                this.ps.setInt(4, usuario.getNivel().getId());

                this.ps.execute();
            } else {
                throw new EmailInvalidoException("E-mail ou nome de usuário já cadastrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InsertDatabaseException("Não foi possível cadastrar o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }
    }

    public ArrayList<UsuarioDto> listar() throws DatabaseException, ValidationException {
        ArrayList<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();

        this.sql = "SELECT u.id, u.Nome, u.Email, u.Nivel, n.Nome FROM usuario u INNER JOIN nivel n ON (n.id = u.Nivel) ORDER BY u.Nome ASC";

        try {
            this.ps = this.con.prepareStatement(sql);

            this.res = this.ps.executeQuery();

            while (res.next()) {
                UsuarioDto usuario = new UsuarioDto();
                usuario.setId(res.getInt(1));
                usuario.setNome(res.getString(2));
                usuario.setEmail(res.getString(3));
                usuario.getNivel().setId(res.getInt(4));
                usuario.getNivel().setNome(res.getString(5));

                usuarios.add(usuario);
            }

            if (usuarios.isEmpty()) {
                throw new SelectDatabaseException("A busca não retornou nenhum resultado");
            }
        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível localizar os usuários.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return usuarios;
    }

    public ArrayList<UsuarioDto> procurar(UsuarioDto usuarioPesquisa) throws DatabaseException, ValidationException {
        ArrayList<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();

        this.sql = "SELECT u.id, u.Nome, u.Email, u.Nivel, n.Nome FROM usuario u INNER JOIN nivel n ON (n.id = u.Nivel) WHERE (u.id = ?) OR (u.Nome LIKE ?) OR (u.Email LIKE ?) ORDER BY n.Nome ASC";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, usuarioPesquisa.getId());
            this.ps.setString(2, "%" + usuarioPesquisa.getEmail() + "%");
            this.ps.setString(3, "%" + usuarioPesquisa.getSenha() + "%");

            this.res = this.ps.executeQuery();

            while (res.next()) {
                UsuarioDto usuario = new UsuarioDto();
                usuario.setId(res.getInt(1));
                usuario.setNome(res.getString(2));
                usuario.setEmail(res.getString(3));
                usuario.getNivel().setId(res.getInt(4));
                usuario.getNivel().setNome(res.getString(5));

                usuarios.add(usuario);
            }

            if (usuarios.isEmpty()) {
                throw new SelectDatabaseException("A busca não retornou nenhum resultado");
            }
        } catch (SQLException e) {
            throw new SelectDatabaseException("Não foi possível localizar os usuários.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return usuarios;
    }

    public UsuarioDto alterar(UsuarioDto usuario) throws DatabaseException, EmailInvalidoException {
        this.sql = "SELECT COUNT(*) FROM usuario WHERE (Email = ?) AND (id <> ?)";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setInt(2, usuario.getId());

            this.res = this.ps.executeQuery();
            res.next();

            if (res.getInt(1) == 0) {
                this.sql = "UPDATE usuario SET nome = ?, email = ?, nivel = ? WHERE id = ?";

                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, usuario.getNome());
                this.ps.setString(2, usuario.getEmail());
                this.ps.setInt(3, usuario.getNivel().getId());
                this.ps.setInt(4, usuario.getId());

                this.ps.execute();
            } else {
                throw new EmailInvalidoException("E-mail já cadastrado.");
            }
        } catch (SQLException e) {
            throw new UpdateDatabaseException("Não foi possível alterar o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }

        return usuario;
    }

    public void excluir(UsuarioDto usuario) throws DatabaseException {
        this.sql = "DELETE FROM usuario WHERE id = ?";

        try {
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, usuario.getId());
            this.ps.execute();
        } catch (SQLException e) {
            throw new DeleteDatabaseException("Não foi possível excluir o usuário.");
        } finally {
            banco.closeConnection(this.con, this.ps, null);
        }
    }
}
