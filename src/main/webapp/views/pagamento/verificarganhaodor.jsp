
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>

    <body id="page-top ">
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
                    <div class="row">

                        <div class="col-md-12">

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12 mb-1">
                                        <div class="card">
                                            <div
                                                class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Formulário
                                                númerico</div>
                                            <div class="card-body">
                                                <%@include file="form-encontrar-ganhador.jsp"%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 mb-1">
                                        <div class="card">
                                            <div
                                                class="card-header  bg-gradient-light text-dark text-uppercase font-weight-bold">Lista
                                                de Ganhadores</div>
                                            <div class="card-body">
                                                <div class="table table-responsive">
                                                    <%@include file="table-view-ganhador.jsp"%>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-md-12 mb-1">
                                        <div class="row ">
                                            <c:choose>
                                                <c:when test="${not empty gratis }">
                                                    <div class="col-md-12 mb-1">
                                                        <div class="card border-success">
                                                            <p
                                                                class="card-header bg-gradient-success text-white text-uppercase font-weight-bold">Centenas
                                                                Grátis</p>
                                                            <div class="card-body">
                                                                <p class="card-title">Lista de centenas gratis
                                                                    prêmiadas</p>
                                                                <div class="table table-responsive">
                                                                    <%@ include file="../centena/table-view-gratis.jsp"%>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </c:when>
                                                <c:when test="${not empty gratisinha }">
                                                    <div class="col-md-12 mb-1">
                                                        <div class="card border-success">
                                                            <p
                                                                class="card-header bg-success text-white text-uppercase font-weight-bold">Centenas
                                                                Gratisinha</p>
                                                            <div class="card-body">
                                                                <p class="card-title">Lista de centenas gratisinhas
                                                                    prêmiadas</p>
                                                                <div class="table table-responsive">
                                                                    <%@ include file="../centena/table-view-gratisinha.jsp"%>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                        </div>
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
