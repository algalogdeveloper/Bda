package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class ModificarQtd implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        int idcompra = Integer.valueOf(request.getParameter("idcompra"));
        int qtd = Integer.valueOf(request.getParameter("qtd"));
        Compra compra = cs.obterCompra(idcompra);
        String msg = "";
        String valid = "";
        if (cs.modificarQtd(idcompra, qtd)) {
            msg = "A quantidade alterada do cliente:";
        } else {
            valid = "Erro na tentativa de alterar a quantidade do cliente:";
        }
        request.setAttribute("msg", msg + compra.getPessoa().getNome());
        request.setAttribute("valid", valid + compra.getPessoa().getNome());
        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + compra.getPessoa().getLocal().getIdLocal();
    }

}
