
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">


                        <div class="row ">

                            <div class="col-xl-12">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark h6 text-uppercase font-weight-bold">
                                        últimas Informações enviadas</div>
                                    <div class="card-body">
                                        <c:choose>
                                            <c:when test="${not  empty msg }">
                                                <p class="alert alert-success text-center text-uppercase">
                                                    <i class="fas fa-check"> <c:out value="${msg}" /></i></p>
                                                </c:when>

                                        </c:choose>

                                        <div class="table table-responsive">
                                            <table class="table table-striped text-uppercase text-center font-weight-bold border-bottom-light "
                                                   >
                                                <thead class="bg-gradient-light">
                                                    <tr >
                                                        <td>Cliente</td>
                                                        <td>Funcionário</td>
                                                        <td>R$ Valor</td>
                                                        <td>Quantidade de talão</td>

                                                    </tr>
                                                </thead>
                                                <c:if test="${not empty meuPagamento2}">
                                                    <tbody>
                                                        <tr class="text-dark font-weight-bold">
                                                            <td><c:out value="${meuPagamento2.pessoa.nome}" /></td>
                                                            <td><c:out value="${meuPagamento2.funcionario.nome}" /></td>
                                                            <td><fmt:formatNumber value="${meuPagamento2.valor}"
                                                                              type="currency" /></td>
                                                            <td><c:out value="${meuPagamento2.qtd_cartela }" /></td>

                                                        </tr>
                                                    </tbody>
                                                </c:if>
                                            </table>

                                        </div>




                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row mt-1">

                            <div class="col-xl-12">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark h6 text-uppercase font-weight-bold">Descrição
                                        das aposta dos clientes</div>
                                    <div class="card-body">


                                        <div class="table-responsive">
                                            <table
                                                class="table  table-hover table-striped text-uppercase font-weight-bold "
                                                id="dataTable">
                                                <thead class="bg-gradient-light">
                                                    <tr class="text-dark">
                                                        <th>Id</th>
                                                        <th>Pessoa</th>
                                                        <th>Funcionario</th>
                                                        <th>Data compra</th>
                                                        <th>Qtd. talões</th>
                                                        <th>Valor</th>
                                                        <th>Endereço</th>
                                                        <th>Pagamento</th>
                                                        <th>Ações</th>

                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:if test="${not empty compras}">

                                                        <c:forEach var="p" items="${compras}">
                                                            <tr>
                                                                <td><c:out value="${p.numero_cartela}" /></td>
                                                                <td><c:out value="${p.pessoa.nome}" /></td>
                                                                <td><c:out value="${p.funcionario.nome}" /></td>
                                                                <td><fmt:formatDate value="${p.dataJogo.time}"
                                                                                pattern="dd/MM/yyyy" /></td>
                                                                <td><c:out value="${p.qtd_cartela}" /></td>
                                                                <td><fmt:formatNumber value="${p.valor}"
                                                                                  type="currency" /></td>
                                                                <th><c:out value="${p.pessoa.local.descricao}" /></th>
                                                                <th><c:if test="${p.pagou }">
                                                                        <c:out value="CONCLUIDO" />
                                                                    </c:if> <c:if test="${not p.pagou }">
                                                                        <c:out value="EM ABERTO" />
                                                                    </c:if></th>
                                                                <th>
                                                                    <div class="btn-group" role="group"
                                                                         aria-label="Basic example">

                                                                        <a
                                                                            href="controller?operacao=PaginaExibirComprasAtivaCartela&acao=<c:out value="${p.idCompra}" /> "
                                                                            class="btn btn-none"
                                                                            onclick="return confirm('Ativar')"><img
                                                                                alt="Ativar milhar" title="Ativar compra" width="30"
                                                                                src="img/ativar.png"> <a
                                                                                href="controller?operacao=BaixaVendaCliente&acao=<c:out value="${p.idCompra}" />"
                                                                                class="btn btn-none"
                                                                                <c:if test="${p.pagou}">
                                                                                    hidden=""
                                                                                </c:if>
                                                                                onclick="return confirm('Realizar Baixa')"><img
                                                                                    alt="Realizar cobrança" title="Realizar cobrança"
                                                                                    width="30" src="img/cobranca.png"> </a> <a
                                                                                type="button" class="btn btn-none"
                                                                                title="Baixa Parcial" href="#" data-toggle="modal"
                                                                                <c:if test="${not p.pagou}">
                                                                                    data-target="#pgParcial" 
                                                                                </c:if>
                                                                                data-whatevereidcompra="<c:out value="${p.idCompra}"/>"
                                                                                data-whatevereidpessoa="<c:out value="${p.pessoa.idPessoa}"/>"
                                                                                data-whateverepessoa="<c:out value="${p.pessoa.nome}"/>">
                                                                                <img alt="Vializar pagamentos do dia"
                                                                                     title="Debitar valor" width="30"
                                                                                     src="img/cobranca-pessoa.png">
                                                                            </a> <a class="btn btn-none"
                                                                                    href="controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=<c:out value="${p.idCompra}"/>&idpessoa=<c:out value="${p.pessoa.idPessoa}"/>">
                                                                                <img alt="Ativar milhar" title="Detalhes" width="30"
                                                                                     src="img/marketing-de-busca2.png">
                                                                            </a>
                                                                    </div>
                                                                </th>

                                                            </tr>

                                                        </c:forEach>
                                                    </c:if>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>


                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
        <%@ include file="obtervalorcliente.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/deletepessoa.js"></script>
        <script src="javascript/pgparcial.js" type="text/javascript"></script>
    </body>
</html>

