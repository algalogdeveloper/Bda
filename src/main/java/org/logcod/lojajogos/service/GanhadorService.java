package org.logcod.lojajogos.service;

import java.util.List;

import org.logcod.lojajogos.model.entity.Ganhador;
import org.logcod.lojajogos.repository.RepositorioGanhador;

public class GanhadorService {

    static RepositorioGanhador rg = new RepositorioGanhador();

    public int save(Ganhador ganhador) {
        return rg.save(ganhador);
    }

    public int update(Ganhador g) {
        return rg.update(g);
    }

    public List<Ganhador> listadeGanhadoresTemporario() {
        return rg.listaDeGanhadoresTemporaria();
    }

    public void limparListaGanhadores() {
        rg.limparListaGanhadores();

    }

    public static void main(String[] args) {
        Ganhador g = new Ganhador();
        g.setPosicao(1);
        g.setEndereco("Rua Tania -oi");
        g.setMilhar("3245");
        g.setPessoa("Fulano");
        g.setPagou("Em aberto");
        rg.save(g);
    }

}
