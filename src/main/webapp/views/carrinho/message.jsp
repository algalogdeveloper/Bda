<div class="card mb-1">
    <div class="card-body">
        <div class="form-group">
            <label class="form-group font-weight-bold mb-2">Milhar:

            </label>            
            <input type="number" class="form-control form-control-lg" id="numero" max="9999" maxlength="4" min="0">
        </div>
    </div>
    <div class="card-footer text-uppercase ">
        <core:choose>
            <core:when test="${not empty msg}">
                <strong id="sucesso" class="alert alert-success p-1"><core:out value="${msg}"/> </strong>
            </core:when>
            <c:when test="${not empty erro}">
                <strong id="erro" class="alert alert-danger p-1"><core:out value="${erro}"/> </strong>
            </c:when>
        </core:choose>
    </div>
</div>