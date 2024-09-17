
<div class="row text-center ">
    <c:forEach var="c" items="${meuCarrinho}">



        <div class="col-md-2">
            <div class="card border-left-primary mb-4">

                <div class="card-body">
                    <h5 class="text-center text-primary font-weight-bold">
                        Situação do
                        <c:out value="${c.value}" />
                    </h5>
                    <strong class="font-italic">
                        Status:
                        <c:choose>
                            <c:when test="${c.disponivel}">
                                <c:out value="Comprando" />
                            </c:when>
                            <c:otherwise>
                                <c:out value="Comprado" />
                            </c:otherwise>
                        </c:choose>
                    </strong>
                </div>
                <div class="card-footer text-primary">
                    <fieldset>
                        <input hidden="" id="idJogo" name="idJogo"
                               value="<c:out value="${c.value}"/>"> <a href="#"
                               id="carrinho-remove" class="btn btn-danger"><i
                                class="fas fa-trash-alt"></i> Remover </a>
                    </fieldset>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
