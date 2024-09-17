<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../../templete/aparencia.jsp" %>
    <body>
        <%@ include file="../../templete/menu.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">

            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <%@ include file="../../templete/filtro.jsp" %>
            </nav>
            <div class="container-fluid">
                <div class="row mt-2">
                    <div class="col-md-12 col-xl-12">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Gerando lista de cobrança dos clientes por seu endereço</div>
                            <div class="card-body">
                                <form action="controller?operacao=FabricaRelatorioComprasEnderecoSemMilhar"
                                      method="post">

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" class="font-weight-bold">Endereço:</label>
                                        <select name="descricao"
                                                class="custom-select form-control font-weight-bold text-uppercase"
                                                id="exampleFormControlSelect1">
                                            <c:choose>
                                                <c:when test="${not empty locais}">
                                                    <c:forEach var="e" items="${locais }">
                                                        <option class="font-weight-bold"
                                                                value='<c:out value="${e.idLocal}"/>'><c:out
                                                                value="${e.descricao}" /></option>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>Não existe endereços</c:otherwise>
                                            </c:choose>
                                        </select>
                                        <div class="form-group mt-2">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio"
                                                       name="situacao" id="inlineRadio1" value="aberto" checked="checked">
                                                <label class="form-check-label font-weight-bold" for="inlineRadio1">Em aberto</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio"
                                                       name="situacao" id="inlineRadio2" value="concluido">
                                                <label class="form-check-label font-weight-bold" for="inlineRadio2">Concluído</label>
                                            </div>
                                        </div>

                                    </div>

                                    <button type="submit" class="btn bg-gradient-light border text-dark">
                                        <i class="fas fa-search-minus"> Consultar Dados</i>

                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>