package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.LocalService;

public class CarregarPaginaReizinho implements Action {

    LocalService localService = new LocalService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("locais", localService.consultarEnderecosComPessoas());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "views/admin/pagina-reizinho-consulta-elemento.jsp";
    }

}
