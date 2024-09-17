<table class="table table-borderless">
    <caption>
        Total de cliente:
        <c:out value="${qtd}" />
    </caption>
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Cliente</th>
            <th scope="col">Data registro</th>
            <th scope="col">Endereço</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty compras}">
                <c:forEach items="${compras}" var="c">
                    <tr>
                        <th scope="row"><c:out value="${c.pessoa.idPessoa}" /></th>
                        <td><c:out value="${c.pessoa.nome}" /></td>
                        <td><f:formatDate value="${c.pessoa.dataRegistro.time}"
                                      pattern="dd/MM/yyyy" /></td>
                        <td><c:out value="${c.pessoa.local.descricao}" /></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </tbody>
</table>