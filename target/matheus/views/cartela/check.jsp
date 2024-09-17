
<div class="modal fade right" id="checkModal" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div
        class="modal-dialog modal-side modal-bottom-right modal-notify modal-info"
        role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header  bg-gradient-light text-dark"">
                <h1 class="heading font-weight-bolder">Formulário</h1>
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
                                    <input name="milhar_old" id="component-idcompra-old" value=""
                                           type="hidden">

                                    <input 	name="idcompra" type="hidden" id="component-idcompra">
                                    <input type="hidden" name="idpessoa" id="component-idpessoa">
                                    <input type="hidden" name="idaposta" id="component-idaposta">
                                    <input type="number" min="0"
                                           name="milhar01" required="required" 
                                           class="form-control font-weight-bold" id="component-milhar"
                                           aria-describedby="emailHelp" placeholder="Milhar 01">
                                    <div class="input-group-prepend">
                                        <button type="submit" id="save-pessoa"
                                                class="btn bg-gradient-success text-white font-weight-bold btn-block">
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