package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PainelAdministrativo implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "views/admin/adminpainelacoes.jsp";
    }

}
