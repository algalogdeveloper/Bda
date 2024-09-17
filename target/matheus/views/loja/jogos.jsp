
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
                        class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <%@ include file="../../templete/filtro.jsp"%>
                    </nav>
                    <div class="container-fluid">

                        <div class="row mt-2">
                            <div class="col-md-12 col-xl-12">
                                <div class="card">
                                    <div class="card-header bg-gradient-light text-dark font-weight-bold text-uppercase">Buscar
                                        milhar por número</div>
                                    <div class="card-body">

                                        <form
                                            action="controller?operacao=ConsultasController&consulta=ativa"
                                            method="post">
                                            <div class="form-group">
                                                <div class="form-group">
                                                    <label for="exampleFormControlInput1"
                                                           class="font-weight-bold">Qual milhar você quer
                                                        ativar:</label> <input type="number" name="buscar"
                                                                           class="form-control font-weight-bold"
                                                                           id="exampleFormControlInput1" min="0"
                                                                           placeholder="">
                                                </div>
                                            </div>
                                            <button type="submit" class="btn bg-gradient-light text-dark">
                                                <i class="fas fa-search"> Consultar Milhar</i>
                                            </button>

                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="row mt-1">
                            <div class="col-md-12 col-xl-12">
                                <div class="card">
                                    <div class="card-header bg-gradient-light text-dark font-weight-bold  text-uppercase">
                                        Todos milhar vendidos só ative os que não possui comprador</div>
                                    <!-- Card Body -->
                                    <div class="card-body">

                                        <div class="row">
                                            <c:choose>
                                                <c:when test="${not empty selecionados }">
                                                    <c:forEach var="m" items="${selecionados}">
                                                        <div class="col-xl-2 col-lg-4">
                                                            <fieldset>
                                                                <div class="card border-left-danger text-center">
                                                                    <div class="card-header bg-gradient-light text-dark font-weight-bold text-center">MILHAR</div>
                                                                    <div class="card-body">
                                                                        <input name="habilitar" id="habilitar"
                                                                               value='<c:out value="${m.value}"/>' hidden="">
                                                                        <p
                                                                            class="card-title text-center font-weight-bold bg-gradient-light rounded text-dark">

                                                                            <c:choose>
                                                                                <c:when test="${m.disponivel}">
                                                                                    <c:out value="Disponível" />
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <c:out value="Não disponível" />
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </p>
                                                                        <p class="card-text text-center h3 text-danger">
                                                                            <c:out value="Nº: ${m.value}" />
                                                                        </p>
                                                                        <a href="#"
                                                                           class="btn bg-gradient-light text-dark border rounded font-weight-bold"
                                                                           id="habilit-milhar"><i class="fa fa-tools"> Habilitar</i></a>
                                                                    </div>
                                                                </div>
                                                                <br>
                                                            </fieldset>
                                                        </div>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise><label class="alert alert-danger p-1 font-weight-bold"> Não existe este milhar. Consulte novamente! </label></c:otherwise>
                                            </c:choose>
                                        </div>
                                        <p class="text-dark text-uppercase font-weight-bold">
                                            Quantidade de numeros desativados:
                                            <c:out value="${size}" />
                                            milhar
                                        </p>
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