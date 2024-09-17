
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
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-4">

                        </div>

                        <div class="row">
                            <div class="col-xl-11 col-lg-7">
                                <div class="card">
                                    <div class="card-header font-weight-bold">PAINEL DE
                                        MILHAR COMPRADAS</div>
                                    <div class="card-body">
                                        <h1 class="text-center font-weight-bold">Detalhes da
                                            compras</h1>
                                        <p class="text-center"><a href="controller?operacao=ExibirCartelasNaoPagas" class="btn btn-outline-primary font-weight-bold"><i class="fas fa-reply-all"></i> Voltar</a></p>	


                                        <c:if test="${not empty info}">
                                            <p class="text-center alert alert-danger font-weight-bold"><c:out value="${info}"/> </p>

                                        </c:if>
                                        <div class="table-responsive">
                                            <table id="dataTable"
                                                   class="table table-borderless table-hover font-weight-bold">
                                                <thead class="alert alert-dark text-center">
                                                    <tr>
                                                        <th>Nº comprado</th>
                                                        <th>Disponível</th>
                                                        <th>Alterar</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr class="alert alert-dark text-center">

                                                        <th>Nº comprado</th>
                                                        <th>Disponível</th>
                                                        <th>Alterar</th>
                                                    </tr>

                                                </tfoot>
                                                <tbody>
                                                    <c:forEach var="a" items="${apostas}">
                                                        <tr class="text-center">
                                                            <td class="text-center"><c:out
                                                                    value="${a.milhar.value}" /></td>
                                                            <td><c:choose>
                                                                    <c:when test="${not a.milhar.disponivel}">
                                                                        <c:out value="Comprado" />
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <c:out value="Disponivel" />
                                                                    </c:otherwise>

                                                                </c:choose> 
                                                            </td>
                                                            <td ><a href="" class="btn btn-outline-success"><i class="fas fa-pencil-alt"></i> Alterar</a></td>
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

                </div>
            </div>
        </div>
        <%@ include file="../cartela/AdicionarUmMilhar.jsp"%>
        <%@ include file="../cartela/check.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
    </body>
</html>