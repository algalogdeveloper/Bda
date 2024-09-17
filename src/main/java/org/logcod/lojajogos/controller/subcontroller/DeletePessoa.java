package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.PessoaService;

public class DeletePessoa implements Action {

    PessoaService ps = new PessoaService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String logado = (String) request.getSession().getAttribute("logado");
        if (Objects.nonNull(logado)) {
            try {

                Pessoa pessoa = ps.get(Integer.parseInt(request.getParameter("codpessoa")));
                ps.delete(pessoa.getIdPessoa());
                request.setAttribute("msg", "Exclusão realizada com sucesso");
            } catch (NumberFormatException e) {
                System.out.println("Log: " + e.getLocalizedMessage());
            }
            return "controller?operacao=PessoaController&pessoa=listar";
        } else {
            request.setAttribute("msg", "Login ou senha invalidos!");
            return "index.jsp";
        }

    }

}
