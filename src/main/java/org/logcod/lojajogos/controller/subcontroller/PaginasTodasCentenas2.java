package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CentenaGratisService;

public class PaginasTodasCentenas2 implements Action {

    CentenaGratisService centenaGratisService = new CentenaGratisService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("gratisinha", centenaGratisService.listaCompraComCentenasGratisinha());
            return "views/centena/consultar-todas-centenas2.jsp";
        } catch (Exception e) {
            return "views/centena/consultar-todas-centenas2.jsp";
        }

    }

}
