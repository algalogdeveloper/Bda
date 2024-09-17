package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CompraService;

public class Faturamento implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String destino = "controller?operacao=PainelAdministrativo";
        try {
            int permissao = Integer.valueOf((Integer) request.getSession().getAttribute("permissao"));
            if (permissao > 0) {
                request.setAttribute("faturamentoGeral", cs.carregarFaturamentoTotalCartelasPagasNoGeral());
                request.setAttribute("faturamento", cs.carregarFaturamentoTotalCartelas());
                request.setAttribute("notfaturamento", cs.carregarFaturamentoTotalCartelasParaReceber());
                request.setAttribute("msg", "Seja bem vindo: " + (String) request.getSession().getAttribute("usuario"));
                destino = "views/pagamento/faturamento.jsp";
            } else {
                request.setAttribute("msg", "Voce não possui permissão: " + (String) request.getSession().getAttribute("usuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return destino;
    }

}
