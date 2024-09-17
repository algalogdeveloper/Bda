<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="content-wrapper" class="d-flex flex-column">

            <nav
                class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <%@ include file="../../templete/filtro.jsp"%>
            </nav>

            <div class="container-fluid">
                <div class="row mt-2">
                    <div class="col-md-12 col-xl-12">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Filtrando
                                todos compras por Endereço e funcionários</div>
                            <div class="card-body">
                                <form action="controller?operacao=FiltrarComprasPorFuncionario"
                                      method="post">

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" class="font-weight-bold">Funcionário:</label>
                                        <select name="idfuncionario"
                                                class=" custom-select form-control font-weight-bold text-uppercase"
                                                id="exampleFormControlSelect1">
                                            <c:choose>
                                                <c:when test="${not empty funcionarios}">
                                                    <c:forEach var="f" items="${funcionarios }">
                                                        <option class="font-weight-bold"
                                                                value='<c:out value="${f.idFuncionario}"/>'><c:out
                                                                value="${f.nome}" /></option>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>Não existe endereços</c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" class="font-weight-bold">Endereço:</label>
                                        <select name="idlocal"
                                                class="custom-select form-control font-weight-bold text-uppercase"
                                                id="exampleFormControlSelect1">
                                            <c:choose>
                                                <c:when test="${not empty locais}">
                                                    <c:forEach var="e" items="${locais }">
                                                        <option class="font-weight-bold"
                                                                value='<c:out value="${e.idLocal}"/>'><c:out
                                                                value="${e.descricao}" /></option>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>Não existe endereços</c:otherwise>
                                            </c:choose>
                                        </select>
                                        <div class="form-group mt-2">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio"
                                                       name="situacao" id="inlineRadio1" value="aberto" checked="checked">
                                                <label class="form-check-label font-weight-bold" for="inlineRadio1">Em aberto</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio"
                                                       name="situacao" id="inlineRadio2" value="concluido">
                                                <label class="form-check-label font-weight-bold" for="inlineRadio2">Concluído</label>
                                            </div>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio"
                                                       name="situacao" id="inlineRadio2" value="todos">
                                                <label class="form-check-label font-weight-bold" for="inlineRadio2">Todos</label>
                                            </div>
                                        </div>

                                    </div>

                                    <button type="submit" class="btn bg-gradient-light text-dark">
                                        <i class="fas fa-search"> Consultar Dados</i>

                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row mt-2">
                    <div class="col-md-12 col-xl-12">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Mostrar compras do funcionario </div>
                            <div class="card-body">
                                <div class="table table-responsive">
                                    <c:choose>
                                        <c:when test="${not empty compras }">
                                            <table
                                                class="table table-borderless table-hover font-weight-bold"
                                                id="dataTable">
                                                <caption>
                                                    Local filtrado:
                                                    <c:choose>
                                                        <c:when test="${not empty endereco}">
                                                            <strong><c:out value="${endereco.descricao}" /> </strong>
                                                        </c:when>
                                                    </c:choose>
                                                </caption>
                                                <thead>
                                                    <tr class="text-uppercase text-dark">
                                                        <th>Id</th>
                                                        <th>Cliente</th>
                                                        <th>R$ Valor</th>
                                                        <th>Data compra</th>
                                                        <th>Situação</th>
                                                        <th>Seus milhar</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach var="c" items="${compras}">
                                                        <tr>
                                                            <td><c:out value="${c.idCompra }" /></td>
                                                            <th><c:out value="${c.pessoa.nome }" /></th>
                                                            <td><fmt:formatNumber value="${c.valor }"
                                                                              type="currency" /></td>
                                                            <td><fmt:formatDate value="${c.dataJogo.time }"
                                                                            pattern="dd/MM/yyyy" /></td>
                                                            <td><c:choose>
                                                                    <c:when test="${c.pagou}">
                                                                        <strong class="alert alert-success p-1">
                                                                            Pagamento já foi efitivado </strong>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                        <strong class="alert alert-danger p-1">Pagamento
                                                                            em aberto</strong>
                                                                        </c:otherwise>
                                                                    </c:choose></td>
                                                            <td><c:forEach var="a" items="${c.apostas}">
                                                                    <c:out value="${a.milhar.value }" />
                                                                </c:forEach></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>

                                            </table>


                                        </c:when>
                                        <c:otherwise>Não existes compras para esta consulta</c:otherwise>
                                    </c:choose>
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