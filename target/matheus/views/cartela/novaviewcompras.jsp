
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
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div
                            class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">NOVA SCREEN DE COMPRAS</h1>
                        </div>

                        <%@ include file="../../templete/quebrados/sequencias.jsp"%>


                        <hr>

                        <%@ include file="../../templete/quebrados/forms.jsp"%>



                        <hr>

                        <div class="card-group">
                            <div class="card">

                                <div class="card-body">
                                    <%@ include file="../../templete/quebrados/carrinhoView.jsp"%>

                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Lista de compras</small>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Selecionados</h5>
                                    <%@ include file="../../templete/quebrados/tableviewcompras.jsp"%>

                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">Carrinho de itens</small>
                                </div>
                            </div>
                        </div>




                        <%@ include file="../cartela/compraspessoa.jsp"%>

                    </div>
                </div>

            </div>

        </div>


        <%@include file="../pessoa/modal.jsp"%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/agregar.js" type="text/javascript"></script>
        <script src="javascript/carrinhoremove.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
    </body>
</html>

