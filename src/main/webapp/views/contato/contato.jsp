
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
                            <h1 class="h3 mb-0 text-gray-800 font-weight-bold">Contato
                                Desenvolvedor do Sistema</h1>
                            <a class="btn btn-info font-weight-bold"
                               href="controller?operacao=CarrinhoController&carrinho=loja">Criar
                                cartela</a>
                        </div>
                        <div class="row">
                            <!-- Area Chart -->
                            <div class="col-xl-12 col-lg-7">
                                <div class="card shadow mb-4 font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">
                                        </h6>

                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">

                                        <div class="row">

                                            <div class="col-xl-3 col-lg-4">
                                                <div class="card" style="width: 18rem;">
                                                    <img class="card-img-top" src="img/programmer.png" alt="Card image cap">
                                                    <div class="card-body">
                                                        <h5 class="card-title">Programador: Leandro, Souza</h5>
                                                        <p class="card-text">Programador de sistemas com experiência.
                                                        </p>
                                                        <p class="card-text">Linguagens:</p>
                                                        <p class="card-text">JAVA, PHP, C, C++ outros:</p>
                                                        <p>Zap: (71) 9 9634-7642 <br>   E-mail:logcodapps@gmail.com</p>
                                                        <a href="#" class="btn btn-primary">Site</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>


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
