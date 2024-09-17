package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.queries.Query;

public class RepositoryMilhar {

    private final Connection connection;
    ContextConfigDataSource dataSource;

    public RepositoryMilhar() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public void salvarJogo(Milhar jogo) {
        String sql = "insert into jogo (idjogo,numero,disponivel) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maxId() + 1);
            ps.setString(2, jogo.getValue());
            ps.setBoolean(3, jogo.isDisponivel());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public int maxId() {
        try {
            String query = "select max(idjogo) as id from jogo j";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = 0;
            id = rs.getInt("id");
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public Milhar getJogo(String value) {

        String sql = "SELECT * FROM jogo jg WHERE jg.numero LIKE ? and jg.disponivel";
        Milhar jogo = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
            }
            return jogo;
        } catch (SQLException e) {
            return jogo;
        }

    }

    public Milhar getJogo(Integer value) {

        String sql = "SELECT * FROM jogo jg " + "WHERE jg.idjogo =  ? ";
        Milhar jogo = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));

            }
            return jogo;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogo;
        }

    }

    public List<Milhar> getJogos(String value) {
        List<Milhar> jogos = new ArrayList<Milhar>();
        String sql = "";
        if (Objects.isNull(value) || Objects.equals(value, "")) {
            sql = "SELECT idjogo,numero,disponivel FROM jogo limit 15 ";

        } else {
            sql = "SELECT * FROM jogo jg where jg.numero like '%" + value + "' limit 10 ";
        }

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Milhar jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
                jogos.add(jogo);
            }
            return jogos;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogos;
        }

    }

    public Collection<Milhar> selecioneMilharVendidos(String buscar) {
        Collection<Milhar> jogos = new ArrayList<Milhar>();
        String sql = "SELECT * FROM jogo where numero like ? and  not disponivel order by numero  limit 100";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Milhar jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
                jogos.add(jogo);
            }
            return jogos;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogos;
        }

    }

    public int getNaoDisponivel(Milhar jogo) {

        String sql = "update jogo set disponivel = false where jogo.numero = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, jogo.getValue());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }

    }

    public Milhar obterMilhar(String numero) {
        try {
            PreparedStatement pst = connection.prepareStatement(Query.createQueryMilharVinculadoAhPessoa());
            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            Milhar milhar = null;
            while (rs.next()) {
                milhar = new Milhar();
                milhar.setIdMilhar(rs.getInt("idjogo"));
                milhar.setValue(rs.getString("numero"));
                milhar.setDisponivel(rs.getBoolean("disponivel"));
            }
            return milhar;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int getNaoDisponivel(int jogo) {

        String sql = "update jogo set disponivel = false where jogo.idjogo = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, jogo);
            System.out.println(pst.toString());
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }

    }

    public static List<String> gerarMilhar() {

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {

            if (i <= 9) {
                // System.out.println("000"+String.valueOf(i));
                list.add("000" + String.valueOf(i));
            }
            if (i > 9 && i <= 99) {
                // System.out.println( "00"+String.valueOf(i));
                list.add("00" + String.valueOf(i));
            }

            if (i > 99 && i <= 999) {
                // System.out.println( "0"+String.valueOf(i));
                list.add("0" + String.valueOf(i));
            }
            if (i > 999) {
                // System.out.println(String.valueOf(i));
                list.add(String.valueOf(i));
            }

        }

        return list;

    }

    public int getDisponivel(String milhar) {
        String sql = "update jogo set disponivel = true where jogo.numero = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, milhar);
            System.out.println(pst.toString());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

    public int getDisponivel(Milhar milhar) {
        String sql = "update jogo set disponivel = true where jogo.numero = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, milhar.getValue());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

    public int todosDisponiveis() {
        String sql = "update jogo set disponivel = true where jogo.idjogo > 0 ";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

    public boolean existe(String milhar) {
        try {
            String query = "select * from jogo j where j.numero = ? and j.disponivel";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, milhar);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            boolean validar = false;
            while (rs.next()) {
                validar = true;
                break;
            }
            return validar;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean validarMilhar(String numero) {
        try {
            PreparedStatement pst = connection.prepareStatement("select * from jogo m where m.numero = ? and m.disponivel");
            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            Milhar milhar = null;
            while (rs.next()) {
                milhar = new Milhar();
                milhar.setIdMilhar(rs.getInt("idjogo"));
                milhar.setValue(rs.getString("numero"));
                milhar.setDisponivel(rs.getBoolean("disponivel"));
            }
            return Objects.isNull(milhar);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

}
