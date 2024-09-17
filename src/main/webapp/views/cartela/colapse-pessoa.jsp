<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="headingOne">
            <h3 class="mb-0">
                <button class="btn btn-link btn-block text-left" type="button"
                        data-toggle="collapse" data-target="#collapseOne"
                        aria-expanded="true" aria-controls="collapseOne">
                    <c:out value="${c.pessoa.nome }" />
                </button>
            </h3>
        </div>
        <div id="collapseOne" class="collapse show"
             aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
                <c:if test="${not empty apostas }">
                    <c:forEach var="a" items="${apostas}">
                        <c:if test="${c.idCompra == a.compra.idCompra }">
                            <label><c:out value="${a.milhar.value}" /></label>
                        </c:if>
                    </c:forEach>
                </c:if>

            </div>
        </div>
    </div>


</div>