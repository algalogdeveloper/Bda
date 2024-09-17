<div class="modal fade font-weight-bolder" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-uppercase font-weight-bolder" id="exampleModalLabel">Cliente:</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="controller?operacao=EnviandoMilharExtraUI">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Cliente:</label>
                        <input type="text" name="cliente" class="form-control" id="cliente">
                        <input name="idcompra" id="idcompra_me" type="hidden">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Milhar extra:</label>
                        <input type="text" name="me" oninput="carrinho()"  class="form-control" id="me">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Lista de milhar extra:</label>
                        <textarea class="form-control" readonly="" name="numeros_extras" id="numeros_extras"></textarea>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn bg-gradient-light border"><i class="fa fa-save"> Enviar </i></button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<script>
    function carrinho() {
        var recebe = document.getElementById("numeros_extras");
        var milhar = document.getElementById("me").value;
        if (milhar.length === 4) {
            if (!validar(recebe, milhar)) {
                recebe.append(milhar + " ");
            }
            document.querySelector("#me").value = "";
        }
    }
    function validar(carrinho, key) {
        var dados = carrinho.value.split(" ");
        var ok = false;
        for (var r in dados) {
            if (dados[r] === key)
                ok = true;
        }
        return ok;
    }
</script>
