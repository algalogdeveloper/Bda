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

                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>

                    <div class="card shadow m-1">
                        <!-- Card Header - Dropdown -->
                        <div
                            class="card-header text-uppercase bg-gradient-light font-weight-bolder text-dark py-2 d-flex flex-row align-items-center justify-content-between">
                            Lista agrupada de compras DE CLIENTES</div>

                        <div class="card-body">
                            <c:choose>
                                <c:when test="${not empty model.message }">
                                    <p class="alert alert-success text-uppercase text-center p-1"
                                       role="alert">
                                        <i class="fas fa-check"> <c:out value="${model.message}" /></i>
                                    </p>
                                </c:when>

                                <c:when test="${not empty erro }">
                                    <p class="alert alert-danger text-uppercase text-center p-1"
                                       role="alert">
                                        <i class="fas fa-bug"> <c:out value="${erro}" /></i>
                                    </p>
                                </c:when>
                            </c:choose>

                            <div class="table-responsive">
                                <%@include file="table-lista-agrupada.jsp" %>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%@include file="cartagrupado.jsp" %>    
        <%@include file="listacomprasmodal.jsp" %>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/listaagrupada.js"></script>
        <script src="javascript/listacomprasmodal.js"></script>
    </body>
</html>