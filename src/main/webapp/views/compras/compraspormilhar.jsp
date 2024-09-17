
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

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">

                        <div class="row">
                            <!-- Area Chart -->
                            <div class="col-md-12">
                                <div class="card mb-4 font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header bg-gradient-light text-dark font-weight-bold text-uppercase">Buscar
                                        por Milhar</div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <form
                                            action="controller?operacao=SelecionarComprasPeloSeuMilhar"
                                            method="post">
                                            <input hidden="" name="acao" value="Buscar"> <label
                                                for="basic-url">Qual é o milhar que você deseja
                                                buscar: <c:if test="${not empty valid }"><span class="alert alert-danger p-1"><c:out value="${valid}"/></span>  </c:if> </label>
                                                <div class="input-group">
                                                    <input class="form-control bg-light border-1" name="filtro"
                                                           aria-label="Search"
                                                           type="number" aria-describedby="basic-addon2" min="0">
                                                    <div class="input-group-append">
                                                        <button class="btn bg-gradient-light text-dark" type="submit">
                                                            <i class="fas fa-search fa-sm"> Buscar</i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <!-- Area Chart -->
                                <div class="col-md-12">
                                    <div class="card mb-4 font-weight-bold">
                                        <!-- Card Header - Dropdown -->
                                        <div
                                            class="card-header bg-gradient-light text-dark font-weight-bold text-uppercase font-weight-bold">Selecionar
                                            cartelas pelo milhar cadastrado</div>

                                        <div class="card-body">

                                            <div class="row">
                                            <c:choose>
                                                <c:when test="${not empty compras}">
                                                    <c:forEach var="m" items="${compras}">
                                                        <div class="col-md-2 my-1">
                                                            <div class="card">
                                                                <div
                                                                    class="card-header bg-gradient-light text-dark font-weight-bold text-center font-weight-bold ">
                                                                    DESCRIÇÃO DA APOSTA</div>
                                                                <div class="card-body font-weight-bold">
                                                                    <p class="text-uppercase text-dark ">
                                                                        Cliente:
                                                                        <c:out value="${m.pessoa.nome}" />
                                                                        <br>Rua:
                                                                        <c:out value="${m.pessoa.local.descricao}" />
                                                                        <br>Cidade:
                                                                        <c:out value="${m.pessoa.local.cidade}" />

                                                                    </p>
                                                                    <p class="text-uppercase text-primary">
                                                                        Nº cartela:
                                                                        <c:out value="${m.numero_cartela}" />
                                                                    </p>
                                                                    <p
                                                                        class="text-white text-center rounded  bg-gradient-info font-weight-bold text-uppercase">
                                                                        Valor:
                                                                        <ft:formatNumber value="${m.valor}" type="currency" />
                                                                    </p>
                                                                    <p class="text-dark">
                                                                        Pagamento:
                                                                        <c:if test="${not m.pagou}">
                                                                            <strong class="alert alert-danger  p-0"> <c:out
                                                                                    value="Em aberto" />
                                                                            </strong>
                                                                        </c:if>
                                                                        <c:if test="${m.pagou}">
                                                                            <strong class="alert alert-success  p-0"><c:out
                                                                                    value="Concluído" /> <i class="fas fa-check"></i> </strong>
                                                                            </c:if>
                                                                    </p>

                                                                </div>

                                                                <ul class="list-group list-group-flush">
                                                                    <li class="list-group-item font-weight-bold"><strong>Números:</strong>
                                                                    </li>
                                                                    <li class="list-group-item"><c:forEach var="a"
                                                                               items="${m.apostas}">
                                                                            <c:choose>
                                                                                <c:when test="${a.milhar.value eq numero}">
                                                                                    <strong class=" text-primary font-weight-bold h5"><c:out
                                                                                            value="${a.milhar.value}" /></strong>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                    <strong class=" text-dark font-weight-bold"><c:out
                                                                                            value="${a.milhar.value}" /> </strong>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:forEach>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <a
                                            href="controller?operacao=SelecionarComprasPeloSeuMilhar&acao=Clear"
                                            class="btn bg-gradient-light text-dark font-weight-bold border"><i class="fa fa-trash-alt"></i> Limpar aposta</a>

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
