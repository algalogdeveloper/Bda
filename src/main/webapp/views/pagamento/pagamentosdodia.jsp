
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
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

                        <div class="row">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header bg-gradient-light text-dark text-uppercase">Pagamentos
                                        efetivado hoje</div>
                                    <div class="card-body">
                                        <div class="btn-group" role="group" aria-label="Basic example">

                                            <a class="btn bg-gradient-light border text-dark font-weight-bold "
                                               href="controller?operacao=CarrinhoController&carrinho=loja">
                                                <i class="fas fa-file"> Novo Talão</i> </a> <a class="btn bg-gradient-light border text-dark font-weight-bold "
                                                                                           href="controller?operacao=CriandoPDFPagamentoDataAtual">
                                                <i class="fas fa-file-pdf"> Relatório de pagamento do dia</i> </a>
                                        </div>
                                        <div class="row ">
                                            <div class=" alert alert-warning mt-2">Obs: Por
                                                motivo de segurança o desenvolvedor do sistema vai criar uma
                                                copiá do arquivo também por causa de eventuais problemas.</div>
                                            <div class="col-xl-12 col-lg-4 ">
                                                <div class="table-responsive">
                                                    <table
                                                        class="table table-hover table-striped font-weight-bold"
                                                        id="dataTable">
                                                        <thead class="bg-gradient-light">
                                                            <tr class="text-uppercase">
                                                                <td>Pessoa</td>
                                                                <td>Situação</td>
                                                                <td>Números dos clientes</td>
                                                            </tr>
                                                        </thead>

                                                        <tfoot>
                                                            <tr class="">
                                                                <td>Pessoa</td>
                                                                <td>Situação</td>
                                                                <td>Números dos clientes</td>
                                                            </tr>
                                                        </tfoot>
                                                        <c:forEach var="c" items="${compras}">
                                                            <tr style="border-bottom-style: solid;">
                                                                <td><c:out value="Nº ${c.numero_cartela}" /> - <c:out
                                                                        value="${c.pessoa.nome}" /> - <f:formatNumber
                                                                        value="${c.valor}" type="currency" /></td>

                                                                <td><c:if test="${c.pagou}">
                                                                        <i class="fas fa-check alert alert-success"> <c:out
                                                                                value="PAGAMENTO CONCLUIDO" />
                                                                        </i>
                                                                    </c:if></td>
                                                                <td>
                                                                    <c:forEach var="a" items="${c.apostas }">
                                                                        <strong class="text-primary"><c:out value="${a.milhar.value}"/></strong>	  
                                                                    </c:forEach>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <c:if test="${empty compras}">
                                                            <tr>
                                                                <td colspan="5">Não existe compras</td>
                                                            </tr>
                                                        </c:if>
                                                    </table>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                    <%@ include file="modal-detalhes-pagamento.jsp"%>
                </div>

                <%@include file="../../templete/scripts.jsp"%>

                <script src="javascript/habilitar.js" type="text/javascript"></script>
                </body>

                </html>
