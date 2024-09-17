<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../templete/aparencia.jsp"%>
    <body id="page-top">
        <%@ include file="../../templete/menu.jsp"%>
        <div id="content-wrapper" class="d-flex flex-column">

            <nav
                class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <%@ include file="../../templete/filtro.jsp"%>
            </nav>

            <div class="container-fluid">
                <div class="row mt-2">
                    <div class="col-md-12 col-xl-12">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Filtrando
                                todos compras por Quantidade e valor</div>
                            <div class="card-body">
                                <form action="controller?operacao=ConsultarCompraQtdValor"
                                      method="post">

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" class="font-weight-bold">Quantidade de talão:</label>
                                        <select name="qtd"
                                                class=" custom-select form-control font-weight-bold text-uppercase"
                                                id="exampleFormControlSelect1">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>
                                            <option>9</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                            <option>13</option>
                                            <option>14</option>
                                            <option>15</option>
                                            <option>16</option>
                                            <option>17</option>
                                            <option>18</option>
                                            <option>19</option>
                                            <option>20</option>
                                            <option>21</option>

                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" class="font-weight-bold">R$ Valor:</label>
                                        <select name="valor"
                                                class="custom-select form-control font-weight-bold text-uppercase"
                                                id="exampleFormControlSelect1">
                                            <option>5</option>
                                            <option>10</option>
                                            <option>15</option>
                                            <option>20</option>
                                            <option>25</option>
                                            <option>30</option>
                                            <option>35</option>
                                            <option>40</option>
                                            <option>45</option>
                                            <option>50</option>
                                            <option>55</option>
                                            <option>60</option>

                                            <option>65</option>
                                            <option>70</option>
                                            <option>75</option>
                                            <option>80</option>
                                            <option>85</option>
                                            <option>90</option>
                                            <option>95</option>
                                            <option>100</option>
                                            <option>105</option>
                                            <option>110</option>
                                            <option>115</option>
                                            <option>120</option>										

                                            <option>125</option>
                                            <option>130</option>
                                            <option>135</option>
                                            <option>140</option>
                                            <option>145</option>
                                            <option>150</option>
                                            <option>155</option>
                                            <option>160</option>
                                            <option>165</option>
                                            <option>170</option>
                                            <option>175</option>
                                            <option>180</option>

                                            <option>185</option>
                                            <option>190</option>
                                            <option>195</option>
                                            <option>200</option>


                                        </select>


                                    </div>

                                    <button type="submit" class="btn bg-gradient-light text-dark border">
                                        <i class="fas fa-search"> Consultar Dados</i>
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row mt-2">
                    <div class="col-md-12 col-xl-12">
                        <div class="card">
                            <div class="card-header bg-gradient-light text-dark text-uppercase font-weight-bold">Mostrar compras do filtras pela qtd e valor </div>
                            <div class="card-body">
                                <div class="table table-responsive">
                                    <c:choose>
                                        <c:when test="${not empty compras }">
                                            <table
                                                class="table table-borderless table-hover font-weight-bold"
                                                id="dataTable">
                                                <caption>
                                                    Local filtrado:
                                                    <c:choose>
                                                        <c:when test="${not empty endereco}">
                                                            <strong><c:out value="${endereco.descricao}" /> </strong>
                                                        </c:when>
                                                    </c:choose>
                                                </caption>
                                                <thead>
                                                    <tr class="text-uppercase text-dark">
                                                        <th>Id</th>
                                                        <th>Cliente</th>
                                                        <th>R$ Valor</th>
                                                        <th>Qtd</th>
                                                        <th>Data compra</th>
                                                        <th>Situação</th>
                                                        <th>Seus milhar</th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach var="c" items="${compras}">
                                                        <tr>
                                                            <td><c:out value="${c.idCompra }" /></td>
                                                            <th><c:out value="${c.pessoa.nome }" /></th>
                                                            <td><fmt:formatNumber value="${c.valor }"
                                                                              type="currency" /></td>
                                                            <td><c:out value="${c.qtd_cartela}"/> </td>
                                                            <td><fmt:formatDate value="${c.dataJogo.time }"
                                                                            pattern="dd/MM/yyyy" /></td>
                                                            <td><c:choose>
                                                                    <c:when test="${c.pagou}">
                                                                        <strong class="alert alert-success p-1">
                                                                            Pagamento já foi efitivado </strong>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                        <strong class="alert alert-danger p-1">Pagamento
                                                                            em aberto</strong>
                                                                        </c:otherwise>
                                                                    </c:choose></td>
                                                            <td><c:forEach var="a" items="${c.apostas}">
                                                                    <c:out value="${a.milhar.value }" />
                                                                </c:forEach></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>

                                            </table>


                                        </c:when>
                                        <c:otherwise>Não existes compras para esta consulta</c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
        <%@include file="../../templete/scripts.jsp"%>
    </body>
</html>