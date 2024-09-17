package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Admin;

public class RepositoryAdmin {

    private Connection connection;
    ContextConfigDataSource dataSource;

    public RepositoryAdmin() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public boolean validarLogin(String login, String senha) {
        try {
            String sql = "select nome,login,senha from adm f where f.login = ? and f.senha = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return true;
    }

    public Admin get(String login, String senha) {
        try {
            String sql = "select * from adm f where f.login = ? and f.senha = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            Admin admin = null;
            if (rs.next()) {
                admin = new Admin();
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                admin.setSenha(rs.getString("senha"));
            }
            return admin;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public boolean save(Admin admin) {
        try {
            String sql = "insert into adm (nome,login,senha) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getLogin());
            ps.setString(3, admin.getSenha());
            return ps.execute();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }

    }

    public List<Admin> listaAdministradores() {
        try {
            String sql = "select * from adm f";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Admin admin = null;
            List<Admin> admins = new ArrayList<Admin>();
            while (rs.next()) {
                admin = new Admin();
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                admin.setSenha(rs.getString("senha"));
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
