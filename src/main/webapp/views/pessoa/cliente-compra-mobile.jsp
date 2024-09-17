
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
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">

                        <div class="row ">
                            <c:choose>
                                <c:when test="${not empty compras}">
                                    <c:forEach var="m" items="${compras}">
                                        <div class="col-md-2 mb-1 ">
                                            <div class="card border-primary">
                                                <div
                                                    class="card-header bg-gradient-light text-dark text-center font-weight-bold text-white">
                                                    DESCRIÇÃO DA APOSTA</div>
                                                <div class="card-body">
                                                    <p class="text-uppercase text-dark font-weight-bold">
                                                        Pessoa:
                                                        <c:out value="${m.pessoa.nome}" />
                                                        <br> Endereço:
                                                        <c:out value="${m.pessoa.local.descricao}" />
                                                        <br> Cidade:
                                                        <c:out value="${m.pessoa.local.cidade}" />
                                                    </p>
                                                    <p class="text-uppercase text-primary">
                                                        Nº cartela:
                                                        <c:out value="${m.numero_cartela}" />
                                                    </p>
                                                    <p
                                                        class="text-white font-weight-bold text-center text-uppercase bg-primary">
                                                        Valor:
                                                        <fmt:formatNumber value="${m.valor}" type="currency" />
                                                    </p>
                                                    <p class="text-uppercase">
                                                        Pagamento:
                                                        <c:if test="${not m.pagou}">
                                                            <strong class="alert alert-danger p-1 "> <c:out
                                                                    value="EM ABERTO" /></strong>
                                                            </c:if>
                                                            <c:if test="${m.pagou}">
                                                            <strong class="alert alert-success p-1"><c:out
                                                                    value="CONCLUIDO" /></strong>
                                                            </c:if>


                                                    </p>
                                                    <p>Números:</p>
                                                    <c:forEach var="a" items="${m.apostas}">
                                                        <strong class="text-dark"><c:out
                                                                value="${a.milhar.value}" /></strong>
                                                        </c:forEach>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <div class="col-md-4 mb-1 ">
                                        <div class="card border-primary">
                                            <div
                                                class="card-header text-uppercase bg-primary text-center font-weight-bold text-white">
                                                Leia a informação</div>
                                            <div class="card-body">
                                                <div class="alert alert-danger text-center font-weight-bold" role="alert">
                                                    <i class="fas fa-info"> Cliente não encontrado. </i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/atualizarpessoa.js"></script>
        <script src="javascript/deletepessoa.js"></script>
    </body>
</html>

