package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class ExibirCartelasPagas implements Action {

    ConsultasService consulta = new ConsultasService();
    LocalService ls = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String filtro = "", filt = "";
        try {
            int inicio = DataSourceUtil.configDataIntegerValue(request.getParameter("inicio"));
            int limit = DataSourceUtil.configDataIntegerValue(request.getParameter("limit") + 1);
            filtro = request.getParameter("buscar");
            filt = request.getParameter("filt");
            System.out.println("inicio: " + inicio + " Limit: " + limit + " pessoa: " + filtro);
        } catch (Exception e) {
            // TODO: handle exception
        }
        request.setAttribute("locais", ls.getLocals());
        request.setAttribute("compras", consulta.exibirCartelasPagas(filtro, filt));
        request.setAttribute("apostas", consulta.consultarApostas());
        return "views/pagamento/cartelaspagas.jsp";
    }

}
