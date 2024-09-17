
<%
int qtdpage = (int) request.getAttribute("qtdpage");
int pagina = (int) request.getAttribute("page");
int qtddata = (int) request.getAttribute("qtddata");
int limite = (int) request.getAttribute("limite");
%>
<c:choose>
    <c:when test="${not empty apostas}">
        <c:forEach var="a" items="${apostas}">
            <div class="col  mr-1">
                <p class="btn btn-outline-primary p-1 text-center ">
                    <c:out value="${a.milhar.value }" />
                </p>
            </div>
        </c:forEach>
    </c:when>
</c:choose>

<p>
    Total pagina:<%=qtdpage%>
    Registros:
    <%=qtddata%>
    limite:<%=limite%>
</p>
<nav aria-label="...">

    <ul class="pagination pagination-sm">
        <li class="page-item"><a class="page-link"
                                 href="controller?operacao=areaadmin&data=<c:out value="${anterior}"/>"
                                 aria-label="Previous"> <span aria-hidden="true">Anterior&laquo;</span>
            </a> <%
             for (int i = 1; i <= qtdpage; i++) {
            if (pagina == i) {
            %>
        <li class="page-item active" aria-current="page"><span
                class="page-link"> <%=i%>
            </span></li>
            <%
            } else if (i <= 5) {
            %>
        <li class="page-item"><a class="page-link"
                                 href="controller?operacao=areaadmin&data=<%=i%>"><%=i%></a></li>
            <%
            }
            %>

        <%}%>
        <li class="page-item"><a class="page-link"
                                 href="controller?operacao=areaadmin&data=<c:out value="${proxima}"/>"
                                 aria-label="Next"> <span aria-hidden="true">Próxima&raquo;</span>
            </a></li>
    </ul>
</nav>