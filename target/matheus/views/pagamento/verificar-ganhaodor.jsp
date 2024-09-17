
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
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <p
                        class="h1 text-center text-success text-uppercase font-weight-bold">Buscar
                        cliente(s) com milhar prêmiado</p>
                    <div class="row">

                        <script type="text/javascript">
                            function add() {
                                var milhar = document.getElementById("milhar").value;
                                if (milhar.length == 4) {
                                    carregar(milhar)
                                    milhar.focus();

                                }

                            }
                            function carregar(milhar) {
                                var url = "controller?operacao=ObterMilharPremiado&milhar="
                                        + milhar;
                                location.href = url
                            }
                        </script>

                        <div class="col-md-12">

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12 mb-1">
                                        <div class="card">
                                            <div
                                                class="card-header bg-gradient-success text-white text-uppercase font-weight-bold">Formulário
                                                númerico</div>
                                            <div class="card-body">
                                                <fieldset id="obter">
                                                    <legend class="text-danger"><c:if test="${not empty erro}"><c:out value="${erro}"/> </c:if> </legend>
                                                        <div class="form-group">
                                                            <input type="number" required="" name="numero" max="9999"
                                                                   class="form-control font-weight-bold btn-round" min="0"
                                                                   maxlength="4" placeholder="Digite o primeiro milhar?"
                                                                   oninput="add()" id="milhar">
                                                        </div>
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </div>
                                    <c:choose>
                                        <c:when test="${not empty apostas}">
                                            <c:forEach var="a" items="${apostas}">
                                                <div class="col-auto mb-1">
                                                    <div class="card">
                                                        <div
                                                            class="card-header bg-gradient-success text-white text-uppercase font-weight-bold">DESCRIÇÂO
                                                            DOS APOSTADORES</div>
                                                        <div class="card-body">
                                                            <div class="card text-center">
                                                                <img
                                                                    src="https://cdn-icons-png.flaticon.com/128/3135/3135715.png"
                                                                    class="card-img-top" alt="...">
                                                                <div class="card-body">
                                                                    <h5 class="card-title text-primary text-uppercase">GANHADOR:<c:out value="${a.compra.pessoa.nome}"/> </h5>
                                                                    <p>Endereço: <c:out value="${a.compra.pessoa.local.descricao}"/></p>
                                                                    <p class="card-text text-primary">Milhar: <c:out value="${a.milhar.value}"/></p>
                                                                    <a href="#" class="btn btn-danger">Delete</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </c:forEach>
                                        </c:when>
                                    </c:choose>
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
