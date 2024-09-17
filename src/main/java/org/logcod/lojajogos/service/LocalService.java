package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.repository.RepositoryLocal;

public class LocalService {

    RepositoryLocal repositoryLocal = new RepositoryLocal();

    public Set<Local> consultarEnderecosComPessoas() {
        return repositoryLocal.consultarEnderecosComPessoas();
    }

    public Local get(int idLocal) {
        return repositoryLocal.getEndereco(idLocal);
    }

    public List<Local> listaVendasEmaberto() {
        return repositoryLocal.listaVendasEmaberto();
    }

    public Collection<Local> getLocals() {
        return repositoryLocal.getLocals();
    }

    public Collection<Local> consultaEndereco(String consulta) {
        if (Objects.isNull(consulta)) {
            consulta = "";
        }
        return repositoryLocal.consultaEndereco(consulta);
    }

    public void save(Local l) {
        repositoryLocal.save(l);
    }

    public void update(Local l) {
        repositoryLocal.update(l);
    }

    public static void main(String[] args) {
        System.out.println(new LocalService().consultaEndereco(""));
    }

    public int delete(int idlocal) {
        return repositoryLocal.delete(idlocal);
    }

    public Local obterLocal(String descricao) {
        // TODO Auto-generated method stub
        return repositoryLocal.obterLocal(descricao);
    }

}
