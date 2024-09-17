package org.logcod.lojajogos.area.administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.repository.RepositoryMilhar;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class AreaAdministrador {

    protected Connection conn;
    protected ContextConfigDataSource dataSource;
    protected FuncionarioService funcionarioService;
    protected PessoaService pessoaService;
    protected MilharService ms;
    protected RepositoryMilhar rm;
    protected CompraService cs;

    public AreaAdministrador() {
        dataSource = ContextConfigDataSource.singletonConexao();
        conn = dataSource.conect();
        funcionarioService = new FuncionarioService();
        pessoaService = new PessoaService();
        rm = new RepositoryMilhar();
        ms = new MilharService();
        cs = new CompraService();
    }

    public List<Compra> catalogarComprasSemCliente() {
        String query = "select c.idpessoa as idpessoa from pessoa c left join compra p on c.idpessoa = p.idpessoa where p.idpessoa is null";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setPessoa(pessoaService.get(rs.getInt("idpessoa")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println("Dados com falha:" + e);
            return null;
        }

    }

    public List<Compra> catalogarApostasSemCompras() {
        String query = "select * from compra c left join aposta p on c.idcompra = p.idcompra where p.idcompra is null";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(pessoaService.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean ativarPlataformaParaVendas() {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("TRUNCATE table aposta,centena_gratis ,centena_gratisinha,compra,pessoa cascade");
            ps.execute();
            rm.todosDisponiveis();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public List<Compra> catalogoComprasCorrigindoToloes() {
        try {
            String query = "select c.idcompra, c.valor, e.descricao as descricao, c.pagou, p.nome as nome,(c.qtd_cartela*5) as qtd_milhar_no_talao , count(a.idcompra)  as qtd_milhar \n"
                    + "from public.endereco e , public.pessoa p ,  public.compra c, public.aposta a  \n"
                    + "where e.idendereco = p.idendereco and  p.idpessoa = c.idpessoa and  c.idcompra =a.idcompra  \n"
                    + "group by c.idcompra,c.valor, e.descricao,c.pagou, p.nome ,c.qtd_cartela having count(a.idcompra) < (c.qtd_cartela*5)  order  by e.descricao , p.nome ";
            List<Compra> compras = new ArrayList();
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                //c.setIdCompra(rs.getInt("idcompra"));
                c.setPremio(rs.getString("descricao"));
                c.setPessoa(pessoaService.consultarPeloNome(rs.getString("nome")));
                c.setQtd_cartela(rs.getInt("qtd_milhar_no_talao"));
                c.setQtdAlternativa(rs.getInt("qtd_milhar"));
                c.setValor(rs.getDouble("valor"));
                c.setPagou(rs.getBoolean("pagou"));
                compras.add(c);
            }
            return compras;
        } catch (SQLException e) {
            return null; // TODO: handle exception
        }
    }

    public List<Aposta> catalogoDeapostasSemMilhar(int page, int limite) {
        try {
            String query = "select j.idjogo as idjogo from aposta a right join jogo j on a.idjogo = j.idjogo where a.idjogo is null limit ? offset ?";
            List<Aposta> apostas = new ArrayList();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, limite);
            ps.setInt(2, page);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                apostas.add(aposta);
            }
            return apostas;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int quantidadeRegistrosSalvos() {
        String query = "select  count(j.idjogo)  from aposta a right join jogo j on a.idjogo = j.idjogo where a.idjogo is null";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet set = ps.executeQuery();
            int qtd;
            set.next();
            qtd = set.getInt(1);
            return qtd;
        } catch (SQLException e) {
            System.out.println(e);
            return 1;
        }

    }

    public List<Compra> carregarListaDeTaloesQtdAcima() {
        try {
            String query = "select c.idcompra, c.valor, e.descricao as descricao, c.pagou, p.nome as nome,(c.qtd_cartela*5) as qtd_milhar_no_talao , count(a.idcompra)  as qtd_milhar \n"
                    + "from public.endereco e , public.pessoa p ,  public.compra c, public.aposta a  \n"
                    + "where e.idendereco = p.idendereco and  p.idpessoa = c.idpessoa and  c.idcompra =a.idcompra  \n"
                    + "group by c.idcompra,c.valor, e.descricao,c.pagou, p.nome ,c.qtd_cartela having  count(a.idcompra)  >  (c.qtd_cartela*5) order  by e.descricao , p.nome ";
            List<Compra> compras = new ArrayList();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                c.setIdCompra(rs.getInt("idcompra"));
                c.setPremio(rs.getString("descricao"));
                c.setPessoa(pessoaService.consultarPeloNome(rs.getString("nome")));
                c.setQtd_cartela(rs.getInt("qtd_milhar_no_talao"));
                c.setQtdAlternativa(rs.getInt("qtd_milhar"));
                c.setValor(rs.getDouble("valor"));
                c.setPagou(rs.getBoolean("pagou"));
                compras.add(c);
            }
            return compras;
        } catch (SQLException e) {
            return null; // TODO: handle exception
        }
    }

}
