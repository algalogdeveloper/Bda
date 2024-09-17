<table class="table table-borderless table-hover text-center text-uppercase" id="dataTable">
    <thead class="bg-gradient-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Contato</th>
            <th scope="col">E-mail</th>
            <th scope="col">Login</th>
            <th scope="col">Permissão</th>
            <th scope="col">Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty funcionarios}">
                <c:forEach var="f" items="${funcionarios}">
                    <tr>
                        <th scope="row"><c:out value="${f.idFuncionario }" /></th>
                        <td><c:out value="${f.nome }" /></td>
                        <td><c:out value="${f.contato }" /></td>
                        <c:choose>
                            <c:when test="${not empty f.email}">
                                <td><c:out value="${f.email }" /></td>
                            </c:when>
                            <c:otherwise>
                                <td>Não existe e-mail</td>
                            </c:otherwise>
                        </c:choose>

                        <td><c:out value="${f.login }" /></td>
                        <td><c:choose>
                                <c:when test="${ f.permissao == 1}">
                                    Ações de Baixas
                                </c:when>
                                <c:when test="${ f.permissao == 2}">
                                    Ações de Consultas
                                </c:when>
                                <c:when test="${ f.permissao == 3}">
                                    Ações de Acomponhamentos
                                </c:when>
                                <c:when test="${ f.permissao == 4}">
                                    Administrador Sistema
                                </c:when>

                                <c:otherwise>Cargo não existe</c:otherwise>
                            </c:choose></td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="#" class="btn btn-primary" 
                                   data-toggle="modal" data-target="#modalFuncionario"
                                   data-whateverid="<c:out value="${f.idFuncionario}"/>"
                                   data-whatevernome="<c:out value="${f.nome}"/>"
                                   data-whatevercontato="<c:out value="${f.contato}"/>"
                                   data-whateverpermissao="<c:out value="${f.permissao}"/>"
                                   data-whateverlogin="<c:out value="${f.login}"/>"
                                   data-whateveremail="<c:out value="${f.email}"/>"
                                   > <i
                                        class="fa fa-user-edit"></i>
                                </a> <a href="#" class="btn btn-danger"> <i
                                        class="fas fa-trash-alt"></i>
                                </a>

                            </div>
                        </td>
                    </tr>
                </c:forEach>

            </c:when>
            <c:otherwise>
                <tr>
                    <th scope="row" colspan="4">Não existe registros</th>
                </tr>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>