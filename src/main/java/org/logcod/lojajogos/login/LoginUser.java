package org.logcod.lojajogos.login;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.service.AdminService;
import org.logcod.lojajogos.service.FuncionarioService;

@SuppressWarnings("serial")
public class LoginUser extends HttpServlet {

    AdminService sa = new AdminService();
    FuncionarioService fs = new FuncionarioService();
    String url = "index.jsp";
    HttpSession session = null;
    protected Funcionario funcionario;

    public String destruirSessionUsuario(String logado, HttpServletRequest session) {
        session.getSession().invalidate();
        return Objects.nonNull(logado) ? null : null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("restricao");
        String logado = (String) request.getSession().getAttribute("logado");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        logado = destruirSessionUsuario(logado, request);
        if (Objects.isNull(logado)) {
            switch (action) {
                case "permission":
                    if (fs.validarLogin(login, senha)) {
                        funcionario = fs.logarFuncionario(login.trim(), senha.trim());
                        funcionario.setHostacesso(request.getRemoteAddr());
                        url = URLUsuarioAutenticado(request, funcionario, session);
                    }
                    else
                    {
                        request.setAttribute("msg", "Login ou senha invalidos!");
                        url = "index.jsp";
                        RequestDispatcher d = request.getRequestDispatcher(url);
                        d.forward(request, response);
                    }
                    break;
            }
        }

        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", url);

    }

    public String URLUsuarioAutenticado(HttpServletRequest request, Funcionario funcionario, HttpSession session) {
        session = request.getSession(true);
        session.setAttribute("chave_acesso", funcionario.getIdFuncionario());
        session.setAttribute("trabalhador", funcionario);
        session.setAttribute("usuario", funcionario.getNome());
        session.setAttribute("logado", funcionario.getLogin());
        session.setAttribute("permissao", funcionario.getPermissao());
        session.setAttribute("dataAcesso", Calendar.getInstance().getTime());
        String url = "index.jsp";
        switch (funcionario.getPermissao()) {
            case 1:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 2:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 3:
                url = "controller?operacao=PainelAdministrativo";
                break;
            case 4:
                url = "controller?operacao=areaadmin";
                break;
            default:
                throw new IllegalArgumentException(url);
        }
        return url;
    }

}
