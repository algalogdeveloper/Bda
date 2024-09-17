<div class="card-group">
    <div class="card">

        <div class="card-body">
            <div class="card">
                <div class="card-header">Sequência de três</div>
                <div class="card-body">
                    <form action="controller" method="get">
                        <fieldset class="user">
                            <input name="operacao" value="CarrinhoController" hidden="">
                            <input name="carrinho" value="agregar" hidden="">
                            <div class="form-group">
                                <input type="number" name="milhar01" id="chaveJogo"
                                       class="form-control font-weight-bold" required="required"
                                       placeholder="Milhar 01"><br> <input
                                       type="number" name="milhar02" id="chaveJogo"
                                       required="required" class="form-control font-weight-bold"
                                       placeholder="Milhar 02"><br> <input
                                       type="number" name="milhar03" id="chaveJogo"
                                       required="required" class="form-control font-weight-bold"
                                       placeholder="Milhar 03">
                            </div>

                            <button type="submit" title="adicionar"
                                    class="btn btn-outline-dark font-weight-bold">
                                <i class="fas fa-plus"></i> VALIDAR SEQUÊNCIA
                            </button>

                        </fieldset>
                    </form>
                </div>
            </div>


        </div>
        <div class="card-footer">
            <small class="text-muted">Formulario</small>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <div class="card">
                <div class="card-header">Sequência de seis</div>
                <div class="card-body">
                    <form action="controller" method="get">

                        <input name="operacao" value="CarrinhoController" hidden="">
                        <input name="carrinho" value="agregar06" hidden="">
                        <div class="form-group">
                            <input type="number" name="milhar01" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 01" maxlength="4"><br> <input
                                   type="number" name="milhar02" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 02" maxlength="4"><br> <input
                                   type="number" name="milhar03" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 03" maxlength="4"><br> <input
                                   type="number" name="milhar04" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 04" maxlength="4"><br> <input
                                   type="number" name="milhar05" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 05" maxlength="4"><br> <input
                                   type="number" name="milhar06" id="chaveJogo"
                                   class="form-control font-weight-bold" required="required"
                                   placeholder="Milhar 06" maxlength="4">
                        </div>

                        <button type="submit" title="adicionar"
                                class="btn btn-success font-weight-bold text-uppercase">
                            <i class="fas fa-plus"></i> Validar sequência 02
                        </button>


                    </form>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <small class="text-muted">Formulario</small>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <div class="card">
                <div class="card-header">Featured</div>
                <div class="card-body">
                    <div class="card shadow mb-4">

                        <div class="card-body">
                            <p class="btn btn-outline-info text-center">
                                Atenção: <i class="fas fa-info"></i>
                            </p>
                            <p class="text-justify">É necessario escolher umas das
                                opções para verificação dos numeros informados!</p>
                        </div>
                        <div class="card-footer">
                            <p class="text-center">
                                Leia: <i class="fas fa-info"></i>
                            </p>
                            <c:if test="${not empty valid}">
                                <p class="alert alert-info">
                                    <c:out value="${valid}" />
                                </p>
                            </c:if>


                        </div>


                    </div>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <small class="text-muted">Mensagens</small>
        </div>
    </div>
</div>