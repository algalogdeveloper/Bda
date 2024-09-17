package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class ListarPessoas implements Action {

    PessoaService ps = new PessoaService();
    LocalService sl = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("pessoas", ps.consultaPessoas("", "", ""));
            request.setAttribute("enderecos", sl.getLocals());
            return "views/pessoa/consultar.jsp";
        } catch (Exception e) {
            System.out.println("Log:" + e.getLocalizedMessage());
        }
        return "views/pessoa/consultar.jsp";
    }
}
