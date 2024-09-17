package org.logcod.lojajogos.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.controller.subcontroller.Invoke;
@WebServlet(name = "ControllerBuscas",urlPatterns ="/ControllerBuscas" )
public class ControllerBuscas extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class<?> instance = Class.forName("org.logcod.lojajogos.controller.subcontroller."+req.getParameter("invoke"));
            Invoke mvc = (Invoke) instance.newInstance();
            String invoke = mvc.invoke(req, resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(invoke);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
        }

    }

}
