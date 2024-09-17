package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Collection;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.LocalService;

public class RepositoryPessoa {

    private Connection connection;
    ContextConfigDataSource dataSource;

    public RepositoryPessoa() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    LocalService sl = new LocalService();

    public Pessoa get(Integer idpessoa) {
        try {
            String sql = "select * from pessoa p where p.idpessoa = " + idpessoa;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
                p.setDataRegistro(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataregistro")));

            }
            System.out.println("Log: " + ps.toString());
            return p;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return new Pessoa();
        }
    }

    public Collection<Pessoa> consultasPessoas(String name, String email, String contato) {
        try {
            String sql = "select * from pessoa p where p.nome like '%" + name + "%' " + "or p.email like '" + email
                    + "' or p.contato like '" + contato + "' ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Collection<Pessoa> pessoas;
            pessoas = new ArrayDeque();
            Pessoa p;
            while (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
                p.setDataRegistro(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataregistro")));
                pessoas.add(p);
            }
            System.out.println("Log: " + ps.toString());
            return pessoas;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarPeloEmailContato(String email, String contato) {
        try {
            String sql = "select * from pessoa p where p.email like ? or p.contato like ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contato);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));

            }
            System.out.println("Log: " + ps.toString());
            return p;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarPeloNome(String nome) {
        try {
            String sql = "select * from pessoa p where p.nome like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
            }
            System.out.println("Log: " + ps.toString());
            return p;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa referenciaCartela(String numero) {
        try {
            String sql = "select * from pessoa p where p.contato like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
            }
            System.out.println("Log: " + ps.toString());
            return p;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarNome(String nome) {
        try {
            String sql = "select * from pessoa p where p.nome like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + nome.trim() + "%");
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));

            }
            System.out.println("Log: " + ps.toString());
            return p;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public int maxIdPessoa() {
        try {
            String query = "select max(idpessoa) as idpessoa from pessoa";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int idpessoa = 0;
            idpessoa = rs.getInt("idpessoa");
            System.out.println("Log: " + ps.toString());
            return idpessoa;
        } catch (Exception e) {
            System.err.println("Log: " + e.getMessage());
            return 0;
        }
    }

    public Pessoa save(Pessoa p) {
        try {
            String sql = "INSERT INTO pessoa(idpessoa,nome,email,contato,referencia,idendereco,dataregistro) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            int chave = maxIdPessoa() + 1;
            ps.setInt(1, chave);
            ps.setString(2, p.getNome());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getContato());
            ps.setString(5, p.getReferencia());
            ps.setInt(6, p.getLocal().getIdLocal());
            ps.setDate(7, new Date(Calendar.getInstance().getTimeInMillis()));
            ps.execute();
            Pessoa pessoa = get(chave);
            System.out.println("Log: " + pessoa);
            return pessoa;
        } catch (SQLException e) {
            System.err.println("Log: " + e.getMessage());
            return null;
        }
    }

    public int update(Pessoa p) {
        try {
            String sql = "update pessoa set nome=?,email=?,contato=?,referencia=?,idendereco=? where idpessoa = "
                    + p.getIdPessoa();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getContato());
            ps.setString(4, p.getReferencia());
            ps.setInt(5, p.getLocal().getIdLocal());
            System.out.println("Log: " + ps.toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Log: " + e.getLocalizedMessage());
            return -1;
        }
    }

    public void delete(int idPessoa) {
        try {
            String sql = "delete from pessoa where pessoa.idpessoa = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

}
