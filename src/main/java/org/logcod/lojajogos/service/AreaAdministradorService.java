package org.logcod.lojajogos.service;

import java.util.List;

import org.logcod.lojajogos.area.administrador.AreaAdministrador;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;

public class AreaAdministradorService {

    AreaAdministrador areaAdministrador;

    public AreaAdministradorService() {
        areaAdministrador = new AreaAdministrador();
    }

    public List<Compra> solicitarListaDeComprasSemCliente() {
        return areaAdministrador.catalogarComprasSemCliente();
    }

    public List<Compra> solicitarListaDeApostasSemCompras() {
        return areaAdministrador.catalogarApostasSemCompras();
    }

    public boolean ativarPlataformaParaVendas() {
        return areaAdministrador.ativarPlataformaParaVendas();
    }

    public List<Aposta> catalogoDeapostasSemMilhar(int page, int limite) {

        return areaAdministrador.catalogoDeapostasSemMilhar(page, limite);
    }

    public int quantidadeRegistrosSalvos() {
        return areaAdministrador.quantidadeRegistrosSalvos();
    }

    public List<Compra> catalogoComprasCorrigindoToloes() {
        return areaAdministrador.catalogoComprasCorrigindoToloes();
    }

    public List<Compra> carregarListaDeTaloesQtdAcima() {
        return areaAdministrador.carregarListaDeTaloesQtdAcima();
    }

    public int obterLimite(int limite) {
        int qtdData = areaAdministrador.quantidadeRegistrosSalvos();
        if (qtdData >= 1000) {
            limite = 300;
        } else if (qtdData >= 500 && qtdData < 999) {
            limite = 150;
        } else if (qtdData >= 100 && qtdData < 499) {
            limite = 100;
        } else if (qtdData >= 1 && qtdData < 99) {
            limite = 30;
        }
        return limite;
    }

}
