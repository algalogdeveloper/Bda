<div class="card-body">
    <div class="table table-responsive text-uppercase" >
        <table id="dataTable"
               class="table table-borderless table-hover text-center font-weight-bold" >
            <thead>
                <tr >
                    <th scope="col">Nº CARTELA</th>
                    <th scope="col">PESSOA</th>
                    <th scope="col">VALOR</th>
                    <th scope="col">DATA COMPRA</th>
                    <th scope="col">QTD</th>
                    <th>PAGAMENTO</th>
                    <th scope="col">Enviados agora</th>
                </tr>

            </thead>
            <tbody class="text-center">
                <c:forEach var="c" items="${compras}">
                    <tr>
                        <th scope="row"><c:out value="${c.numero_cartela }" /></th>
                        <td scope="row"><c:out value="${c.pessoa.nome }" /></td>
                        <td><fmt:formatNumber value="${c.valor}" type="currency" /></td>
                        <td><fmt:formatDate value="${c.dataJogo.time}" pattern="dd/MM/yyyy" /></td>
                        <td><c:out value="${c.qtd_cartela} cartelas" /></td>
                        <td><c:if test="${c.pagou }">
                                <c:out value="CONCLUIDO" />
                            </c:if> <c:if test="${not c.pagou }">
                                <c:out value="EM ABERTO" />
                            </c:if></td>
                        <td>
                            <c:forEach var="a" items="${c.apostas}">
                                <strong class="text-primary"><c:out value="${a.milhar.value}" /> </strong>
                            </c:forEach>
                        </td>							
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>