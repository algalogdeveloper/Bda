<%int j=1; %>
<table class="table table-borderless table-hover text-uppercase"
       style="border-collapse: collapse; "
       id="dataTable">
    <thead>
        <tr style="border-bottom: inset; border-width: 1pt;">
            <th scope="col">#Posição</th>
            <th scope="col">Pessoa</th>
            <th scope="col">Endereco</th>
            <th scope="col">Centena</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty gratis}">
            <c:forEach var="c" items="${gratis}">
                <tr>
                    <th scope="row"><%=j++ %> <c:out value="º prêmio" /></th>
                    <td><c:out value="${c.compra.pessoa.nome}" /></td>
                    <td><c:out value="${c.compra.pessoa.local.descricao}" /></td>
                    <td><c:out value="${c.numero}" /></td>
                </tr>
            </c:forEach>
        </c:if>

    </tbody>
</table>