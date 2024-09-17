
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
                            <h1 class="h3 mb-0 text-gray-800 font-weight-bold">
                                REAPROVEITAR COMPRA</h1>
                            <a class="btn btn-info font-weight-bold"
                               href="controller?operacao=CarrinhoController&carrinho=loja">Criar
                                cartela</a>
                        </div>
                        <div class="row">
                            <!-- Area Chart -->
                            <div class="col-xl-12 col-lg-7">
                                <div class="card shadow mb-4 font-weight-bold">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">


                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-xl-4 col-lg-7">

                                                <div class="card" style="width: 18rem;">
                                                    <img src="img/undraw_posting_photo.svg" class="card-img-top"
                                                         alt="...">
                                                    <div class="card-body">
                                                        <h5 class="card-title font-weight-bold">
                                                            NOME :
                                                            <c:out value=" ${compra.pessoa.nome}" />
                                                        </h5>
                                                        <p class="card-text">Todos os numeros disponivel para
                                                            realizar a transferência da pessoa.</p>
                                                        <p class="card-text">
                                                            Numeros:
                                                            <c:forEach var="a" items="${apostas}">
                                                                <c:out value=" ${a.milhar.value}" />
                                                            </c:forEach>
                                                        </p>
                                                        <p class="card-text alert alert-info">
                                                            <i class="fas fa-info"></i> Obs: A pessoa referênciada
                                                            está ligado aos milhar exibidos.
                                                        </p>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="col-xl-8 col-lg-7">
                                                <div class="card" style="width: 18rem;">
                                                    <img src="img/login.jpeg" class="card-img-top" alt="..."
                                                         >
                                                    <div class="card-body">
                                                        <h5 class="card-title font-weight-bold">
                                                            NOVO PESSOA
                                                        </h5>
                                                        <form>
                                                            <div class="form-group">
                                                                <label for="exampleFormControlInput1">Apeliado</label> <input
                                                                    type="text" name="nome"
                                                                    class="form-control font-weight-bold"
                                                                    id="exampleFormControlInput1"
                                                                    placeholder="Apelido da pessoa?"> <input
                                                                    name="operacao" hidden=""
                                                                    value="CadatrarPessoaComMilharAssociado"> <input
                                                                    name="idcompra" hidden=""
                                                                    value="<c:out value="${compra.idCompra}"/>">
                                                            </div>

                                                            <div class="form-group ">
                                                                <label for="exampleFormControlSelect2">Endereços
                                                                </label> <select multiple class="form-control font-weight-bold"
                                                                                 name="end" id="exampleFormControlSelect2">
                                                                    <c:forEach var="e" items="${enderecos}">
                                                                        <option value="<c:out value="${e.idLocal}"/>"
                                                                                class="font-weight-bold"><c:out
                                                                                value="${e.descricao}" />
                                                                        </option>

                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleFormControlTextarea1">Referência
                                                                </label>
                                                                <textarea class="form-control" name="ref"
                                                                          id="exampleFormControlTextarea1" rows="3"></textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleFormControlTextarea1">Pagou
                                                                </label>
                                                                <select class="form-control"  name="pagou"
                                                                        id="exampleFormControlTextarea1" >
                                                                    <option disabled="disabled">Pessoa pagou?</option>
                                                                    <option value="nao">Não</option>
                                                                    <option value="sim">Sim</option>
                                                                </select>

                                                            </div>

                                                            <div class="form-group">

                                                                <button
                                                                    class="form-control btn btn-success font-weight-bold"
                                                                    type="submit" id="exampleFormControlTextarea1">Save</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>



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
