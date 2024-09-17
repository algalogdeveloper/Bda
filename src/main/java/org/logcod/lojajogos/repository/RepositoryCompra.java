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
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Faturamento;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class RepositoryCompra {

    Connection connection;
    PreparedStatement ps;
    ContextConfigDataSource dataSource;
    ApostaService as = new ApostaService();
    PessoaService psp = new PessoaService();
    MilharService ms = new MilharService();
    ConsultasService cs = new ConsultasService();

    public RepositoryCompra() {
        dataSource = ContextConfigDataSource.singletonConexao();
        connection = dataSource.conect();
    }

    public int receberPagamentoParcial(int idcompra, double valor) {
        try {
            ps = connection.prepareStatement("update compra set valor = valor - ? where idcompra = ? and valor >=  ?");
            ps.setDouble(1, valor);
            ps.setInt(2, idcompra);
            ps.setDouble(3, valor);
            ps.execute();
            System.out.println(ps.toString());
            return obterCompra(idcompra).getIdCompra();
        } catch (SQLException e) {
        
            return 0;
        }
    }

    public boolean verificarSeCompraEstaPaga(Integer key) {
        try {
            ps = connection.prepareStatement("SELECT * FROM compra c WHERE c.pagou=true AND c.idcompra = ?");
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
            }
            return Objects.nonNull(compra);
        } catch (Exception e) {
            return false;
        }
    }

    public Compra obterCompraPorClienteId(int idCliente) {
        try {
            String query = "select * from compra c where c.idpessoa = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
            }
            return compra;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }
    }

    public boolean truncarDataTables() {
        try {
            String query = "truncate table aposta,compra,pessoa";
            ps = connection.prepareStatement(query);
            return ps.execute();
        } catch (Exception e) {
            return false;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelas() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            String consulta = "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c where pagou";
            ps = connection.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasParaReceber() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            String consulta = "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c where not pagou";
            ps = connection.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasPagasNoGeral() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            String consulta = "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c";
            ps = connection.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Compra> vizualizarPagamentosDoDia() {
        try {
            String consulta = "select * from compra c where c.datajogo = current_date and pagou";
            ps = connection.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            Vector<Compra> compras = new Vector<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }
    }

    public Compra get(int chavePK) {
        try {
            String query = "select * from compra c where c.idcompra = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, chavePK);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setValorBilhete(rs.getDouble("valorbilhete"));
                compra.setQtdAlternativa(rs.getInt("qtd_no_canhoto"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                //compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
            }
            return compra;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public boolean habilitarCobranca() {
        try {
            String query = "update compra set pagou = false where idcompra > 0";
            ps = connection.prepareStatement(query);
            ps.execute();
            System.out.println(ps.toString());
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean pagarCompra(int idcompra) {
        try {
            String query = "update compra set pagou = true where idcompra = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idcompra);
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Compra getPessoa(int _idCompra, int _idPessoa) {
        try {
            String query = "select * from compra c where c.idcompra = ? and c.idpessoa = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, _idCompra);
            ps.setInt(2, _idPessoa);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
            }
            return compra;

        } catch (Exception e) {
            System.out.println("Excessão" + e.getLocalizedMessage());
            return null;

        }

    }

    public boolean inserirMilharParaPessoa(int idCompra, int idPessoa, List<Milhar> milhars) {
        try {
            Compra compra = getPessoa(idCompra, idPessoa);
            boolean insert = false;
            int count = 0;
            for (Milhar milhar : milhars) {
                ms.getNaoDisponivel(milhar.getIdMilhar());
                Aposta aposta = new Aposta(milhar, compra);
                as.save(aposta);
                count++;
            }

            if (milhars.size() == count) {
                insert = true;
            }

            return insert;
        } catch (Exception e) {
            System.out.println("Compras pode ou não ter sido realizada: " + e);
            return false;
        }
    }

    // consultar cartelas vendidas
    public Collection<Compra> consultarCompras(int chavePK) {
        try {
            String query = "select * from compra c where c.idpessoa = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, chavePK);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public Collection<Compra> comprasAll() {
        try {
            String query = "select * from compra c";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastro(String local) {
        try {
            String query = "select * from endereco e inner join pessoa p on e.idendereco=p.idendereco "
                    + "inner join compra c on c.idpessoa = p.idpessoa where  e.idendereco = ? and not pagou";
            ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(local));
            ResultSet rs = ps.executeQuery();
            // System.out.println(ps.toString());
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Compra> selecionarComprasPeloSeuMilharDeCadastro(String numero) {
        try {
            String query = "";
            query = "select  distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor  from pessoa p inner join compra c on p.idpessoa=c.idpessoa inner join aposta a on c.idcompra=a.idcompra inner join jogo j on a.idjogo=j.idjogo where j.numero like ? limit 12 ";

            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + numero + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                // compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public int maxId() {
        try {
            String query = "select max(idcompra) as id from compra";
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

    // cadastrar cartela com os numeros selecionado
    public Compra save(Compra minhaVenda, List<Milhar> itens) {
        try {
            String insertJogo = "insert into compra (idcompra,dataJogo,idpessoa,pagou,cancelar,valor,numero_cartela,premio,qtd_cartela,valorBilhete,idfuncionario,desconto,qtd_no_canhoto) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            ps = connection.prepareStatement(insertJogo);
            int key = maxId() + 1;
            ps.setInt(1, key);
            ps.setDate(2, DataSourceUtil.formatDataUtil());
            ps.setInt(3, minhaVenda.getPessoa().getIdPessoa());
            ps.setBoolean(4, minhaVenda.isPagou());
            ps.setBoolean(5, minhaVenda.isCancelar());
            ps.setDouble(6, minhaVenda.getValor());
            ps.setString(7, minhaVenda.getNumero_cartela());
            ps.setString(8, minhaVenda.getPremio());
            ps.setInt(9, minhaVenda.getQtd_cartela());
            ps.setDouble(10, minhaVenda.getValorBilhete());
            ps.setInt(11, minhaVenda.getFuncionario().getIdFuncionario());
            ps.setDouble(12, minhaVenda.getDesconto());
            ps.setObject(13, minhaVenda.getQtdAlternativa());
            ps.execute();
            Compra compra = obterCompra(key);
            //Thread.sleep(2000);
            for (Milhar m : itens) {
                Aposta aposta = new Aposta(m, compra);
                as.save(aposta);
                ms.getNaoDisponivel(m);
            }
            return obterCompra(key);
        } catch (SQLException e) {
            System.out.println("ERRO EM NA TENTIVA DE ENVIAR APOSTA: " + e);
            return null;
        }
    }

    public void deleteCompra(int idcompra) {
        try {
            String sql = "delete from compra c where idcompra = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    CentenaGratisService service = new CentenaGratisService();

    public void removerCompras(int idcompra) {
        try {

            Collection<Aposta> apostas = cs.detalhesAposta(idcompra);
            System.out.println("Para remover: " + apostas);
            for (Aposta ap : apostas) {
                Milhar m = ms.getJogo(ap.getMilhar().getIdMilhar());
                System.out.println();
                ms.getDisponivel(m);
                as.deleteAposta(ap.getIdAposta());
            }

            Compra compra = get(idcompra);
            int idpessoa = compra.getPessoa().getIdPessoa();
            service.deleteCentenas(idcompra);
            deleteCompra(compra.getIdCompra());
            psp.delete(idpessoa);

        } catch (Exception e) {
            System.out.println("excessão: " + e.getLocalizedMessage());
        }
    }

    public int modificarQtd(int idCompra, int qtd, double valor) {

        String query = "update compra set valor = valor + " + valor + " , qtd_cartela = qtd_cartela + " + qtd
                + " where idcompra = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idCompra);
            System.out.println(ps.toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return -1;
        }

    }

    FuncionarioService funcionarioService = new FuncionarioService();

    public Compra obterCompra(int idcompra) {
        try {
            String query = "SELECT * FROM compra c where c.idcompra = ? ";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idcompra);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
            }
            return compra;
        } catch (Exception e) {
            return null;
        }
    }

    public Compra finalizarPagamento(int idcompra, int chave_acesso) {
        String query = "update compra set pagou=true,  dataJogo=current_date , idfuncionario = ? where idcompra = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, chave_acesso);
            ps.setInt(2, idcompra);
            System.out.println(ps.toString());
            ps.execute();
            return obterCompra(idcompra);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return null;
        }
    }

    public Boolean alterarPessoa(int idcompra, int idpessoa) {
        String query = "update compra set idpessoa=? where idcompra = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idpessoa);
            ps.setInt(2, idcompra);
            System.out.println(ps.toString());
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return false;
        }
    }

    public void alterarMilharPessoa(Aposta aposta, int idmilhar) {
        // TODO Auto-generated method stub
        String query = "update aposta set idjogo = ? where idaposta = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idmilhar);
            ps.setInt(2, aposta.getIdAposta());
            System.out.println(ps.toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
    }

    protected double pegarValor(Integer idcompra, Integer idPessoa) {
        // TODO Auto-generated method stub
        String query = "select max(valor) as get from compra c where idcompra = ? and idpessoa = ?";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            double get = 0;
            if (rs.next()) {
                get = rs.getDouble("get");
            }
            return get;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return 0;
        }
    }

    public Integer qtdMinCartela() {
        String query = "select min(qtd_cartela) as minima from compra c ";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Integer quatidadeMinima = 0;
            if (rs.next()) {
                quatidadeMinima = rs.getInt("minima");
            }
            return quatidadeMinima;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return null;
        }
    }

    public void voltarPrecoFixo(Integer chave, int qtd) {
        String query = "update compra set valor = ? where idcompra = " + chave;
        try {
            double valorBilhete = pegarValor(chave);
            System.out.println(valorBilhete);
            ps = connection.prepareStatement(query);
            ps.setDouble(1, valorBilhete * qtd);
            ps.setInt(2, chave);
            ps.executeUpdate();
            System.out.println(ps.toString());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected double pegarValor(Integer idcompra) {
        String query = "select max(valorbilhete) as value from compra c where c.idcompra = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idcompra);
            ResultSet rs = ps.executeQuery();
            double valor = 0;
            if (rs.next()) {
                valor = rs.getDouble("value");
            }

            return valor;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public int ativarTodosCartelasParaVenda() {
        String query = "update jogo set disponivel = true where idjogo > 0";
        try {
            ps = connection.prepareStatement(query);
            System.out.println(ps.toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return -1;

        }

    }

    public List<Aposta> listaCompletaSemFiltrosCompras() {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("select * from endereco e, pessoa p , compra c, aposta a, jogo j "
                            + "where e.idendereco = p.idendereco " + "and p.idpessoa = c.idpessoa "
                            + "and c.idcompra = a.idcompra " + "and a.idjogo = j.idjogo");
            ResultSet rs = ps.executeQuery();
            List<Aposta> apostas = new ArrayList<Aposta>();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(rs.getInt(1));
                aposta.setCompra(get(rs.getInt(2)));
                aposta.setMilhar(new MilharService().getJogo(rs.getInt(3)));
                apostas.add(aposta);
            }
            return apostas;
        } catch (Exception e) {
            // TODO: handle exception
            return new ArrayList();
        }
    }

    public boolean ativarCobrancaCliente(Integer valueOf) {
        try {
            String select = "update compra set pagou = false where idcompra = ? ";
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setInt(1, valueOf.intValue());
            ps.execute();
            System.out.println(ps.toString());
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public String obterPrecoNormalizado(int key, double valorNormal) {
        try {
            String select = "update compra set valor = ? where idcompra = ? ";
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setDouble(1, valorNormal);
            ps.setInt(2, key);
            ps.execute();
            return "Enviado";
        } catch (Exception e) {
            return "Cancelado";
        }

    }

    public Collection<Compra> listaEmabertoCompras() {
        try {
            String query = "SELECT * FROM compra c where not c.pagou";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }

    }

    public Collection<Compra> consultarComprasEmabertoCobrador() {
        try {
            String query = "SELECT * FROM compra c where not c.pagou";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Compra> catalogodeComprasComsuasApostasEmaberto(int limit, int page) {
        try {
            String query = "SELECT * FROM compra c where not c.pagou limit ? offset ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, page);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public double calcularValorPagamentoCurrenteDate() {
        try {
            String query = "select  sum(c2.valor) as valor from  compra c2 where c2.datajogo = current_date and  c2.pagou ";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            double valor = 0;
            rs.next();
            valor = rs.getDouble("valor");
            return valor;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Compra> joinEnderecoPessoaCompraApostaGerandoPdfEmaberto() {
        try {
            String query = "SELECT distinct (c.idpessoa) as idpessoa,c.idcompra as idcompra,p.nome as nome ,c.datajogo as datajogo ,e.descricao as descricao  ,c.pagou as pagou, c.numero_cartela as numero_cartela, c.valor as valor  from  endereco e  inner join pessoa p on e.idendereco  = p.idendereco \n"
                    + "inner join  compra c  on  p.idpessoa  = c.idpessoa inner  join  aposta a on  c.idcompra  = a.idcompra \n"
                    + "where  not  pagou order by  e.descricao ";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Compra> filtrarCompraPorFuncionario(Funcionario funcionario, Local local, boolean situacao) {
        try {
            String query = "select  e.idendereco as idendereco  ,\n" + "c.idpessoa as idpessoa  , \n"
                    + "c.idcompra as idcompra,\n" + "c.datajogo as datajogo , \n" + "c.pagou as pagou, \n"
                    + "c.valor as valor,\n" + "c.numero_cartela  as numero_cartela\n"
                    + "from  endereco e  inner join pessoa p \n" + "on e.idendereco  = p.idendereco \n"
                    + "inner  join  compra c  \n" + "on p.idpessoa  = c.idpessoa  \n" + "inner  join  funcionario f \n"
                    + "on c.idfuncionario  = f.idfuncionario \n" + "where  e.idendereco = ? and  f.idfuncionario = ?\n"
                    + " and c.pagou = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, local.getIdLocal());
            ps.setInt(2, funcionario.getIdFuncionario());
            ps.setBoolean(3, situacao);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                //compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public List<Compra> filtrarTodasComprasPorFuncionario(Funcionario funcionario, Local local) {
        try {
            String query = "select  e.idendereco as idendereco  ,\n" + "c.idpessoa as idpessoa  , \n"
                    + "c.idcompra as idcompra,\n" + "c.datajogo as datajogo , \n" + "c.pagou as pagou, \n"
                    + "c.valor as valor,\n" + "c.numero_cartela  as numero_cartela\n"
                    + "from  endereco e  inner join pessoa p \n" + "on e.idendereco  = p.idendereco \n"
                    + "inner  join  compra c  \n" + "on p.idpessoa  = c.idpessoa  \n" + "inner  join  funcionario f \n"
                    + "on c.idfuncionario  = f.idfuncionario \n" + "where  e.idendereco = ? and  f.idfuncionario = ?\n";
            ps = connection.prepareStatement(query);
            ps.setInt(1, local.getIdLocal());
            ps.setInt(2, funcionario.getIdFuncionario());
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                //compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean ajustarValorTalaoCliente(int idCompra, double valor) {
        try {
            String sql = "update compra set valor = ? where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, valor);
            ps.setObject(2, idCompra);
            System.out.println(ps.toString());
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }

    public List<Compra> consultarMilharClienteQtdEValor(double valor, int qtd) {

        try {
            String query = "select * from endereco e, pessoa p, compra c " + "where e.idendereco = p.idendereco "
                    + "and p.idpessoa = c.idpessoa " + "and c.qtd_cartela = ? " + "and c.valor = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, qtd);
            ps.setDouble(2, valor);
            List<Compra> compras = new ArrayList<>();
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Erro:" + e);
        }

    }

    public int calcularTotalTaloes(long id) {
        try {
            String query = "select sum(c.qtd_cartela) as soma from endereco e , pessoa p , compra c \n"
                    + "where  e.idendereco  = p.idendereco  \n" + "and p.idpessoa  = c.idpessoa and e.idendereco = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int soma = rs.getInt("soma");
            System.out.println("Log:" + ps.toString());
            return soma;
        } catch (SQLException e) {
            System.err.println("Log:" + e.getMessage());
            return 0;
        }
    }

    public List<Compra> buscarCompraClienteMobile(String data) {
        try {
            String query = "select distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor, c.qtd_cartela  "
                    + "from pessoa p " + "inner join compra c on p.idpessoa=c.idpessoa  "
                    + "inner join aposta a on c.idcompra=a.idcompra " + "inner join jogo j on a.idjogo=j.idjogo "
                    + "where j.numero like ? or p.nome like ? limit 15 ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setObject(1, data);
            ps.setObject(2, "%" + data + "%");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            System.out.println("Log: " + ps.toString());
            return compras;
        } catch (SQLException e) {
            System.err.println("Log:" + e.getMessage());
            return null;
        }

    }

    public Compra carregarCompraCliente(String numero) {
        try {
            String query = "";
            query = "select  distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor  from pessoa p inner join compra c on p.idpessoa=c.idpessoa inner join aposta a on c.idcompra=a.idcompra inner join jogo j on a.idjogo=j.idjogo where j.numero like ? limit 12 ";
            ps = connection.prepareStatement(query);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            Compra compra = null;
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));

            }
            System.out.println("Log: " + ps.toString());
            return compra;

        } catch (Exception e) {
            System.err.println("Log:" + e.getMessage());
            return null;
        }
    }

    public boolean modificarQtd(int id, int qtd) {
        try {
            String sql = "update compra set qtd_cartela = ? where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, qtd);
            ps.setObject(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void alterarNumeroCartelaCliente(long idcliente, String numero_cartela) {
        try {
            String sql = "update compra set numero_cartela = ? where idpessoa = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, numero_cartela);
            ps.setObject(2, idcliente);
            System.out.println("Log: " + ps.toString());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Log:" + e.getMessage());
        }
    }

    public List<Compra> listaagrupada() {
        try {
            String query = "SELECT e.descricao as local, p.nome as cliente, "
                    + "c.datajogo as datajogo, c.numero_cartela as numero_cartela,c.idcompra as idcompra,  c.qtd_cartela as qtd"
                    + " FROM endereco e, pessoa p, compra c \n"
                    + "where e.idendereco = p.idendereco and p.idpessoa  = c.idpessoa  \n"
                    + "group by e.descricao, p.nome, c.datajogo, c.numero_cartela,c.idcompra,c.qtd_cartela\n"
                    + "order by  e.descricao, p.nome, c.datajogo, c.numero_cartela,c.idcompra, c.qtd_cartela";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<>();
            while (rs.next()) {
                Local local = new Local(rs.getString("local"));
                Pessoa p = new Pessoa(rs.getString("cliente"), local);
                Compra c = new Compra();
                c.setPessoa(p);
                c.setQtd_cartela(rs.getInt("qtd"));
                c.setNumero_cartela(rs.getString("numero_cartela"));
                c.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                c.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(c);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println("Erro:" + e.getMessage());
            return null;
        }

    }

    public Compra save(Compra minhaVenda, LinkedHashSet<Milhar> itens) {
        try {
            String insertJogo = "insert into compra (idcompra,dataJogo,idpessoa,pagou,cancelar,valor,numero_cartela,premio,qtd_cartela,valorBilhete,idfuncionario,desconto,qtd_no_canhoto) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            ps = connection.prepareStatement(insertJogo);
            int key = maxId() + 1;
            ps.setInt(1, key);
            ps.setDate(2, DataSourceUtil.formatDataUtil());
            ps.setInt(3, minhaVenda.getPessoa().getIdPessoa());
            ps.setBoolean(4, minhaVenda.isPagou());
            ps.setBoolean(5, minhaVenda.isCancelar());
            ps.setDouble(6, minhaVenda.getValor());
            ps.setString(7, minhaVenda.getNumero_cartela());
            ps.setString(8, minhaVenda.getPremio());
            ps.setInt(9, minhaVenda.getQtd_cartela());
            ps.setDouble(10, minhaVenda.getValorBilhete());
            ps.setInt(11, minhaVenda.getFuncionario().getIdFuncionario());
            ps.setDouble(12, minhaVenda.getDesconto());
            ps.setObject(13, minhaVenda.getQtdAlternativa());
            ps.execute();
            Compra compra = obterCompra(key);
            //Thread.sleep(2000);
            for (Milhar m : itens) {
                Aposta aposta = new Aposta(m, compra);
                as.save(aposta);
                ms.getNaoDisponivel(m);
            }
            return obterCompra(key);
        } catch (SQLException e) {
            System.out.println("ERRO EM NA TENTIVA DE ENVIAR APOSTA: " + e);
            return null;
        }
    }

    public void updateCompraQtdValor(Compra compra) {
        try {
            String sql = "update compra set qtd_cartela = ?, valor = ? where idcompra = ?";
            ps = connection
                    .prepareStatement(sql);
            ps.setObject(1, compra.getQtd_cartela());
            ps.setObject(2, compra.getValor());
            ps.setObject(3, compra.getIdCompra());
            ps.execute();
        } catch (SQLException e) {
        }

    }

    public int menorQtdnoCanhoto() {
        int min_qtd_no_canhoto = 0;
        try {
            String query = "select min(qtd_no_canhoto) as min_qtd_no_canhoto from compra;";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            min_qtd_no_canhoto = rs.getInt("min_qtd_no_canhoto");
            return min_qtd_no_canhoto;
        } catch (SQLException e) {
            return min_qtd_no_canhoto;
        }

    }
    
    
    public int menorValordoCanhoto() {
        int min_qtd_no_canhoto = 0;
        try {
            String query = "select min(valorbilhete) as min_qtd_no_canhoto from compra;";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            min_qtd_no_canhoto = rs.getInt("min_qtd_no_canhoto");
            return min_qtd_no_canhoto;
        } catch (SQLException e) {
            return min_qtd_no_canhoto;
        }

    }

}
