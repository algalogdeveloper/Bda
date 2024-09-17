<div class="table-responsive">
    <table id="dataTable"
           class="table table-striped table-hover font-weight-bold">
        <thead>
            <tr>
                <th scope="col">Nº cartela</th>
                <th scope="col">Pessoa</th>
                <th scope="col">Valor</th>

                <th scope="col">QTD</th>
                <th>Pagou</th>
                <th scope="col">Ação</th>

            </tr>
        </thead>
        <tbody class="text-center">
            <c:forEach var="c" items="${compras}">
                <tr>
                    <th scope="row"><c:out value="${c.numero_cartela }" />
                    </th>
                    <td scope="row"><c:out value="${c.pessoa.nome }" /></td>
                    <td><fmt:formatNumber value="${c.valor}"
                                      type="currency" /></td>

                    <td><c:out value="${c.qtd_cartela} cartelas" /></td>
                    <td><c:if test="${c.pagou }">
                            <c:out value="Sim" />
                        </c:if> <c:if test="${not c.pagou }">
                            <c:out value="Não" />
                        </c:if></td>

                    <td scope="col">
                        <div class="dropdown">
                            <a class="btn btn-secondary dropdown-toggle" href="#"
                               role="button" id="dropdownMenuLink"
                               data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false"> AÇÕES </a>

                            <div class="dropdown-menu"
                                 aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item" href="controller?operacao=CarrinhoController&carrinho=apagarcompra&idcompra=<c:out value="${c.idCompra}"/>"><i
                                        class="fas fa-trash-alt"></i> Remover</a> <a
                                    class="dropdown-item" 
                                    data-toggle="modal" data-target="#comprasModal"
                                    data-whateveridcompra="<c:out value="${c.idCompra}"/>"
                                    data-whateveridpessoa="<c:out value="${c.pessoa.idPessoa}"/>"
                                    href="#"><i	class="fas fa-plus"></i> Adicionar</a> <a
                                    class="dropdown-item" href="controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=<c:out value="${c.idCompra}"/>&idpessoa=<c:out value="${c.pessoa.idPessoa}"/>"><i
                                        class="fas fa-check"></i> Verificar</a>
                            </div>
                        </div>
                    </td>



                </tr>
            </c:forEach>
        </tbody>


    </table>
</div>