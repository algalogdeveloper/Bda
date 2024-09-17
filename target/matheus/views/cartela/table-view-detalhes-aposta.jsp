<table id="dataTable"
       class="table table-borderless border table-hover font-weight-bold text-center">
    <thead class="bg-gradient-light text-dark">
        <tr class="text-uppercase">
            <th>Milhar</th>
            <th>Disponível</th>
            <th>Ações </th>

        </tr>
    </thead>
    <tbody>
        <c:forEach var="a" items="${apostas}">
            <tr> 
                <td><c:out value="${a.milhar.value}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${not a.milhar.disponivel}">					     		
                            <strong class="alert alert-success p-1"><c:out value="Comprado" /> <i class="fas fa-check"></i> </strong>
                        </c:when>						
                    </c:choose>
                </td>
                <td>

                    <a href="" class="btn bg-gradient-primary text-white font-weight-bold" data-toggle="modal"
                       data-target="#checkModal"
                       data-whatevernumero="<c:out value="${a.milhar.value}"/>"
                       data-whateveridaposta="<c:out value="${a.idAposta}"/>"
                       data-whateveridcompra="<c:out value="${compra.idCompra}"/>"
                       data-whatevermilharold="<c:out value="${a.milhar.value}"/>"
                       data-whateveridpessoa="<c:out value="${compra.pessoa.idPessoa}"/>">

                        <i class="fas fa-pencil-alt"></i>
                    </a>

                    <a onclick="return confirm('Deseja excluir milhar: <c:out value="${a.milhar.value}"/>')" href="controller?operacao=RemoverApostaClienenteASCascate&idaposta=<c:out value="${a.idAposta}"/>&idpessoa=<c:out value="${compra.pessoa.idPessoa}"/>&idcompra=<c:out value="${compra.idCompra}"/>" class="btn bg-gradient-danger text-white font-weight-bold"> <i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
