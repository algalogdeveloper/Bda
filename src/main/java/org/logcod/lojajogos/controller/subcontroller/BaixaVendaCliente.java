package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

public class BaixaVendaCliente implements Action {

    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String destino = "controller?operacao=DirecionarPaginaExibirComprasRealizadas";
        try {
            String msg = "O pagamento já foi realizado.";
            Integer id = DataSourceUtil.configDataIntegerValue(request.getParameter("acao"));
            if (!cs.verificarSeCompraEstaPaga(id)) {

                Compra meuPagamento = cs.pagarCompra(id, (Integer) request.getSession().getAttribute("chave_acesso"));
                msg = meuPagamento.isPagou() ? "O Pagamento foi enviado com sucesso!"
                        : "Desculpe pagamento não realizado!";
                if (meuPagamento.getValor() < (meuPagamento.getQtd_cartela() * meuPagamento.getValorBilhete())) {
                    cs
                            .obterPrecoNormalizado(meuPagamento
                                    .getIdCompra(), (meuPagamento
                                            .getQtd_cartela()
                                    * meuPagamento
                                            .getValorBilhete())
                                    - meuPagamento.getDesconto());
                }
                request.setAttribute("meuPagamento", meuPagamento);
                request.setAttribute("msg", msg);
                destino = "controller?operacao=DirecionarPaginaExibirComprasRealizadas";
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return destino;
    }

}
