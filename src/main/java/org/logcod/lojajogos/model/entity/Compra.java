package org.logcod.lojajogos.model.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.logcod.lojajogos.service.ApostaService;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Compra {

    private int idCompra;
    private Calendar dataJogo;
    private Pessoa pessoa;
    private boolean pagou;
    private boolean cancelar;
    private double valor;
    private Calendar dataPg;
    private String numero_cartela;
    private String premio;
    private int qtd_cartela;
    private double valorBilhete;
    private Funcionario funcionario;
    private int qtdAlternativa;
    private double desconto;
    private Collection<Aposta> apostas;
    
    private Set<MilharExtra> milharExtras;

    private TreeMap<Object, Object> listacentenas = new TreeMap<>();

    public Compra(Pessoa p) {
        this.pessoa = p;
    }

    public Collection<Aposta> obter(int id) {
        apostas.size();
        return new ApostaService().consultarApostasIdCompra(id);
    }

}
