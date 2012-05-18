package br.upis.ltpiv.turma352.series_mix;

import br.upis.ltpiv.turma352.series_mix.model.bo.UsuarioBo;
import br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDto;
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

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        // Iniciando a sessão
        HttpSession session = request.getSession(true);

        // Instanciando a mensagem de retorno
        MessageVO message = new MessageVO();

        // Recebendo o valor da operação a ser efetuada
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1: // Login
                try {
                    String email = request.getParameter("lemail");
                    String senha = request.getParameter("lsenha");

                    UsuarioDto usuario = new UsuarioDto();
                    usuario.setEmail(email);
                    usuario.setSenha(senha);

                    UsuarioBo usuarioBo = new UsuarioBo();
                    usuario = usuarioBo.login(usuario);

                    Login login = new Login();
                    login.setId(usuario.getId());
                    login.setNome(usuario.getNome());
                    login.setEmail(usuario.getEmail());
                    login.setNivel(usuario.getNivel());
                    session.setAttribute("login", login);

                    message.setType("success");
                    message.setMessage("Bem-vindo " + usuario.getNome());
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case 2: // Logoff
                session.invalidate();
                response.sendRedirect("index.jsp");
                break;

            case 3: // Cadastrar Usuário
                try {
                    // Recebendo os parâmetros inseridos pelo usuário
                    UsuarioDto usuario = new UsuarioDto();
                    usuario.setNome(request.getParameter("nome"));
                    usuario.setEmail(request.getParameter("email"));
                    usuario.setSenha(request.getParameter("senha"));
                    usuario.getNivel().setId(Integer.parseInt(request.getParameter("nivel")));

                    // Instanciando o objeto para cadastro do usuário
                    new UsuarioBo().cadastrar(usuario);

                    message.setType("success");
                    message.setMessage("Usuário cadastrado com sucesso!");
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
                break;

            case 4: // Pesquisar Usuário
                try {
                    if (request.getParameter("search") != null) {
                        UsuarioDto usuario = new UsuarioDto();
                        usuario.setNome(request.getParameter("search"));
                        usuario.setEmail(usuario.getNome());

                        ArrayList<UsuarioDto> lista = new UsuarioBo().procurar(usuario);
                        request.setAttribute("search", lista);
                    } else {
                        ArrayList<UsuarioDto> lista = new UsuarioBo().listar();
                        request.setAttribute("search", lista);
                    }
                } catch (NullPointerException e) {
                    message.setType("error");
                    message.setMessage("Ocorreu um erro ao tentar recuperar os atributos da pesquisa.");
                    request.setAttribute("message", message);
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                    request.setAttribute("message", message);
                }

                request.getRequestDispatcher("usuarioListar.jsp").forward(request, response);
                break;

            case 5: // Alterar Usuário
                try {
                    UsuarioDto usuario = new UsuarioDto();
                    usuario.setId(Integer.parseInt(request.getParameter("id")));
                    usuario.setNome(request.getParameter("nome"));
                    usuario.setEmail(request.getParameter("email"));
                    usuario.getNivel().setId(Integer.parseInt(request.getParameter("nivel")));

                    UsuarioBo usuarioBo = new UsuarioBo();
                    usuario = usuarioBo.alterar(usuario);

                    session.setAttribute("usuario", usuario);

                    message.setType("success");
                    message.setMessage("Usuário alterado com sucesso!");
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("usuarioAlterarCadastro.jsp").forward(request, response);
                break;

            case 6: // Excluir Usuário
                try {
                    UsuarioDto usuario = new UsuarioDto();
                    usuario.setId(Integer.parseInt(request.getParameter("id")));

                    UsuarioBo usuarioBo = new UsuarioBo();
                    usuarioBo.excluir(usuario);

                    message.setType("success");
                    message.setMessage("Usuário excluído com sucesso!");

                    ArrayList<UsuarioDto> lista = new UsuarioBo().listar();
                    request.setAttribute("search", lista);
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("usuarioListar.jsp").forward(request, response);
                break;

            case 7: // Recuperar dados a partir do ID do Usuário
                try {
                    UsuarioDto usuarioPesquisa = new UsuarioDto();
                    usuarioPesquisa.setId(Integer.parseInt(request.getParameter("id")));

                    UsuarioBo usuarioBo = new UsuarioBo();
                    ArrayList<UsuarioDto> usuarios = usuarioBo.procurar(usuarioPesquisa);
                    for (UsuarioDto usuario : usuarios) {
                        session.setAttribute("usuario", usuario);
                        break;
                    }
                } catch (Exception e) {
                    message.setType("error");
                    message.setMessage(e.getMessage());
                    request.setAttribute("message", message);
                }

                request.getRequestDispatcher("usuarioAlterarCadastro.jsp").forward(request, response);
                break;

            default:
        }
    }
}