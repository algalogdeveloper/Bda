package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.GanhadorService;
import org.logcod.lojajogos.service.MilharService;

public class CarregarMilharPremiado implements Action {

    protected ConsultasService cs = new ConsultasService();
    protected ApostaService as = new ApostaService();
    protected MilharService ms = new MilharService();
    protected GanhadorService gs = new GanhadorService();
    protected static LinkedHashSet<Aposta> apostas = new LinkedHashSet<Aposta>();
    protected CentenaGratisService gratisService = new CentenaGratisService();

    public static LinkedHashSet<Aposta> getApostas() {
        return apostas;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String erro = "";
        LinkedHashSet<CentenaGratisinha> gratisinhas = null;
        LinkedHashSet<CentenaGratis> gratis = null;

        try {
            Aposta minhaAposta1 = as.apostaPorNumero(request.getParameter("milhar"));
            System.out.println("Minha aposta=" + minhaAposta1);
            if (Objects.nonNull(minhaAposta1)) {
                apostas.add(minhaAposta1);
            }
            if (apostas.size() >= 5) {
                gratis = carregarCentenaGratis(apostas);
                gratisinhas = carregarGratisinhas(apostas);
            }
            request.setAttribute("erro", erro);

        } catch (Exception e) {
            System.out.println("Erro=" + e.getLocalizedMessage());
        }
        request.setAttribute("apostas", apostas);
        request.setAttribute("gratis", gratis);
        request.setAttribute("gratisinha", gratisinhas);
        return "controller?operacao=ObterMilharPremiado";
    }

    public LinkedHashSet<CentenaGratis> carregarCentenaGratis(LinkedHashSet<Aposta> apostas) {
        LinkedHashSet<CentenaGratis> centenaGratis = new LinkedHashSet<CentenaGratis>();
        for (Aposta a : apostas) {
            centenaGratis.add(gratisService.obterCentena(a.getMilhar().getValue().trim().substring(1, 4)));
        }
        return centenaGratis;

    }

    public LinkedHashSet<CentenaGratisinha> carregarGratisinhas(LinkedHashSet<Aposta> apostas) {
        LinkedHashSet<CentenaGratisinha> centenaGratis = new LinkedHashSet<CentenaGratisinha>();
        for (Aposta a : apostas) {
            centenaGratis.add(gratisService.obterCentenaGratisinha(a.getMilhar().getValue().trim().substring(1, 4)));
        }
        return centenaGratis;

    }

}
