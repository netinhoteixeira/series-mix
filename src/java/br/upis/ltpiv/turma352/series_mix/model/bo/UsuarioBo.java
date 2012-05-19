package br.upis.ltpiv.turma352.series_mix.model.bo;

import br.upis.ltpiv.turma352.series_mix.exception.database.DatabaseException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.EmailInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;
import br.upis.ltpiv.turma352.series_mix.model.dao.UsuarioDao;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDto;
import java.util.ArrayList;

public class UsuarioBo {

    private UsuarioDao usuarioDao;

    public UsuarioBo() throws DatabaseException {
        this.usuarioDao = new UsuarioDao();
    }

    public UsuarioDto login(UsuarioDto usuario) throws DatabaseException, ValidationException {
        return usuarioDao.acessar(usuario);
    }

    public void cadastrar(UsuarioDto usuario) throws DatabaseException, ValidationException {
        usuarioDao.cadastrar(usuario);
    }

    public ArrayList<UsuarioDto> procurar(UsuarioDto usuario) throws DatabaseException, ValidationException {
        return usuarioDao.procurar(usuario);
    }

    public UsuarioDto alterar(UsuarioDto usuario) throws DatabaseException, ValidationException {
        return usuarioDao.alterar(usuario);
    }

    public void excluir(UsuarioDto usuario) throws DatabaseException {
        usuarioDao.excluir(usuario);
    }

    public ArrayList<UsuarioDto> listar() throws DatabaseException, ValidationException {
        return usuarioDao.listar();
    }
}