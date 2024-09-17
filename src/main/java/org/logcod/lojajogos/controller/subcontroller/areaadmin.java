package org.logcod.lojajogos.controller.subcontroller;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.AreaAdministradorService;
import org.logcod.lojajogos.service.CompraService;

public class areaadmin implements Action {

    AreaAdministradorService as;
    CompraService cs = new CompraService();

    public areaadmin() {
        as = new AreaAdministradorService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            List<Compra> compras = as.solicitarListaDeComprasSemCliente();
            List<Compra> compras2 = as.solicitarListaDeApostasSemCompras();
            List<Compra> compras3 = as.catalogoComprasCorrigindoToloes();

            request.setAttribute("qtd", compras.size());
            request.setAttribute("compras", compras);
            request.setAttribute("qtd2", compras2.size());
            request.setAttribute("compras2", compras2);
            request.setAttribute("compras3", compras3);
            pagination1(request);
            Collection<Compra> compras4 = cs.catalogodeComprasComsuasApostasEmaberto(100, 0);
            request.setAttribute("qtdTalaocorrigido", compras3.size());
            request.setAttribute("compras4", compras4);
            request.setAttribute("compras5", as.carregarListaDeTaloesQtdAcima());
            request.setAttribute("qtdMilharNasCompras", compras4.size());
            request.setAttribute("acima_qtd", as.carregarListaDeTaloesQtdAcima().size());
            return "admin/painel-admin-acoes.jsp";
        } catch (Exception e) {
            return "admin/painel-admin-acoes.jsp";
        }

    }

    public void pagination1(HttpServletRequest request) {
        String page = request.getParameter("data");
        if (Objects.isNull(page)) {
            page = "1";
        }
        int pagina = Integer.valueOf(page);
        int qtdData = as.quantidadeRegistrosSalvos();
        int limite = as.obterLimite(240);
        int offset = (pagina * limite) - limite;
        int qtdPage = qtdData / limite;
        if (qtdData % limite != 0) {
            qtdPage++;
        }

        int proxima = 1;
        int anterior = 1;

        if (pagina > 1) {
            anterior = pagina - 1;
        }
        if ((qtdData - pagina * limite) > 0) {
            proxima = pagina + 1;
        }

        request.setAttribute("qtddata", qtdData);
        request.setAttribute("qtdpage", qtdPage);
        request.setAttribute("page", pagina);
        request.setAttribute("anterior", anterior);
        request.setAttribute("proxima", proxima);
        List<Aposta> apostas = as.catalogoDeapostasSemMilhar(offset, limite);
        request.setAttribute("apostas", apostas);
        request.setAttribute("limite", limite);

    }

}
