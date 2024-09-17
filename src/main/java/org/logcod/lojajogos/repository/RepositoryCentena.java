package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;

public class RepositoryCentena {

    Connection connection;
    ContextConfigDataSource dataSource;

    public RepositoryCentena() {

        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public boolean enviaCentenaGratis(CentenaGratis gratis) {
        try {
            String sql = "INSERT INTO centena_gratis(id_centena,numero,idcompra) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            int chave = maxCentenaGratis() + 1;
            gratis.setIdCentena(chave);
            ps.setInt(1, gratis.getIdCentena());
            ps.setString(2, gratis.getNumero());
            ps.setInt(3, gratis.getCompra().getIdCompra());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean enviaCentenaGratis(CentenaGratisinha gratis) {
        try {
            String sql = "INSERT INTO centena_gratisinha(id_centena,numero,idcompra) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            int chave = maxCentenaGratisinha() + 1;
            gratis.setIdCentena(chave);
            ps.setInt(1, gratis.getIdCentena());
            ps.setString(2, gratis.getNumero());
            ps.setInt(3, gratis.getCompra().getIdCompra());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public int maxCentenaGratis() {
        try {
            String query = "select max(id_centena) as id_centena from centena_gratis";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public int qtdCentenaGratis() {
        try {
            String query = "select count(id_centena) as id_centena from centena_gratis";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }

    public int maxCentenaGratisinha() {
        try {
            String query = "select max(id_centena) as id_centena from centena_gratisinha";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int qtdCentenaGratisinha() {
        try {
            String query = "select count(id_centena) as id_centena from centena_gratisinha";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            return 1;
        }
    }

    public void deletaCentenaGratis(int idcompra) {
        try {
            String sql = "delete from centena_gratis where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

    public void deletaCentenaGratisinha(int idcompra) {
        try {
            String sql = "delete from centena_gratisinha where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

    public void deleteCentenas(int idcompra) {

        deletaCentenaGratis(idcompra);
        deletaCentenaGratisinha(idcompra);
    }

    CompraService compraService = new CompraService();

    public CentenaGratis getCentenaGratis(int id) {
        try {
            String query = "select * from centena_gratis cg where cg.id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            CentenaGratis centenaGratis = null;
            while (rs.next()) {
                centenaGratis = new CentenaGratis(rs.getInt(1), rs.getString(2),
                        compraService.obterCompra(rs.getInt(3)));
            }
            return centenaGratis;
        } catch (Exception e) {
            return null;
        }
    }

    public CentenaGratisinha getCentenaGratisinha(int id) {
        try {
            String query = "select * from centena_gratisinha cg where cg.id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha centenaGratis = null;
            while (rs.next()) {
                centenaGratis = new CentenaGratisinha(rs.getInt(1), rs.getString(2),
                        compraService.obterCompra(rs.getInt(3)));
            }
            return centenaGratis;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CentenaGratis> listaCompraComCentenasGratis() {
        try {
            String query = "select * from centena_gratis cg";

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<CentenaGratis> centenaGratis = new ArrayList<CentenaGratis>();
            while (rs.next()) {
                CentenaGratis c = new CentenaGratis();
                c.setIdCentena(rs.getInt("id_centena"));
                c.setNumero(rs.getString("numero"));
                c.setCompra(compraService.obterCompra(rs.getInt("idcompra")));
                centenaGratis.add(c);

            }
            return centenaGratis;

        } catch (Exception e) {
            return null;
        }

    }

    public List<CentenaGratisinha> listaCompraComCentenasGratisinha() {
        try {
            String query = "select * from centena_gratisinha cg";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<CentenaGratisinha> centenaGratis = new ArrayList<CentenaGratisinha>();
            while (rs.next()) {
                CentenaGratisinha c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                centenaGratis.add(c);

            }
            return centenaGratis;

        } catch (Exception e) {
            return null;
        }

    }

    int auto = 1;

    public CentenaGratis obterCentena(String centena) {
        try {
            String query = "select * from centena_gratis cg where cg.numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratis c = null;
            if (rs.next()) {
                c = new CentenaGratis();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                return c;
            }

            return new CentenaGratis(auto++, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));

        } catch (SQLException e) {
            return new CentenaGratis(auto, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));
        }

    }

    int auto2 = 1;

    public CentenaGratisinha obterCentenaGratisinha(String centena) {

        try {
            String query = "select * from centena_gratisinha cg where cg.numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha c = null;
            if (rs.next()) {
                c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                return c;
            }

            return new CentenaGratisinha(auto2++, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));

        } catch (SQLException e) {
            return new CentenaGratisinha(auto2, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));
        }

    }

    public CentenaGratis obter(String centena) {
        try {
            String query = "select * from centena_gratis cg where cg.numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratis c = null;
            if (rs.next()) {
                c = new CentenaGratis();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));

            }
            return c;

        } catch (SQLException e) {
            return null;
        }

    }

    public CentenaGratisinha obterTwo(String centena) {
        try {
            String query = "select * from centena_gratisinha cg where cg.numero = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha c = null;
            if (rs.next()) {
                c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
            }
            return c;
        } catch (SQLException e) {
            return null;
        }
    }

    public void modificarCentena(CentenaGratis gratis) {
        try {
            String sql = "update centena_gratis set numero = ? where id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gratis.getNumero());
            ps.setInt(2, gratis.getIdCentena());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public boolean deleteCentena(int id_centena) {
        try {
            String sql = "delete from centena_gratis where id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_centena);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteCentenaTow(Integer valueOf) {
        try {
            String sql = "delete from centena_gratisinha where id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, valueOf);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void modificarCentena(CentenaGratisinha gratis) {
        try {
            String sql = "update centena_gratisinha set numero = ? where id_centena = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, gratis.getNumero());
            ps.setInt(2, gratis.getIdCentena());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

}
