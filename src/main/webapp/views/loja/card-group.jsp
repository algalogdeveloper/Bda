<div class="card-deck">
    <div class="card">
        <img src="..." class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Buscar clientes:</h5>
            <form class="form-inline">
                <input name="consulta" hidden="" value="compras">

                <select class="custom-select my-1 mr-sm-2 text-uppercase"
                        id="inlineFormCustomSelectPref">

                    <c:choose>
                        <c:when test="${not empty locais}">

                            <c:forEach var="l" items="${locais}">

                                <option value="<c:out value="${l.idLocal}"/>">
                                    <c:out value="${l.descricao}" />
                                </option>

                            </c:forEach>

                        </c:when>
                        <c:otherwise>
                            <option>Lista sem elementos</option>
                        </c:otherwise>

                    </c:choose>

                </select>
                <button type="submit" class="btn btn-primary my-1">Submit</button>
            </form>
        </div>
    </div>
    <div class="card">
        <img src="..." class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This card has supporting text below as a
                natural lead-in to additional content.</p>
            <p class="card-text">
                <small class="text-muted">Last updated 3 mins ago</small>
            </p>
        </div>
    </div>
    <div class="card">
        <img src="..." class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This is a wider card with supporting text
                below as a natural lead-in to additional content. This card has even
                longer content than the first to show that equal height action.</p>
            <p class="card-text">
                <small class="text-muted">Last updated 3 mins ago</small>
            </p>
        </div>
    </div>
</div>