<form action="controller?operacao=UISacolaEnviar" method="post">
    <div class="row">
        <div class="col-sm-5 mb-1">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title font-weight-bold border-bottom-success">DADOS ADICIONAIS DO CLIENTE:</h5>
                    <div class="form-group">
                        <label for="exampleFormControlInput1" class="font-weight-bold">Nome do cliente:*</label>
                        <input type="text" id="nome" required="" name="nome" class="form-control font-weight-bold"  placeholder="Nome do cliente">
                    </div>
                    <div class="form-group mb-3">
                        <label for="exampleFormControlInput1" class="font-weight-bold">Endereço do cliente:*</label>
                        <select name="endereco" required="" id="endereco" class="custom-select form-control text-uppercase font-weight-bold " >
                            <core:forEach var="e" items="${enderecos}">
                                <core:choose>
                                    <core:when test="${model.endereco eq e.idLocal}">
                                        <option selected="" class="text-uppercase font-weight-bold" value="<core:out value="${e.idLocal}"/>" ><core:out value="${e.descricao}"/> </option>
                                    </core:when>
                                    <core:otherwise>
                                        <option class="text-uppercase font-weight-bold" value="<core:out value="${e.idLocal}"/>" ><core:out value="${e.descricao}"/> </option>
                                    </core:otherwise>
                                </core:choose>
                            </core:forEach>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-7 mb-1">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title font-weight-bold border-bottom-success">DADOS ADICIONAIS DO CANHATO:</h5>
                    <div class="form-group">
                        <label for="exampleFormControlInput1" class="font-weight-bold">Descriçao do canhoto:*</label>
                        <input type="text" name="descricao" required="" id="descricao" class="form-control font-weight-bold" placeholder="Qual é a premiação" value="<core:out value="${model.descricao}"/>" >
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">R$ Valor do canhato:*</label>
                                <input type="number" name="valor" required="" id="valor" class="form-control font-weight-bold" placeholder="0,00" value="<core:out value="${model.valor}" />" >
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="exampleFormControlInput1"  class="font-weight-bold">R$ Quantidade:*</label>
                                <input type="number" name="qtd" id="qtd"  required="" class="form-control font-weight-bold"  placeholder="0" value="<core:out value="${model.qtd}"/>">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">R$ Desconto:*</label>
                                <input type="number" name="desconto" required="" id="desconto" class="form-control font-weight-bold"  placeholder="0,00">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group mb-3">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Situação:*</label>
                                <select required="" name="situacao" class="custom-select form-control text-uppercase font-weight-bold" id="situacao">
                                    <option class="text-uppercase font-weight-bold" value="NÃO"><core:out value="NÃO"/> </option>
                                    <option class="text-uppercase font-weight-bold" value="SIM" ><core:out value="SIM"/> </option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row mb-1">
        <div class="col-md-6">
            <button  type="submit" id="enviar" class="btn btn-light border-bottom-success text-uppercase btn-lg btn-block mt-1"><i class="fa fa-check text-success"> Enviando dados do canhoto</i> </button>
        </div>
        <div class="col-md-6">
            <button type="reset" id="limpar" class="btn btn-light border-bottom-danger text-uppercase btn-lg btn-block mt-1"><i class="fa fa-bug text-danger"> Limpar dados da canhoto</i> </button>
        </div>
    </div>
</form>