<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<%
    Page pagina = new Page();
    pagina.setId(3);
    pagina.setTitle("Cadastro");
    session.setAttribute("page", pagina);
%>
<jsp:include page="/WEB-INF/layout/top.jsp" /> 
<div id="content"> 
    <div id="main">
        <div class="box-two">
            <h1>Cadastro de Usuário</h1>
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
                %>
                <form id="form_validate" action="controller" method="post">
                    <div>
                        <label for="nome">Nome</label><br />
                        <input class="text" id="nome" type="text" name="nome" /><br />
                    </div> 
                    <div>
                        <label for="email">E-mail</label><br />
                        <input class="text" id="email" type="text" name="email" /><br />
                    </div>
                    <div>
                        <label for="senha">Senha</label><br />
                        <input class="text" id="senha" type="password" name="senha" /><br />
                    </div>
                    <div>
                        <label for="senha2">Confirme a senha</label><br />
                        <input class="text" id="senha2" type="password" name="senha2" /><br />
                    </div>
                    <div>
                        <label for="nivel">Nível de acesso</label><br />
                        <select id="nivel" name="nivel">
                            <option value=""></option>
                            <option value="1">Administrador</option>
                            <option value="2">Colaborador</option>
                            <option value="3">Usuário</option>
                        </select>
                        <br />
                    </div>
                    <div class="box-check">
                        <input class="check" id="termos" type="checkbox" name="termos" />
                        <label for="termos">Li e concordo com os <a href="termos_uso.jsp">Termos de Uso</a></label>
                    </div>
                    <div class="button-position">
                        <input type="hidden" value="3" name="op" />
                        <input class="button" type="submit" value="Cadastrar" />
                        <input class="button" type="reset" value="Limpar" />
                    </div>
                </form>
            </div>
        </div>
        <div class="box sidebar">
        </div> 
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />