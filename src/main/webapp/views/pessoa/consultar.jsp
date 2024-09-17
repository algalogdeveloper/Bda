
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

                <!-- Main Content -->
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-2 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-2">
                            <h1 class="h3 mb-0 text-gray-800">
                                <a href="" data-toggle="modal" data-target="#modalDiscount"
                                   data-whateverid="<c:out value="0"/>"
                                   class="btn bg-gradient-light text-dark"><i
                                        class="fas fa-user-alt"> Novo Cliente</i> </a>
                            </h1>

                        </div>
                        <div class="row">
                            <!-- Area Chart -->
                            <div class="col-xl-12">
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header  bg-gradient-light font-weight-bolder text-dark py-2 d-flex flex-row align-items-center justify-content-between">
                                        CATÁLOGO DE CLIENTES</div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <c:choose>
                                            <c:when test="${not empty msg }">
                                                <p class="alert alert-success text-uppercase text-center p-1"
                                                   role="alert">
                                                    <i class="fas fa-check"> <c:out value="${msg}" /></i>
                                                </p>
                                            </c:when>

                                            <c:when test="${not empty erro }">
                                                <p class="alert alert-danger text-uppercase text-center p-1"
                                                   role="alert">
                                                    <i class="fas fa-bug"> <c:out value="${erro}" /></i>
                                                </p>
                                            </c:when>
                                        </c:choose>
                                        <%-- <c:if test="${not empty msg}">
                                                <p class="alert alert-success text-uppercase text-center p-1"
                                                        role="alert">
                                                        <i class="fas fa-check"> <c:out value="${msg}" /></i>
                                                </p>
                                        </c:if> --%>
                                        <div class="table-responsive">
                                            <%@ include file="table-view-pessoas.jsp"%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file="../pessoa/modal.jsp"%>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/atualizarpessoa.js"></script>
        <script src="javascript/deletepessoa.js"></script>
    </body>
</html>

