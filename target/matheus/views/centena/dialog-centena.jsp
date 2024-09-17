
<div class="modal fade" id="pgParcial" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">
        <div class="modal-content">
            <div class="modal-header  border-dark">
                <p class="modal-title text-uppercase font-weight-bold" id="staticBackdropLabel">Formulário
                    DE Cadastro de centenas Grátis</p>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <script>
                function carregar() {
                    var recebe = document.getElementById("recebe");
                    var x = document.getElementById("numero").value;
                    if (x.length == 3) {
                        if (!validar(recebe, x)) {
                            recebe.append(x + " ");
                        }
                        document.querySelector("#numero").value = "";
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
            <div class="modal-body">
                <div class="row">
                    <div class="col-12">
                        <div class="modal-body">
                            <form action="controller?operacao=EnviaCentena" method="post">
                                <div class="form-group">
                                    <input type="hidden" name="id_compra" id="component-idcompra" />
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name"
                                           class="col-form-label font-weight-bold">Centena:* </label> 
                                    <input type="number" name="gratis" maxlength="3"
                                           class="form-control font-weight-bold  border-dark" 
                                           id="numero"
                                           oninput="carregar()">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">Grátis: </label>
                                    <textarea class="form-control  border-dark" 
                                              readonly="readonly" id="recebe"
                                              name="recebe_valor" rows="3"></textarea>
                                </div>
                                <div class="flex-center">
                                    <div class="btn-group " role="group" aria-label="Basic example">
                                        <button type="submit" class="btn btn-success"><i class="fas fa-save"> Enviar</i> </button>
                                        <button type="reset" class="btn btn-outline-danger"
                                                data-dismiss="modal"><i class="fas fa-times"> Fechar</i></button>
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
