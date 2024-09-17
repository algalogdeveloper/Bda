<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                <nav
                    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <%@ include file="../../templete/filtro.jsp"%>
                </nav>
                <div class="container-fluid">
                    <div class="row my-2">
                        <div class="col-md-12">
                            <div class="card">
                                <div
                                    class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Consulta
                                    rapida de compras</div>
                                <div class="card-body">
                                    <form class="mr-auto w-100 navbar-search" method="post"
                                          action="controller?operacao=ConsultaRapidaComprasCliente">
                                        <div class="input-group">
                                            <input type="text" name="buscar"
                                                   class="form-control bg-light border-1 small"
                                                   placeholder="Buscar cliente pelo milhar ou nome"
                                                   aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="submit">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>

                        <div class="col-md-12 my-2">
                            <div class="card">
                                <div
                                    class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Descrição
                                    da compras consulta</div>
                                <div class="card-body">
                                    <div class="row ">
                                        <c:choose>
                                            <c:when test="${not empty compras}">
                                                <c:forEach var="m" items="${compras}">
                                                    <div class="col-md-2 mb-1 ">
                                                        <div class="card <c:if test="${not m.pagou}">border-left-danger</c:if> <c:if test="${m.pagou}">border-left-success</c:if>">
                                                                <div
                                                                    class="card-header  bg-gradient-light text-center text-uppercase font-weight-bold text-dark">
                                                                    Descrição</div>
                                                                <div class="card-body ">
                                                                    <p class="text-uppercase text-dark font-weight-bold">
                                                                        Cliente:
                                                                    <c:out value="${m.pessoa.nome}" />
                                                                    <br> Endereço:
                                                                    <c:out value="${m.pessoa.local.descricao}" />
                                                                    <br> Cidade:
                                                                    <c:out value="${m.pessoa.local.cidade}" />
                                                                </p>
                                                                <p class="text-uppercase font-weight-bold text-primary">
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
                                                                    <c:choose>
                                                                        <c:when test="${not m.pagou }">
                                                                            <strong class="alert alert-danger p-1 "> <c:out
                                                                                    value="EM ABERTO" />
                                                                            </strong>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <strong class="alert alert-success p-1"><c:out
                                                                                    value="CONCLUIDO" /></strong>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                </p>
                                                                <p>Números:</p>
                                                                <c:forEach var="a" items="${m.apostas}">
                                                                    <strong class="text-primay"><c:out
                                                                            value="${a.milhar.value}" /></strong>
                                                                    </c:forEach>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:when>

                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

        </div>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>