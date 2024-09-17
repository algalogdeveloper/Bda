

<div class="modal" tabindex="-1" id="pgParcial" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark">
                <h5 class="modal-title font-weight-bold">PAGAMENTO PARCIAL</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form class="user" action="controller?operacao=PagamentoParcial"
                      method="post">
                    <label for="basic-url" class="font-weight-bold">Quanto você deseja debitar?</label>
                    <div class="input-group">
                        <!-- <input name="operacao" value="PagamentoParcial" type="hidden"> -->
                        <input name="idcompra" type="hidden" id="component-idcompra">
                        <input type="hidden" name="idpessoa" id="component-idpessoa">
                        <input type="number" name="valor" min="0"
                               value="" required="required"
                               class="form-control font-weight-bold" id="component-milhar"
                               aria-describedby="emailHelp"
                               placeholder="">

                        <div class="input-group-prepend">
                            <button type="submit" id="save-pessoa"
                                    class="btn bg-gradient-light text-dark font-weight-bold btn-block">
                                <i class="fas fa-dollar-sign"> DEBITAR</i> 
                            </button>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>
