<div class="modal fade right" id="pgParcial" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
    <div
        class="modal-dialog modal-side modal-bottom-right modal-notify modal-info"
        role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="heading">DEBITAR VENDA CLIENTE</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-12">
                        <div class="card-body">
                            <div class="">
                                <form class=""
                                      action="controller?operacao=ObterPagamentoparcial"
                                      method="post">
                                    <div class="row">

                                        <div class="form-group">

                                            <input type="number" name="idpessoa" required="required"
                                                   hidden=""
                                                   class="form-control font-weight-bold lg-4x form-control-user"
                                                   id="component-idpessoa" readonly="readonly"
                                                   aria-describedby="emailHelp" placeholder="Código pessoa">
                                        </div>
                                        <div class="form-group">
                                            <input type="number" readonly="readonly" hidden=""
                                                   name="idcompra" required="required"
                                                   class="form-control font-weight-bold form-control-user"
                                                   id="component-idcompra" placeholder="Código compra">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="number" name="valor" required="required"
                                               class="form-control font-weight-bold form-control-user"
                                               id="component-valor" placeholder="R$ Valor para debitar">
                                    </div>

                                    <button type="submit" id="save-pessoa"
                                            class="btn btn-outline-success text-center text-uppercase font-weight-bold btn-block">
                                        <i class="fas fa-save"></i> Enviando valor para debitar
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


