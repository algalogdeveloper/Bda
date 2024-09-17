
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="data" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body>
        <%@ include file="../../templete/menu.jsp"%>
        <div id="wrapper">
            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-2 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-uppercase">Associar milhar extra ao cliente</div>
                            <div class="card-body">
                                <c:choose>
                                    <c:when test="${not empty msg}">
                                        <div class="alert alert-success p-1 text-center font-weight-bolder"><c:out value="${msg}"/></div>
                                    </c:when>
                                    <c:when test="${not empty erro}">
                                        <div class="alert alert-danger p-1 text-center font-weight-bolder"><c:out value="${erro}"/></div>
                                    </c:when>
                                </c:choose>
                                <table class="table table-striped table-hover font-weight-bolder text-uppercase" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Nº milhar</th>
                                            <th>Cliente</th>
                                            <th>Data da Compra</th>
                                            <th>Jogos</th>
                                            <th>Numeros extra</th>
                                            <th>Associar milhar extra</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="c" items="${listarComprasSemFiltros}">
                                            <tr>
                                                <td><c:out value="${c.numero_cartela}"/></td>
                                                <td><c:out value="${c.pessoa.nome}"/></td>
                                                <td><data:formatDate value="${c.dataJogo.time}" /> </td>
                                                <td><c:out value="${c.apostas}"/></td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${c.milharExtras eq '[]'}">
                                                            Sem milhar
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="#"
                                                               data-toggle="modal" 
                                                               data-target="#modelextra" 
                                                               data-lista="<c:out value="${c.milharExtras}"/>"
                                                               class="btn bg-gradient-light border font-weight-bolder">
                                                                <c:out value="${c.milharExtras}"/>
                                                            </a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td><button class="btn bg-gradient-light border"
                                                            data-toggle="modal" 
                                                            data-target="#exampleModal" 
                                                            data-whatever="<c:out value="${c.pessoa.nome}"/>"
                                                            data-id="<c:out value="${c.idCompra}"/>"
                                                            ><i class="fa fa-user-graduate"> Associar</i> </button></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <%@include file="ui-modal-extra.jsp" %>

        <%@include file="ui-editar-milhars-extras.jsp" %>
        <%@include file="../../templete/scripts.jsp"%>
        <script>
            $('#exampleModal').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var recipient = button.data('whatever');
                var id = button.data('id');
                var modal = $(this);
                modal.find('.modal-title').text('Milhar extra: ' + recipient);
                modal.find('#cliente').val(recipient);
                modal.find('#idcompra_me').val(id);
            });

        </script>
        <script>
            $('#modelextra').on('show.bs.modal', function (event) {
                var acao = $(event.relatedTarget);
                var lista = acao.data('lista');

                var ui = $(this);
                ui.find('#numeros_ex').val(lista);
            });
        </script>

    </body>
</html>