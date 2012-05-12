<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<% session.setAttribute("page", new Page(9, "Alterar Cadastro"));%>
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
                } else {
                    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
                    pageContext.setAttribute("usuario", usuario);
                %>
                <form id="form_validate" action="controller" method="post">                        
                    <div>
                        <label for="mnome">Nome</label><br />
                        <input class="text" id="mnome" type="text" name="mnome" value="${usuario.usuario_nome}" /><br />
                    </div> 
                    <div>
                        <label for="memail">E-mail</label><br />
                        <input class="text" id="memail" type="text" name="memail" value="${usuario.usuario_email}" /><br />
                    </div>
                    <!--<div>
                        <label for="msenha">Senha</label><br />
                        <input class="text" id="msenha" type="password" name="msenha" /><br />
                    </div> 
                    <div>
                        <label for="msenha2">Confirme a senha</label><br />
                        <input class="text" id="msenha2" type="password" name="msenha2" /><br />
                    </div>-->
                    <div>
                        <label for="mnivel">Nível de acesso</label><br />
                        <select id="mnivel" name="mnivel">
                            <option value=""></option>
                            <option value="Administrador">Administrador</option>
                            <option value="Colaborador">Colaborador</option>
                            <option value="Usuário">Usuário</option>
                        </select>
                        <br />
                    </div>
                    <div class="button-position">
                        <input type="hidden" value="5" name="op" />
                        <input type="hidden" name="id" value="${usuario.codigo_usuario}" />
                        <input class="button" type="submit" value="Alterar" />
                        <input class="button" type="reset" value="Resetar" />
                    </div>
                </form>
                <% }%>
            </div>
        </div>
        <div class="box sidebar">
        </div> 
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />               