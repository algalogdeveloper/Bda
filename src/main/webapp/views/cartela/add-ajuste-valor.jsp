<div class="modal fade right" id="addajustevalor" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="false">
    <div class="modal-dialog modal-dialog-centered modal-info"
         role="document">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">                
                <div class="heading h5 font-weight-bolder" >AJUSTAR VALOR TALÃO</div>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form class=""
                      action="controller?operacao=CarrinhoController&carrinho=AjustarValor"
                      method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="hidden" placeholder="idcompra" name="idcompra"  id="compra-idcompra">
                                <input type="hidden" placeholder="idpessoa" name="idpessoa" id="pessoa-idpessoa">

                            </div>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1" class="font-weight-bold">Qual é o valor:</label>
                        <input type="number" name="valor" required="required"
                               class="form-control font-weight-bold form-control-user"
                               id="component-valor" placeholder="">
                    </div>
                    <div class="btn-group" role="group" aria-label="Basic example">

                        <button type="submit" id="save-pessoa"
                                class="btn bg-gradient-light border font-weight-bold text-center text-uppercase">
                            <i class="fa fa-edit">  Ajustar</i> </button>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>






