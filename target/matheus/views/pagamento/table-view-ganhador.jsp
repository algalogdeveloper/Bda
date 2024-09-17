<table
    class="table table-striped table-hover font-weight-bold text-center text-uppercase"
    id="dataTable">
    <thead class="bg-gradient-light">
        <tr>
            <th scope="col">Posição</th>
            <th scope="col">Pessoa</th>
            <th scope="col">Endereço</th>
            <th scope="col">Milhar</th>
            <th scope="col">Pagou</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty compras}">
            <c:forEach var="c" items="${compras}">
                <tr>
                    <th scope="row"><c:out value="${c.posicao}º prêmio" /></th>
                    <td><c:out value="${c.pessoa}" /></td>
                    <td><c:out value="${c.endereco}" /></td>
                    <td><c:out value="${c.milhar}" /></td>

                    <td><c:choose>
                            <c:when test="${c.pagou eq 'Sim' }">
                                <strong class="p-2 aler alert-success">Sim</strong>
                            </c:when>
                            <c:otherwise>
                                <strong class="p-1 aler alert-danger">Não</strong>
                            </c:otherwise>
                        </c:choose></td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>