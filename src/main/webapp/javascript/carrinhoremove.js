$(document).ready(function () {
    $('fieldset #carrinho-remove').click(function () {
        var cod = $(this).parent().find('#idJogo').val();
        Swal.fire({
            title: 'Mensagem',
            text: "Deseja eliminar este milhar: " + cod,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim'
        }).then((result) => {
            if (result.value) {
                apagar(cod);
                Swal.fire(
                        'Excluir!',
                        'Milhar apagado com sucesso.',
                        'success'
                        ).then((result) => {
                    if (result.value) {
                        parent.location.href = "controller?operacao=CarrinhoController&carrinho=loja";
                    }
                });
            }
        })

    });

    function apagar(value) {
        var url = "controller?operacao=CarrinhoController&carrinho=delete"
        $.ajax({
            type: 'POST',
            url: url,
            data: "idJogo=" + value,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }
});

