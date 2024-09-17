<table class="table table-borderless">
    <caption>
        Total de apostas:
        <c:out value="${qtd2}" />
    </caption>
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Cliente</th>
            <th scope="col">Data compra</th>
            <th scope="col">Valor</th>
            <th scope="col">Situação</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty compras2}">
                <c:forEach items="${compras2}" var="c">
                    <tr>
                        <th scope="row"><c:out value="${c.idCompra}" /></th>
                        <td><c:out value="${c.pessoa.nome}" /></td>
                        <td><f:formatDate value="${c.dataJogo.time}"
                                      pattern="dd/MM/yyyy" /></td>
                        <td><c:out value="${c.valor}" /></td>
                        <td><c:choose>
                                <c:when test="${c.pagou}">
                                    Concluido
                                </c:when>
                                <c:otherwise>Em aberto</c:otherwise>
                            </c:choose></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </tbody>
</table>