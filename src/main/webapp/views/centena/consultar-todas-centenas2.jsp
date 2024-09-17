
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
                            <h1 class="h3 mb-0 text-gray-800 text-uppercase">Consultar
                                todas centenas Gratisinha.</h1>
                        </div>

                        <div class="row mr-md-2">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card shadow ">


                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="card border-success">
                                                    <div class="card-header bg-success text-white  text-uppercase">Centenas gratisinha</div>
                                                    <div class="card-body">
                                                        <h5 class="card-title">Todas centenas: <strong class="alert alert-primary p-1"> <c:out value="${msg}"/></strong> </h5>
                                                        <div class="table table-responsive">
                                                            <%@ include file="table-view-centena-gratisinha.jsp"%>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@ include file="dialog-centena.jsp"%>
                </div>
            </div>
        </div>

        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/modificar-centena-gratis.js" type="text/javascript"></script>	
        <script src="javascript/pgparcial.js" type="text/javascript"></script>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/agregar.js" type="text/javascript"></script>
        <script src="javascript/carrinhoremove.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
    </body>
</html>