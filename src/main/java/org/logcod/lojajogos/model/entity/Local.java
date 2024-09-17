package org.logcod.lojajogos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Local {

    private int idLocal;
    private String descricao;
    private String cidade;
    private Rota rota;

    public Local(String descricao, String cidade) {
        super();
        this.descricao = descricao;
        this.cidade = cidade;
    }
    
    public Local(int id, String descricao, String cidade) {
        idLocal = id;
        this.descricao = descricao;
        this.cidade = cidade;
    }

    public Local(String descricao) {
        this.descricao = descricao;
    }

    public Local(int id) {
        this.idLocal = id;
    }

}
