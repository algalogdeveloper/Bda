package org.logcod.lojajogos.controller.subcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.service.CentenaGratisService;

public class DeleteCentenaTwo implements Action {

    public DeleteCentenaTwo() {
        // TODO Auto-generated constructor stub
    }
    CentenaGratisService service = new CentenaGratisService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            if (service.deleteCentenaTwo(Integer.valueOf(request.getParameter("id")))) {
                request.setAttribute("msg", "Centena excluida com sucesso!");
            } else {
                request.setAttribute("msg", "Não excluida a centena!");
            }

            return "controller?operacao=PaginasTodasCentenas2";
        } catch (Exception e) {
            return "controller?operacao=PaginasTodasCentenas2";
        }
    }

}
