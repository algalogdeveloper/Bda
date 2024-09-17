package org.logcod.lojajogos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MilharExtra {
   
    private Compra compra;
    private String numero;

    @Override
    public String toString() {
        return numero;
                }
   
}
