package org.logcod.lojajogos.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Milhar {

    private Integer idMilhar;
    private String value;
    private boolean disponivel;

    public Milhar(String value, boolean disponivel) {
        this.value = value;
        this.disponivel = disponivel;
    }
}
