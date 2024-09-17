

<div class="modal" tabindex="-1" id="modalqtd">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">
                <h5 class="modal-title text-uppercase font-weight-bold">Modificar a quantidade</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=ModificarQtd" method="post">
                    <div class="form-group">
                        <input type="hidden" name="idcompra" id="idcompra"> <label
                            for="exampleInputEmail1" class="font-weight-bold">Qual a nova quantidade?</label> <input
                            type="number" required="required" class="form-control rounded" name="qtd" id="qtd"
                            aria-describedby="emailHelp"> 
                    </div>
                    <button type="submit" class="btn bg-gradient-light font-weight-bold"><i class="fa fa-edit"></i> Modificar
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
