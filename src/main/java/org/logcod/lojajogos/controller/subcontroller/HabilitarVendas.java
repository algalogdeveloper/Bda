package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.AreaAdministradorService;

public class HabilitarVendas implements Action {

    AreaAdministradorService as = new AreaAdministradorService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String message = "As ações não foram aplicadas";
        if (as.ativarPlataformaParaVendas()) {
            message = "Todas as ações da plataforma foram habilitadas para vendas.";
        }
        request.setAttribute("message", message);
        return "controller?operacao=areaadmin";
    }

}
