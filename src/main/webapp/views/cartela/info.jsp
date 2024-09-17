<div class="card-deck mb-1">

    <div class="card">
        <div
            class="card-header bg-gradient-light font-weight-bold  text-dark text-uppercase">Enviando numeros do talão
            :</div>
        <div class="card-body">

            <c:if test="${not empty vendaEnviadaCliente }">
                <div class="table table-responsive">
                    <table class="table border table-striped table-hover font-weight-bold">
                        <thead>
                            <tr class="text-uppercase">
                                <th class="col-1">Nº</th>
                                <th>Descrição</th>
                                <th>Qtd</th>
                                <th>Valor</th>
                                <th>Números</th>
                                <th>Situação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><c:out value="${vendaEnviadaCliente. numero_cartela}" /></td>
                                <td class="text-uppercase"><c:out
                                        value="${vendaEnviadaCliente.pessoa.nome}" />  -  <c:out
                                        value="${vendaEnviadaCliente.pessoa.local.descricao}" /></td>
                                <td><c:out value="${vendaEnviadaCliente.qtd_cartela}" /></td>
                                <td><fmt:formatNumber value="${vendaEnviadaCliente.valor}" type="currency" />
                                </td>
                                <c:choose>
                                    <c:when test="${not empty vendaEnviadaCliente.apostas}">
                                        <td><c:forEach var="v"
                                                   items="${vendaEnviadaCliente.apostas}">
                                                <c:out value="${v.milhar.value }" />
                                            </c:forEach></td>
                                        </c:when>
                                    </c:choose>
                                <td><c:choose>
                                        <c:when test="${not vendaEnviadaCliente.pagou}">
                                            <strong class="alert alert-danger p-1"> <c:out
                                                    value="Em aberto" /></strong>
                                            </c:when>
                                            <c:otherwise>
                                            <strong class="alert alert-success p-1"> <c:out
                                                    value="Concluído" /></strong>
                                            </c:otherwise>
                                        </c:choose></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>


        </div>
    </div>

    <div class="card">
        <div
            class="card-header bg-gradient-light font-weight-bold  text-dark text-uppercase">Últimas
            Informações:</div>
        <div class="card-body">

            <c:if test="${not empty msg }">
                <p
                    class="card-text text-center  alert alert-success font-weight-bold">
                    <i class="fas fa-check"> <c:out value="${msg}" /></i>
                </p>
            </c:if>

            <p class="card-text">
                <c:if test="${not empty valid}">
                <p
                    class="alert alert-danger text-center font-weight-bold p-1">
                    <c:out value="${valid}" />
                </p>
            </c:if>
            </p>
        </div>
    </div>
</div>