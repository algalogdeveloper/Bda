package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Rota;

public class RepositoryRota {

    Connection connection;
    PreparedStatement ps;
    ContextConfigDataSource dataSource;

    public RepositoryRota() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public LinkedHashSet<Local> listarLocaisPorRota(int key) {
        try {
            String query = "select * from endereco e, pessoa p where e.idendereco = p.idendereco and e.codigo_rota = ? ";
            ps = connection.prepareStatement(query);
            ps.setObject(1, key);
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<Local> locais = new LinkedHashSet<>();
            while (rs.next()) {
                Local l = new Local(rs.getInt(1), rs.getString(2), rs.getString(3));
                locais.add(l);
            }
            return locais;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public LinkedHashSet<Rota> listaRotasAS() {
        try {
            String query = "select * from rota r ";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<Rota> rotas = new LinkedHashSet<>();
            while (rs.next()) {
                Rota r = new Rota(rs.getInt(1), rs.getInt(2));
                r.setLocais(listarLocaisPorRota(rs.getInt(1)));
                rotas.add(r);
            }
            return rotas;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Rota buscarRotasAS(int key) {
        try {
            String query = "select * from rota r where codigo = ? ";
            ps = connection.prepareStatement(query);
            ps.setObject(1, key);
            ResultSet rs = ps.executeQuery();
            Rota r = null;
            while (rs.next()) {
                r = new Rota(rs.getInt(1), rs.getInt(2));
                r.setLocais(listarLocaisPorRota(rs.getInt(1)));
            }
            return r;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
