
package org.logcod.lojajogos.controller.subcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.ConsultasService;

public class NumeroExtraUI implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ConsultasService cs = new ConsultasService();
        List<Compra> listarComprasSemFiltros = cs.listarComprasSemFiltros();
        request.setAttribute("listarComprasSemFiltros", listarComprasSemFiltros);
        return "views/extra/milhar-extra.jsp"; 
    }
    
}
