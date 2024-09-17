<table class="table table-borderless text-center table-hover" id="dataTable">
    <caption>
        Total de apostas:
        <c:out value="${qtdMilharNasCompras}" />
    </caption>
    <thead>
        <tr>
            <th scope="col">Cod</th>
            <th scope="col">Cliente</th>					
            <th scope="col">Valor</th>
            <th scope="col">Endereço</th>
            <th>Números</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty compras4}">
                <c:forEach items="${compras4}" var="c">
                    <tr>
                        <th scope="row"><c:out value="${c.idCompra}" /></th>
                        <td><c:out value="${c.pessoa.nome}" /></td>
                        <td> <f:formatNumber value="${c.valor}" type="currency" /> </td>
                        <td><c:out value="${c.pessoa.local.descricao}" /></td>
                        <th>
                            <c:forEach items="${c.apostas}" var="ap">
                                <c:out value="${ap.milhar.value}" />
                            </c:forEach>
                        </th>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </tbody>
</table>