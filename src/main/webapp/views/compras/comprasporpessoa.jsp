
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
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800 font-weight-bold">CARTELAS
                                POR PESSOA</h1>
                            <a class="btn btn-info font-weight-bold"
                               href="controller?operacao=CarrinhoController&carrinho=loja">Criar
                                cartela</a>
                        </div>

                        <div class="row">
                            <div class="row">
                                <div class="col-xl-12 border"><%@ include
                                        file="card-pessoa.jsp"%>
                                    </div>

                                </div>


                            </div>

                        </div>
                    </div>
                    <%@include file="../../templete/scripts.jsp"%>
                    <script src="javascript/habilitar.js" type="text/javascript"></script>
                    </body>

                    </html>
