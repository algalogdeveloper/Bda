package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CentenaGratisService;

public class CentenasGratis implements Action {

    ApostaService cs = new ApostaService();
    CentenaGratisService gs = new CentenaGratisService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("qtd_gratis", gs.qtdCentenaGratis());
        request.setAttribute("qtd_gratisinha", gs.qtdCentenaGratisinha());
        request.setAttribute("compras", cs.listaCompletaSemFiltrosApostas());
        return "views/centena/add-centena.jsp";
    }

}
