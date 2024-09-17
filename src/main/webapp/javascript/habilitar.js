$(document).ready(function () {
    $('fieldset #habilit-milhar').click(function () {
        var cod = $(this).parent().find('#habilitar').val();
        Swal.fire({
            title: 'Mensagem',
            text: "Deseja ativa este milhar: " + cod,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim'
        }).then((result) => {
            if (result.value) {
                apagar(cod);
                Swal.fire(
                        'Informação!',
                        'Milhar foi ativado.',
                        'success'
                        ).then((result) => {
                    if (result.value) {
                        parent.location.href = "controller?operacao=ConsultasController&consulta=ativa&buscar= ";
                    }
                });
            }
        })

    });

    function apagar(value) {
        var url = "controller?operacao=ConsultasController&consulta=habilitar"
        $.ajax({
            type: 'POST',
            url: url,
            data: "habilitar=" + value,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }
});
