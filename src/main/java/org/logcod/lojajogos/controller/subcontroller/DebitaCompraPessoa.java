package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;

public class DebitaCompraPessoa implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String destino = "controller?operacao=PainelAdministrativo";
        Local local = (Local) request.getSession().getAttribute("local");
        try {
            request.setCharacterEncoding("UTF-8");
            // response.setCharacterEncoding("UTF-8");
            String msg = "O pagamento já foi realizado.";
            Integer id = DataSourceUtil.configDataIntegerValue(request.getParameter("acao"));
            if (!cs.verificarSeCompraEstaPaga(id)) {
                Compra meuPagamento = cs.pagarCompra(id, (Integer) request.getSession().getAttribute("chave_acesso"));
                msg = meuPagamento.isPagou() ? "O Pagamento foi enviado com sucesso!"
                        : "Desculpe pagamento não realizado!";
                if (meuPagamento.getValor() < (meuPagamento.getQtd_cartela() * meuPagamento.getValorBilhete())) {
                    cs.obterPrecoNormalizado(meuPagamento.getIdCompra(),
                            (meuPagamento.getQtd_cartela() * meuPagamento.getValorBilhete())
                            - meuPagamento.getDesconto());
                }
                request.setAttribute("meuPagamento", meuPagamento);
                request.setAttribute("msg", msg);
                destino = "controller?operacao=PagamentoController&buscar=" + local.getIdLocal();

            } else {
                destino = "controller?operacao=PagamentoController&buscar=" + local.getIdLocal();
            }
        } catch (Exception e) {
            destino = "controller?operacao=PagamentoController&buscar=" + local.getIdLocal();
        }

        return destino;

    }

}
