package org.logcod.lojajogos.model.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String email;
    private String contato;
    private String login;
    private String senha;
    private int permissao;
    private LocalDate dtAcesso;
    private String hostacesso;

}
