package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.service.CentenaGratisService;

public class ModificarCentenaGratis implements Action {

    public ModificarCentenaGratis() {
        // TODO Auto-generated constructor stub
    }

    CentenaGratisService service = new CentenaGratisService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            CentenaGratis centenasGratis = service
                    .getCentenaGratis(Integer
                            .valueOf(request.getParameter("id_centena")));
            centenasGratis.setNumero(request.getParameter("centena"));
            if (Objects.isNull(service.obter(centenasGratis.getNumero()))) {
                service.modificarCentena(centenasGratis);
                request.setAttribute("msg", "Centena modificado com sucesso!");
            } else {
                request.setAttribute("msg", "A centena não foi modificada!");
            }

            return "controller?operacao=PaginasTodasCentenas";
        } catch (Exception e) {
            return "controller?operacao=PaginasTodasCentenas";
        }

    }

}
