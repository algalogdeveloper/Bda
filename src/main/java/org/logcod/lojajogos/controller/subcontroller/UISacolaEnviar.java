package org.logcod.lojajogos.controller.subcontroller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.PessoaService;

public class UISacolaEnviar implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CompraService cs = new CompraService();
        PessoaService ps = new PessoaService();
        FuncionarioService fs = new FuncionarioService();
        try {
            LinkedHashSet<Milhar> minhaSacola = (LinkedHashSet<Milhar>) request.getSession().getAttribute("sacola");
            Funcionario funcionario = fs.getFuncionario((Integer) request.getSession().getAttribute("chave_acesso"));
            if (!minhaSacola.isEmpty() && validandoQtdNoCanhotoEhSacola(minhaSacola.size(), Integer.parseInt(request.getParameter("qtd")))) {
                //Obter dados do cliente
                Pessoa C = createPessoa(request.getParameter("nome"), request.getParameter("endereco"));
                C.setContato(minhaSacola.stream().findFirst().get().getValue());
                C.setReferencia(minhaSacola.stream().findFirst().get().getValue());
                Pessoa cliente = ps.save(C);
                // obter dados do canhoto
                Compra compra = createCompra(request.getParameter("descricao"), request.getParameter("valor"), request.getParameter("qtd"), request.getParameter("desconto"), cliente, funcionario, minhaSacola);
                compra.setPagou(request.getParameter("situacao").equals("SIM"));
                
                //preencher dados com session 
                //enviando as apostas
                Compra enviar = cs.enviar(compra, minhaSacola);
                request.setAttribute("compra", enviar);
                request.setAttribute("msg", "Canhato(s) de " + enviar.getPessoa().getNome() + " enviado com sucesso!");
                //limpar sacola
                minhaSacola.clear();

            } else {
                request.setAttribute("sacola", minhaSacola);
                request.setAttribute("erro", "Carregue sua sacola com quantidade minima que esta em 1 canhoto!");
            }
            request.getSession().setAttribute("model", carregarFieldsSession(request));

        } catch (Exception e) {
            request.setAttribute("erro", e);
        }

        return "controller?operacao=UISacola";
    }

    public Pessoa createPessoa(String param, String endereco) {
        LocalService ls = new LocalService();
        return new Pessoa(param, ls.get(Integer.parseInt(endereco)));
    }

    public Map<Object, Object> carregarFieldsSession(HttpServletRequest request) {
        Map<Object, Object> model = new HashMap<>();
        model.put("endereco", request.getParameter("endereco"));
        model.put("descricao", request.getParameter("descricao"));
        model.put("valor", request.getParameter("valor"));
        model.put("qtd", request.getParameter("qtd"));
        return model;
    }

    public Compra createCompra(String descricao, String valorItem, String qtd, String desconto, Pessoa p, Funcionario f, LinkedHashSet<Milhar> numeros) {
        Compra c = new Compra();
        c.setPremio(descricao);
        c.setValorBilhete(Double.parseDouble(valorItem));
        c.setQtd_cartela(calcularQtd(numeros.size(), Integer.parseInt(qtd)));
        c.setQtdAlternativa(Integer.parseInt(qtd));
        c.setDesconto(Double.parseDouble(desconto));
        c.setValor(c.getValorBilhete() * c.getQtd_cartela() - c.getDesconto());
        c.setDataJogo(Calendar.getInstance());
        c.setNumero_cartela(numeros.stream().findFirst().get().getValue());
        c.setPessoa(p);
        c.setFuncionario(f);
        return c;
    }

    public int calcularCanhotosIncompletos(int qtdNaSacola, int qtdCanhoto) {
        int calculo = 0;
        if (qtdNaSacola % qtdCanhoto > 0) {
            calculo = qtdNaSacola % qtdCanhoto;
        }
        if (calculo > 2) {
            return 1;
        }
        return 0;
    }

    public boolean validandoQtdNoCanhotoEhSacola(int qtdNaSacola, int qtdCanhoto) {
        return calcularQtd(qtdNaSacola, qtdCanhoto) > 0;
    }

    public int calcularQtd(int qtdNaSacola, int qtdCanhoto) {
        return (qtdNaSacola >= qtdCanhoto) ? qtdNaSacola / qtdCanhoto : 0;
    }

}
