package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.repository.RepositoryConsultas;

public class ConsultasService {

    protected static RepositoryConsultas consultas = RepositoryConsultas.abrirConsultas();
    protected static PessoaService ps = new PessoaService();
    protected static ApostaService as = new ApostaService();
    protected static LocalService ls = new LocalService();

    public ConsultasService() {

    }

    public List<Compra> listarComprasSemFiltros() {
        return consultas.listarComprasSemFiltros();
    }

    public Collection<Compra> listarComprasDetalhes(int filter) {
        return consultas.listarCompras(filter);
    }

    public List<Aposta> VirificarGanhadoresBolao(String p1, String p2, String p3,
            String p4, String p5, String p6, String p7,
            String p8, String p9, String p10) {

        return consultas.VirificarGanhadoresBolao(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public Collection<Compra> consultarCompraPorPessoa(String filtro) {
        return consultas.consultarCompraPorPessoa(filtro);
    }

    public Collection<Compra> exibirCartelasPagas(String filtro, String filt) {

        return consultas.exibirCartelasPagas(filtro, filt);
    }

    public Collection<Compra> selecioneCartelasVendidasNoDia() {
        return consultas.selecioneCartelasVendidasNoDia();
    }

    public Collection<Aposta> detalhesAposta(int idCompra) {
        return consultas.detalhesAposta(idCompra);
    }

    public Collection<Compra> selecionarComprasPeloEnderecoDasPessoas(Local local) {
        return consultas.selecionarComprasPeloEnderecoDasPessoas(local);
    }

    public Collection<Aposta> consultarApostas() {
        return consultas.consultarApostas(); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<Compra> exibirCartelasNaoPagas(String parameter, String filt) {

        return consultas.exibirCartelasNaoPagas(parameter, filt);
    }

    public Collection<Compra> listarComprasSemFiltrosCobrador(String filter) {
        return consultas.listarComprasSemFiltrosCobrador(filter);
    }

}
