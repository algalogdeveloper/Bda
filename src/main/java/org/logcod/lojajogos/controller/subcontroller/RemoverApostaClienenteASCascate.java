package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.MilharService;

public class RemoverApostaClienenteASCascate implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApostaService as = new ApostaService();
        MilharService ms = new MilharService();
        int idcompra = convertEmNumero(request.getParameter("idcompra"));
        int idaposta = convertEmNumero(request.getParameter("idaposta"));
        int idpessoa = convertEmNumero(request.getParameter("idpessoa"));
        System.out.println("Log: Id compra:" + idcompra);
        System.out.println("Log: Id aposta:" + idaposta);
        System.out.println("Log: Id pessoa:" + idpessoa);
        try {
            Aposta a = as.get(idaposta);
            System.out.println("Log:" + a);
            ms.getDisponivel(a.getMilhar());
            as.removerMilharAhMais(a.getIdAposta());
            request.setAttribute("message", "O milhar a mais que foi no talão do cliente foi removido: " + a.getMilhar().getValue());
        } catch (Exception e) {

        }

        return "controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=" + idcompra + "&idpessoa=" + idpessoa
                + "";
    }

    public Integer convertEmNumero(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (Exception e) {
            return 0;
        }
    }
}
