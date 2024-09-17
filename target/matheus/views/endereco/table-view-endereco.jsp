<table
    class="table table-hover table-borderless text-uppercase font-weight-bold"
    id="dataTable">
    <caption>Lista de Endereços</caption>
    <thead>
        <tr>
            <th>#ID</th>
            <th>Descrição</th>
            <th>Cidade</th>
            <th>Rota</th>
            <th class="text-center">Ações</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="e" items="${enderecos}">
            <tr>
                <td><c:out value="${e.idLocal}" /></td>
                <td><c:out value="${e.descricao}" /></td>
                <td><c:out value="${e.cidade}" /></td>
                <td><c:out value="${e.rota.numeroRota}" /></td>
                <td class="text-center">
                    <div class="btn-group" role="group" aria-label="Basic example">

                        <a href="#" data-toggle="modal" data-target="#localModal"
                           data-whateverid="<c:out value="${e.idLocal}"/>"
                           data-whateveredescricao="<c:out value="${e.descricao}" />"
                           data-whateverecidade="<c:out value="${e.cidade}"/>"
                           data-whatevererota="<c:out value="${e.rota.idRota}"/>"
                           class="btn bg-gradient-primary text-white"> <i class="fas fa-pencil-alt"></i>
                        </a> <a onclick="return confirm('Deseja excluir informação?')"
                                href="controller?operacao=LocalController&locais=excluir&codlocal=<c:out value="${e.idLocal}"/>"
                                class="btn bg-gradient-danger text-white"><i class="fas fa-trash-alt"></i> </a>
                    </div>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>