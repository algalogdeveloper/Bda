package org.logcod.lojajogos.controller.subcontroller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.LocalService;

public class FormFiltroEnderecoParaGerarPdfCompra implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LocalService localService = new LocalService();
        Set<Local> locais = localService.consultarEnderecosComPessoas();
        System.out.println("Log:" + locais);
        request.setAttribute("enderecos", locais);
        return "views/compras/filtrar-compras-por-endereco-gerando-pdf.jsp";
    }
}
