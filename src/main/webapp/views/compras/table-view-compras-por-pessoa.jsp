<div class="table-responsive">
    <table
        class="table table-hover table-striped text-uppercase font-weight-bold"
        id="dataTable">
        <thead class="">
            <tr class="">

                <td>Pessoa</td>
                <td>Situação</td>
                <td>Números dos clientes</td>
            </tr>
        </thead>

        <tfoot>
            <tr class="">
                <td>Pessoa</td>
                <td>Situação</td>
                <td>Números dos clientes</td>
            </tr>
        </tfoot>
        <c:forEach var="c" items="${compras}">
            <tr style="border-bottom-style: solid;">
                <td><c:out value="${c.numero_cartela}" /> - <c:out
                        value="${c.pessoa.nome}" /> - <ft:formatNumber value="${c.valor}"
                        type="currency" /></td>

                <td><c:if test="${c.pagou}">
                        <i class=" text-uppercase"> <c:out
                                value="Concorrendo prêmio" />
                        </i>

                    </c:if> <c:if test="${not c.pagou}">
                        <i class="text-uppercase">
                            <c:out value="Pagamento não concluido" />
                        </i>

                    </c:if></td>
                <td><a
                        href="controller?operacao=DetalhesCompraPorPessoas&acao=<c:out value="${c.idCompra}"/>"
                        class="btn btn-outline-primary"><img alt="" width="20" src="img/filtro.png"> Encontra milhar</a></td>
            </tr>
        </c:forEach>
        <c:if test="${empty compras}">
            <tr>
                <td colspan="5">Não existe compras</td>
            </tr>
        </c:if>

    </table>
</div>
