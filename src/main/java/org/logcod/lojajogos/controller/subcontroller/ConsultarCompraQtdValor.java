package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ConsultarCompraQtdValor implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Compra> lista = null;
        CompraService cs = new CompraService();
        try {
            double valor = Double.valueOf(request.getParameter("valor"));
            int qtd = Integer.valueOf(request.getParameter("qtd"));
            lista = cs.consultarMilharClienteQtdEValor(valor, qtd);
            request.setAttribute("compras", lista);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return "views/compras/filtrar-compras-por-qtd-valor.jsp";
    }

}
