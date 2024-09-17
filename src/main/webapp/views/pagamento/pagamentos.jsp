
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
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h4 mb-0 font-weight-bold text-uppercase text-dark">Painel
                                de pagamentos dos clientes</h1>

                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-uppercase text-dark font-weight-bolder">Filtrar
                                        pessoas pelo seu endereço:</div >
                                    <div class="card-body mb-4">
                                        <form action="controller?operacao=PagamentoController"
                                              method="post">
                                            <div class="input-group mb-2">
                                                <select
                                                    class="custom-select form-control bg-light font-weight-bold border-5 text-uppercase"
                                                    name="buscar" aria-label="Search"
                                                    aria-describedby="basic-addon2"
                                                    id="inlineFormCustomSelectPref">
                                                    <c:choose>
                                                        <c:when test="${not empty local}">
                                                            <option value="<c:out value="${local.idLocal}"/>"><c:out
                                                                    value="${local.descricao}" /></option>
                                                            </c:when>
                                                        </c:choose>
                                                        <c:forEach var="l" items="${locais}">
                                                        <option value="<c:out value="${l.idLocal}" />">
                                                            <c:out value="${l.descricao}" />
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                                <div class="input-group-append">
                                                    <button type="submit" class="btn bg-gradient-light text-dark text-uppercase">
                                                        <i class="fas fa-search fa-sm"> Buscar</i>
                                                    </button>
                                                </div>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="card text-center">
                                    <div  class="card-header bg-gradient-light text-dark font-weight-bolder">LOCALIZAÇÃO:</div>
                                    <div class="card-body">
                                        <div class="table table-responsive">
                                            <%@ include file="descricao-pagamento-table.jsp"%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div
                                        class="card-header bg-gradient-light text-dark font-weight-bolder">
                                        INFORMAÇÕES:</div>
                                    <div class="card-body">
                                        <p class="card-title">
                                            <c:if test="${not empty msg}">
                                            <div
                                                class="alert alert-success text-center alert-dismissible fade"
                                                role="alert">
                                                <c:out value="${msg}" />

                                                <button type="button" class="close" data-dismiss="alert"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                        </c:if>
                                        <c:choose>
                                            <c:when test="${not empty local }">
                                                <strong class="text-uppercase text-dark font-weight-bold">Endereço: <c:out value="${local.descricao}" />
                                                </strong>
                                            </c:when>
                                        </c:choose>
                                        </p>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row my-2">
                            <div class="col-xl-12 col-lg-7">

                                <div class="card mb-4 font-weight-bold ">
                                    <div class="card-header bg-gradient-light text-dark text-uppercase h6 font-weight-bold">
                                        Lista de pessoas para realizar cobrança:
                                        <c:if test="${not empty valorCurrent }">
                                            <f:formatNumber value="${valorCurrent }" type="currency" />
                                        </c:if>
                                    </div>
                                    <div class="card-body">
                                        <div class="col-xl-12 col-xg-6">
                                            <%@ include file="table-view-pagamento.jsp"%>
                                        </div>
                                        <script>
                                            function obterCompra(param) {
                                                Swal.fire({
                                                    title: 'MENSAGEM',
                                                    text: "Você está realizando uma cobrança!",
                                                    icon: 'warning',
                                                    showCancelButton: true,
                                                    confirmButtonColor: '#3085d6',
                                                    cancelButtonColor: '#d33',
                                                    confirmButtonText: 'Sim'
                                                }).then((result) => {
                                                    if (result.isConfirmed) {
                                                        Swal.fire(
                                                                'Processando pagamento cliente!',
                                                                'Confirme o pagamento.',
                                                                'success'
                                                                ).then((result) => {
                                                            if (result.isConfirmed) {
                                                                parent.location.href = "controller?operacao=DebitaCompraPessoa&acao=" + param;
                                                            }
                                                        });
                                                    }
                                                })
                                            }
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../pagamento/pagamentoparcial.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/pgparcial.js" type="text/javascript"></script>
        <script src="javascript/habilitar.js" type="text/javascript"></script>
    </body>

</html>
