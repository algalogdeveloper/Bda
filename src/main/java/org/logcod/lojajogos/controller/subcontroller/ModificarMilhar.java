
package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Milhar;

public class ModificarMilhar implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Set<Milhar> lista = new LinkedHashSet<>();
        lista.add( new Milhar(request.getParameter("milhar01"),false));
        lista.add(new Milhar(request.getParameter("milhar02"), false));
        lista.add(new Milhar(request.getParameter("milhar03"), false));
        lista.add(new Milhar(request.getParameter("milhar04"), false));
        if(!request.getParameter("milhar05").equals(" ")){
        lista.add(new Milhar(request.getParameter("milhar05"), false));
        lista.add(new Milhar(request.getParameter("milhar06"), false));
        lista.add(new Milhar(request.getParameter("milhar07"), false));
        lista.add(new Milhar(request.getParameter("milhar08"), false));
        }
         lista.forEach(a->{
             System.out.println("Number:"+a.getValue());
         });
        return "controller?operacao=ViewListaAgrupada"; 
    }
    
}
