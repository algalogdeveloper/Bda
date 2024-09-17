<table
    class="table table-borderless table-hover text-center text-uppercase text-center">
    <thead>
        <tr>
            <th>Chave#</th>
            <th>Descrição</th>
            <th>Valor R$</th>
            <th>Situação</th>
        </tr>
    </thead>
    <c:if test="${not empty meuPagamento }">
        <tbody>
            <tr>
                <td><c:out value="${meuPagamento. numero_cartela}" /></td>
                <td class=""><c:out value="${meuPagamento.pessoa.nome}" /> -
                    <c:out value="${meuPagamento.pessoa.local.descricao}" /></td>
                <td><f:formatNumber value="${meuPagamento.valor}"
                                type="currency" /> </td>
                <td><c:if test="${meuPagamento.pagou}">
                        <c:out value="Pagamento efetivado" />
                    </c:if> <c:if test="${not meuPagamento.pagou}">
                        <strong style="color: red;"><c:out value="Em aberto" /></strong>
                    </c:if></td>
            </tr>
        </tbody>
    </c:if>
</table>