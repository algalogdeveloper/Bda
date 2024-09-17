package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.service.FuncionarioService;

public class EnviaFuncionario implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        FuncionarioService fs = new FuncionarioService();
        Funcionario f = new Funcionario();
        f.setIdFuncionario(Integer.valueOf(request.getParameter("idf")));
        f.setNome(request.getParameter("nome"));
        f.setEmail(request.getParameter("email"));
        f.setLogin(request.getParameter("login"));
        f.setSenha(request.getParameter("senha"));
        f.setPermissao(Integer.valueOf(request.getParameter("permissao")));
        f.setContato(request.getParameter("contato"));
        request.setAttribute("msg", fs.createFuncionario(f));
        return "controller?operacao=CatalogoFuncionario";
    }

}
