<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDto" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<%
    Page pagina = new Page();
    pagina.setId(9);
    pagina.setTitle("Alterar Cadastro");
    session.setAttribute("page", pagina);
%>
<jsp:include page="/WEB-INF/layout/top.jsp" />
<div id="content">
    <div id="main">
        <div class="box-two">
            <h1>Alterar Cadastro</h1>
            <div class="box main">
                <%
                    if (request.getAttribute("message") != null) {
                        MessageVO msg = (MessageVO) request.getAttribute("message");
                %>
                <div class="msg <%= msg.getType()%>">
                    <p class="txt <%= msg.getType()%>"><%= msg.getMessage()%></p>
                    <p class="btn <%= msg.getType()%>"><a href="#" title="Fechar"><button></button></a></p>
                </div>
                <%
                    }
                    UsuarioDto usuario = (UsuarioDto) session.getAttribute("usuario");
                    pageContext.setAttribute("usuario", usuario);
                %>
                <form id="form_validate" action="controller" method="post">
                    <div>
                        <label for="nome">Nome</label><br />
                        <input class="text" id="nome" type="text" name="nome" value="<%= usuario.getNome()%>" /><br />
                    </div>
                    <div>
                        <label for="email">E-mail</label><br />
                        <input class="text" id="email" type="text" name="email" value="<%= usuario.getEmail()%>" /><br />
                    </div>
                    <div>
                        <label for="nivel">Nível de acesso</label><br />
                        <select id="nivel" name="nivel">
                            <option value=""></option>
                            <option value="1"<% if (usuario.getNivel().getId() == 1) { %> selected="true"<% } %>>Administrador</option>
                            <option value="2"<% if (usuario.getNivel().getId() == 2) { %> selected="true"<% } %>>Colaborador</option>
                            <option value="3"<% if (usuario.getNivel().getId() == 3) { %> selected="true"<% } %>>Usuário</option>
                        </select>
                        <br />
                    </div>
                    <div class="button-position">
                        <input type="hidden" value="5" name="op" />
                        <input type="hidden" name="id" value="<%= usuario.getId()%>" />
                        <input class="button" type="submit" value="Alterar" />
                        <input class="button" type="reset" value="Resetar" />
                    </div>
                </form>
            </div>
        </div>
        <div class="box sidebar">
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />