package org.logcod.lojajogos.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Ganhador {

    private int posicao;
    private String pessoa;
    private String endereco;
    private String milhar;
    private String pagou;
}
