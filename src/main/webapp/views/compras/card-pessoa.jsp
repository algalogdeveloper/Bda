<div class="card-body">
    <div class="card-group">
        <div class="card">
            <h5 class="card-header">Filtrar pessoa pelo nome:</h5>
            <div class="card-body">
                <p class="card-text">
                <form class="form-inline" action="controller">

                    <div class="form-group mx-sm-3 mb-2">
                        <input name="operacao" value="ConsultasController" hidden="">
                        <input name="consulta" value="cartela-por-pessoa" hidden="">
                        <label for="inputPassword2" class="sr-only">Buscar</label> <input
                            type="text" name="buscar" class="form-control font-weight-bold"
                            id="inputPassword2" placeholder="Apelido da pessoa?">
                    </div>
                    <button type="submit" class="btn btn-outline-primary mb-2">
                        <i class="fas fa-filter"></i> Buscar cliente
                    </button>

                </form>
            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Situação:</h5>
            <div class="card-body">

                <p class="card-text alert alert-info">A situação que a pessoa se
                    encontra é referente aos pagamentos realizados na tela de
                    pagamento.</p>

            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Observações:</h5>
            <div class="card-body">
                <p class="card-text alert alert-danger">Todas cartelas vendidas
                    estão listadas abaixo.</p>

            </div>
        </div>
    </div>
    <hr>
    <div class="row">

        <%@ include file="table-view-compras-por-pessoa.jsp"%>

        <br>

    </div>
    <strong class="font-weight-bold">Limite permitido de cartelas
        <c:out value="${size}" />
    </strong>
</div>