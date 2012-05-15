package br.upis.ltpiv.turma352.series_mix;

import br.upis.ltpiv.turma352.series_mix.exception.validation.NivelUsuarioInvalidoException;
import br.upis.ltpiv.turma352.series_mix.exception.validation.ValidationException;

public class GeneralFunctions {

    public int nivelUsuario(String nomeNivel) throws ValidationException {
        if (nomeNivel.equals("Administrador")) {
            return 1;
        } else if (nomeNivel.equals("Colaborador")) {
            return 2;
        } else if (nomeNivel.equals("Usuario")) {
            return 3;
        } else {
            throw new NivelUsuarioInvalidoException("Nível de usuário inválido!");
        }
    }

    public String nivelUsuario(int nivel) throws ValidationException {
        String nomeNivel;

        switch (nivel) {
            case 1:
                nomeNivel = "Administrador";
                break;
            case 2:
                nomeNivel = "Colaborador";
                break;
            case 3:
                nomeNivel = "Usuário";
                break;
            default:
                nomeNivel = "";
        }

        if (!nomeNivel.equals("")) {
            return nomeNivel;
        } else {
            throw new NivelUsuarioInvalidoException("Nível de usuário inválido!");
        }
    }
}
