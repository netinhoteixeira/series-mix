<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDto" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<%@ page import="java.util.ArrayList" %>
<%
    Page pagina = new Page();
    pagina.setId(8);
    pagina.setTitle("Usuários");
    session.setAttribute("page", pagina);
%>
<jsp:include page="/WEB-INF/layout/top.jsp" />
<div id="content">
    <div id="main">
        <div class="box-one">
            <h1>Lista de Usuários</h1>

            <div class="search-text">
                <form action="controller" method="post">
                    <div class="search-inputs">
                        <input class="text" id="msearch" type="text" name="search" />
                    </div>
                    <div class="button-position">
                        <input type="hidden" value="4" name="op" />
                        <input class="button" type="submit" value="Pesquisar" />
                        <button onclick="window.location.href='usuarioCadastro.jsp';return false;">Cadastrar</button>
                    </div>
                </form>
            </div>

            <div class="separator"></div>

            <%  // Mensagem ao usuário
                if (request.getAttribute("message") != null) {
                    MessageVO msg = (MessageVO) request.getAttribute("message");
            %>
            <div class="msg <%= msg.getType()%>">
                <p class="txt <%= msg.getType()%>"><%= msg.getMessage()%></p>
                <p class="btn <%= msg.getType()%>"><a href="#" title="Fechar"><button></button></a></p>
            </div>
            <% }%>

            <%
                // Recebendo a lista de usuários cadastrados
                ArrayList<UsuarioDto> lista = (ArrayList<UsuarioDto>) request.getAttribute("search");
            %>
            <table class="search-result">
                <tbody>
                    <tr>
                        <th class="th-first"></th>
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Nível</th>
                        <th class="th-last">Opções</th>
                    </tr>

                    <% // Percorrendo a lista recebida
                        for (int i = 0; i < lista.size(); i++) {
                            UsuarioDto usuario = (UsuarioDto) lista.get(i);
                    %>
                    <tr>
                        <td><%= usuario.getId()%></td>
                        <td><a href="controller?op=7&id=<%= usuario.getId()%>"><%= usuario.getNome()%></a></td>
                        <td><%= usuario.getEmail()%></td>
                        <td><%= usuario.getNivel().getNome()%></td>
                        <td>
                            <a href="controller?op=7&id=<%= usuario.getId()%>">
                                <img class="edit" src="media/image/frame/icon_edit.png" alt="Alterar" title="Alterar"/>
                            </a>
                            <a href="controller?op=6&id=<%= usuario.getId()%>" onclick="return confirm('Tem certeza que deseja excluir <%= usuario.getNome()%>?')">
                                <img class="delete" src="media/image/frame/icon_delete.png" alt="Excluir" title="Excluir"/>
                            </a>
                        </td>
                    </tr>
                    <% }%>

                </tbody>
            </table>

            <div class="search-details">
                <div class="button-position">
                    <a href="#"><button>Excluir</button></a>
                    <a href="usuarioCadastro.jsp"><button>Cadastrar</button></a>
                </div>

                <div class="page">
                    <span class="number">Página 1 de 3</span>
                    <span><a class="current" href="#">1</a></span>
                    <span><a href="#">2</a></span>
                    <span><a href="#">3</a></span>
                    <span><a href="#">Próxima</a></span>
                    <span><a href="#">Última</a></span>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />