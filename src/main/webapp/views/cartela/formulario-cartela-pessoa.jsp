<form action="controller?operacao=CarrinhoController" method="post">
    <div class="row">
        <input name="carrinho" hidden="" value="compra">
        <div class="col-md-5">
            <div class="card mb-4">
                <div
                    class="card-header bg-gradient-light text-dark font-weight-bold text-uppercase">
                    <h6 class="m-0 font-weight-bold">DADOS DO CLIENTE</h6>
                </div>

                <div class="card-body">
                    <div class="mt-1 small">
                        <div class="form-group">
                            <input type="text" required="required" name="nome"
                                   class="form-control font-weight-bold" id="exampleInputEmail"
                                   aria-describedby="emailHelp" placeholder="Apelido">
                        </div>
                        <div class="form-group">
                            <select name="idLocal"
                                    class="custom-select form-control font-weight-bold text-uppercase">
                                <c:if test="${not empty endereco }">
                                    <option class="form-control font-weight-bold text-uppercase"
                                            value="<c:out value="${endereco.idLocal}"/>">
                                        <c:out value="${endereco.descricao}" />
                                    </option>
                                </c:if>
                                <c:forEach var="e" items="${enderecos}">
                                    <option class="form-control font-weight-bold text-uppercase"
                                            value="<c:out value="${e.idLocal}"/>"><c:out
                                            value="${e.descricao}" />
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-7">
            <div class="card mb-2">
                <div
                    class="card-header bg-gradient-light text-dark font-weight-bolds text-uppercase ">
                    <h6 class="m-0 font-weight-bold">DADOS DO TALAO</h6>
                </div>
                <div class="card-body">

                    <div class="row">

                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="text" required="required" name="premio"
                                       class="form-control font-weight-bold"
                                       value='<c:out value="${premio}"/>' id="" aria-describedby=""
                                       placeholder="Prêmio">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <input type="number" min="0" name="valor"
                                       value='<c:out value="${valor}"/>'
                                       class="form-control font-weight-bold" required="required" id=""
                                       aria-describedby="" placeholder="R$ Valor cartela">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">

                                <input type="number" min="0" name="qtd_cartela"								
                                       class="form-control font-weight-bold" id="exampleInputEmail"
                                       value="<c:out value="${qtd_cartela}"/>"
                                       aria-describedby="emailHelp" required="required"
                                       placeholder="Qtd de nº na cartela">
                            </div>
                        </div>
                        <div class="col -md-3">
                            <div class="form-group">

                                <input type="number" min="0" name="desconto"									
                                       class="form-control font-weight-bold" id="exampleInputEmail"
                                       aria-describedby="emailHelp" required="required"
                                       placeholder="0.00">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div>
                                <div class="form-group">
                                    <select name="situacao" required="required"
                                            class="custom-select form-control font-weight-bold">
                                        <option disabled="disabled">A pessoa pagou?</option>
                                        <option>Não</option>
                                        <option>Sim</option> 
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <div class="col-xl-12 col-md-4">
            <div class="card">
                <p class="card-header bg-gradient-light text-dark font-weight-bold text-uppercase">AÇÕES</p>
                <div class="card-body">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="submit" name="Enviar" class="btn bg-gradient-light btn-lg border font-weight-bolder">
                            <i class="fa fa-save text-primary"> </i> ENVIAR DADOS
                        </button>
                        <button type="reset" name="Enviar"
                                class="btn bg-gradient-light text-danger border btn-lg font-weight-bold">
                            <img alt="" width="15" src="img/limpar-limpo.png"> LIMPAR
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>