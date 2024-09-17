<table class="table table-hover table-bordered text-uppercase"
       id="dataTable">
    <thead class="bg-gradient-light">
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Contato</th>
            <th>Referencia</th>
            <th>Endereço</th>
            <th>Data Registro</th>
            <th>AÇÕES</th>
        </tr>
    </thead>
    <tfoot>
        <tr class="alert alert-dark">

            <th>Id</th>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Contato</th>
            <th>Referencia</th>
            <th>Endereço</th>
            <th>Data Registro</th>
            <th>AÇÕES</th>
        </tr>
    </tfoot>
    <tbody>
        <c:if test="${not empty pessoas}">

            <c:forEach var="p" items="${pessoas}">
                <tr>
                    <td><c:out value="${p.idPessoa}" /></td>
                    <td><c:out value="${p.nome}" /></td>
                    <td><c:choose>
                            <c:when test="${not empty p.email}">
                                <c:out value="${p.email}" />
                            </c:when>
                            <c:otherwise>
                                <c:out value="Atualize as informações" />
                            </c:otherwise>
                        </c:choose></td>
                    <td><c:out value="${p.contato}" /></td>
                    <td><c:choose>
                            <c:when test="${not empty p.referencia}">
                                <c:out value="${p.referencia}" />
                            </c:when>
                            <c:otherwise>
                                <c:out value="Atualize as informações" />
                            </c:otherwise>
                        </c:choose></td>
                    <th><c:out value="${p.local.descricao}" /></th>
                    <th><fmt:formatDate value="${p.dataRegistro.time}"
                                    pattern="dd/MM/yyyy" /></th>

                    <td>
                        <div class="btn-group" role="group" aria-label="Basic example">

                            <a class="btn btn-primary" href="#" data-toggle="modal"
                               data-target="#modalDiscount"
                               data-whateverid="<c:out value="${p.idPessoa}"/>"
                               data-whatevernome="<c:out value="${p.nome}" />"
                               data-whateveremail="<c:out value="${p.email}"/>"
                               data-whateverecontato="<c:out value="${p.contato}"/>"
                               data-whateverlocal="<c:out value="${p.local.idLocal}"/>"								
                               data-whateverreferencia="<c:out value="${p.referencia}"/>"><i
                                    class="fas fa-pencil-alt"></i></a> <a
                                onclick="return confirm('Deseja excluir a pessoa?')"
                                class="btn btn-danger"
                                href="controller?operacao=PessoaController&pessoa=remove&codpessoa=<c:out value="${p.idPessoa}"/>"><i
                                    class="fas fa-trash-alt"></i></a>
                        </div>


                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>