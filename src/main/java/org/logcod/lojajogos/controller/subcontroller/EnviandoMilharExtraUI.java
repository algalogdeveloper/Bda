package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.repository.MilharExtraRepository;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharExtraService;

public class EnviandoMilharExtraUI implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        MilharExtraService mes = new MilharExtraService(new MilharExtraRepository());
        try {
            Integer id = Integer.valueOf(request.getParameter("idcompra"));
            String numero_extras = request.getParameter("numeros_extras");
            String[] extras = numero_extras.split(" ");
            mes.enviandoNumerosExtra(id, extras);
            request.setAttribute("msg", "Milhar foi vinculado ao cliente: " + cs.obterCompra(id)
                    .getPessoa().getNome());
        } catch (Exception e) {
            request.setAttribute("erro", "O milhar não esta disponivel para o cliente!  ");
        }
        return "controller?operacao=NumeroExtraUI";
    }

}
