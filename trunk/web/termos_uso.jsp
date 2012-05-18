<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="error.jsp" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<%
    Page pagina = new Page();
    pagina.setId(4);
    pagina.setTitle("Termos de Uso");
    session.setAttribute("page", pagina);
%>
<jsp:include page="/WEB-INF/layout/top.jsp" />            	
<div id="content"> 
    <div id="main">

    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />               