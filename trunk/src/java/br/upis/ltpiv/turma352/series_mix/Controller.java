package br.upis.ltpiv.turma352.series_mix;

import br.upis.ltpiv.turma352.series_mix.model.bo.UsuarioBO;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO;
import br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO;
import br.upis.ltpiv.turma352.series_mix.session.Login;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //Instanciando o objeto para uso das funções gerais
    GeneralFunctions function = new GeneralFunctions();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Iniciando a sessão
        HttpSession session = request.getSession(true);

        //Instanciando a mensagem de retorno
        MessageVO message = new MessageVO();

        //Recebendo o valor da operação a ser efetuada
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {

            case 1: //Login

                try {
                    String email = request.getParameter("lemail");
                    String senha = request.getParameter("lsenha");
                    //String remember = request.getParameter("lremember");

                    UsuarioDTO us = new UsuarioBO().login(new UsuarioDTO(email, senha));

                    Login login = new Login(us.getCodigo(), us.getNivel(), us.getNome(), us.getEmail());

                    session.setAttribute("login", login);

                    message.setType("success");
                    message.setMessage("Bem-vindo " + us.getNome());

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    e.printStackTrace();

                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);

                break;

            case 2: //Logoff
                session.invalidate();
                response.sendRedirect("index.jsp");
                break;

            case 3: //Cadastrar Usuário

                try {

                    //Recebendo os parâmetros inseridos pelo usuário
                    String nome = request.getParameter("mnome");
                    String email = request.getParameter("memail");
                    String senha = request.getParameter("msenha");
                    int nivel = function.nivelUsuario((String) request.getParameter("mnivel"));

                    //Instanciando o objeto para cadastro do usuário
                    new UsuarioBO().cadastrar(new UsuarioDTO(nome, email, senha, nivel));

                    message.setType("success");
                    message.setMessage("Usuário cadastrado com sucesso!");

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    e.printStackTrace();

                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);

                break;

            case 4: //Pesquisar Usuário

                try {

                    ArrayList<UsuarioDTO> list = null;
                    /*
                     * String nome = "a"; String email = "@";
                     *
                     * if(!request.getParameter("msearch").equals(null)){ nome =
                     * request.getParameter("msearch"); email =
                     * request.getParameter("msearch");
                    }
                     */

                    list = new UsuarioBO().pesquisar(new UsuarioDTO());

                    request.setAttribute("search", list);

                } catch (NullPointerException e) {

                    message.setType("error");
                    message.setMessage("Ocorreu um erro ao tentar recuperar os atributos da pesquisa.");
                    request.setAttribute("message", message);
                    e.printStackTrace();

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    request.setAttribute("message", message);
                    e.printStackTrace();

                }

                request.getRequestDispatcher("usuarios.jsp").forward(request, response);

                break;

            case 5: //Alterar Usuário

                break;

            case 6: //Excluir Usuário

                break;

            default:

        }
    }
}