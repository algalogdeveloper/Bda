package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Faturamento;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.repository.RepositoryCompra;

public class CompraService {

    protected static RepositoryCompra repositoryCompra = new RepositoryCompra();
    protected static ApostaService as = new ApostaService();
    protected static MilharService ms = new MilharService();
    protected static ConsultasService consultasService = new ConsultasService();

    public int calcularTotalTaloes(long id) {
        return repositoryCompra.calcularTotalTaloes(id);
    }

    public boolean truncarDataTables() {
        return repositoryCompra.truncarDataTables();
    }

    public boolean verificarSeCompraEstaPaga(Integer key) {
        return repositoryCompra.verificarSeCompraEstaPaga(key);
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelas() {
        return repositoryCompra.carregarFaturamentoTotalCartelas();
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasPagasNoGeral() {
        return repositoryCompra.carregarFaturamentoTotalCartelasPagasNoGeral();
    }

    public int receberPagamentoParcial(int idcompra, double valor) {
        return repositoryCompra.receberPagamentoParcial(idcompra, valor);
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasParaReceber() {
        return repositoryCompra.carregarFaturamentoTotalCartelasParaReceber();
    }

    public Vector<Compra> vizualizarPagamentosDoDia() {
        return repositoryCompra.vizualizarPagamentosDoDia();
    }

    public boolean habilitarCobranca() {
        return repositoryCompra.habilitarCobranca();
    }

    public Boolean alterarPessoa(int idcompra, int idpessoa) {
        return repositoryCompra.alterarPessoa(idcompra, idpessoa);
    }

    public Collection<Compra> selecionarComprasPeloSeuMilharDeCadastro(String numero) {
        if (Objects.isNull(numero) || Objects.equals(numero, "")) {
            numero = "";
        }
        return repositoryCompra.selecionarComprasPeloSeuMilharDeCadastro(numero);
    }

    public Compra carregarCompraCliente(String numero) {
        return repositoryCompra.carregarCompraCliente(numero);
    }

    public Compra pagarCompra(int idcompra, int chave_acesso) {
        return repositoryCompra.finalizarPagamento(idcompra, chave_acesso);
    }

    public Compra obterCompra(int id) {
        return repositoryCompra.obterCompra(id);
    }

    public Compra save(Compra jogo, List<Milhar> itens) {
        return repositoryCompra.save(jogo, itens);
    }
    
    public Compra enviar(Compra jogo, LinkedHashSet<Milhar> sacola) {
        return repositoryCompra.save(jogo, sacola);
    }

    public Compra obterCompraPorClienteId(int idCliente) {
        return repositoryCompra.obterCompraPorClienteId(idCliente);
    }

    public Compra get(int idCompra) {
        return repositoryCompra.get(idCompra);
    }

    public Compra getPessoa(int _idCompra, int _idPessoa) {
        return repositoryCompra.getPessoa(_idCompra, _idPessoa);
    }

    public boolean inserirMilharParaPessoa(int idCompra, int idPessoa, List<Milhar> milhars) {
        return repositoryCompra.inserirMilharParaPessoa(idCompra, idPessoa, milhars);
    }

    public Collection<Compra> comprasAll() {
        return repositoryCompra.comprasAll();
    }

    public Collection<Compra> consularCompras(int idCompra) {
        return repositoryCompra.consultarCompras(idCompra);
    }

    public void deleteCompra(int idcompra) {
        repositoryCompra.deleteCompra(idcompra);
    }

    public int modificarQtd(int idCompra, int qtd, double valor) {
        return repositoryCompra.modificarQtd(idCompra, qtd, valor);
    }

    public void removerCompras(int idcompra) {
        repositoryCompra.removerCompras(idcompra);
    }

    public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastro(String local) {

        return repositoryCompra.selecionarComprasPeloSeuEnderecoDeCadastro(local);
    }

    public void alterarMilharPessoa(Aposta aposta, int idmilhar) {
        repositoryCompra.alterarMilharPessoa(aposta, idmilhar);

    }

    public void voltarPrecoFixo(Integer idCompra, int idPessoa) {
        repositoryCompra.voltarPrecoFixo(idCompra, idPessoa);

    }

    public int ativarTodosCartelasParaVenda() {
        return repositoryCompra.ativarTodosCartelasParaVenda();

    }

    public boolean ativarCobrancaCliente(int valueOf) {

        return repositoryCompra.ativarCobrancaCliente(valueOf);
    }

    public String obterPrecoNormalizado(int key, double valorNormal) {
        return repositoryCompra.obterPrecoNormalizado(key, valorNormal);
    }

    public Collection<Compra> listaEmabertoCompras() {
        return repositoryCompra.listaEmabertoCompras();
    }

    public Collection<Compra> catalogodeComprasComsuasApostasEmaberto(int limit, int page) {
        return repositoryCompra.catalogodeComprasComsuasApostasEmaberto(limit, page);
    }

    public double calcularValorPagamentoCurrenteDate() {
        return repositoryCompra.calcularValorPagamentoCurrenteDate();
    }

    public List<Compra> joinEnderecoPessoaCompraApostaGerandoPdfEmaberto() {
        return repositoryCompra.joinEnderecoPessoaCompraApostaGerandoPdfEmaberto();
    }

    public List<Compra> filtrarCompraPorFuncionario(Funcionario funcionario, Local local, String situacao) {

        List<Compra> compras = null;
        switch (situacao) {
            case "aberto":
                compras = repositoryCompra.filtrarCompraPorFuncionario(funcionario, local, false);
                break;
            case "concluido":
                compras = repositoryCompra.filtrarCompraPorFuncionario(funcionario, local, true);
                break;
            case "todos":
                compras = repositoryCompra.filtrarTodasComprasPorFuncionario(funcionario, local);
                break;

        }
        return compras;

    }

    public boolean ajustarValorTalaoCliente(int idCompra, double valor) {
        return repositoryCompra.ajustarValorTalaoCliente(idCompra, valor);
    }

    public List<Compra> consultarMilharClienteQtdEValor(double valor, int qtd) {

        return repositoryCompra.consultarMilharClienteQtdEValor(valor, qtd);
    }

    public List<Compra> buscarCompraClienteMobile(String data) {
        return repositoryCompra.buscarCompraClienteMobile(data);
    }

    public boolean modificarQtd(int idcompra, int qtd) {
        return repositoryCompra.modificarQtd(idcompra, qtd);

    }

    public void alterarNumeroCartelaCliente(int idcliente, String numero_cartela) {
        repositoryCompra.alterarNumeroCartelaCliente(idcliente, numero_cartela);
    }

    public List<Compra> apostasAgrupadas() {
        return repositoryCompra.listaagrupada();
    }

    public void updateCompraQtdValor(Compra compra) {
       repositoryCompra.updateCompraQtdValor(compra); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     public int menorQtdnoCanhoto(){
         return repositoryCompra.menorQtdnoCanhoto();
     }
     
      public int menorValordoCanhoto() {
          return repositoryCompra.menorValordoCanhoto();
      }
}
