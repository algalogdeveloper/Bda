

<div class="modal fade right" id="pgParcial2" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="true">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">

        <div class="modal-content">
            <div class="modal-header  border-dark">
                <p class="modal-title text-uppercase font-weight-bold" id="staticBackdropLabel">Formulário
                    centenas gratisinha</p>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <script>
                function add() {
                    var x = document.getElementById("numero2").value;
                    var carrinho = document.getElementById("recebe2");
                    if (x.length == 3) {
                        if (!validar(carrinho, x))
                            carrinho.append(x + " ");
                        document.querySelector("#numero2").value = "";
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
                }
            </script>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12">
                        <div class="modal-body">
                            <form action="controller?operacao=EnviaCentenaGratisinha"
                                  method="post">
                                <div class="form-group">
                                    <input type="hidden" name="id_compra" id="component-idcompra2" />
                                </div>

                                <div class="form-group">
                                    <label for="message-text"
                                           class="col-form-label font-weight-bold">Adicionando
                                        centenas:*</label> <input name="gratisinha" type="number"
                                                              maxlength="3" class="form-control font-weight-bold border-dark"
                                                              id="numero2" oninput="add()" />
                                </div>

                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">Centenas
                                        Grátisinhas: </label>
                                    <textarea class="form-control border-dark" required="required"
                                              readonly="readonly" id="recebe2" name="recebe_valor" rows="3"></textarea>
                                </div>

                                <div class="flex-center">
                                    <div class="btn-group" role="group" aria-label="Basic example">

                                        <button type="submit" class="btn btn-success">
                                            <i class="fas fa-save"> Enviar</i>
                                        </button>
                                        <button type="reset" class="btn btn-danger"
                                                data-dismiss="modal">
                                            <i class="fas fa-times"> Fechar</i>
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>

    </div>
</div>