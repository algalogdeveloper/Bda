package org.logcod.lojajogos.controller.subcontroller;

import java.util.Collection;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.repository.RepositoryRota;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.RotaService;

public class LocalController implements Action {

    LocalService sl = new LocalService();

    protected String consulta = "";

    public String consultarEnderecos(HttpServletRequest request) {
        // consulta = request.getParameter("consulta");
        Collection<Local> locais = sl.consultaEndereco("");
        System.out.println(locais);
        request.setAttribute("enderecos", locais);
        return "views/endereco/consultar.jsp";
    }

    private int idlocal;
    String url = "index";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String menu = request.getParameter("locais");
        System.out.println("refences: " + menu);
        String logado = (String) request.getSession().getAttribute("logado");
        if (Objects.nonNull(logado) && Objects.nonNull(menu)) {
            switch (menu) {

                case "save": {
                    Integer chaveidLocal = Integer.valueOf(request.getParameter("chaveidLocal"));
                    url = saveUpdate(chaveidLocal, request);
                    break;
                }
                case "excluir": {
                    System.out.println("Partindo deste ponto");
                    url = delete(request);
                    break;
                }
                case "listar": {
                    this.url = consultarEnderecos(request);
                    break;
                }

            }
        } else {
            url = "LoginUser?restricao=logar";
        }
        return url;

    }

    public String delete(HttpServletRequest request) {
        int delete = sl.delete(Integer.valueOf(request.getParameter("codlocal")));
        String message = "Dados não podem ser exluido existe referencia para esta informação";
        if (delete > -1) {
            message = "Endereco excluido com sucesso.";
        }
        request.setAttribute("message", message);
        return "controller?operacao=LocalController&locais=listar";
    }

    public String saveUpdate(Integer idlocal, HttpServletRequest request) {
        try {
            RotaService rs = new RotaService(new RepositoryRota());
            if (idlocal == 0) {
                Local local = new Local(request.getParameter("descricao"), request.getParameter("cidade"));
                local.setRota(rs.buscarRotasAS(Integer.parseInt(request.getParameter("rota"))));
                sl.save(local);
                request.setAttribute("message", "Dados salvo com sucesso do(a) " + local.getDescricao());
            } else {

                Local local = new Local(idlocal, request.getParameter("descricao"), request.getParameter("cidade"));
                local.setRota(rs.buscarRotasAS(Integer.parseInt(request.getParameter("rota"))));

                sl.update(local);
                request.setAttribute("message", "Dados modificado com sucesso do(a) " + local.getDescricao());
            }

        } catch (Exception e) {
        }
        return "controller?operacao=LocalController&locais=listar";
    }

}
