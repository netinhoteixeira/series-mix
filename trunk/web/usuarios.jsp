<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="error.jsp" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.dto.UsuarioDTO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<%@ page import="java.util.ArrayList" %>
<% session.setAttribute("page", new Page(8, "Usuários")); %>
<jsp:include page="/WEB-INF/layout/top.jsp" />                
<div id="content"> 
    <div id="main">
        <div class="box-one">
            <h1>Lista de Usuários</h1>

            <%  // Mensagem ao usuário
                if(request.getAttribute("message") != null){
                    MessageVO msg = (MessageVO) request.getAttribute("message");
            %>
            <div class="msg <%= msg.getType() %>">
                <p class="txt <%= msg.getType() %>"><%= msg.getMessage() %></p>
                <p class="btn <%= msg.getType() %>"><a href="#" title="Fechar"><button></button></a></p>
            </div>
            <% } %>

            <div class="search-text">
                <form action="controller" method="post">
                    <div class="search-inputs">
                        <input class="text" id="msearch" type="text" name="msearch" />
                    </div>
                    <div class="button-position">
                        <input type="hidden" value="4" name="op" />
                        <input class="button" type="submit" value="Pesquisar" />
                        <a href="cadastro.jsp"><button>Cadastrar</button></a>
                    </div>
                </form>
            </div>

            <div class="separator"></div>

            <%  // Recebendo a lista de usuários cadastrados
                if((request.getAttribute("search") != null)&&(request.getAttribute("search") instanceof ArrayList)){
                    ArrayList<UsuarioDTO> list = (ArrayList<UsuarioDTO>) request.getAttribute("search");
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
                       for(int i=0; i<list.size(); i++){
                       UsuarioDTO usuario = (UsuarioDTO) list.get(i);
                       pageContext.setAttribute("usuario", usuario);
                    %>
                    <tr>
                        <td>${usuario.codigo}</td>
                        <td><a href="controller?op=5&id=${usuario.codigo}">${usuario.nome}</a></td>
                        <td>${usuario.email}</td> 
                        <td>${usuario.nmNivel}</td>
                        <td>
                            <a href="controller?op=5&id=${usuario.codigo}">
                                <img src="media/image/frame/button_edit.png" alt="Alterar" title="Alterar"/>
                            </a>
                            <a href="controller?op=6&id=${usuario.codigo}" onclick="return confirm('Tem certeza que deseja excluir ${usuario.nome}?')">
                                <img src="media/image/frame/button_delete.png" alt="Excluir" title="Excluir"/>
                            </a>
                        </td>
                    </tr>
                    <% } %>

                </tbody>
            </table>  

            <div class="search-details">
                <div class="button-position">
                    <a href="#"><button>Excluir</button></a>
                    <a href="cadastro.jsp"><button>Cadastrar</button></a>
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

            <% } %>

        </div> 
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />               