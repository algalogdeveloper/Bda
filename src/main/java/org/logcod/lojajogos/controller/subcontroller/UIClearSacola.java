package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Milhar;

public class UIClearSacola implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LinkedHashSet<Milhar> products = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
        if (!products.isEmpty()) {           
            products.clear();
             request.setAttribute("erro", "Sacola vazia!");
            request.setAttribute("carregado", products.size());
        }
      
        return "controller?operacao=UISacola";
    }

}
