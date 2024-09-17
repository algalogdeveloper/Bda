<div class="card">
    <div class="card-header">Compras com quantidade acima</div>
    <div class="card-body">
        <h5 class="card-title">apostas:</h5>
        <p class="card-text">Lista</p>
        <table class="table table-borderless text-center">
            <caption>
                Total acima:
                <c:out value="${acima_qtd}" />
            </caption>
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Qtd. talão</th>
                    <th scope="col">Qtd. inserido</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Endereço</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty compras5}">
                        <c:forEach items="${compras5}" var="c">
                            <tr>
                                <th scope="row"><c:out value="${c.idCompra}" /></th>
                                <td><c:out value="${c.pessoa.nome}" /></td>
                                <td><c:out value="${c.qtd_cartela}" /></td>
                                <td><c:out value="${c.qtdAlternativa}" /></td>
                                <td><c:out value="${c.valor}" /></td>
                                <td><c:out value="${c.premio}" /></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </div>
</div>