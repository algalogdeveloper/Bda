package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarMilharExtraUI implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
              String numero = request.getParameter("");
              
        } catch (Exception e) {
        }
        return "views/extra/buscar-milhar.jsp";
    }

}
