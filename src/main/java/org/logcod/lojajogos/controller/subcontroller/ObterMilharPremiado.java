package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.GanhadorService;
import org.logcod.lojajogos.service.MilharService;

public class ObterMilharPremiado implements Action {

    protected ConsultasService cs = new ConsultasService();
    protected ApostaService as = new ApostaService();
    protected MilharService ms = new MilharService();
    protected GanhadorService gs = new GanhadorService();
    protected static LinkedHashSet<Aposta> apostas = new LinkedHashSet<>();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String erro = null;
        try {
            String milhar = request.getParameter("milhar");
            Aposta minhaAposta = as.apostaPorNumero(milhar);
            if (minhaAposta != null) {
                apostas.add(minhaAposta);
            } else {
                erro = "Milhar não encontrado";
            }
            request.setAttribute("erro", erro);
            request.setAttribute("apostas", apostas);
            return "views/pagamento/verificar-ganhaodor.jsp";
        } catch (Exception e) {
            erro = "Milhar não encontrado";
            request.setAttribute("erro", erro);
            request.setAttribute("apostas", apostas);
            return "views/pagamento/verificar-ganhaodor.jsp";
        }

    }

}
