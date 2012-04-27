$(document).ready(function() {
    // Controla o texto dos inputs pré-preenchidos
    $('.search .text').click(function() {
        if ($(this).val() === 'Pesquisar') {
            $(this).val(new String());
        }
    });
    $('.search .text').blur(function() {
        if ($(this).val().length === 0) {
            $(this).val('Pesquisar');
        }
    });
    $('#submenu .email').click(function() {
        if ($(this).val() === 'E-mail') {
            $(this).val(new String());
        }
    });
    $('#submenu .email').blur(function() {
        if ($(this).val().length === 0) {
            $(this).val('E-mail');
        }
    });
    $('#submenu .senha').click(function(){
        if ($(this).val() === 'Senha') {
            $(this).val(new String());
        }
    });
    $('#submenu .senha').blur(function() {
        if ($(this).val().length === 0) {
            $(this).val('Senha');
        }
    });

    // Controla os ícones das redes sociais do rodapé
    function change_image(element, image){
        element.attr('src', image);
    }
    
    $('.search .facebook').hover(
        function() {
            change_image($(this), 'media/image/frame/icon_facebook-hover.png');
        }, function() {
            change_image($(this), 'media/image/frame/icon_facebook.png');
        });
    $('.search .twitter').hover(
        function() {
            change_image($(this), 'media/image/frame/icon_twitter-hover.png');
        }, function() {
            change_image($(this), 'media/image/frame/icon_twitter.png');
        });
    $('.search .gplus').hover(
        function() {
            change_image($(this), 'media/image/frame/icon_gplus-hover.png');
        }, function() {
            change_image($(this), 'media/image/frame/icon_gplus.png');
        });
    $('.search .youtube').hover(
        function() {
            change_image($(this), 'media/image/frame/icon_youtube-hover.png');
        }, function() {
            change_image($(this), 'media/image/frame/icon_youtube.png');
        });
    $('.search .rss').hover(
        function() {
            change_image($(this), 'media/image/frame/icon_rss-hover.png');
        }, function() {
            change_image($(this), 'media/image/frame/icon_rss.png');
        });
});