$(document).ready(function () {
    $("fieldset #agregar").click(function () {
        var chaveJogo = $(this).parent().find("#chaveJogo").val();


    });//fim clik


    function carregarListPremio(chaveJogo) {
        var url = "controller?operacao=Carregar&carrinho=agregar";
        $.ajax({
            type: 'POST',
            url: url,
            data: "chaveJogo=" + chaveJogo,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }
});


