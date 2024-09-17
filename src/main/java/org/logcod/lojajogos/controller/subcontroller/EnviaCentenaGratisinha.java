package org.logcod.lojajogos.controller.subcontroller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.CompraService;

public class EnviaCentenaGratisinha implements Action {

    CentenaGratisService cgs = new CentenaGratisService();
    CompraService cs = new CompraService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Compra pegar = cs.obterCompra(Integer.valueOf(request.getParameter("id_compra")));
            String centenas = request.getParameter("recebe_valor");
            String msg = "A centena já esta  entregue ao cliente.";
            int qtd = 0;
            String guardar[] = new String[30];
            if (centenas.length() > 0) {
                String todasCentenas[] = centenas.split(" ");
                if (Objects.nonNull(todasCentenas)) {
                    for (String data : todasCentenas) {
                        CentenaGratisinha centenaGratis = new CentenaGratisinha();
                        centenaGratis.setNumero(data);
                        centenaGratis.setCompra(pegar);
                        if (Objects.isNull(cgs.obterTwo(data))) {
                            cgs.enviaCentenaGratis(centenaGratis);
                        } else {
                            qtd++;
                            guardar[qtd] = data;
                        }
                    }
                }
                if (qtd > 0) {
                    msg = "Existe centenas não enviadas! " + guardar[qtd].toString();
                } else {
                    msg = "Centena gratisinha enviada com sucesso! Para " + pegar.getPessoa().getNome();
                }
            }

            request.setAttribute("msg", msg);
            return "controller?operacao=CentenasGratis";
        } catch (Exception e) {
            System.out.println(e);
            return "controller?operacao=CentenasGratis";
        }
    }

}
