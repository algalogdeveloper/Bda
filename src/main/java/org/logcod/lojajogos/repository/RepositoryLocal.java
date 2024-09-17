package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.RotaService;

public class RepositoryLocal {

    private Connection connection;
    protected ContextConfigDataSource dataSource;
    protected RotaService rotaService;

    public RepositoryLocal() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
        rotaService = new RotaService(new RepositoryRota());
    }

    public Set<Local> consultarEnderecosComPessoas() {
        try {
            Set<Local> consultarPessa = new LinkedHashSet<Local>();
            String query = "select e.idendereco as id,e.descricao as dr,e.cidade as cd from endereco e, pessoa p, compra c where e.idendereco = p.idendereco and p.idpessoa = c.idpessoa";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Local l = new Local();
                l.setIdLocal(rs.getInt("id"));
                l.setDescricao(rs.getString("dr"));
                l.setCidade(rs.getString("cd"));
                consultarPessa.add(l);
            }
            return consultarPessa;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean save(Local local) {
        String sql = "insert into endereco (idendereco,descricao,cidade,codigo_rota) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, retornarChave() + 1);
            ps.setString(2, local.getDescricao());
            ps.setString(3, local.getCidade());
            ps.setObject(4, local.getRota().getIdRota());
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public int retornarChave() {
        try {
            String query = "select max(idendereco) as chave from endereco";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int chave = 0;
            chave = rs.getInt("chave");
            return chave;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public int delete(int idlocal) {
        String sql = "delete from endereco where idendereco = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idlocal);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }

    }

    public Collection<Local> getLocals() {

        Collection<Local> locals = new ArrayList<Local>();
        String sql = "SELECT * FROM endereco e order by e.descricao";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Local local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                local.setRota(rotaService.buscarRotasAS(rs.getInt("codigo_rota")));
                locals.add(local);
            }
            return locals;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return locals;
        }

    }

    public List<Local> listaVendasEmaberto() {
        String query = "select  DISTINCT(e.idendereco) as chave,e.descricao,e.cidade from public.endereco e \n"
                + "INNER JOIN public.pessoa p ON e.idendereco = p.idendereco \n"
                + "INNER Join public.compra c on p.idpessoa = c.idpessoa where not pagou ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            List<Local> locals = new ArrayList<>();
            Local local;
            while (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("chave"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                local.setRota(rotaService.buscarRotasAS(rs.getInt("codigo_rota")));

                locals.add(local);
            }
            return locals;
        } catch (Exception e) {
            return new ArrayList<Local>();
        }
    }

    public Collection<Local> consultaEndereco(String consulta) {
        String sql = "SELECT * FROM endereco e where e.descricao like ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + consulta + "%");
            ResultSet rs = pst.executeQuery();
            Collection<Local> locals = new ArrayDeque();
            Local local;
            while (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                local.setRota(rotaService.buscarRotasAS(rs.getInt("codigo_rota")));

                locals.add(local);
            }
            return locals;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    public Local getEndereco(int id) {
        String sql = "SELECT * FROM endereco e where e.idendereco = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Local local = null;
            if (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                local.setRota(rotaService.buscarRotasAS(rs.getInt("codigo_rota")));

            }
            return local;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return new Local();
        }

    }

    public int update(Local l) {
        String sql = "update endereco set descricao=?,cidade=?,codigo_rota=? where idendereco = " + l.getIdLocal();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, l.getDescricao());
            ps.setString(2, l.getCidade());
            ps.setObject(3, l.getRota().getIdRota());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

    public Local obterLocal(String descricao) {
        String sql = "SELECT * FROM endereco e where e.descricao = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, descricao);
            ResultSet rs = pst.executeQuery();
            Local local = null;
            if (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                local.setRota(rotaService.buscarRotasAS(rs.getInt("codigo_rota")));

            }
            return local;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return new Local();
        }
    }

}
