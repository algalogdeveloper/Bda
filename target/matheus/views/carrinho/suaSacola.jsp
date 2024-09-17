

<%@taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@taglib  prefix="formatador" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body>
        <%@ include file="../../templete/menu.jsp"%>
        <div id="content">
            <nav
                class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <%@ include file="../../templete/filtro.jsp"%>
            </nav>
            <div class="container-fluid">
                <%@include file="message.jsp" %>
                <core:choose>
                    <core:when test="${not empty compra}">
                        <%@include file="dataView.jsp" %>
                    </core:when>
                </core:choose>
                <script>
                    var numero = document.getElementById("numero");
                    numero.addEventListener('input', function () {
                        if (numero.value.length === 4) {
                            window.location.href = 'controller?operacao=UICarrinho&mc=' + numero.value;
                        }
                    });
                    numero.focus();
                </script>
                <core:if test="${carregado > 0}">
                    <div class="card mb-1">
                        <div class="card-header bg-gradient-light font-weight-bolder">Loja do cliente</div>
                        <div class="card-body">
                            <h5 class="card-title font-weight-bold text-uppercase">Loja do cliente: <core:if test="${not empty carregado}"> <core:out value="${carregado} milhar(s)"/> </core:if></h5>
                            <%@include file="cart.jsp" %>
                        </div>
                        <div class="card-footer">
                            <a href="controller?operacao=UIClearSacola" class="btn mb-2 btn-link border-bottom-danger text-danger font-weight-bold"><i class="fa fa-shopping-bag"> Limpar minha sacola </i></a>
                        </div>
                    </div>

                </core:if>
                <%@include file="forms.jsp" %>
            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>

    </body>
</html>
