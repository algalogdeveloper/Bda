
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body>
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
                        <h1>Lista de rotas</h1>
                        <div class="card shadow">
                            <div class="card-header bg-gradient-light font-weight-bolder">Qual rota voce deseja criar?</div>
                            <div class="card-body">
                                <form action="controller?operacao=BuscarPaginasPDF" method="post">
                                    <select name="rota" class="form-group custom-select font-weight-bolder">
                                        <core:forEach var="r" items="${rotas}">
                                            <option class="font-weight-bolder" value="<core:out value="${r.idRota}"/>"><core:out value="Rota: ${r.numeroRota}"/></option>
                                        </core:forEach>
                                    </select>
                                    <button class="btn bg-gradient-light border font-weight-bolder" type="submit"><i class="fa fa-search"></i> Buscar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>
