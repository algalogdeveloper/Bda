<form action="controller?operacao=VerificarGanhador" id="frm" method="post">

    <div class="form-group">

        <input type="number" required="" name="milhar" max="9999"
               class="form-control font-weight-bold btn-round" min="0" maxlength="4"
               placeholder="Digite o primeiro milhar?" id="milhar">
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <input type="number" required="" name="p2" min="0" maxlength="4"
                       class="form-control font-weight-bold btn-round" min="0" max="9999"
                       id="component-name" placeholder="2º milhar?">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="number" required="" name="p3" min="0" maxlength="4"
                       max="9999" class="form-control font-weight-bold btn-round"
                       id="component-name" placeholder="3º milhar">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="number" required="" name="p4" min="0" maxlength="4"
                       max="9999" class="form-control font-weight-bold btn-round"
                       id="component-name" placeholder="4º milhar">
            </div>
        </div>


        <div class="col-md-6">
            <div class="form-group">
                <input type="number" required="" name="p5" min="0" maxlength="4"
                       max="9999" class="form-control font-weight-bold btn-round"
                       id="component-name" placeholder="5º milhar">
            </div>
        </div>



    </div>



    <div class="form-group">
        <div class="btn-group" role="group" aria-label="Basic example">
            <button type="submit" name="btTableView"
                    class="btn bg-gradient-light border font-weight-bold text-dark"
                    value="tableview">
                <i class="fas fa-user-friends"> VERIFICAR GANHADORES</i>
            </button>
        </div>
    </div>

</form>