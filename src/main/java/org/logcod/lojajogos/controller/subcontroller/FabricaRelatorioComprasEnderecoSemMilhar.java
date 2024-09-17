package org.logcod.lojajogos.controller.subcontroller;

import org.logcod.lojajogos.relatorio.FabricaRelatorios;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class FabricaRelatorioComprasEnderecoSemMilhar implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String descricao = request.getParameter("descricao");
            if (Objects.isNull(descricao)) {
                descricao = "0";
            } else {
                FabricaRelatorios.carregarRelatorioDisplayViewSemMilhar(response, request, descricao);
            }
        } catch (Exception e) {
        }
        return "controller?operacao=PainelAdministrativo";
    }
}
