$(document).ready(function () {
    $("td #excluir-local").click(function () {
        var idlocal = $(this).parent().find("#codlocal").val();
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Mensagem',
            text: "Deseja excluir local! ",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Sim',
            cancelButtonText: 'Não',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                apagar(idlocal);
                swalWithBootstrapButtons.fire(
                        'Mensagem!',
                        'Local excluída com sucesso.',
                        'success'
                        ).then((result) => {
                    if (result.value) {

                        parent.location.href = "controller?operacao=LocalController&locais=listar";

                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                        'Cancelada',
                        ' Tentativa de exclusão',
                        'error'
                        )
            }
        });
    });

    function apagar(codlocal) {
        var url = "controller?operacao=LocalController?locais=excluir";
        $.ajax({
            type: 'POST',
            url: url,
            data: "codlocal=" + codlocal,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }

});


