<div class="modal fade right" id="dialogqtddiferente" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">
                <div class="heading h5 font-weight-bolder">ENVIAR MILHAR DOS
                    TALÕES</div>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=InserirTalaoQTDDiferente"
                      method="post">
                    <div class="form-group">
                        <input type="hidden" name="id_compra" id="component-idcompra-qtd" />
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label font-weight-bold">Digite o
                            milhar do cliente:*</label> <input name="milhar" 
                                                           type="number" 
                                                           maxlength="3"
                                                           class="form-control font-weight-bold border" 
                                                           id="milhar_estranho"
                                                           oninput="enviar()" />
                    </div>


                    <div class="form-group">
                        <strong id="lm">Total de numeros: </strong>
                        <textarea class="form-control border font-weight-bolder" 
                                  required="required"
                                  readonly="readonly"
                                  id="lista_estranha" 
                                  name="lista" 
                                  rows="3"></textarea>
                    </div>
                    <div class="flex-center">
                        <button type="submit" class="btn bg-gradient-light border font-weight-bold">
                            <i class="fas fa-save"> Enviar</i>
                        </button> 
                        <button type="button" id="btl" class="btn bg-gradient-light border font-weight-bold">
                            <i class="fas fa-bug text-danger"> Limpar</i>
                        </button>

                    </div>
                    <script>
                        var btl = document.getElementById("btl");
                        btl.addEventListener('click', function () {
                            $("#lista_estranha").text("");
                            auto = 0;
                            $("#lm").text("Total de numeros: ");

                        });
                    </script>
                </form>
            </div>
        </div>
    </div>
</div>


<script>
    var auto = 0;
    function enviar() {
        var recebe = document.getElementById("lista_estranha");
        var x = document.getElementById("milhar_estranho").value;

        if (x.length === 4) {
            if (!validar(recebe, x)) {
                recebe.append(x + " ");
                auto = auto + 1;
            }
            document.querySelector("#milhar_estranho").value = "";

            $("#lm").text("Total de numeros: " + auto);
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