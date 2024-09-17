package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.CarrinhoService;

/**
 *
 * @author Leandro
 */
public class UiSacolaRemove implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CarrinhoService cs = CarrinhoService.createCarrinho();
        try {
            String param = request.getParameter("param");
            LinkedHashSet<Milhar> minhaSacola = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
            if(!minhaSacola.isEmpty()){
                cs.excluirNumero(minhaSacola, param);
                request.setAttribute("msg", "O numero "+param+ " foi removido com sucesso!");
                request.setAttribute("carregado", minhaSacola.size());
            }
        } catch (Exception e) {
        }
        return "controller?operacao=UISacola";
    }

}
