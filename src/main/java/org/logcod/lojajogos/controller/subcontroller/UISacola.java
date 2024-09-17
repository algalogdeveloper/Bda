package org.logcod.lojajogos.controller.subcontroller;

import java.util.Collection;
import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.LocalService;

public class UISacola implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            LinkedHashSet<Milhar> minhaSacola = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
            if (!minhaSacola.isEmpty()) {
                request.setAttribute("sacola", minhaSacola);
                request.setAttribute("carregado", minhaSacola.size());
            }

        } catch (Exception e) {
        }
        LocalService ls = new LocalService();
        Collection<Local> locals = ls.getLocals();
        request.setAttribute("enderecos", locals);
        return "views/carrinho/suaSacola.jsp";
    }

}
