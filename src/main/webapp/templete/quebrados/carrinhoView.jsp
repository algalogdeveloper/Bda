<div class="row">
    <c:forEach var="c" items="${meuCarrinho}">
        <div class="col-xl-4 col-lg-5">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between alert alert-primary">
                    <h6 class="m-0 font-weight-bold text-primary">NUMEROS</h6>

                </div>

                <div class="card-body">
                    <h4 class="text-center font-weight-bold">
                        Nº
                        <c:out value="${c.value}" />
                    </h4>
                    <p class="font-italic text-center">
                        Situação:
                        <c:choose>
                            <c:when test="${c.disponivel}">
                                <c:out value="Comprando" />
                            </c:when>
                            <c:otherwise>
                                <c:out value="Comprado" />
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
                <div class="card-footer text-primary">
                    <fieldset>
                        <input hidden="" id="idJogo" name="idJogo"
                               value="<c:out value="${c.value}"/>"> <a href="#"
                               id="carrinho-remove" class="btn btn-primary"><i
                                class="fas fa-trash-alt"></i> Remover </a>
                    </fieldset>
                </div>

            </div>

        </div>
    </c:forEach>
</div>