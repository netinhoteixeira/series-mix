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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
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
                    String nome = "";
                    String email = "";

                    if (request.getParameter("msearch") != null) {
                        nome = request.getParameter("msearch");
                        email = request.getParameter("msearch");
                    }

                    list = new UsuarioBO().pesquisar(new UsuarioDTO(nome, email));

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

                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nome = request.getParameter("mnome");
                    String email = request.getParameter("memail");
                    //String senha = request.getParameter("msenha");
                    int nivel = function.nivelUsuario((String) request.getParameter("mnivel"));

                    UsuarioDTO usuario = new UsuarioBO().alterar(new UsuarioDTO(id, nome, email, nivel));

                    session.setAttribute("usuario", usuario);
                    
                    message.setType("success");
                    message.setMessage("Usuário alterado com sucesso!");

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    e.printStackTrace();

                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("alterar_cadastro.jsp").forward(request, response);

                break;


            case 6: //Excluir Usuário

                try {

                    int id = Integer.parseInt(request.getParameter("id"));
                    new UsuarioBO().excluir(new UsuarioDTO(id));

                    message.setType("success");
                    message.setMessage("Usuário excluído com sucesso!");

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    e.printStackTrace();

                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);

                break;

            case 7: //Recuperar dados a partir do ID do Usuário

                try {

                    int id = Integer.parseInt(request.getParameter("id"));
                    UsuarioDTO usuario = new UsuarioBO().pesquisarId(new UsuarioDTO(id));

                    session.setAttribute("usuario", usuario);

                } catch (Exception e) {

                    message.setType("error");
                    message.setMessage(e.getMessage());
                    request.setAttribute("message", message);
                    e.printStackTrace();

                }

                request.getRequestDispatcher("alterar_cadastro.jsp").forward(request, response);

                break;

            default:

        }
    }
}