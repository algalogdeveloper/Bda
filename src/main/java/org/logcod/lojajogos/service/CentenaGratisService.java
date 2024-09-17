package org.logcod.lojajogos.service;

import java.util.List;

import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.repository.RepositoryCentena;

public class CentenaGratisService {

    RepositoryCentena cr = new RepositoryCentena();

    public boolean enviaCentenaGratis(CentenaGratis gratis) {

        if (cr.qtdCentenaGratis() <= 1000) {
            return cr.enviaCentenaGratis(gratis);
        }
        return false;

    }

    public boolean enviaCentenaGratis(CentenaGratisinha gratis) {

        if (cr.qtdCentenaGratisinha() <= 1000) {
            return cr.enviaCentenaGratis(gratis);
        }
        return false;

    }

    public void deleteCentenas(int idcompra) {
        cr.deleteCentenas(idcompra);

    }

    public CentenaGratisinha getCentenaGratisinha(int id) {
        return cr.getCentenaGratisinha(id);
    }

    public CentenaGratis getCentenaGratis(int id) {
        return cr.getCentenaGratis(id);
    }

    public CentenaGratis obterCentena(String centena) {
        return cr.obterCentena(centena);
    }

    public CentenaGratisinha obterCentenaGratisinha(String centena) {
        return cr.obterCentenaGratisinha(centena);
    }

    public int qtdCentenasGratis() {
        // TODO Auto-generated method stub
        return cr.qtdCentenaGratis();
    }

    public int qtdCentenasGratisinha() {
        // TODO Auto-generated method stub
        return cr.qtdCentenaGratisinha();
    }

    public List<CentenaGratis> listaCompraComCentenasGratis() {
        return cr.listaCompraComCentenasGratis();
    }

    public List<CentenaGratisinha> listaCompraComCentenasGratisinha() {
        return cr.listaCompraComCentenasGratisinha();
    }

    public int qtdCentenaGratis() {
        return cr.qtdCentenaGratis();
    }

    public int qtdCentenaGratisinha() {
        return cr.qtdCentenaGratisinha();
    }

    public CentenaGratis obter(String centena) {
        return cr.obter(centena);
    }

    public CentenaGratisinha obterTwo(String centena) {
        return cr.obterTwo(centena);
    }

    public void modificarCentena(CentenaGratis centenasGratis) {
        cr.modificarCentena(centenasGratis);

    }

    public boolean deleteCentena(int id_centena) {
        return cr.deleteCentena(id_centena);
    }

    public boolean deleteCentenaTwo(Integer valueOf) {
        // TODO Auto-generated method stub
        return cr.deleteCentenaTow(valueOf);
    }

    public void modificarCentena(CentenaGratisinha centenasGratis) {
        cr.modificarCentena(centenasGratis);

    }

}
