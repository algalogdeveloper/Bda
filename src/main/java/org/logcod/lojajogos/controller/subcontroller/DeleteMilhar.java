package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.MilharService;

public class DeleteMilhar implements Action {

    MilharService js = new MilharService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String value = js.getJogo(request.getParameter("idJogo")).getValue();
        @SuppressWarnings("unchecked")
        List<Milhar> products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
        products.remove(posicao(js.getJogo(value), products));
        return "controller?operacao=CarrinhoController&carrinho=loja";

    }

    public int posicao(Milhar milhar, List<Milhar> jogos) {
        int pos = -1;
        for (int i = 0; i < jogos.size(); i++) {
            Milhar jogo = jogos.get(i);
            // (71) 99902-6825 galega
            if (validarIgual(jogo.getValue(), milhar.getValue())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private static boolean validarIgual(String value, String value2) {
        return Objects.equals(value, value2);
    }
}
