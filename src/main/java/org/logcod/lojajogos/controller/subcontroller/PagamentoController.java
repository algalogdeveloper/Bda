package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;

public class PagamentoController implements Action {

    ConsultasController pc = new ConsultasController();
    CompraService cs = new CompraService();
    LocalService lc = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int permissao = Integer.valueOf((Integer) request.getSession().getAttribute("permissao"));
        String destino = "controller?operacao=PainelAdministrativo";
        Local localSession = null;

        try {
            String buscar = request.getParameter("buscar");
            if (permissao > 0) {

                int id = 1;

                if (Objects.isNull(buscar)) {
                    buscar = "0";
                }
                id = Integer.valueOf(buscar);

                localSession = lc.get(id) == null ? new Local(0, "Selecione", "ok") : lc.get(id);
                request.getSession().setAttribute("local", localSession);
                request.setAttribute("locais", lc.consultarEnderecosComPessoas());
                request.setAttribute("compras",
                        cs.selecionarComprasPeloSeuEnderecoDeCadastro(String.valueOf(localSession.getIdLocal())));
                request.setAttribute("valorCurrent", cs.calcularValorPagamentoCurrenteDate());
                destino = "views/pagamento/pagamentos.jsp";
            } else {
                request.setAttribute("msg",
                        "Você não possui permissão " + (String) request.getSession().getAttribute("usuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return destino;
    }

}
