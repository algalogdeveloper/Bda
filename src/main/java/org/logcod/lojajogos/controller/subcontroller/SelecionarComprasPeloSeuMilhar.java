package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;

public class SelecionarComprasPeloSeuMilhar implements Action {

    protected CompraService cs = new CompraService();
    protected ConsultasService consultasService = new ConsultasService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String page = request.getParameter("acao");
            System.out.println("Ação: " + page);
            switch (page) {
                case "Buscar":
                    String numero = request.getParameter("filtro");
                    request.setAttribute("numero", numero);
                    Compra compra = cs.carregarCompraCliente(numero);
                    if (Objects.isNull(compra)) {
                        request.setAttribute("valid", "Este milhar não esta vinculado a nenhun cliente");
                    }
                    request.setAttribute("compras", carregarListaMilharConsultado(compra));
                    break;
                case "Clear":
                    compras.clear();
                    break;
            }

        } catch (Exception e) {
        }

        return "views/compras/compraspormilhar.jsp";
    }

    protected static LinkedHashSet<Compra> compras = new LinkedHashSet();

    public LinkedHashSet<Compra> carregarListaMilharConsultado(Compra compra) {
        if (Objects.nonNull(compra)) {
            compras.add(compra);
        }
        return compras;
    }

}
