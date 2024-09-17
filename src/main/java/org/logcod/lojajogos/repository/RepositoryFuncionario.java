package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Funcionario;

public class RepositoryFuncionario {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    protected ContextConfigDataSource dataSource;

    public RepositoryFuncionario() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public boolean validarLogin(String login, String senha) {
        try {
            String sql = "select * from funcionario f where f.login like ? and f.senha like ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        } 

    }

    public Funcionario getFuncionario(int id) {
        try {
            String query = "select * from funcionario f where f.idfuncionario = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idfuncionario"));
            f.setNome(rs.getString("nome"));
            f.setContato(rs.getString("contato"));
            f.setLogin(rs.getString("login"));
            f.setPermissao(rs.getInt("permissao"));
            f.setSenha(rs.getString("senha"));
            return f;
        } catch (SQLException e) {
            return null;
        }
    }

    public Collection<Funcionario> getFuncionarios(int limit) {
        try {
            String query = "select * from funcionario f limit ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setContato(rs.getString("contato"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setSenha(rs.getString("senha"));
                f.setEmail(rs.getString("email"));
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            return null;
        }
    }

    public Collection<Funcionario> consultarFuncionarios(String consulta) {
        try {
            String query = "select * from funcionario f where f.nome like '%" + consulta + "%'"
                    + " or f.email like '" + consulta + "'";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Collection<Funcionario> funcionarios = new ArrayDeque();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setContato(rs.getString("contato"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            return null;
        }
    }

    public int maxId() {
        try {
            String query = "select max(idfuncionario) as id from funcionario f";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            int id = 0;
            id = rs.getInt("id");
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public Funcionario save(Funcionario f) {
        try {
            String sql = "insert into funcionario (idfuncionario,nome,contato,login,senha,permissao,email) values (?,?,?,?,?,?,?) ";
            ps = connection.prepareStatement(sql);
            Integer key = maxId() + 1;
            ps.setInt(1, key);
            ps.setString(2, f.getNome());
            ps.setString(3, f.getContato());
            ps.setString(4, f.getLogin());
            ps.setString(5, f.getSenha());
            ps.setInt(6, f.getPermissao());
            ps.setString(7, f.getEmail());
            ps.executeUpdate();
            Funcionario funcionario = getFuncionario(key);
            return funcionario;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Funcionario update(Funcionario f) {
        try {
            String sql = "update funcionario set nome=?,contato=?,permissao=?,email=? where idfuncionario = ? ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getContato());
            ps.setInt(3, f.getPermissao());
            ps.setString(4, f.getEmail());
            ps.setInt(5, f.getIdFuncionario());
            ps.executeUpdate();
            return f;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Funcionario logar(String login, String senha) {
        try {
            String query = "select * from funcionario f where f.login like ? and f.senha like ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            Funcionario f = null;
            if (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setPermissao(rs.getInt("permissao"));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }

    }

    public Funcionario obter(String email) {
        try {
            String query = "select * from funcionario f where f.email like ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Funcionario f = null;
            if (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha"));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
