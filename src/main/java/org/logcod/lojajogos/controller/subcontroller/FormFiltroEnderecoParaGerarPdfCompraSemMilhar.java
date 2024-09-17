package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.LocalService;

public class FormFiltroEnderecoParaGerarPdfCompraSemMilhar implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LocalService localService = new LocalService();
        request.setAttribute("locais", localService.consultarEnderecosComPessoas());
        return "views/compras/filtrar-compras-por-endereco-sem-milhar.jsp";
    }
}
