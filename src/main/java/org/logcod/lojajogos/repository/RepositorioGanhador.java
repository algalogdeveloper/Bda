package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.model.entity.Ganhador;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;

public class RepositorioGanhador {

    Connection connection;
    MilharService ms = new MilharService();
    CompraService cs = new CompraService();
    ContextConfigDataSource dataSource;

    public RepositorioGanhador() {

        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public int save(Ganhador ganhador) {
        try {
            String sql = "insert into ganhador (posicao,pessoa,endereco,milhar,pagou) values (?,?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ganhador.getPosicao());
            ps.setString(2, ganhador.getPessoa());
            ps.setString(3, ganhador.getEndereco());
            ps.setString(4, ganhador.getMilhar());
            ps.setString(5, ganhador.getPagou());
            return ps.executeUpdate();
        } catch (SQLException e) {
            Informacoes.SOP(e.getLocalizedMessage());
            return -1;
        }

    }

    public int update(Ganhador ganhador) {
        try {
            String sql = "update ganhador set posicao= ?, pessoa=?,endereco=?,milhar=?,pagou=? where posicao =  " + ganhador.getPosicao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ganhador.getPosicao());
            ps.setString(2, ganhador.getPessoa());
            ps.setString(3, ganhador.getEndereco());
            ps.setString(4, ganhador.getMilhar());
            ps.setString(5, ganhador.getPagou());
            return ps.executeUpdate();
        } catch (SQLException e) {
            Informacoes.SOP(e.getLocalizedMessage());
            return -1;
        }

    }

    public List<Ganhador> listaDeGanhadoresTemporaria() {
        try {
            String sql = "SELECT * FROM ganhador g";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Ganhador> lista = new ArrayList<Ganhador>();
            while (rs.next()) {
                Ganhador g = new Ganhador();
                g.setPosicao(rs.getInt(1));
                g.setPessoa(rs.getString(2));
                g.setEndereco(rs.getString(3));
                g.setMilhar(rs.getString(4));
                g.setPagou(rs.getString(5));
                lista.add(g);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public void limparListaGanhadores() {
        try {
            String sql = "DELETE FROM ganhador WHERE posicao > 0";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            Informacoes.SOP(e.getLocalizedMessage());
        }

    }

}
