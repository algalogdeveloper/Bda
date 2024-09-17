package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class RepositoryAposta {

    Connection connection;
    MilharService ms = new MilharService();
    CompraService cs = new CompraService();
    ContextConfigDataSource dataSource;

    public RepositoryAposta() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public int maxId() {
        try {
            String query = "select max(idaposta) as id from aposta";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = 0;
            id = rs.getInt("id");
            return id;
        } catch (Exception e) {
            return 0;
        }
    }

    public int save(Aposta aposta) {
        try {
            String sql = "insert into aposta (idaposta,idjogo,dataAposta,idcompra) values (?,?,?,?) ";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, maxId() + 1);
            ps.setInt(2, aposta.getMilhar().getIdMilhar());
            ps.setDate(3, DataSourceUtil.formatDataUtil());
            ps.setInt(4, aposta.getCompra().getIdCompra());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }

    }

    public Aposta get(int id) {
        try {
            String query = "select * from aposta a where a.idaposta = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            Aposta aposta = new Aposta();
            while (rs.next()) {
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));

            }
            return aposta;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }

    }

    public Aposta apostaPorNumero(String value) {
        try {
            String query = "select * from endereco e " + "inner join pessoa p on e.idendereco = p.idendereco "
                    + "inner join compra c on p.idpessoa = c.idpessoa "
                    + "inner join aposta a on c.idcompra=a.idcompra "
                    + "inner join jogo j on a.idjogo=j.idjogo where j.numero like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            Aposta aposta = new Aposta();
            while (rs.next()) {
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));

            }
            return aposta;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }

    }

    public Aposta get(int idaposta, int idcompra) {
        try {
            String query = "select * from aposta a where a.idaposta = ? and a.idcompra = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idaposta);
            ps.setInt(2, idcompra);
            ResultSet rs = ps.executeQuery();
            Aposta aposta = null;
            while (rs.next()) {
                aposta = new Aposta();
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
            }
            return aposta;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }

    }

    public List<Aposta> listaCompletadeApostaPorCliente() {
        try {
            String query = "select * from aposta a ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Aposta> apostas = null;
            apostas = new ArrayList<Aposta>();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
                apostas.add(aposta);
            }
            return apostas;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }
    }

    public Collection<Aposta> consultarApostasIdCompra(int chavePK) {
        try {
            String query = "select * from aposta a where a.idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, chavePK);
            ResultSet rs = ps.executeQuery();
            Collection<Aposta> apostas = new ArrayList<Aposta>();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                //aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
                apostas.add(aposta);
            }
            return apostas;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }

    }

    public void deleteAposta(int idaposta) {
        try {
            String query = "delete from aposta where idaposta = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idaposta);
            System.out.println(ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro: " + e.getLocalizedMessage());
        }
    }

    public Collection<Aposta> consultarApostasNumero(String numero) {
        try {
            String query = "select * from aposta a where a.numero like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            Collection<Aposta> apostas = null;
            apostas = new ArrayDeque();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(rs.getInt("idaposta"));
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
                apostas.add(aposta);
            }
            return apostas;
        } catch (SQLException e) {
            System.out.println("falha: " + e.getLocalizedMessage());
            return null;
        }

    }

    public int update(int chavePK) {
        // TODO Auto-generated method stub
        return 0;
    }

    PessoaService pessoaService = new PessoaService();
    FuncionarioService fs = new FuncionarioService();

    public List<Compra> listaCompletaSemFiltrosApostas() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from endereco e, pessoa p , compra c "
                    + "where e.idendereco = p.idendereco "
                    + "and p.idpessoa = c.idpessoa order by p.nome");
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<Compra>();
            compras.isEmpty();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(pessoaService.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setFuncionario(fs.getFuncionario(rs.getInt("idfuncionario")));
                compras.add(compra);

            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e);
            return new ArrayList();
        }
    }

    public void removerMilharAhMais(int idaposta) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from aposta where idaposta = ?");
            ps.setObject(1, idaposta);
            ps.execute();
            System.out.println(ps.toString());
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
