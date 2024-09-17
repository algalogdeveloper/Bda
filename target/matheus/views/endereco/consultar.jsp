
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
                <div id="content">
                    <nav
                        class="navbar navbar-expand navbar-light bg-white topbar mb-2 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">
                        <div class=" mb-2">
                            <a href="#" data-toggle="modal" data-target="#localModal"
                               data-whateverid="<c:out value="0"/>" class="btn bg-gradient-light font-weight-bolder border text-dark">
                                <i class="fas fa-home"> Novo Endereço</i> </a>
                        </div>
                        <div class="row">
                            <div class="col-xl-12 col-lg-7">
                                <div class="card">
                                    <div class="card-header  bg-gradient-light font-weight-bolder text-dark text-uppercase">
                                        Catalogo de Endereços
                                    </div>
                                    <div class="card-body font-weight-bolder">
                                        <c:choose>
                                            <c:when test="${not empty message}">
                                                <p class="alert alert-success text-uppercase text-center p-1"> <i class="fas fa-check"> <c:out value="${message}"/></i> </p>
                                            </c:when>
                                        </c:choose>
                                        <div class="table-responsive">
                                            <%@ include file="table-view-endereco.jsp"%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="../endereco/modallocal.jsp"%>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
        <script src="javascript/deletelocal.js" type="text/javascript"></script>
        <script >
            $('#localModal').on('show.bs.modal', function (event) {
                var evento = $(event.relatedTarget);
                var codlocal = evento.data('whateverid');
                var descricao = evento.data('whateveredescricao');
                var cidade = evento.data('whateverecidade');
                var rota = evento.data('whatevererota');
                var screen = $(this);
                screen.find('#component-idlocal').val(codlocal);
                screen.find('#component-descricao').val(descricao);
                screen.find('#component-cidade').val(cidade);
                if (rota !== null) {
                    screen.find('#component-rota').val(rota);
                }
            });
        </script>


    </body>

</html>