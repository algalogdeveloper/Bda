<div class="modal fade right" id="comprasModal" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">
                <div class="heading h5 font-weight-bolder ">FORMULÁRIO DE MILHAR</div>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form class=""
                      action="controller?operacao=CarrinhoController&carrinho=pessoa"
                      method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input name="idcompra" type="hidden" id="component-idcompra">
                                <input type="hidden" name="idpessoa" id="component-idpessoa">
                                <input type="text" name="milhar01" required="required"
                                       class="form-control font-weight-bold lg-4x form-control-user"
                                       id="component-descricao" aria-describedby="emailHelp"
                                       placeholder="Milhar 01">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar02" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 02">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar03" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 03">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar04" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 04">
                            </div>
                        </div>
                    </div>
                    <!-- acima de cinco -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar05" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 05">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar06" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 06">
                            </div>
                        </div> 
                    </div>

                    <!-- acima de cinco -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar07" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 07">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="number" name="milhar08" required="required"
                                       class="form-control font-weight-bold form-control-user"
                                       id="component-cidade" placeholder="Milhar 08">
                            </div>
                        </div>
                    </div>

                    <!--                    <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="number" name="milhar09" required="required"
                                                           class="form-control font-weight-bold form-control-user"
                                                           id="component-cidade" placeholder="Milhar 09">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="number" name="milhar10" required="required"
                                                           class="form-control font-weight-bold form-control-user"
                                                           id="component-cidade" placeholder="Milhar 10">
                                                </div>
                                            </div>
                                        </div>-->


                    <div class="form-group">
                        <input type="number" name="valor" required="required"
                               class="form-control font-weight-bold form-control-user"
                               id="component-cidade" placeholder="Valor cartela">
                    </div>
                    <div class="btn-group" role="group" aria-label="Basic example">

                        <button type="submit" id="save-pessoa"
                                class="btn bg-gradient-light border text-success text-center text-uppercase font-weight-bold">
                            <i class="fa fa-save"> Salvar</i> </button>
                        <button type="reset" id="save-pessoa"
                                class="btn bg-gradient-light border text-dark text-center text-uppercase font-weight-bold">
                            <i class="fa fa-clone text-danger">  Limpar</i> </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>






