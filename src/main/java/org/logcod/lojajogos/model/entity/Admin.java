package org.logcod.lojajogos.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admin {

    private int idAdm;
    private String nome;
    private String login;
    private String senha;
}
