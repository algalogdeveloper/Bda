package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class FiltrarComprasPorFuncionario implements Action {

    PessoaService ps = new PessoaService();
    LocalService sl = new LocalService();
    CompraService compraService = new CompraService();
    FuncionarioService fs = new FuncionarioService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Funcionario funcionario = fs.getFuncionario(Integer.valueOf(request.getParameter("idfuncionario")));
            Local local = sl.get(Integer.valueOf(request.getParameter("idlocal")));
            request.setAttribute("endereco", local);
            request.setAttribute("compras", compraService.filtrarCompraPorFuncionario(funcionario, local, pegarSituacao(request)));
        } catch (Exception e) {

        }
        request.setAttribute("locais", sl.consultarEnderecosComPessoas());
        request.setAttribute("funcionarios", fs.getFuncionarios(20));
        return "views/funcionario/filtrar-compras-por-funcionario.jsp";
    }

    public String pegarSituacao(HttpServletRequest request) {
        String situacao = request.getParameter("situacao");
        System.out.println("Qual é a situação:" + situacao);
        return situacao;
    }

}
