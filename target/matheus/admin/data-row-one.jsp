<div class="row mt-3">
    <div class="col-md-4 ">
        <div class="card">
            <div class="card-header">Pessoas</div>
            <div class="card-body">
                <h5 class="card-title">Sem compras:</h5>
                <p class="card-text">Mostrar todas pessoas sem compra.</p>
                <div class="table-responsive">
                    <%@ include file="table-view-pessoas-sem-compras.jsp"%>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-5">
        <div class="card">
            <div class="card-header">Compras</div>
            <div class="card-body">
                <h5 class="card-title">Sem apostas:</h5>
                <p class="card-text">Lista</p>
                <div class="table-responsive">
                    <%@ include file="table-view-compras-sem-aposta.jsp"%>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="card">
            <div class="card-header">Habilitar todos recursos de vendas</div>
            <div class="card-body">
                <h5 class="card-title">Informação:</h5>
                <p class="card-text">Atenção muito cuidado quando executar está
                    ação.</p>
                <a href="controller?operacao=HabilitarVendas"
                   class="btn btn-primary"
                   onclick="return confirm('Deseja executar esta ação?')">Iniciar
                    Agora</a>
            </div>
        </div>
    </div>

</div>