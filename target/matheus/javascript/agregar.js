$(document).ready(function () {
    $("fieldset #frm").click(function () {
        var chaveJogo = $(this).parent().find("#chaveJogo").val();

        if (chaveJogo === "") {
            Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: 'Valor invalido!',
                showConfirmButton: false,
                timer: 1500
            });
        } else {
            run(chaveJogo);
        }
    });//fim clik

    function run(chaveJogo) {
        let timerInterval;
        Swal.fire({
            title: 'Aguarde...',
            html: 'Preenchendo milhar na cartela: ' + chaveJogo,
            timer: 2000,
            timerProgressBar: true,
            onBeforeOpen: () => {
                Swal.showLoading()
                timerInterval = setInterval(() => {
                    const content = Swal.getContent()
                    if (content) {
                        const b = content.querySelector('b')
                        if (b) {
                            b.textContent = Swal.getTimerLeft()

                        }
                    }
                }, 100)
            },
            onClose: () => {
                clearInterval(timerInterval)
            }
        }).then((result) => {
            if (result.dismiss === Swal.DismissReason.timer) {

                agregar(chaveJogo);
                parent.location.href = "controller?operacao=CarrinhoController&carrinho=loja";

            }
        });
    }

    function agregar(chaveJogo) {
        var url = "controller?operacao=CarrinhoController&carrinho=agregar";
        $.ajax({
            type: 'POST',
            url: url,
            data: "chaveJogo=" + chaveJogo,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }
});


