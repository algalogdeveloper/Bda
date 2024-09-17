package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.service.CentenaGratisService;

public class ModificarCentenaGratisTwo implements Action {

    public ModificarCentenaGratisTwo() {
        // TODO Auto-generated constructor stub
    }

    CentenaGratisService service = new CentenaGratisService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CentenaGratisinha centenasGratis = service
                    .getCentenaGratisinha(Integer
                            .valueOf(request.getParameter("id_centena")));
            centenasGratis.setNumero(request.getParameter("centena"));
            if (Objects.isNull(service.obterTwo(centenasGratis.getNumero()))) {
                service.modificarCentena(centenasGratis);
                request.setAttribute("msg", "Centena modificado com sucesso!");
            } else {
                request.setAttribute("msg", "Não modificado a centena!");
            }

            return "controller?operacao=PaginasTodasCentenas2";
        } catch (Exception e) {
            return "controller?operacao=PaginasTodasCentenas2";
        }

    }

}
