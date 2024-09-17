$(document).ready(function () {
    $('fieldset #compra-remove').click(function () {
        var cod = $(this).parent().find('#idcompra').val();
        Swal.fire({
            title: 'MENSAGEM',
            text: "Deseja eliminar a compra: ",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim'
        }).then((result) => {
            if (result.value) {
                apagar(cod);
                Swal.fire(
                        'MENSAGEM!',
                        'Compra apagado com sucesso.',
                        'success'
                        ).then((result) => {
                    if (result.value) {
                        window.location = "controller?operacao=CarrinhoController&carrinho=loja";
                    }
                });
            }
        })

    });

    function apagar(idcompra) {
        var url = "controller?operacao=CarrinhoController&carrinho=apagarcompra"
        $.ajax({
            type: 'POST',
            url: url,
            data: "idcompra=" + idcompra,
            success: function (data, textStatus, jqXHR) {
            }
        });
    }
});

