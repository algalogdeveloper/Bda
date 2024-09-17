package org.logcod.lojajogos.controller.subcontroller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ConsultarPagamentosDoDia implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Compra> lista = cs.vizualizarPagamentosDoDia();
            request.setAttribute("compras", lista);
        } catch (Exception e) {
        }
        return "views/pagamento/pagamentosdodia.jsp";
    }

}
