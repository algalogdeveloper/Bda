package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class CadastrarPessoa implements Action {

    PessoaService ps = new PessoaService();
    LocalService sl = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String logado = (String) request.getSession().getAttribute("logado");
        if (Objects.nonNull(logado)) {
            try {
                String idpessoa = request.getParameter("idPessoa");
                Pessoa pessoa = new Pessoa(Integer.parseInt(idpessoa), request.getParameter("nome"),
                        request.getParameter("email"), request.getParameter("contato"),
                        request.getParameter("referencia"), sl.get(Integer.valueOf(request.getParameter("idLocal"))));
                String msg = "";
                if (pessoa.getIdPessoa() == 0) {
                    ps.save(pessoa);
                    msg = "Cadatrado com sucesso " + pessoa.getNome();
                } else {
                    ps.update(pessoa);
                    msg = "Atualizada com sucesso " + pessoa.getNome();
                }
                return "controller?operacao=PessoaController&pessoa=listar";
            } catch (Exception e) {
                System.err.println("Log:" + e.getMessage());
                return "controller?operacao=PessoaController&pessoa=listar";
            }
        } else {
            request.setAttribute("msg", "Login ou senha invalidos!");
            return "index.jsp";
        }
    }

}
