package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.Objects;

import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.repository.RepositoryPessoa;

public class PessoaService {

    private RepositoryPessoa rp;
    private CompraService cs;

    public PessoaService() {
        rp = new RepositoryPessoa();
        cs = new CompraService();
    }

    public Pessoa save(Pessoa p) {
        return rp.save(p);
    }

    public Pessoa referenciaCartela(String numero) {
        return rp.referenciaCartela(numero);
    }

    public Pessoa get(int idPessoa) {
        return rp.get(idPessoa);
    }

    public int update(Pessoa p) {
        int upd = rp.update(p);
        System.out.println("Log: valor do update " + upd);
        if (upd > 0) {
            cs.alterarNumeroCartelaCliente(p.getIdPessoa(), p.getContato());
        }
        return rp.update(p);
    }

    public Collection<Pessoa> consultaPessoas(String nome, String email, String contato) {
        if (Objects.isNull(nome)) {
            nome = "";
        }
        return rp.consultasPessoas(nome, email, contato);

    }

    public Pessoa consultarPeloEmailContato(String email, String contato) {
        return rp.consultarPeloEmailContato(email, contato);
    }

    public Pessoa consultarPeloContato(String contato) {
        return rp.consultarPeloNome(contato);
    }

    public Pessoa consultarPeloNome(String contato) {
        return rp.consultarPeloNome(contato);
    }

    public void delete(int idPessoa) {
        rp.delete(idPessoa);
    }

    public static void main(String[] args) {
        PessoaService ps = new PessoaService();
        Informacoes.SOP(ps.consultaPessoas("", "", ""));

    }

}
