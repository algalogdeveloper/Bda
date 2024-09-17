<form action="controller" method="get">

    <input name="operacao" hidden="" value="CarrinhoController"> <input
        name="carrinho" hidden="" value="compra">

    <div class="card-group">
        <div class="card">

            <div class="card-body">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">DADOS PESSOAIS</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">

                        <div class="mt-1 small">
                            <div class="form-group">
                                <input type="text" required="required" name="nome"
                                       class="form-control font-weight-bold" id="exampleInputEmail"
                                       aria-describedby="emailHelp" placeholder="Apelido">
                            </div>
                            <div class="form-group">
                                <input type="text" name="contato"
                                       class="form-control font-weight-bold "
                                       id="exampleInputPassword" placeholder="Contato">
                            </div>
                            <div class="form-group">
                                <select name="idLocal" class="form-control font-weight-bold">

                                    <c:forEach var="e" items="${enderecos}">
                                        <option class="form-control font-weight-bold"
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
            <div class="card-footer">
                <small class="text-muted">Formulario</small>
            </div>
        </div>

        <div class="card">

            <div class="card-body">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">DADOS
                            ADICIONAIS DA CARTELA</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">

                        <div class="mt-1 small">

                            <div class="row">
                                <div class="col-xl-12 col-lg-7">

                                    <div class="form-group">
                                        <input type="text" required="required" name="premio"
                                               class="form-control font-weight-bold"
                                               value='<c:out value="${premio}"/>' id="" aria-describedby=""
                                               placeholder="Prêmio">
                                    </div>

                                </div>
                                <div class="col-xl-6 col-lg-7">

                                    <div class="form-group">

                                        <input type="number" min="0" name="valor"
                                               value='<c:out value="${valor}"/>'
                                               class="form-control font-weight-bold" required="required"
                                               id="" aria-describedby="" placeholder="R$ Valor cartela">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" name="numero_cartela" class="form-control"
                                               required="required" id="exampleInputPassword"
                                               placeholder="Nº cartela">
                                    </div>


                                </div>
                                <div class="col-xl-6 col-lg-7">

                                    <div class="form-group">

                                        <input type="number" min="0" name="qtd_cartela"
                                               value='<c:out value="${qtd_cartela}"/>'
                                               class="form-control font-weight-bold" id="exampleInputEmail"
                                               value="<c:out value="${qtd_cartela}"/>"
                                               aria-describedby="emailHelp" required="required"
                                               placeholder="Qtd de nº na cartela">
                                    </div>
                                    <div class="form-group">
                                        <select name="situacao" required="required"
                                                class="form-control font-weight-bold">
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

            <div class="card-footer">

                <button type="submit" min="0" name="Enviar"
                        class="btn btn-success btn-lg font-weight-bold">ENVIAR
                    INFORMAÇÕES</button>
                <button type="reset" min="0" name="Enviar"
                        class="btn btn-danger btn-lg font-weight-bold">LIMPAR
                    INFORMAÇÕES</button>
            </div>

        </div>
    </div>


</form>