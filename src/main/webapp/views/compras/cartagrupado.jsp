<div class="modal fade" id="cartagrupado" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-uppercase font-weight-bold" id="exampleModalLabel">Lista agrupada</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="controller?operacao=ModificarMilhar">
                    <table class="table table-bordered text-center font-weight-bold" id="dt">
                        <thead class="bg-gradient-light text-uppercase">
                            <tr>
                                <th scope="col" colspan="4">Lista de milhar</th>

                            </tr>
                        </thead>
                        <tbody class="font-weight-bold">
                            <tr>
                                <th><input id="row_id1" type="text" name="milhar01" class="form-control bg-gradient-light font-weight-bold"> </th>
                                <td><input id="row_id2" type="text" name="milhar02" class="form-control bg-gradient-light font-weight-bold"></td>
                                <td><input id="row_id3" type="text" name="milhar03" class="form-control bg-gradient-light font-weight-bold"></td>
                                <td><input id="row_id4" type="text" name="milhar04" class="form-control bg-gradient-light font-weight-bold"></td>
                            </tr>
                            <tr>
                                <th><input id="row_id5" type="text" name="milhar05" class="form-control bg-gradient-light font-weight-bold"> </th>
                                <td><input id="row_id6" type="text" name="milhar06"  class="form-control bg-gradient-light font-weight-bold"></td>
                                <td><input id="row_id7" type="text" name="milhar07"  class="form-control bg-gradient-light font-weight-bold"></td>
                                <td><input id="row_id8" type="text" name="milhar08" class="form-control bg-gradient-light font-weight-bold"></td>
                            </tr>

                        </tbody>
                    </table>

                    <div class="modal-footer">
                        <button type="button" class="btn bg-gradient-light border" data-dismiss="modal"><i class="fa fa-closed-captioning"> Fechar</i></button>
                        <button type="submit" class="btn bg-gradient-light border"><i class="fa fa-save"> Gravar</i> </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
