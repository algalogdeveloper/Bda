package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class CriarCartela implements Action {

    LocalService serviceLocal = new LocalService();
    CompraService jogoService = new CompraService();
    PessoaService pessoaService = new PessoaService();
    ConsultasService consultasService = new ConsultasService();
    ApostaService apostaService = new ApostaService();
    MilharService milharService = new MilharService();
    private Compra compra = null;

    @SuppressWarnings("unchecked")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Pessoa pessoa = criarPessoa(request);
            List<Milhar> products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
            compra = criarCartela(compra, request, pessoa, products);

            if (products.isEmpty()) {
                request.setAttribute("msg", "lista está vazia");
            } else {
                Compra comprapessoa = jogoService.getPessoa(compra.getIdCompra(), pessoa.getIdPessoa());
                if (!Objects.equals(compra, comprapessoa)) {
                    jogoService.save(compra, products);
                } else {
                    jogoService.inserirMilharParaPessoa(compra.getIdCompra(), pessoa.getIdPessoa(), products);
                }
            }
            products = new ArrayList<Milhar>();
            request.getSession().setAttribute("meuCarrinho", products);
            return "controller?operacao=CarrinhoController&carrinho=loja";
        } catch (Exception e) {
            return "controller?operacao=CarrinhoController&carrinho=loja";
        }
    }

    public Pessoa criarPessoa(HttpServletRequest request) {

        try {
            String nome = request.getParameter("nome");
            String contato = request.getParameter("contato");
            Local local = serviceLocal.get(Integer.valueOf(request.getParameter("idLocal")));
            Pessoa pessoa = pessoaService.consultarPeloContato(contato);
            if (Objects.isNull(pessoa)) {
                pessoa = new Pessoa(0, nome, contato, local);
                pessoa = pessoaService.save(pessoa);
            }
            return pessoa;
        } catch (Exception e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }

    }

    public Compra criarCartela(Compra cartela, HttpServletRequest request, Pessoa pessoa, List sequencia_numeros) {

        try {
            cartela = new Compra();
            int qtd_cartela = pegarQuantidade(request.getParameter("qtd_cartela"));
            cartela.setPessoa(pessoa);
            cartela.setPagou(false);
            cartela.setValor(Double.valueOf(request.getParameter("valor")) * (sequencia_numeros.size() / qtd_cartela));
            cartela.setNumero_cartela(request.getParameter("numero_cartela"));
            cartela.setPremio(request.getParameter("premio"));
            cartela.setQtd_cartela(sequencia_numeros.size() / qtd_cartela);
            cartela.setPagou(situacao(request.getParameter("situacao")));
            request.getSession().setAttribute("premio", request.getParameter("premio"));
            request.getSession().setAttribute("qtd_cartela", qtd_cartela);
            request.getSession().setAttribute("valor", request.getParameter("valor"));

            request.setAttribute("msg", "Você vendeu " + sequencia_numeros.size() / qtd_cartela + " bilhete para "
                    + pessoa.getNome() + " na data " + DataSourceUtil.formatarDataViewCalendar(Calendar.getInstance()));
            return cartela;
        } catch (Exception e) {
            return cartela;
        }

    }

    public Integer pegarQuantidade(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            System.out.println("Erro: " + e.getLocalizedMessage());
            return 0;
            // TODO: handle exception
        }
    }

    public boolean situacao(String pagou) {
        boolean pg = false;
        try {
            System.out.println("st: " + pagou);
            if (pagou.equalsIgnoreCase("sim")) {
                pg = true;
            }
            return pg;
        } catch (Exception e) {
            return pg;
        }
    }

}
