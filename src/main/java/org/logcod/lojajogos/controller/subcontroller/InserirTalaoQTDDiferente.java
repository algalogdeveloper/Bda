package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;

public class InserirTalaoQTDDiferente implements Action {

    CompraService cs = new CompraService();
    MilharService ms = new MilharService();
    List<Milhar> milhars = new ArrayList<>();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] values = request.getParameter("lista").split(" +");
        String id = request.getParameter("id_compra");
        Compra compra = cs.get(Integer.parseInt(id));
        Compra milharVendido = null;
        try {
            int count = 0;
            int valid = 0;
            for (String data : values) {
                Milhar milhar = ms.getJogo(data);
                if (Objects.nonNull(milhar)) {
                    milhars.add(milhar);
                    count++;
                } else {
                    milharVendido = cs.carregarCompraCliente(data);
                    valid++;
                }
            }

            if (milhars.size() == count && valid == 0 && milhars.size() >= compra.getQtdAlternativa()) {
                compra.setQtd_cartela((milhars.size() / compra.getQtdAlternativa()) + compra.getQtd_cartela());
                compra.setValor((compra.getQtd_cartela() * compra.getValorBilhete()) - compra.getDesconto());
                cs.inserirMilharParaPessoa(compra.getIdCompra(), compra.getPessoa().getIdPessoa(), milhars);
                cs.updateCompraQtdValor(compra);
                request.setAttribute("msg", "Os números foram enviados: ");
            } else {
                request.setAttribute("valid", milharVendido != null ? "Existe numero(s) na sequencia de " + milharVendido.getPessoa().getNome() + " nº " + milharVendido.getApostas().toString() + " repitido com de " + compra.getPessoa().getNome()+ " milhar(s) "+request.getParameter("lista") : "");
            }
            valid = 0;
        } catch (Exception e) {
            request.setAttribute("valid", "Existe milhar indisponível!");
        }
        auto=0;
        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + compra.getPessoa().getLocal().getIdLocal();
    }
    
    private static int auto=0;
    private int auto(){
        return auto++;
    }

}
