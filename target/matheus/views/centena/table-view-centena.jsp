<div class="table-responsive">
    <table id="dataTable"
           class="table table-borderless table-hover text-center font-weight-bold">
        <thead>
            <tr>
                <th scope="col">ID#</th>
                <th scope="col">PESSOA</th>
                <th scope="col">VALOR</th>
                <th scope="col">DATA COMPRA</th>
                <th scope="col">QTD</th>
                <th>PAGAMENTO</th>
                <th scope="col">AÇÕES</th>
        </thead>
        <tbody class="text-center">

            <c:forEach var="c" items="${compras}">
                <tr>
                    <th scope="row"><c:out value="${c.idCompra}" /></th>
                    <td scope="row"><c:out value="${c.pessoa.nome }" /></td>
                    <td><fmt:formatNumber value="${c.valor}" type="currency" /></td>
                    <td><fmt:formatDate value="${c.dataJogo.time}"
                                    pattern="dd/MM/yyyy" /></td>
                    <td><c:out value="${c.qtd_cartela} cartelas" /></td>
                    <td><c:if test="${c.pagou }">
                            <c:out value="CONCLUIDO" />
                        </c:if> <c:if test="${not c.pagou }">
                            <c:out value="EM ABERTO" />
                        </c:if></td>
                    <td>
                        <div class="btn-group" role="group" aria-label="Basic example">

                            <button type="button" class="btn btn-outline-success" href="#"
                                    data-toggle="modal" data-target="#pgParcial"
                                    data-whatevereidcompra="<c:out value="${c.idCompra}"/>">
                                <i class="fas fa-plus-circle"> Grátis</i>
                            </button>

                            <button type="button"  class="btn btn-outline-secondary"
                                    href="#" data-toggle="modal" data-target="#pgParcial2"
                                    data-whatevereidcompra="<c:out value="${c.idCompra}"/>">
                                <i class="fas fa-plus-circle"> Gratisinha</i>
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>