<table id="dataTable" class="table table-borderless table-hover text-center">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Pessoa</th>
            <th scope="col">Endereco</th>
            <th scope="col">Centena</th>
            <th scope="col">Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty gratisinha}">
            <c:forEach var="c" items="${gratisinha}">
                <tr>
                    <th scope="row"><c:out value="${c.idCentena}" /></th>
                    <td><c:out value="${c.compra.pessoa.nome}" /></td>
                    <td><c:out value="${c.compra.pessoa.local.descricao}" /></td>
                    <td><c:out value="${c.numero}" /></td>
                    <th class="text-center">
                        <div class="btn-group" role="group" aria-label="Basic example">

                            <a href="#" class="btn btn-primary"
                               data-toggle="modal" 
                               data-target="#edit_form_centena"
                               data-whatevereid="<c:out value="${c.idCentena}"/>"
                               data-whatevercentena="<c:out value="${c.numero}"/>"
                               ><i class="fas fa-edit"> Editar</i></a> 					
                            <a href="controller?operacao=DeleteCentenaTwo&id=<c:out value="${c.idCentena}"/>" onclick="return confirm('Delete centena agora')" class="btn btn-outline-danger"><i class="fas fa-trash-alt">  Delete</i></a>
                        </div>
                    </th>
                </tr>
            </c:forEach>
        </c:if>

    </tbody>
</table>

<%@ include file="dialog-form-edit-two.jsp" %>