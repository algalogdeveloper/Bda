package org.logcod.lojajogos.model.entity;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aposta {

    private int idAposta;
    private Milhar milhar;
    private Calendar dataAposta;
    private Compra compra;

    public Aposta(Milhar milhar, Compra compra) {
        this.milhar = milhar;
        this.compra = compra;
    }

    @Override
    public String toString() {
        return milhar.getValue();
    }

}
