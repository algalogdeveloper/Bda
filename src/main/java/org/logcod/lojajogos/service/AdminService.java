package org.logcod.lojajogos.service;

import java.util.List;

import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.model.entity.Admin;
import org.logcod.lojajogos.repository.RepositoryAdmin;

public class AdminService {

    static RepositoryAdmin ra = new RepositoryAdmin();

    public Admin logarAdmin(String login, String senha) {
        return ra.get(login, senha);
    }

    public boolean save(Admin admin) {
        return ra.save(admin);
    }

    public boolean validarLogin(String login, String senha) {
        return ra.validarLogin(login, senha);
    }

    public static void main(String[] args) {
        AdminService as = new AdminService();
        List<Admin> lista = as.listaAdministradores();
        for (Admin admin : lista) {
            Informacoes.SOP(admin);
        }
    }

    private List<Admin> listaAdministradores() {
        // TODO Auto-generated method stub
        return ra.listaAdministradores();
    }
}
