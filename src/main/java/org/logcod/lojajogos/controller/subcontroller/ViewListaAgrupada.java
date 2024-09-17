package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.service.CompraService;

public class ViewListaAgrupada implements Action {

    protected CompraService cs;

    public ViewListaAgrupada() {
        cs = new CompraService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
             request.setAttribute("apostasAgrupadas", cs.apostasAgrupadas());           
        } catch (Exception e) {
            System.err.println("Erro:"+e.getMessage());
        }
        return "views/compras/lista-agrupada-de-apostas.jsp";
     }

}
