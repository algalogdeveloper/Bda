<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="ft" uri="http://java.sun.com/jstl/fmt"%>

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
                        <div
                            class="align-items-center justify-content-between mb-2 text-dark">
                            <h5 class="font-weight-bold">PAINEL DE ACOMPANHAMENTO DAS COMPRAS</h5>

                        </div>
                        <div class="row text-uppercase">
                            <div class="col-md-3">
                                <div class="card text-center">
                                    <div
                                        class="card-header bg-gradient-light text-dark font-weight-bold font-weight-bold">Lista
                                        de endereços:</div>
                                    <div class="card-body">
                                        <%@ include file="form-filtro.jsp"%>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark font-weight-bold font-weight-bold">Mensagens:</div>
                                    <div class="card-body">
                                        <c:choose>
                                            <c:when test="${not empty compraModificada }">
                                                <div class="table  table-responsive">
                                                    <table class="table table-borderlass  border table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th colspan="3" class="text-uppercase text-black">Cliente:
                                                                    <c:out value="${compraModificada.pessoa.nome}" />
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td colspan="3" class="font-weight-bold">
                                                                    <c:out value="${compraModificada.apostas}"/>                                                                    
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </c:when>
                                        </c:choose>
                                        <p class="text-center">
                                            <c:choose>
                                                <c:when test="${not empty msg}">
                                                    <strong class="alert alert-success p-1 text-center">
                                                        <i class="fas fa-check"> <c:out value="${msg}" /></i>
                                                    </strong>
                                                </c:when>
                                                <c:when test="${not empty valid }">
                                                    <strong class="alert alert-danger p-1 text-center">
                                                        <i class="fas fa-bug"> <c:out value="${valid}" /></i>
                                                    </strong>
                                                </c:when>
                                                <c:otherwise>
                                                    <strong class="alert alert-warning p-1 text-center">
                                                        <i class="fas fa-info"> <c:out
                                                                value="Aguardando informação" /></i>
                                                    </strong>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark font-weight-bold font-weight-bolder">Endereço
                                        selecionado:</div>
                                    <div class="card-body">
                                        <h5 class="text-uppercase text-dark font-weight-bold">
                                            <c:out value="${local_filt.descricao}" />
                                        </h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row my-2">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark font-weight-bold font-weight-bolder ">PAINEL
                                        DE ACOMPANHAMENTO DAS COMPRAS</div>
                                    <div class="card-body">
                                        <div class="my-1">
                                            <a  class="btn bg-gradient-light text-uppercase mb-2  font-weight-bold"
                                                data-toggle="modal"
                                                data-target="#dialog-taloes-qtd-diferentes-cliente" href="#">
                                                <i class="fas fa-user-astronaut fa-sm"> Criar uma nova aposta</i>
                                            </a>
                                        </div>
                                        <%@ include file="table-view-loja.jsp"%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@ include file="dialog-qtd.jsp"%>
                    <%@ include file="../cartela/compraspessoa.jsp"%>
                    <%@ include file="../cartela/add-ajuste-valor.jsp"%>
                    <%@ include file="../loja/dialog-taloes-qtd-diferentes.jsp"%>
                    <%@ include file="../loja/dialog-taloes-qtd-diferentes-cliente.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/ajustar-valor.js" type="text/javascript"></script>
        <script src="javascript/taloesqtdiferente.js" type="text/javascript"></script>
        <script src="javascript/ajustarqtd.js" type="text/javascript"></script>


    </body>

</html>
