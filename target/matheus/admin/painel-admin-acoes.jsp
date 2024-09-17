<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">

        <title>Área do Administrador</title>
    </head>
    <body>

        <div class="container-fluid">
            <div class="h1 mt-2">PAÍNEL DE ACOMPANHAMENTOS DAS AÇÕES</div>
            <a href="controller?operacao=IndexController" class="btn btn-link">Logout</a>
            <c:if test="${not empty message}">
                <p class="alert alert-info text-center">
                    <c:out value="${message}" />
                </p>
            </c:if>

            <div class="accordion " id="accordionExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button text-uppercase " type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapseOne"
                                aria-expanded="true" aria-controls="collapseOne">
                            Acompanhar as compras de clientes com irregularidades</button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show"
                         aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <%@ include file="data-row-one.jsp"%>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed text-uppercase" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapseTwo"
                                aria-expanded="false" aria-controls="collapseTwo">
                            Acompanhar as compras de clientes com quantidades irregulares e
                            milhar disponível</button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse"
                         aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <%@ include file="data-row-two.jsp"%>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingThree">
                        <button class="accordion-button collapsed text-uppercase" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapseThree"
                                aria-expanded="false" aria-controls="collapseThree">
                            Lista de clientes com suas compras e milhar em aberto</button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse"
                         aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="table-responsive">
                                <%@ include file="table-view-compras-com-milhar-dos-clientes.jsp"%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



        </div>


        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    </body>
</html>
