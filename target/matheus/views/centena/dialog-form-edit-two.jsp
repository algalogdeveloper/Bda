
<div class="modal fade" id="edit_form_centena" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Editando centena</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=ModificarCentenaGratisTwo"
                      method="post">
                    <input type="hidden" id="component-idcentena-gratis"
                           name="id_centena">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Centena:</label>
                        <input type="text" name="centena" class="form-control"
                               id="component-centena">
                    </div>
                    <div class="modal-footer">
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


