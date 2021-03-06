$(document).ready(function(){
    // Controla o texto dos inputs pré-preenchidos
    $('.search .text').click(function(){
        if ($(this).val() == 'Pesquisar'){ 
            $(this).val('');
        }
    });                
    $('.search .text').blur(function(){
        if ($(this).val().length == 0){
            $(this).val('Pesquisar');
        }
    });
    $('#panel .email').click(function(){
        if ($(this).val() == 'E-mail'){ 
            $(this).val('');
        }
    });                
    $('#panel .email').blur(function(){
        if ($(this).val().length == 0){
            $(this).val('E-mail');
        }
    });
    $('#panel .senha').click(function(){
        if ($(this).val() == 'Senha'){ 
            $(this).val('');
        }
    });                
    $('#panel .senha').blur(function(){
        if ($(this).val().length == 0){
            $(this).val('Senha');
        }
    });
    
    // Controla os hovers dos ícones
    function change_image(element, image){
        element.attr('src',image);
    }                
    $('.search .facebook').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_facebook-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_facebook.png'); 
        }
        );
    $('.search .twitter').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_twitter-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_twitter.png'); 
        }
        );    
    $('.search .gplus').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_gplus-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_gplus.png'); 
        }
        );    
    $('.search .youtube').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_youtube-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_youtube.png'); 
        }
        );    
    $('.search .rss').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_rss-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_rss.png'); 
        }
        );    
    $('.search-result .delete').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_delete-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_delete.png'); 
        }
        );
    $('.search-result .edit').hover(
        function(){
            change_image($(this), 'media/image/frame/icon_edit-hover.png'); 
        }, function(){
            change_image($(this), 'media/image/frame/icon_edit.png'); 
        }
        );

    // Controla as validações de formulário
    $('#form_validate input[type="reset"]').click(function() {
        $('label.error').hide();
        $('input.error, textarea.error, select.error').removeClass("error");
        $('input.valid, textarea.valid, select.valid').removeClass("valid");
    });
    
    $('#form_validate').validate({
        submitHandler: function(form) {
            form.submit(function(){
                return true;
            });
        },
        rules:{
            nome:{
                required: true,
                minlength: 3
            },
            email:{
                required: true,
                email: true
            },
            senha:{
                required: true
            },
            senha2:{
                required: true,
                equalTo: "#senha"
            },
            nivel: "required",
            termos: "required"
        },
        messages:{
            nome:{
                required: "O nome é obrigatório!",
                minlength: "O nome deve conter no mínimo 3 caracteres."
            },
            email: {
                required: "O e-mail é obrigatório.",
                email: "Informe um e-mail válido."
            },
            senha: {
                required: "A senha é obrigatória."
            },
            senha2:{
                required: "A confirmação da senha é obrigatória.",
                equalTo: "As senhas não conferem."
            },
            nivel: "Informe o nível de acesso.",
            termos: "Para se cadastrar, você deve aceitar os termos de uso."
        },
        errorPlacement: function(error, element) {
            if (element.attr("name") == "termos")
                error.insertAfter(".box-check label");
            else if (element.attr("name") == "nivel")
                error.insertAfter("select");
            else
                error.insertAfter(element);
        },
        debug:true
    });
    
    // Fecha as caixas de mensagem
    $('.msg button').click(function(){
        $('.msg').fadeOut(1000);
    });
});