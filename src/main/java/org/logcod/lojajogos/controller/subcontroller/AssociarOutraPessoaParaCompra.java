package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;

public class AssociarOutraPessoaParaCompra implements Action {

    CompraService cs = new CompraService();
    ConsultasService css = new ConsultasService();
    LocalService ls = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Compra compra = cs.get(DataSourceUtil.configDataIntegerValue(request.getParameter("acao")));
            request.setAttribute("compra", compra);
            request.setAttribute("apostas", css.detalhesAposta(compra.getIdCompra()));
            request.setAttribute("enderecos", ls.getLocals());
            return "views/compras/reaproveitarcompra.jsp";
        } catch (Exception e) {
            // TODO: handle exception
            return "controller?operacao=PagamentoController&buscar=" + (String) request.getSession().getAttribute("local");

        }
    }

}
