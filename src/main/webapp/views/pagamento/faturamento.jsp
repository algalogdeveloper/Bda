<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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

                        <div class="card-group text-center">
                            <div class="card">
                                <div class="card-header bg-gradient-light font-weight-bold  text-dark">TOTAL
                                    DE CARTELAS COBRADAS</div>
                                <div class="card-body">

                                    <p class="card-text">
                                    <fieldset class="text-center">
                                        <legend>Análise:</legend>
                                        <c:forEach var="f" items="${faturamento}">
                                            <p
                                                class="card-title text-dark text-uppercase font-weight-bold">
                                                Cliente(s) :
                                                <c:out value="${f.qtdPessoas}" />
                                            </p>
                                            <p class="card-text text-dark text-uppercase font-weight-bold">
                                                Valor recido:
                                                <f:formatNumber value="${f.valor}" type="currency" />
                                            </p>
                                            <p class="card-text text-dark text-uppercase font-weight-bold">
                                                Talões :
                                                <c:out value="${f.qtdCartelas}  pago(s)" />
                                            </p>
                                        </c:forEach>

                                    </fieldset>
                                    </p>


                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header font-weight-bold bg-gradient-light text-dark">TOTAL
                                    DE CARTELAS PARA COBRAR:</div>
                                <div class="card-body text-center">
                                    <fieldset class="text-center">
                                        <legend>Análise:</legend>
                                        <c:forEach var="f" items="${notfaturamento}">
                                            <p
                                                class="card-title text-dark text-uppercase font-weight-bold">
                                                Cliente(s) :
                                                <c:out value="${f.qtdPessoas} pessoas" />
                                            </p>
                                            <p class="card-text text-dark text-uppercase font-weight-bold">
                                                Valor para receber:
                                                <f:formatNumber value="${f.valor}" type="currency" />
                                            </p>
                                            <p class="card-text text-dark text-uppercase font-weight-bold">
                                                Talões :
                                                <c:out value="${f.qtdCartelas}  não pago(s)" />
                                            </p>
                                        </c:forEach>
                                    </fieldset>

                                </div>
                            </div>

                        </div>

                        <div class="row mt-1">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card mb-4 font-weight-bold">
                                    <div class="card-header bg-gradient-light text-dark">ANÁLISE
                                        GERAL</div>
                                    <div class="card-body">
                                        <table class="table table-borderless table-hover">
                                            <c:forEach var="f" items="${faturamentoGeral}">
                                                <tr>
                                                    <td class="row text-dark text-uppercase font-weight-bold">Quantidade
                                                        pessoas:</td>
                                                    <td><c:out value=" ${f.qtdPessoas}" /></td>

                                                </tr>
                                                <tr>
                                                    <td class="row text-dark text-uppercase">Valor total
                                                        receber:</td>
                                                    <td><f:formatNumber value=" ${f.valor}" type="currency" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="row text-dark text-uppercase">Quantidade
                                                        cartelas:</td>
                                                    <td><c:out value=" ${f.qtdCartelas}" /></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>

                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/habilitar.js" type="text/javascript"></script>
    </body>

</html>
