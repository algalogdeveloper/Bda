package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.FuncionarioService;

public class CatalogoFuncionario implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String destino = "controller?operacao=PainelAdministrativo";
        int permissao = (Integer) request.getSession().getAttribute("permissao");
        FuncionarioService fs = new FuncionarioService();
        request.setAttribute("funcionarios", fs.getFuncionarios(30));
        if (permissao > 0) {
            destino = "views/funcionario/catalogo-funcionario.jsp";
        } else {
            request.setAttribute("msg", "Suas credenciais não lhe permite acessar esta pagina.");
        }
        return destino;
    }

}
