package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class ExibirCartelasNaoPagas implements Action {

    ConsultasService consulta = new ConsultasService();
    LocalService ls = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            String filtro = request.getParameter("buscar");
            String filt = request.getParameter("filt");
            request.setAttribute("compras", consulta.exibirCartelasNaoPagas(filtro, filt));
            request.setAttribute("apostas", consulta.consultarApostas());
            request.setAttribute("locais", ls.getLocals());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return "views/pagamento/cartelasnaopagas.jsp";
    }

    public int convertInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

}
