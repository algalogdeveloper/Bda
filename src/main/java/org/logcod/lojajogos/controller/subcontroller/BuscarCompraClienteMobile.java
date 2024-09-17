package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class BuscarCompraClienteMobile implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String data = request.getParameter("buscar").toUpperCase();
            System.out.println("Buscado = " + data);
            List<Compra> compras = cs.buscarCompraClienteMobile(data);
            System.out.println(compras);
            request.setAttribute("compras", compras);
        } catch (Exception e) {

        }

        return "views/pessoa/cliente-compra-mobile.jsp";
    }

}
