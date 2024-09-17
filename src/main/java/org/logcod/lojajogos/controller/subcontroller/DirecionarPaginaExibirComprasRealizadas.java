package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.ApostaService;

public class DirecionarPaginaExibirComprasRealizadas implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        ApostaService servive = new ApostaService();
        String destino = "controller?operacao=PainelAdministrativo";

        try {
            int permissao = Integer
                    .valueOf((Integer) request
                            .getSession()
                            .getAttribute("permissao"));
            if (permissao > 0) {
                request.setAttribute("compras", servive.listaCompletaSemFiltrosApostas());
                destino = "views/pessoa/apostas-pessoas.jsp";
            } else {
                request.setAttribute("msg", "Você não possui permissão " + (String) request
                        .getSession()
                        .getAttribute("usuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return destino;
    }

}
