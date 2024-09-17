
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
                            <h1 class="h3 mb-0 text-gray-800">LOCAIS CADASTRADOS</h1>

                        </div>
                        <div class="row">
                            <!-- Area Chart -->
                            <div class="col-xl-12 col-lg-7">
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">Todos
                                            endereços inseridos</h6>
                                        <a href="#" data-toggle="modal" data-target="#localModal"
                                           data-whateverid="<c:out value="0"/>" class="btn btn-info">
                                            <i class="fas fa-map-marker-alt"></i> Novo local
                                        </a>
                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body font-weight-bolder">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover" id="dataTable"
                                                   width="100%" cellspacing="0">
                                                <thead class="alert alert-dark">
                                                    <tr>
                                                        <th>#ID</th>
                                                        <th>Descrição</th>
                                                        <th>Cidade</th>
                                                        <th class="text-right">Editar</th>
                                                        <th>Remove</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr class="alert alert-dark">
                                                        <th>#ID</th>
                                                        <th>Descrição</th>
                                                        <th>Cidade</th>
                                                        <th class="text-right">Editar</th>
                                                        <th>Remove</th>
                                                    </tr>
                                                </tfoot>
                                                <tbody>
                                                    <c:forEach var="e" items="${enderecos}">
                                                        <tr>
                                                            <td><c:out value="${e.idLocal}" /></td>
                                                            <td><c:out value="${e.descricao}" /></td>
                                                            <td><c:out value="${e.cidade}" /></td>
                                                            <td class="text-right"><a href="#"
                                                                                      data-toggle="modal" data-target="#localModal"
                                                                                      data-whateverid="<c:out value="${e.idLocal}"/>"
                                                                                      data-whateveredescricao="<c:out value="${e.descricao}" />"
                                                                                      data-whateverecidade="<c:out value="${e.cidade}"/>"
                                                                                      class="btn btn-info"> <i class="fas fa-pencil-alt"></i>
                                                                </a></td>
                                                            <td>
                                                                <!-- excluir --> <input hidden="" id="codlocal"
                                                                                        name="codlocal"> <a href="#" id="excluir-local"
                                                                                        class="btn btn-danger"><i class="fas fa-trash-alt"></i>
                                                                </a>
                                                            </td>


                                                        </tr>
                                                    </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>


                                </div>

                            </div>

                        </div>
                    </div>

                </div>
                <!-- tela cadastro modal endereço-->
                <%@include file="../endereco/modallocal.jsp"%>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletelocal.js" type="text/javascript"></script>
        <script src="javascript/atualizarlocal.js"></script>

    </body>

</html>