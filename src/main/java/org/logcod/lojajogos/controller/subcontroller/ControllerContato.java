package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerContato implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "views/contato/contato.jsp";
    }

}
