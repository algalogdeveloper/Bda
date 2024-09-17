<div class="card">
    <div class="card-body">
        <form action="controller?operacao=CarrinhoController" method="post">
            <div class="row">
                <input name="carrinho" value="sequencia" hidden="">
                <div class="col-md-3">
                    <div class="mb-1">
                        <input required="" type="number" name="milhar01" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="1º Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar02" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="2º Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar03" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="3º Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar04" required="" max="9999" min="0" maxlength="4" class="form-control font-weight-bolder" placeholder="4º Milhar" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
            </div> 

            <div class="row">
                <div class="col-md-3 ">
                    <div class="mb-1">
                        <input required="" name="milhar05" type="number" max="9999" min="0" maxlength="4" placeholder="5º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">                        
                        <input type="number" name="milhar06" required="" max="9999" min="0" maxlength="4" placeholder="6º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar07" required="" max="9999" min="0" maxlength="4" placeholder="7º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="mb-1">
                        <input type="number" name="milhar08" required="" max="9999" min="0" maxlength="4" placeholder="8º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
            </div> 

            <div class="row">
                <div class="col-md-6">
                    <div class="mb-1">
                        <input required="" name="milhar09" type="number" max="9999" min="0" maxlength="4" placeholder="9º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                    </div>
                </div>
                <div class="col-md-6">
                    <div class="mb-1">                        
                        <input type="number" name="milhar10" required="" max="9999" min="0" maxlength="4" placeholder="10º Milhar" class="form-control font-weight-bolder" id="exampleInputEmail1" aria-describedby="emailHelp">

                    </div>
                </div>



            </div> 

            <button type="submit" class="btn btn-primary"> <i class="fa fa-caret-right"> Analisar Numeros</i> </button>
            <button type="reset" class="btn btn-danger"> <i class="fa fa-bug"> Limpar Campos</i> </button>

        </form>

    </div>
    <div class="card-footer font-italic font-weight-bolder text-danger">
        Todos campos são obrigatórios *
    </div>
</div>