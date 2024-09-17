<div class="modal fade right" id="milharUnico" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div
        class="modal-dialog border-dark modal-side modal-bottom-right modal-notify modal-info"
        role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header bg-gradient-light text-dark">
                <h3 class="heading font-weight-bolder text-uppercase">Formulário</h3>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card-body">
                            <form class="user"
                                  action="controller?operacao=CarrinhoController&carrinho=alterar" method="post">
                                <label for="basic-url" class="font-weight-bold">Milhar:</label>
                                <div class="input-group">
                                    <input name="idcompra" value="<c:out value="${compra.idCompra}"/>"
                                           type="hidden" id="component-idcompra"> <input
                                           type="hidden"
                                           value="<c:out value="${compra.pessoa.idPessoa}"/>"
                                           name="idpessoa" id="component-idpessoa"> 
                                    <input type="hidden" name="idaposta" value="0"  id="component-idaposta"> 
                                    <input type="number" min="0" name="milhar01" required="required" class="form-control font-weight-bold" id="component-milhar"
                                           aria-describedby="emailHelp" placeholder="Milhar 01">

                                    <div class="input-group-prepend">
                                        <button type="submit" id="save-pessoa"
                                                class="btn bg-gradient-primary text-white font-weight-bold ">
                                            <i class="fas fa-save"> Save</i> 
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>