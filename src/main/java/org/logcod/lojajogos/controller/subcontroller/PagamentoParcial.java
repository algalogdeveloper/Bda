package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class PagamentoParcial implements Action {

    CompraService compraService = new CompraService();
    ConsultasService css = new ConsultasService();
    LocalService ls = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Local local = (Local) request.getSession().getAttribute("local");

        try {
            String msg = "Pagamento já foi finalizado";
            Integer idCompra = DataSourceUtil.configDataIntegerValue(request.getParameter("idcompra"));
            Double valor = DataSourceUtil.convertType(request.getParameter("valor"));
            if (!compraService.verificarSeCompraEstaPaga(idCompra)) {
                Compra meuPagamento = compraService.obterCompra(compraService.receberPagamentoParcial(idCompra, valor));
                msg = "Pagamento não foi efetivado totalmente! ";
                request.getSession().setAttribute("meuPagamento", meuPagamento);
            }
            request.setAttribute("msg", msg);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "controller?operacao=PagamentoController&buscar=" + local.getIdLocal());
            return "";
        } catch (Exception e) {
            System.out.println(e);
            return "controller?operacao=PagamentoController&buscar=" + local.getIdLocal();
        }

    }

}
