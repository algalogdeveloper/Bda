package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class ListarMilhar implements Action {

    LocalService serviceLocal = new LocalService();
    CompraService jogoService = new CompraService();
    PessoaService pessoaService = new PessoaService();
    ConsultasService consultasService = new ConsultasService();
    ApostaService apostaService = new ApostaService();
    MilharService milharService = new MilharService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("enderecos", serviceLocal.getLocals());
            request.setAttribute("compras", consultasService.selecioneCartelasVendidasNoDia());
            return "views/cartela/compras.jsp";
        } catch (Exception e) {
            return "index.jsp";
        }

    }

}
