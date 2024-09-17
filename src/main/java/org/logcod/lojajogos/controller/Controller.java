package org.logcod.lojajogos.controller;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.controller.subcontroller.Action;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String direcionar = "index.jsp";
            if (Objects.nonNull((String) request.getSession().getAttribute("logado"))) {
                String url = request.getServletContext().getInitParameter("invoke") + request.getParameter("operacao");
                Class<?> instance = Class.forName(url);
                Action mvc = (Action) instance.newInstance();
                direcionar = mvc.execute(request, response);
            } else {
                request.setAttribute("msg", "Login ou senha invalidos!");
            }
            request.getRequestDispatcher(direcionar).forward(request, response);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException
                | ServletException ex) {
            request.setAttribute("msg", "Controllador operando com falha: " + ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
