<form 
    action="controller?operacao=ConsultasController&consulta=compras"
    method="post">
    <div class="input-group mb-2">
        <select 
            class="custom-select form-control bg-light font-weight-bold border-5 text-uppercase"
            name="buscar" aria-label="Search" aria-describedby="basic-addon2"
            id="inlineFormCustomSelectPref">
            <c:forEach var="l" items="${locais}">
                <option class="font-weight-bold" value="<c:out value="${l.idLocal}"/>">
                    <c:out value="${l.descricao}" />
                </option>
            </c:forEach>
        </select>
        <div class="input-group-append">
            <button type="submit" class="btn bg-gradient-light border text-uppercase font-weight-bold">
                <i class="fas fa-search fa-sm"></i> 
            </button>
        </div>
    </div>
</form>