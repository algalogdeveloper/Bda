package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CompraService;

public class HabilitarCobranca implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        cs.habilitarCobranca();
        return "controller?operacao=PagamentoController";
    }

}
