
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Verificar ganhador</title>
    </head>
    <body>
        <form action="controller" method="get">
            <table border="0" style="width: 50%;">
                <tr>
                    <td colspan="3">CONSULTAR GANHADORES

                        <input name="operacao" value="VerificarGanhador" type="hidden" >
                    </td>
                </tr>
                <tr>
                    <td>Primeiro:</td>
                    <td><input name="p1" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Segundo:</td>
                    <td><input name="p2" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Terceiro:</td>
                    <td><input name="p3" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Quarto:</td>
                    <td><input name="p4" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Quinto:</td>
                    <td><input name="p5" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Sexto:</td>
                    <td><input name="p6" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Setímo:</td>
                    <td><input name="p7" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Oitavo:</td>
                    <td><input name="p8" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Nono:</td>
                    <td><input name="p9" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td>Decímo:</td>
                    <td><input name="p10" type="number" required="required"></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input name="" type="submit" value="Procurar"></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <table border="1" style="width: 50%;">
            <tr style="background: blue; color: white; text-transform:uppercase; font-family: fantasy;">
                <td>Posição</td>
                <td>Pessoa</td>
                <td>Endereço</td>
                <td>Milhar</td>
            </tr>
            <c:forEach var="c" items="${compras}">
                <tr>
                    <td><c:out value="${c.idAposta}º prêmio"/> </td>
                    <td><c:out value="${c.compra.pessoa.nome}"/></td>
                    <td><c:out value="${c.compra.pessoa.local.descricao}"/></td>
                    <td><c:out value="${c.milhar.value}"/></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>