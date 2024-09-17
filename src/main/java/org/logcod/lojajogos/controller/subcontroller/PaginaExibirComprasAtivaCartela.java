package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class PaginaExibirComprasAtivaCartela implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("acao");
        CompraService compraService = new CompraService();
        boolean ativa = compraService.ativarCobrancaCliente(Integer.valueOf(action));
        System.out.println("Cobrança ativa: " + ativa);
        if (ativa) {
            Compra meuPagamento = compraService.obterCompra(Integer.valueOf(action));
            if (meuPagamento.getValor() < (meuPagamento.getQtd_cartela() * meuPagamento.getValorBilhete())) {
                compraService
                        .obterPrecoNormalizado(meuPagamento
                                .getIdCompra(), (meuPagamento
                                        .getQtd_cartela()
                                * meuPagamento.getValorBilhete())
                                - meuPagamento.getDesconto());

            }
            request.getSession().setAttribute("meuPagamento2", meuPagamento);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "controller?operacao=DirecionarPaginaExibirComprasRealizadas");
        }
        request.setAttribute("msg", "Sua compra não foi alterada ainda.");
        return "controller?operacao=DirecionarPaginaExibirComprasRealizadas";
    }

}
