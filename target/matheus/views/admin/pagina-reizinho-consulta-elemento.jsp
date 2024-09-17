
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
                        <div class="row my-1">
                            <div class="col-md-12">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">
                                        Buscar por Endereço:</div>
                                    <div class="card-body">
                                        <form 
                                            action="controller?operacao=ObterEndereco" method="post">
                                            <div class="input-group mb-2">
                                                <select
                                                    class="custom-select text-uppercase form-control font-weight-bold"
                                                    name="buscar" aria-label="Search"
                                                    aria-describedby="basic-addon2">
                                                    <c:choose>
                                                        <c:when test="${not empty locais }">
                                                            <c:forEach var="l" items="${locais}">
                                                                <option>
                                                                    <c:out value="${l.descricao}" />
                                                                </option>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option>Local não encontradado</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </select>
                                                <div class="input-group-append">
                                                    <button type="submit"
                                                            class="btn bg-gradient-light text-dark  mb-2 text-uppercase font-weight-bold ">
                                                        <i class="fas fa-search fa-sm"></i> Buscar
                                                    </button>
                                                </div>
                                            </div>

                                        </form>


                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div
                                        class="card-header bg bg-gradient-light text-dark text-uppercase font-weight-bold">
                                        Clientes consultados:</div>
                                    <div class="card-body">
                                        <div class="table-responsive-md">
                                            <table
                                                class="table table-striped table-hover font-weight-bold text-uppercase "
                                                id="dataTable">
                                                <caption class="text-success">
                                                    Endereço filtrado:
                                                    <c:out value="${endereco}" />
                                                </caption>
                                                <thead class="bg-gradient-light text-dark">
                                                    <tr>
                                                        <th scope="col">#ID</th>
                                                        <th scope="col">Cliente</th>
                                                        <th scope="col">Situação</th>
                                                        <th scope="col">Números:</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:choose>
                                                        <c:when test="${not empty compras}">
                                                            <c:forEach var="c" items="${compras}">
                                                                <tr>
                                                                    <th scope="row"><c:out value="${c.numero_cartela}" />
                                                                    </th>
                                                                    <td><c:out value="${c.pessoa.nome}" /> - <c:out
                                                                            value="${c.qtd_cartela} cartelas" /></td>

                                                                    <td><c:choose>
                                                                            <c:when test="${c.pagou}">
                                                                                <strong class="alert alert-success p-1"> <fmt:formatNumber
                                                                                        value="${c.valor}" type="currency" /> Pagamento
                                                                                    efitivado

                                                                                </strong>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <strong class="alert alert-danger p-1"> <fmt:formatNumber
                                                                                        value="${c.valor}" type="currency" /> Em aberto
                                                                                </strong>
                                                                            </c:otherwise>
                                                                        </c:choose></td>

                                                                    <td><c:choose>
                                                                            <c:when test="${not empty c.apostas}">
                                                                                <c:forEach var="a" items="${c.apostas}">
                                                                                    <strong class="text-dark font-weight-bold"><c:out
                                                                                            value="${a.milhar.value}" /> </strong>
                                                                                    </c:forEach>
                                                                                </c:when>
                                                                                <c:otherwise>Milhar não encontrado.</c:otherwise>
                                                                        </c:choose></td>
                                                                </tr>
                                                            </c:forEach>
                                                        </c:when>
                                                    </c:choose>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <%@ include file="dialog-table-view.jsp"%>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletelocal.js" type="text/javascript"></script>
        <script src="javascript/atualizarlocal.js"></script>

    </body>

</html>
