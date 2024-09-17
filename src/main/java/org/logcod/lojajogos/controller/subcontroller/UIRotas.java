package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.RepositoryRota;
import org.logcod.lojajogos.service.RotaService;

public class UIRotas implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        RotaService rs = new RotaService(new RepositoryRota());
        request.setAttribute("rotas", rs.listaRotasAS());
        return "views/rotas/UIrotas.jsp";
    }

}
