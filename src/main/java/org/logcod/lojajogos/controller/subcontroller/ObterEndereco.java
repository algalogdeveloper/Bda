package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class ObterEndereco implements Action {

    LocalService localService = new LocalService();
    CompraService compraService = new CompraService();
    ConsultasService cs = new ConsultasService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String endereco = request.getParameter("buscar");
            request.setAttribute("endereco", endereco);
            request.setAttribute("compras", cs.listarComprasSemFiltrosCobrador(endereco));
        } catch (Exception e) {
            System.out.println(e);
        }
        return "controller?operacao=CarregarPaginaReizinho";
    }

}
