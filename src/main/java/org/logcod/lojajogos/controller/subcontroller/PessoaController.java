package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class PessoaController implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String url = "controller?operacao=PessoaController&pessoa=listar";
            String logado = (String) request.getSession().getAttribute("logado");
            if (Objects.nonNull(logado)) {
                String menu = request.getParameter("pessoa");
                switch (menu) {
                    case "listar":
                        url = selecionarPessoas(request);
                        break;

                    case "save":
                        url = savePessoa(request);
                        break;

                    case "remove":
                        url = deletePessoa(request);
                        break;

                }
            } else {
                url = "LoginUser?restricao=logar";
            }
            System.out.println("log: " + url);
            return url;

        } catch (Exception e) {
            System.out.println("log:" + e.getLocalizedMessage());

            return "index.jsp";
        }

    }

    public String deletePessoa(HttpServletRequest request) {
        try {

            Pessoa pessoa = ps.get(Integer.parseInt(request.getParameter("codpessoa")));
            ps.delete(pessoa.getIdPessoa());
            request.setAttribute("msg", "Exclusão realizada com sucesso");
        } catch (NumberFormatException e) {
            System.out.println("Log: " + e.getLocalizedMessage());
        }

        return "controller?operacao=PessoaController&pessoa=listar";

    }

    public String savePessoa(HttpServletRequest request) {
        try {
            String idpessoa = request.getParameter("idPessoa");
            Pessoa pessoa = new Pessoa(Integer.parseInt(idpessoa), request.getParameter("nome"),
                    request.getParameter("email"), request.getParameter("contato"), request.getParameter("referencia"),
                    sl.get(Integer.valueOf(request.getParameter("idLocal"))));
            String msg = null;
            String erro = null;
            if (pessoa.getIdPessoa() == 0) {
                if (ps.save(pessoa) != null) {
                    msg = "Cadatrado com sucesso " + pessoa.getNome();

                }
                erro = "O cliente já pode está cadastrado!";
            } else {
                ps.update(pessoa);
                msg = "Atualizada com sucesso " + pessoa.getNome();
            }
            request.setAttribute("msg", msg);
            request.setAttribute("erro", erro);
            return "controller?operacao=PessoaController&pessoa=listar";
            // request.setAttribute("msg", msg);
        } catch (Exception e) {
            System.err.println("Log:" + e.getCause());
            return "controller?operacao=PessoaController&pessoa=listar";
        }

    }

    PessoaService ps = new PessoaService();
    LocalService sl = new LocalService();

    public String selecionarPessoas(HttpServletRequest request) {
        request.setAttribute("pessoas", ps.consultaPessoas("", "", ""));
        request.setAttribute("enderecos", sl.getLocals());
        return "views/pessoa/consultar.jsp";
    }

}
