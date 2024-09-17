
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
                            <h1 class="h3 mb-0 text-gray-800 text-uppercase">Cadastrar
                                Centena escolhida pelo cliente.</h1>
                        </div>

                        <div class="row mr-md-2">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card  border-success ">
                                    <div class="card-header bg-success text-white  font-weight-bolder  text-uppercase">Cadastrar
                                        Centena escolhida pelo cliente</div>
                                    <div class="card-body">
                                        <c:if test="${not empty msg }">

                                            <h5 class="alert alert-success text-center ">
                                                <c:out value="${msg}" />
                                            </h5>
                                        </c:if>
                                        <div class="row">
                                            <div class="col-md-6">


                                                <div class="card">
                                                    <div class="card-header bg bg-light text-uppercase text-success">Ações disponiveis para
                                                        o funcionário:</div>
                                                    <div class="card-body">

                                                        <ul class="list-group list-group-horizontal">
                                                            <li class="list-group-item "><a class="btn btn-outline-none font-weight-bold "
                                                                                            href="controller?operacao=PaginasTodasCentenas"><i class="fas fa-search"></i>
                                                                    Consultar grátis</a></li>
                                                            <li class="list-group-item"><a class="btn btn-outline-none font-weight-bold "
                                                                                           href="controller?operacao=PaginasTodasCentenas2"><i class="fas fa-search"></i>
                                                                    Consultar gratisinha</a></li>

                                                        </ul>

                                                    </div>
                                                </div>


                                            </div>
                                            <div class="col-md-6">
                                                <div class="card">
                                                    <div class="card-header bg bg-light text-success text-uppercase">Informações</div>
                                                    <div class="card-body">
                                                        <div class="row mt-1">
                                                            <div class="col-md-6 col-lg-6"> 
                                                                <strong>  Quantidade de centenas grátis: <c:out value="${qtd_gratis}" /></strong>  
                                                            </div>
                                                            <div class="col-md-6 col-lg-6"> 
                                                                <strong> Qtd. centena gratisinha: <c:out value="${qtd_gratisinha}" /></strong>
                                                            </div>
                                                        </div>


                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <hr>

                                        <!-- carregar cartelas de compras  -->
                                        <%@ include file="table-view-centena.jsp"%>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@ include file="dialog-centena.jsp"%>

                        <%@ include file="dialog-centena-gratisinha.jsp"%>
                    </div>
                </div>
            </div>
        </div>
        <%-- <%@include file="../pessoa/modal.jsp"%> --%>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/pgparcial.js" type="text/javascript"></script>
        <script src="javascript/pgparcial2.js" type="text/javascript"></script>
        <script src="javascript/atualizarpessoa.js" type="text/javascript"></script>
        <script src="javascript/agregar.js" type="text/javascript"></script>
        <script src="javascript/carrinhoremove.js" type="text/javascript"></script>
        <script src="javascript/compra.js" type="text/javascript"></script>
        <script src="javascript/carregarMilhar.js" type="text/javascript"></script>
        <script src="javascript/deletecompra.js" type="text/javascript"></script>
    </body>
</html>
