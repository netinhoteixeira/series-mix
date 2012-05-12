<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.model.vo.MessageVO" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<% session.setAttribute("page", new Page(1, "Home"));%>
<jsp:include page="/WEB-INF/layout/top.jsp" />
<div id="content"> 
    <div id="main">
        <div class="box-three">
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/the-big-bang-theory.png" alt="The Big Bang Theory" /></a></p>
                <h3>The Big Bang Theory</h3>
                <h4>S05 E20</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/how-i-met-your-mother.png" alt="How I Met Your Mother" /></a></p>
                <h3>How I Met Your Mother</h3>
                <h4>S07 E19</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/covert-affairs.png" alt="Covert Affairs" /></a></p>
                <h3>Covert Affairs</h3>
                <h4>S02 E15</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
        </div>
        <div class="box-three">
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/nikita.png" alt="Nikita" /></a></p>
                <h3>Nikita</h3>
                <h4>S02 E22</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/sons-of-anarchy.png" alt="Sons of Anarchy" /></a></p>
                <h3>Sons of Anarchy</h3>
                <h4>S04 E10</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/body-of-proof.png" alt="Body of Proof" /></a></p>
                <h3>Body of Proof</h3>
                <h4>S02 E23</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
        </div>
        <div class="box-three">
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/happily-divorced.png" alt="Happily Divorced" /></a></p>
                <h3>Happily Divorced</h3>
                <h4>S02 E06</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/true-blood.png" alt="True Blood" /></a></p>
                <h3>True Blood</h3>
                <h4>S05 E01</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
            <div class="box">
                <p><a href="#"><img src="media/image/thumb/game-of-thrones.png" alt="Game of Thrones" /></a></p>
                <h3>Game of Thrones</h3>
                <h4>S02 E13</h4>
                <p><a href="#"><button>Download</button></a></p>
            </div>
        </div>
        <div class="box-one">
            <div class="separator"></div>
            <div class="page">
                <span class="number">Página 1 de 200</span>
                <span><a class="current" href="#">1</a></span>
                <span><a href="#">2</a></span>
                <span><a href="#">3</a></span>
                <span><a href="#">4</a></span>
                <span><a href="#">5</a></span>
                <span><a href="#">Próxima</a></span>
                <span><a href="#">Última</a></span>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp" />
<%
    if (request.getAttribute("message") != null) {
        MessageVO msg = (MessageVO) request.getAttribute("message");
%> <script>alert("<%= msg.getMessage()%>")</script> <% }%>