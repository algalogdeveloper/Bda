$(document).ready(function () {
    $("td #delete-pessoa").click(function () {
        var codpessoa = $(this).parent().find("#codpessoa").val();

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Mensagem',
            text: "Deseja excluir pessoa! ",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Sim',
            cancelButtonText: 'Não',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                apagar(codpessoa);
                swalWithBootstrapButtons.fire(
                        'Mensagem!',
                        'Pessoa excluída com sucesso.',
                        'success'
                        ).then((result) => {
                    if (result.value) {

                        parent.location.href = "controller?operacao=PessoaController&pessoa=view";

                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                        'Cancelada',
                        ' Tentativa de exclusão',
                        'error'
                        )
            }
        })


    });

    function apagar(codpessoa) {
        var url = "controller?operacao=PessoaController&pessoa=remove";
        $.ajax({
            type: 'POST',
            url: url,
            data: "codpessoa=" + codpessoa,
            success: function (data, textStatus, jqXHR) {

            }

        });

    }
});