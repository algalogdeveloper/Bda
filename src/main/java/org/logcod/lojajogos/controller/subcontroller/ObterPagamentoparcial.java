package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class ObterPagamentoparcial implements Action {

    CompraService compraService = new CompraService();
    ConsultasService css = new ConsultasService();
    LocalService ls = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String msg = "Pagamento já foi finalizado";
            Integer idCompra = DataSourceUtil.configDataIntegerValue(request.getParameter("idcompra"));
            Double valor = DataSourceUtil.convertType(request.getParameter("valor"));
            System.out.println(idCompra);
            System.out.println(valor);
            if (!compraService.verificarSeCompraEstaPaga(idCompra)) {
                Compra meuPagamento = compraService
                        .obterCompra(compraService.receberPagamentoParcial(idCompra, valor));
                msg = "Pagamento não foi efetivado totalmente! ";
                request.getSession().setAttribute("meuPagamento2", meuPagamento);
            }

            request.setAttribute("msg", msg);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "controller?operacao=DirecionarPaginaExibirComprasRealizadas");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "controller?operacao=DirecionarPaginaExibirComprasRealizadas";

    }

}
