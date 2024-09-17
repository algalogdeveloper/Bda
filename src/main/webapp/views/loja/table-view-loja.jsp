<div class="table-responsive">
    <table class="table table-bordered font-weight-bolder table-hover text-center text-uppercase font-weight-bolder"
           id="dataTable" cellspacing="0">
        <caption class="h4 text-primary">
            Local de consulta:
            <c:out value="${local_filt.descricao}" />
        </caption>
        <thead class="bg-gradient-light">
            <tr class="">
                <th>Nº</th>
                <th>Pessoa</th>
                <th>Data</th>
                <th>Qtd</th>
                <th>Valor</th>
                <th>Pagamento</th>
                <th>Números</th>
                <th>Ações</th>
            </tr>
        </thead>

        <tbody>
            <c:if test="${not empty compras }">
                <c:forEach var="c" items="${compras}">
                    <tr>
                        <td><c:out value="${c.numero_cartela}" /></td>
                        <th><c:out value="${c.pessoa.nome}" /></th>

                        <td><ft:formatDate value="${c.dataJogo.time}"
                                       pattern="dd/MM/yyyy" /></td>
                        <td><c:out value="${c.qtd_cartela}" /></td>
                        <td><ft:formatNumber value="${c.valor }" type="currency"></ft:formatNumber></td>
                        <td><c:choose>
                                <c:when test="${c.pagou }">
                                    <label class="alert alert-success p-1"><i
                                            class="fas fa-check"> <c:out value="Pagamento finalizado" /></i></label>
                                    </c:when>
                                    <c:otherwise>
                                    <label class="alert alert-danger p-1"><i
                                            class="fas fa-dollar-sign"> <c:out
                                                value="Pagamento em aberto" /></i></label>
                                        </c:otherwise>
                                    </c:choose></td>

                        <td>
                            <c:forEach var="a" items="${c.apostas}">
                                <c:out value="${a.milhar.value}" />                         
                            </c:forEach>

                        </td>

                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">

                                <a class="btn btn-light" title="Verificar" 
                                   <c:choose>
                                       <c:when test="${permissao == 1 }">
                                           href="controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=<c:out value="${c.idCompra}"/>&idpessoa=<c:out value="${c.pessoa.idPessoa}"/>"
                                       </c:when>									
                                   </c:choose>
                                   href="#" >
                                    <i class="fas fa-calendar-check"> Ver</i>
                                </a>
                                <!--                        <a 	title="Adicionar" 
                                <c:choose>
                                    <c:when test="${permissao == 1 }">
                                        data-toggle="modal" data-target="#comprasModal"
                                        data-whateveridcompra="<c:out value="${c.idCompra}"/>"
                                        data-whateveridpessoa="<c:out value="${c.pessoa.idPessoa}"/>"
                                    </c:when>									
                                </c:choose>
                                class="btn btn-light" href="#"><i
                                    class="fas fa-plus-circle"> Add</i> </a>-->


                                <a 	title="Adicionar" 
                                    <c:choose>
                                        <c:when test="${permissao == 1 }">
                                            data-toggle="modal" data-target="#dialogqtddiferente"
                                            data-whateveridcompra="<c:out value="${c.idCompra}"/>"
                                            data-whateveridpessoa="<c:out value="${c.pessoa.idPessoa}"/>"
                                        </c:when>									
                                    </c:choose>
                                    class="btn btn-light" href="#"><i
                                        class="fas fa-user-plus"> Add</i> </a>	

                                <a 	title="Ajustar valores" 
                                    <c:choose>
                                        <c:when test="${permissao == 1 }">
                                            data-toggle="modal" 
                                            data-target="#addajustevalor"
                                            data-whateverkeycompra="<c:out value="${c.idCompra}"/>"									
                                            data-whateverkeypessoa="<c:out value="${c.pessoa.idPessoa}"/>"
                                        </c:when>									
                                    </c:choose>
                                    class="btn btn-light" href="#"><i
                                        class="fas fa-pencil-alt"> Valor</i> </a>	
                                <a 	title="Ajustar qtd" 
                                    <c:choose>
                                        <c:when test="${permissao == 1 }">
                                            data-toggle="modal" 
                                            data-target="#modalqtd"
                                            data-whateverqtd="<c:out value="${c.idCompra}"/>"	
                                        </c:when>									
                                    </c:choose>
                                    class="btn btn-light" href="#"><i class="fas fa-edit"> Qtd</i> </a>	


                                <c:choose>
                                    <c:when test="${permissao == 1 }">
                                        <a class="btn btn-light" title="Remover"
                                           onclick="return confirm('Deleta aposta')" de
                                           href="controller?operacao=CarrinhoController&carrinho=apagarcompra&idcompra=<c:out value="${c.idCompra}"/>">
                                            <i class="fas fa-trash-alt"> Del</i>
                                        </a>
                                    </c:when>
                                </c:choose>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
    <strong>Quantidade de talões: <c:out value="${soma}"/></strong>
</div>