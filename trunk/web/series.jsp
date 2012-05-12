<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="error.jsp" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<% session.setAttribute("page", new Page(2, "Séries")); %>
<jsp:include page="/WEB-INF/layout/top.jsp" />            	
<div id="content"> 
    <div id="main">

    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />               