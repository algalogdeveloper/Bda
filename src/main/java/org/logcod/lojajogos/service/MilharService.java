package org.logcod.lojajogos.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.repository.RepositoryMilhar;

public class MilharService {

    static RepositoryMilhar rj = new RepositoryMilhar();

    public Milhar obterMilhar(String numero) {
        return rj.obterMilhar(numero);
    }

    public void save(Milhar jogo) {
        rj.salvarJogo(jogo);
    }

    public List<Milhar> getJogos(String value) {
        return rj.getJogos(value);
    }

    public Milhar getJogo(String value) {
        return rj.getJogo(value);
    }

    public Collection<Milhar> selecioneMilharVendidos(String buscar) {

        if (Objects.isNull(buscar)) {
            buscar = "";
        }
        return rj.selecioneMilharVendidos(buscar);
    }

    public Milhar getJogo(Integer value) {
        return rj.getJogo(value);
    }

    public int getNaoDisponivel(Milhar jogo) {
        return rj.getNaoDisponivel(jogo);

    }

    public int getDisponivel(Milhar milhar) {
        return rj.getDisponivel(milhar);
    }

    public int getDisponivel(String milhar) {
        return rj.getDisponivel(milhar);
    }

    public int getNaoDisponivel(int jogo) {
        return rj.getNaoDisponivel(jogo);
    }

    public static void main(String[] args) {
        MilharService milharService = new MilharService();
        try {

            String number = "0506";
            String number2 = "0508";
            String number3 = "0516";
            String number4 = "0519";

            Milhar obter = Objects.isNull(milharService.obterMilhar(number)) ? milharService.getJogo(number) : null;
            Milhar obter2 = Objects.isNull(milharService.obterMilhar(number2)) ? milharService.getJogo(number2) : null;
            Milhar obter3 = Objects.isNull(milharService.obterMilhar(number3)) ? milharService.getJogo(number3) : null;
            Milhar obter4 = Objects.isNull(milharService.obterMilhar(number4)) ? milharService.getJogo(number4) : null;
            if (obter.isDisponivel() && obter2.isDisponivel() && obter3.isDisponivel() && obter4.isDisponivel());
            List<Milhar> milhars = Arrays.asList(obter, obter2, obter3, obter4);
            System.out.println(milhars);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Essessão");
        }

    }

    public boolean existe(String milhar) {
        return rj.existe(milhar);
    }

    public boolean validarMilhar(String numero) {
        return rj.validarMilhar(numero);
    }

}
