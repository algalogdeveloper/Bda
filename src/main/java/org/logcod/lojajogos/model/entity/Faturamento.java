package org.logcod.lojajogos.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Faturamento {

    private Double valor;
    private Integer qtdPessoas;
    private Integer qtdCartelas;
}
