package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Ganhador;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.GanhadorService;
import org.logcod.lojajogos.service.MilharService;

public class VerificarGanhador implements Action {

    ConsultasService cs = new ConsultasService();
    ApostaService as = new ApostaService();
    MilharService ms = new MilharService();

    protected Aposta criarAposta(String value) {
        Aposta a = as.apostaPorNumero(value);
        System.out.println(a.getMilhar().getValue());
        try {
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    GanhadorService gs = new GanhadorService();

    protected Aposta apostaVazia(int index) {
        try {
            Local l = new Local("Não existe", "Sem nome");
            System.out.println(l);
            Pessoa p = new Pessoa();
            p.setNome("Pessoa não pagou");
            p.setContato("vazio");
            p.setLocal(l);
            System.out.println(p);
            Compra compra = new Compra();
            compra.setPessoa(p);
            compra.setPagou(false);
            compra.setCancelar(false);
            compra.setPremio("Não ganhou");
            Aposta a = new Aposta();
            a.setIdAposta(index);
            a.setCompra(compra);
            a.setMilhar(new Milhar("Milhar não vendido", false));
            return a;
        } catch (Exception e) {
            return null;
        }

    }

    Aposta p1 = null;
    Aposta p2 = null;
    Aposta p3 = null, p4 = null, p5 = null, p6 = null, p7 = null, p8 = null, p9 = null, p10 = null;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            p1 = criarAposta(request.getParameter("p1").trim());
            p1.setIdAposta(1);
        } catch (Exception e) {
            if (Objects.isNull(p1)) {
                p1 = apostaVazia(1);
            }
        }
        try {
            p2 = criarAposta(request.getParameter("p2").trim());
            p2.setIdAposta(2);
        } catch (Exception e) {
            if (Objects.isNull(p2)) {
                p2 = apostaVazia(2);
            }
        }
        try {
            p3 = criarAposta(request.getParameter("p3").trim());
            p3.setIdAposta(3);
        } catch (Exception e) {
            if (Objects.isNull(p3)) {
                p3 = apostaVazia(3);
            }
        }
        try {
            p4 = criarAposta(request.getParameter("p4").trim());
            p4.setIdAposta(4);
        } catch (Exception e) {
            if (Objects.isNull(p4)) {
                p4 = apostaVazia(4);
            }

        }

        try {
            p5 = criarAposta(request.getParameter("p5").trim());
            p5.setIdAposta(5);
        } catch (Exception e) {
            if (Objects.isNull(p5)) {
                p5 = apostaVazia(5);
            }
        }
        List<Aposta> compras = new ArrayList<Aposta>();
        compras.add(p1);
        compras.add(p2);
        compras.add(p3);
        compras.add(p4);
        compras.add(p5);

        // atualizar lista de ganhadores
        gs.limparListaGanhadores();
        List<Ganhador> ganhadors = atualizarListadeGanhadores(request, compras);
        String btTableView = request.getParameter("btTableView");
        if (Objects.equals(btTableView, "tableview")) {
            request.setAttribute("compras", ganhadors);

        }
        return "views/pagamento/verificarganhaodor.jsp";
    }

    public List<Ganhador> atualizarListadeGanhadores(HttpServletRequest request, List<Aposta> compras) {

        for (Aposta aposta : compras) {
            Ganhador ganhador = new Ganhador();
            ganhador.setPosicao(aposta.getIdAposta());
            ganhador.setPessoa(aposta.getCompra().getPessoa().getNome());
            ganhador.setMilhar(aposta.getMilhar().getValue());
            ganhador.setEndereco(aposta.getCompra().getPessoa().getLocal().getDescricao());
            ganhador.setPagou((aposta.getCompra().isPagou()) ? "Sim" : "Não");
            gs.save(ganhador);
        }

        List<Ganhador> lista = gs.listadeGanhadoresTemporario();

        for (Ganhador ganhador : lista) {

            if (ganhador.getPosicao() == 1) {
                ganhador.setMilhar(request.getParameter("p1"));
            } else if (ganhador.getPosicao() == 2) {
                ganhador.setMilhar(request.getParameter("p2"));
            } else if (ganhador.getPosicao() == 3) {
                ganhador.setMilhar(request.getParameter("p3"));
            } else if (ganhador.getPosicao() == 4) {
                ganhador.setMilhar(request.getParameter("p4"));
            } else if (ganhador.getPosicao() == 5) {
                ganhador.setMilhar(request.getParameter("p5"));
            } else if (ganhador.getPosicao() == 6) {
                ganhador.setMilhar(request.getParameter("p6"));
            } else if (ganhador.getPosicao() == 7) {
                ganhador.setMilhar(request.getParameter("p7"));
            } else if (ganhador.getPosicao() == 8) {
                ganhador.setMilhar(request.getParameter("p8"));
            } else if (ganhador.getPosicao() == 9) {
                ganhador.setMilhar(request.getParameter("p9"));
            } else if (ganhador.getPosicao() == 10) {
                ganhador.setMilhar(request.getParameter("p10"));
            }

        }

        for (Ganhador ganhador : lista) {
            gs.update(ganhador);
        }
        return gs.listadeGanhadoresTemporario();

    }

    CentenaGratisService gratisService = new CentenaGratisService();

    public List<CentenaGratis> catalogarCentenasGratis(HttpServletRequest request) {
        List<CentenaGratis> centenaGratis = new ArrayList<CentenaGratis>();
        centenaGratis.add(gratisService.obterCentena(request.getParameter("p1").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentena(request.getParameter("p2").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentena(request.getParameter("p3").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentena(request.getParameter("p4").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentena(request.getParameter("p5").substring(1, 4)));
        return centenaGratis;
    }

    public List<CentenaGratisinha> catalogarCentenasGratisinha(HttpServletRequest request) {
        List<CentenaGratisinha> centenaGratis = new ArrayList<CentenaGratisinha>();
        centenaGratis.add(gratisService.obterCentenaGratisinha(request.getParameter("p1").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentenaGratisinha(request.getParameter("p2").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentenaGratisinha(request.getParameter("p3").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentenaGratisinha(request.getParameter("p4").substring(1, 4)));
        centenaGratis.add(gratisService.obterCentenaGratisinha(request.getParameter("p5").substring(1, 4)));
        return centenaGratis;
    }

}
