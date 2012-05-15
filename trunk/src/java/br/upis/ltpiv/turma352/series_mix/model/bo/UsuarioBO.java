package br.upis.ltpiv.turma352.series_mix.model.bo;

import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.EmailInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;
import br.upis.ltpiv.turma352.series_mix.model.dao.UsuarioDAO;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO;
import java.util.ArrayList;

public class UsuarioBO {

    private UsuarioDAO UsuarioDAO;

    public UsuarioBO() throws DatabaseException {
        this.UsuarioDAO = new UsuarioDAO();
    }

    public UsuarioDTO login(UsuarioDTO us) throws DatabaseException, ValidationException {
        return UsuarioDAO.loginUsuario(us);
    }

    public void cadastrar(UsuarioDTO us) throws DatabaseException, EmailInvalidoException {
        UsuarioDAO.cadastrarUsuario(us);
    }

    public ArrayList<UsuarioDTO> pesquisar(UsuarioDTO us) throws DatabaseException, ValidationException {
        return UsuarioDAO.pesquisarUsuario(us);
    }

    public UsuarioDTO pesquisarId(UsuarioDTO us) throws DatabaseException {
        return UsuarioDAO.pesquisarIdUsuario(us);
    }

    public UsuarioDTO alterar(UsuarioDTO us) throws DatabaseException, EmailInvalidoException {
        return UsuarioDAO.alterarUsuario(us);
    }

    public void excluir(UsuarioDTO us) throws DatabaseException {
        UsuarioDAO.excluirUsuario(us);
    }
}
