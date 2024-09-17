package org.logcod.lojajogos.model.entity;

import java.util.Calendar;

import org.logcod.lojajogos.config.util.DataSourceUtil;

import lombok.Data;

@Data
public class ListaOrdenada {

    public int chave;
    public String descricao;
    public String pessoa;
    public double valor;
    public Calendar dataCobranca, dataAposta;
    public Integer qtdCartela;
    public Integer qtd;
    public boolean pagou;

    @Override
    public String toString() {
        return "\ndescricao =" + descricao + ",\n pessoa=" + pessoa + "\n valor=" + valor + "\ndataCobranca="
                + DataSourceUtil.formatarDataViewCalendar(dataCobranca) + "\ndataAposta=" + DataSourceUtil.formatarDataViewCalendar(dataAposta) + "\nqtdCartela=" + qtdCartela + "\n qtd=" + qtd + "";
    }
}
