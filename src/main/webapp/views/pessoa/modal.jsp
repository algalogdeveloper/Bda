<div class="modal fade" id="modalDiscount" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true">
    <div class="modal-dialog modal-dialog-centered modal-lg"
         role="document">

        <div class="modal-content">

            <div class="modal-header  bg-gradient-light text-dark font-weight-bold">
                <h5 class="modal-title font-weight-bold">FORMULÁRIO DO CLIENTE</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>

            <div class="modal-body">
                <div class="row">

                    <div class="col-md-12">
                        <div class="modal-body">
                            <form action="controller?operacao=PessoaController&pessoa=save"
                                  method="post">
                                <div class="form-group">
                                    <!--  <input type="hidden" value="save" name="pessoa"/> -->
                                    <input type="hidden" name="idPessoa" id="component-idPessoa" />
                                </div>
                                <div class="form-group">
                                    <label for="recipient-name" class="font-weight-bold">Nome:* </label> <input type="text"
                                                                                                                required="" name="nome"
                                                                                                                class="form-control font-weight-bold btn-round"
                                                                                                                id="component-name">
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="message-text" class="font-weight-bold">E-mail:</label> <input name="email"
                                                                                                                      class="form-control font-weight-bold" id="component-email" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="message-text" class="font-weight-bold">Contato:</label> <input
                                                name="contato" type="tel"
                                                class="form-control font-weight-bold" id="component-contato" />

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="font-weight-bold">Endereços:*</label> 
                                    <select name="idLocal" required 
                                            class="custom-select form-control font-weight-bold" id="component-endereco">
                                        <c:choose>
                                            <c:when test="${not empty enderecos}">
                                                <c:forEach var="e" items="${enderecos}">
                                                    <option class="font-weight-bold" value="<c:out value="${e.idLocal}"/>">
                                                        <c:out value="${e.descricao}" />
                                                    </option>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <option>Não existe endereços</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="message-text" class="font-weight-bold">Referência:</label>
                                    <textarea placeholder="Informe uma referencia pessoal?"
                                              name="referencia" class="form-control font-weight-bold"
                                              id="component-referencia">

                                    </textarea>
                                </div>

                                <div class="flex-center">
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button type="submit" class="btn  bg-gradient-success text-white"><i class="fas fa-save"> Enviar</i> </button>
                                        <button type="reset" class="btn  bg-gradient-danger text-white"
                                                data-dismiss="modal">Fechar</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


