<div class="modal fade right" id="dialog-taloes-qtd-diferentes-cliente"
     tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" data-backdrop="false">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">
                <div class="heading h5 font-weight-bolder" id="div-cliente">INSERIR MILHAR DE
                    TALÕES DIFERENTE</div>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=InserirTalaoClienteQTDDiferente"
                      method="post">
                    <div class="form-group">
                        <input type="hidden" name="id_compra" id="component-idcompra-qtd" />
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="message-text" class="col-form-label font-weight-bold">Cliente:</label>
                                <input name="CLIENTE_NAME" type="text"
                                       class="form-control font-weight-bold border"
                                       />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="message-text" class="col-form-label font-weight-bold">Endereço:</label>
                                <select
                                    class="custom-select form-control bg-light font-weight-bold border-5 text-uppercase"
                                    name="endereco_cliente" aria-label="Search" aria-describedby="basic-addon2"
                                    id="inlineFormCustomSelectPref">
                                    <c:forEach var="l" items="${locais}">
                                        <option class="font-weight-bold"
                                                value="<c:out value="${l.idLocal}"/>">
                                            <c:out value="${l.descricao}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label font-weight-bold">Adicionando
                            milhar:</label> <input name="milhar1" type="number" maxlength="3"
                                               class="form-control font-weight-bold border" id="milhar1"
                                               oninput="inserindo()" />
                    </div>

                    <div class="form-group">
                        <strong>Lista de milhar: </strong>
                        <textarea class="form-control border-light" required="required"
                                  readonly="readonly" id="lista1" name="lista" rows="3"></textarea>
                    </div>

                    <div class="flex-center">
                        <div class="btn-group" role="group" aria-label="Basic example">

                            <button type="submit" class="btn btn-success">
                                <i class="fas fa-save"> Enviar</i>
                            </button>
                            <button type="reset" class="btn btn-danger" data-dismiss="modal">
                                <i class="fas fa-times"> Fechar</i>
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>


<script>
    function inserindo() {
        var recebe = document.getElementById("lista1");
        var x = document.getElementById("milhar1").value;
        if (x.length === 4) {
            if (!validar(recebe, x)) {
                recebe.append(x + " ");
            }
            document.querySelector("#milhar1").value = "";
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