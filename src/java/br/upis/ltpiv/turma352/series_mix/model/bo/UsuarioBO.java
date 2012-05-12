package br.upis.ltpiv.turma352.series_mix.model.bo;

import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;
import br.upis.ltpiv.turma352.series_mix.model.dao.UsuarioDAO;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO;
import java.util.ArrayList;

public class UsuarioBO {

    private UsuarioDAO UsuarioDAO;

    public UsuarioBO() throws DatabaseException {
        this.UsuarioDAO = new UsuarioDAO();
    }

    public void cadastrar(UsuarioDTO us) throws DatabaseException {
        UsuarioDAO.cadastrarUsuario(us);
    }

    public UsuarioDTO login(UsuarioDTO us) throws DatabaseException, ValidationException {
        return UsuarioDAO.loginUsuario(us);
    }

    public ArrayList<UsuarioDTO> pesquisar(UsuarioDTO us) throws DatabaseException, ValidationException {
        return UsuarioDAO.pesquisarUsuario(us);
    }
}
