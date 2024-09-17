
<table class="table table-striped table-hover" id="dataTable">
    <thead>
        <tr class="text-uppercase">
            <th scope="col" class="col-1">Talao Nº</th>
            <th scope="col">Endereço</th>
            <th scope="col">Cliente</th>
            <th scope="col">Nº de cartela</th>
            <th scope="col">Data da aposta</th>
            <th scope="col" class="col-1">Açoes</th>
        </tr>
    </thead>
    <tbody class="font-weight-bold">
    <c:forEach items="${apostasAgrupadas}" var="c">
        <tr>
            <th scope="row"><c:out value="${c.numero_cartela}"/></th>
        <td><c:out value="${c.pessoa.local.descricao}"/> </td>
        <td><c:out value="${c.pessoa.nome}"/></td>
        <td><c:out value="${c.qtd_cartela}"/></td>
        <td><fmt:formatDate value="${c.dataJogo.time}" pattern="dd/MM/yyyy" /></td>
        <th>
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" 
                        class="btn bg-gradient-light border"
                        data-toggle="modal" 
                        data-target="#cartagrupado"
                        data-cliente="<c:out value="${c.pessoa.nome}"/>"
                data-lista="<c:out value="${c.apostas}"/>"><i class="fa fa-pencil-alt"></i> </button>
                <button type="button" title="Meus numeros"
                        data-toggle="modal" 
                        data-target="#listacomprasmodal" 
                        data-cliente="<c:out value="${c.pessoa.nome}"/>"
                data-compras="<c:out value="${c}"/>" 
                class="btn bg-gradient-light border">
                <i class="fa fa-eye"></i>
                </button>

            </div>

        </th>
        </tr>

    </c:forEach>

</tbody>
</table>