package org.logcod.lojajogos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CentenaGratis {

    private int idCentena;
    private String numero;
    private Compra compra;
}
