package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class CadatrarPessoaComMilharAssociado implements Action {

    PessoaService ps = new PessoaService();
    LocalService ls = new LocalService();
    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String idCompra = request.getParameter("idcompra");
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("end");
            String ref = request.getParameter("ref");
            String pg = request.getParameter("pagou");
            Pessoa pessoa = ps.consultarPeloNome(nome);
            Local local = ls.get(Integer.valueOf(endereco));
            if (Objects.isNull(pessoa)) {
                pessoa = new Pessoa(nome, ref, local);
                pessoa = ps.save(pessoa);
            }
            cs.alterarPessoa(Integer.valueOf(idCompra), pessoa.getIdPessoa());
            request.setAttribute("msg", "Pessoa foi modificada!");

            if (Objects.equals(pg, "sim")) {
                cs.pagarCompra(Integer.valueOf(idCompra),
                        (Integer) request.getSession().getAttribute("chave_acesso"));
                request.setAttribute("msg", "Pessoa foi modificada e cartelas paga!");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return "controller?operacao=PagamentoController&buscar=" + (String) request.getSession().getAttribute("local");
    }

}
