<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html lang="br">
    <%@ include file="templete/aparencia.jsp"%>
    <body>
        <main>
            <%@ include file="admin/login.jsp"%>
            <%@ include file="templete/scripts.jsp"%>
            <script>
                var evento = document.getElementById("button-addon2");
                var ti = document.getElementById("tranformando-input");
                var message = document.getElementById("message");

                var qtd = 1;
                evento.addEventListener('click', function (e) {
                    if (ti.value.length > 0) {
                        if (qtd === 1)
                        {
                            ti.removeAttribute('type');
                            message.removeAttribute("hidden");
                            message.setAttribute("class", "font-weight-bold text-danger");
                            evento.setAttribute("class", "btn bg-light border");
                            evento.innerHTML = '<i class="fa fa-eye text-danger"></i>';
                            qtd = 2;
                        } else
                        {
                            ti.setAttribute("type", "password");
                            message.setAttribute("hidden", "hidden");
                            evento.setAttribute("class", "btn bg-light border");
                            evento.innerHTML = '<i class="fa fa-eye-slash "></i>';
                            qtd = 1;
                        }
                    }

                    ti.focus();
                });

            </script>

        </main>
    </body>

</html>

