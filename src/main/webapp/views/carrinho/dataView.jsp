<div class="row">
    <div class="col-md-12">
        <div class="table table-responsive">
            <table class="table table-striped table border">
                <thead class="text-uppercase">
                <th class="col-auto">Nº</th>
                <th class="col-auto">Cliente</th>
                <!--                <th class="col-auto">Endereço</th>-->
                <!--                <th class="col-auto">Data compra</th>-->
                <th class="col-auto">R$ Valor</th>
                <th class="col-auto">Qtd</th>
                <th class="col-auto">Situação</th>
                <!--                <th class="col-auto">Números</th>-->
                </thead>
                <tbody>
                    <tr class="font-weight-bold">
                        <td><core:out value="${compra.numero_cartela}"/></td>
                        <td><core:out value="${compra.pessoa.nome}"/></td>
        <!--                <td><core:out value="${compra.pessoa.local.descricao}"/></td>-->
        <!--                <td><formatador:formatDate value="${compra.dataJogo.time}" pattern="dd/MM/yyyy" /></td>-->
                        <td><formatador:formatNumber value="${compra.valor}" type="currency"/> </td>
                        <td><core:out value="${compra.qtd_cartela}"/></td>
                        <td>
                            <core:choose>
                                <core:when test="${compra.pagou}">
                                    <strong class="alert alert-success p-1"><core:out value="Concluido"/></strong>   
                                </core:when>
                                <core:otherwise>
                                    <strong class="alert alert-danger p-1"><core:out value="Em Aberto"/></strong> 
                                </core:otherwise>
                            </core:choose>
                        </td>
        <!--                <td><core:out value="${compra.apostas}"/></td>-->
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
