
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="ft" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>

        <div id="wrapper">

            <%@ include file="../../templete/menu2.jsp"%>
            <div id="content-wrapper" class="d-flex flex-column text-uppercase">
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>

                    <div class="accordion " id="accordionExample">
                        <div class="card ">
                            <div class="card-header bg-gradient-light" id="headingOne">
                                <h2 class="mb-0">
                                    <button class="btn btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        <i class="fa fa-play text-uppercase"> Ações de cadastros</i>
                                    </button>
                                </h2>
                            </div>

                            <%@include file="accordionone.jsp" %>
                        </div>
                        <div class="card">
                            <div class="card-header bg-gradient-light" id="headingTwo">
                                <h2 class="mb-0">
                                    <button class="btn btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        <i class="fa fa-play text-uppercase"> Ações de Consultas</i>
                                    </button>
                                </h2>
                            </div>
                            <%@include  file="accordiontwo.jsp" %>
                        </div>
                        <div class="card border-0">
                            <div class="card-header bg-gradient-light" id="headingThree">
                                <h2 class="mb-0">
                                    <button class="btn btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        <i class="fa fa-play text-uppercase"> Ações de Pagamentos</i>

                                    </button>
                                </h2>
                            </div>
                            <%@include file="accordiontree.jsp" %>
                        </div>
                    </div>

                </div>                     
            </div>
        </div>

        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletelocal.js" type="text/javascript"></script>
        <script src="javascript/atualizarlocal.js"></script>

    </body>

</html>
