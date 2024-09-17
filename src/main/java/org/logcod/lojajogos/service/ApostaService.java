package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.repository.RepositoryAposta;

public class ApostaService {

    RepositoryAposta repositoryAposta = new RepositoryAposta();

    public void save(Aposta aposta) {
        repositoryAposta.save(aposta);
    }

    public Aposta apostaPorNumero(String value) {
        return repositoryAposta.apostaPorNumero(value);
    }

    public int update(int chavePK) {
        return repositoryAposta.update(chavePK);
    }

    public Aposta get(int id) {
        return repositoryAposta.get(id);
    }

    public Aposta get(int idaposta, int idcompra) {
        return repositoryAposta.get(idaposta, idcompra);
    }

    public Collection<Aposta> consultarApostasIdCompra(int chavePK) {
        return repositoryAposta.consultarApostasIdCompra(chavePK);
    }

    public List<Aposta> listaCompletadeApostaPorCliente() {
        return repositoryAposta.listaCompletadeApostaPorCliente();
    }

    public Collection<Aposta> consultarApostaId(String value) {
        return repositoryAposta.consultarApostasNumero(value);
    }

    static ApostaService apostaService = new ApostaService();
    static CompraService compraService = new CompraService();
    static MilharService milharService = new MilharService();

    public static void main(String[] args) {

        Collection<Aposta> aposta = apostaService.consultarApostasIdCompra(1);

        System.out.println(aposta);

    }

    public void deleteAposta(int idaposta) {
        repositoryAposta.deleteAposta(idaposta);

    }

    public List<Compra> listaCompletaSemFiltrosApostas() {
        return repositoryAposta.listaCompletaSemFiltrosApostas();
    }

    public void removerMilharAhMais(int id) {
        repositoryAposta.removerMilharAhMais(id);
    }

}
