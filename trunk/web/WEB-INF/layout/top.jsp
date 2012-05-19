<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="br.upis.ltpiv.turma352.series_mix.session.Page" %>
<% Page pg = (Page) session.getAttribute("page");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title> ${page.title} | Séries Mix - Um Mix de Diversão</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="author" content="Aline Damasceno, Francisco Ernesto e Jady Pâmella" />
        <meta name="description" content="Projeto de LTP-IV para a avaliação P3. Sistema gerenciador de website de download de séries desenvolvido em Java." />
        <link rel="icon" href="media/image/frame/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="media/image/frame/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="media/css/style.css" type="text/css" media="all" />
        <script type="text/javascript" src="media/js/jquery.min.js"></script>
        <script type="text/javascript" src="media/js/jquery.validate.js"></script>
        <script type="text/javascript" src="media/js/scripts.js"></script>
    </head>
    <body>
        <div class="wrapper">
            <!-- Início do Cabeçalho -->
            <div id="header">
                <div id="logo">
                    <a href="index.jsp">
                        <img src="media/image/frame/logo_header.png" alt="Logo Séries Mix" />
                    </a>
                </div>

                <!-- Início do Menu Principal -->
                <div id="nav">
                    <div class="search">
                        <form action="controller" method="get">
                            <p><input class="text" type="text" name="s" value="Pesquisar" /></p>
                            <p><input class="button" type="submit" value="" /></p>
                        </form>
                        <p class="redes-sociais">
                            <a href="#" title="Facebook">
                                <img class="facebook" src="media/image/frame/icon_facebook.png" alt="Facebook" />
                            </a>
                            <a href="#" title="Twitter">
                                <img class="twitter" src="media/image/frame/icon_twitter.png" alt="Twitter" />
                            </a>
                            <a href="#" title="Google Plus">
                                <img class="gplus" src="media/image/frame/icon_gplus.png" alt="Google Plus" />
                            </a>
                            <a href="#" title="Youtube">
                                <img class="youtube" src="media/image/frame/icon_youtube.png" alt="Youtube" />
                            </a>
                            <a href="#" title="Feed RSS">
                                <img class="rss" src="media/image/frame/icon_rss.png" alt="Feed RSS" />
                            </a>
                        </p>
                    </div>
                    <div class="menu">
                        <ul>
                            <li <% if (pg.getId() == 1) {%> class="active" <% }%> ><a href="index.jsp">Home</a></li>
                            <li <% if (pg.getId() == 2) {%> class="active" <% }%> ><a href="series.jsp">Séries</a></li>
                            <li <% if (pg.getId() == 3) {%> class="active" <% }%> ><a href="usuarioCadastro.jsp">Cadastre-se</a></li>
                            <li <% if (pg.getId() == 4) {%> class="active" <% }%> ><a href="termos_uso.jsp">Termos de Uso</a></li>
                            <li <% if (pg.getId() == 5) {%> class="active" <% }%> ><a href="contato.jsp">Contato</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Fim do Cabeçalho -->

            <!-- Início do Conteúdo -->
            <div id="container">  
                <div id="sidebar">
                    <div id="panel" class="submenu">
                        <% if (session.getAttribute("login") == null) {%>
                        <h1>Efetue o Login</h1>
                        <form action="controller" method="post">
                            <table>                            	
                                <tr><td colspan="2"><input class="text email" id="lemail" type="text" name="lemail" value="E-mail" /></td></tr>
                                <tr><td colspan="2"><input class="text senha" id="lsenha" type="password" name="lsenha" value="Senha" /></td></tr>
                                <tr><td colspan="2" class="remember"><input class="check" id="lremember" type="checkbox" name="lremember" value="1" checked="checked" />
                                        <label for="lremember">Mantenha-me conectado</label></td></tr>
                                <tr><td class="link"><a href="#">Esqueci minha senha</a><br /><a href="#">Não sou cadastrado</a></td>
                                    <td><input type="hidden" value="1" name="op" /><input class="button" type="submit" value="OK" /></td>
                                </tr>
                            </table>
                        </form>
                        <% } else {%>
                        <h1>Meu Perfil</h1>
                        <ul>
                            <li><a href="#">Minha Conta</a></li>
                            <li><a href="controller?op=4">Usuários</a></li>
                            <li><a href="#">Séries</a></li>
                            <li><a href="#">Temporadas</a></li>
                            <li><a href="#">Episódios</a></li>
                            <li><a href="#">Comentários</a></li> 
                            <li><a href="controller?op=2">Sair</a></li>
                        </ul>
                        <% }%>
                    </div>

                    <div id="series" class="submenu">
                        <h1>Mais Baixadas</h1>
                        <ul>
                            <li><a href="#">2 Broke Girls</a></li>
                            <li><a href="#">A Gifted Man</a></li>
                            <li><a href="#">Body Of Proof</a></li>
                            <li><a href="#">Chuck</a></li>
                            <li><a href="#">Covert Affairs</a></li>
                            <li><a href="#">Dexter</a></li>
                            <li><a href="#">Happily Divorced</a></li>
                            <li><a href="#">Hot In Cleveland</a></li>
                            <li><a href="#">How I Met Your Mother</a></li>
                            <li><a href="#">I Hate My Teenage Daughter</a></li>
                            <li><a href="#">New Girl</a></li>
                            <li><a href="#">Nikita</a></li>
                            <li><a href="#">One Tree Hill</a></li>
                            <li><a href="#">Silk</a></li>
                            <li><a href="#">Supernatural</a></li>
                            <li><a href="#">Teen Wolf</a></li>
                            <li><a href="#">The Big Bang Theory</a></li>
                            <li><a href="#">The Secret Circle</a></li>
                            <li><a href="#">The Walking Dead</a></li>
                            <li><a href="#">Tood and the Book of Pure Evil</a></li>
                            <li><a href="#">True Blood</a></li>
                            <li><a href="#">Two and a Half Men</a></li>
                            <li><a href="#">White Collar</a></li>
                            <li><a href="#">Whitney</a></li>
                            <li><a href="#">Work It</a></li>
                        </ul>
                    </div>
                </div>