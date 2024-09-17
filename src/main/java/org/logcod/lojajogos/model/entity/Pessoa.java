package org.logcod.lojajogos.model.entity;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;
    private String nome;
    private String email;
    private String contato;
    private String referencia;
    private Local local;
    private Calendar dataRegistro;

    public Pessoa(String nome, String email, String contato, String referencia, Local local) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
        this.referencia = referencia;
        this.local = local;
    }

    public Pessoa(Integer idPessoa, String nome, String email, String contato, String referencia, Local local) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.contato = contato;
        this.referencia = referencia;
        this.local = local;
    }

    public Pessoa(Integer idPessoa, String nome, String contato, Local local) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.contato = contato;
        this.local = local;
    }

    public Pessoa(String nome, String ref, Local local) {
        this.nome = nome;
        this.contato = ref;
        this.local = local;
    }

    public Pessoa(String nome, Local local) {
        this.nome = nome;
        this.local = local;
    }

}
