package org.logcod.lojajogos.controller.subcontroller;

import java.util.LinkedHashSet;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.CarrinhoService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;

public class UICarrinho implements Action {

    protected HttpSession sacola = null;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CarrinhoService cs = CarrinhoService.createCarrinho();
        MilharService ms = new MilharService();
        CompraService compraService = new CompraService();
        sacola = request.getSession(true);
        try {
            LinkedHashSet<Milhar> products = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
            Milhar numero = ms.getJogo(request.getParameter("mc"));
            if (Objects.nonNull(numero)) {
                products = cs.carrinhoUiAdd(products, numero);
                sacola.setAttribute("sacola", products);
                request.setAttribute("msg", "Número disponivel: "+numero.getValue());               
            } else 
            {                
                request.setAttribute("erro", "Verifique o milhar "+request.getParameter("mc")+" esta com "+compraService.carregarCompraCliente(request.getParameter("mc")).getPessoa().getNome());
            }
             request.setAttribute("carregado", products.size());
            return "controller?operacao=UISacola";
        } catch (Exception e) {
            return "controller?operacao=UISacola";
        }

    }

}
