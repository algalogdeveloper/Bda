package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class CarrinhoController implements Action {

    String url = "index.jsp";
    LocalService ls = new LocalService();
    CompraService cs = new CompraService();
    PessoaService ps = new PessoaService();
    ConsultasService sc = new ConsultasService();
    ApostaService as = new ApostaService();
    MilharService ms = new MilharService();
    FuncionarioService fs = new FuncionarioService();

    HttpSession session;
    protected Compra compra;
    int guardarIdLocal = 0;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String menu = request.getParameter("carrinho");
            String logado = (String) request.getSession().getAttribute("logado");
            @SuppressWarnings("unchecked")
            List<Milhar> products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
            session = request.getSession(true);
            int permissao = (Integer) request.getSession().getAttribute("permissao");
            if (Objects.nonNull(menu) && Objects.nonNull(logado)) {

                switch (menu) {
                    case "loja":
                        if (permissao > 0) {
                            url = carregarLojadeMilhar(request);
                        } else {
                            request.setAttribute("msg", "Seu acesso a este local não eh autorizado!");
                            url = "controller?operacao=PainelAdministrativo";
                        }
                        break;
                    case "agregar":
                        url = agregarElementos(session, request, products);
                        break;
                    case "sequencia":
                        url = dobroDeElementos(session, products, request);
                        break;
                    case "delete":
                        descarrengandoCarrinho(request, products);
                        break;
                    case "compra":
                        url = cadastrarCartela(session, request, products, response);
                        break;
                    case "pessoa":
                        url = pegarElementosdoFormulario(request);
                        break;
                    case "apagarcompra":
                        url = apagarCompra(request);
                        break;
                    case "cartelas":
                        url = cartelasCompradas(request);
                        break;
                    case "alterar":
                        url = alterarMilharPessoa(request);
                        break;
                    case "AjustarValor":
                        url = ajustarValorTalaoCliente(request);
                        break;
                    case "Limpar":
                        url = limparCarrinho(products);
                        break;
                }

            } else {
                url = "index.jsp";
            }
            request.setAttribute("carrinhoCheio", products.size());
            return url;
        } catch (Exception e) {
            System.out.println("sessão: " + e.getCause());
            return url;
        }

    }

    private String ajustarValorTalaoCliente(HttpServletRequest request) {
        String msg = "Nada aconteceu";
        String valid = "Nada aconteceu no erro";
        int idCompra = Integer.valueOf(request.getParameter("idcompra"));
        int idPessoa = Integer.valueOf(request.getParameter("idpessoa"));
        double valor = Double.valueOf(request.getParameter("valor"));
        Compra compra = cs.obterCompra(idCompra);
        if (cs.ajustarValorTalaoCliente(idCompra, valor)) {
            msg = "O valor da aposta do cliente: " + compra.getPessoa().getNome() + " foi corrigida.";
        } else {
            valid = "O valor da  aposta do cliente " + compra.getPessoa().getNome() + " não foi corrigida.";

        }
        request.setAttribute("msg", msg);
        request.setAttribute("valid", valid);

        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + compra.getPessoa().getLocal().getIdLocal();

    }

    private String limparCarrinho(List<Milhar> products) {
        products.clear();
        return "controller?operacao=CarrinhoController&carrinho=loja";
    }

    private String alterarMilharPessoa(javax.servlet.http.HttpServletRequest request) {
        // TODO Auto-generated method stub
        try {
            int idcompra = Integer.valueOf(request.getParameter("idcompra"));
            int idaposta = Integer.valueOf(request.getParameter("idaposta"));
            int idpessoa = Integer.valueOf(request.getParameter("idpessoa"));
            String oldMilhar = request.getParameter("milhar_old");
            Milhar novoMilhar = ms.getJogo(request.getParameter("milhar01"));
            if (idaposta > 0) {
                if (Objects.nonNull(novoMilhar)) {
                    if (!Objects.equals(novoMilhar.getValue(), oldMilhar)) {
                        Aposta aposta = as.get(idaposta, idcompra);
                        if (Objects.nonNull(aposta)) {
                            cs.alterarMilharPessoa(aposta, novoMilhar.getIdMilhar());
                            ms.getNaoDisponivel(novoMilhar.getIdMilhar());
                            ms.getDisponivel(oldMilhar);
                            request.setAttribute("message",
                                    "Milhar foi modificado com sucesso: " + novoMilhar.getValue());
                        }

                    } else {
                        request.setAttribute("info", "Milhar são iguais");
                    }
                } else {
                    request.setAttribute("info", "Milhar não esta disponível");
                }
            } else {
                if (Objects.nonNull(novoMilhar)) {
                    Aposta aposta = new Aposta();
                    compra = cs.get(idcompra);
                    aposta.setCompra(compra);
                    aposta.setMilhar(novoMilhar);
                    ms.getNaoDisponivel(novoMilhar.getIdMilhar());
                    as.save(aposta);
                    request.setAttribute("message", "Milhar cadastrado com sucesso:" + novoMilhar.getValue());
                } else {
                    request.setAttribute("info", "Milhar não esta disponível!");
                }
            }
            return "controller?operacao=CarrinhoController&carrinho=cartelas&idcompra=" + idcompra + "&idpessoa="
                    + idpessoa + "";
        } catch (Exception e) {
            // TODO: handle exception
            request.setAttribute("info", "Milhar não esta disponível");
            return "controller?operacao=CarrinhoController&carrinho=cartelas";

        }

    }

    private String cartelasCompradas(javax.servlet.http.HttpServletRequest request) {
        try {
            int idcompra = Integer.parseInt(request.getParameter("idcompra"));
            int idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
            Collection<Aposta> apostas = sc.detalhesAposta(idcompra);
            Compra compra = cs.getPessoa(idcompra, idpessoa);
            request.setAttribute("apostas", apostas);
            request.setAttribute("compra", compra);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return "views/cartela/verificar_compra.jsp";
    }

    private String apagarCompra(javax.servlet.http.HttpServletRequest request) {

        try {
            int id = Integer.valueOf(request.getParameter("idcompra"));
            Compra compra = cs.get(id);
            System.out.println("Solicitação de exclusão de compra: ");
            if (!cs.verificarSeCompraEstaPaga(id)) {

                if (Objects.nonNull(compra)) {
                    guardarIdLocal = compra.getPessoa().getLocal().getIdLocal();
                    cs.removerCompras(id);
                    System.out.println("Compra removida...");
                    request.setAttribute("msg", " Cartela vinculada a " + compra.getPessoa().getNome().toLowerCase()
                            + " foi excluida com sucesso");
                } else {
                    request.setAttribute("msg", " Cartela já foi excluida");
                }

            } else {
                request.setAttribute("msg", " Cartela vinculada a " + compra.getPessoa().getNome().toLowerCase()
                        + " está paga não pode ser excluida");
                guardarIdLocal = compra.getPessoa().getLocal().getIdLocal();

            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "controller?operacao=ConsultasController&consulta=compras&buscar=" + guardarIdLocal;

    }

    private String pegarElementosdoFormulario(HttpServletRequest request) {
        String msg = "";
        String valid = "";
        int idCompra = Integer.parseInt(request.getParameter("idcompra"));
        int idPessoa = Integer.parseInt(request.getParameter("idpessoa"));

        try {
            Milhar milhar01 = (ms.obterMilhar(request.getParameter("milhar01")) == null)
                    ? ms.getJogo(request.getParameter("milhar01"))
                    : null;
            Milhar milhar02 = (ms.obterMilhar(request.getParameter("milhar02")) == null)
                    ? ms.getJogo(request.getParameter("milhar02"))
                    : null;
            Milhar milhar03 = (ms.obterMilhar(request.getParameter("milhar03")) == null)
                    ? ms.getJogo(request.getParameter("milhar03"))
                    : null;

            Milhar milhar04 = (ms.obterMilhar(request.getParameter("milhar04")) == null)
                    ? ms.getJogo(request.getParameter("milhar04"))
                    : null;

            Milhar milhar05 = (ms.obterMilhar(request.getParameter("milhar05")) == null)
                    ? ms.getJogo(request.getParameter("milhar05"))
                    : null;

            Milhar milhar06 = (ms.obterMilhar(request.getParameter("milhar06")) == null)
                    ? ms.getJogo(request.getParameter("milhar06")) : null;

            Milhar milhar07 = (ms.obterMilhar(request.getParameter("milhar07")) == null)
                    ? ms.getJogo(request.getParameter("milhar07")) : null;

            Milhar milhar08 = (ms.obterMilhar(request.getParameter("milhar08")) == null)
                    ? ms.getJogo(request.getParameter("milhar08")) : null;

//            Milhar milhar09 = (ms.obterMilhar(request.getParameter("milhar09")) == null)
//                    ? ms.getJogo(request.getParameter("milhar09")) : null;
//
//            Milhar milhar10 = (ms.obterMilhar(request.getParameter("milhar10")) == null)
//                    ? ms.getJogo(request.getParameter("milhar10")) : null;
            double valor = Double.parseDouble(request.getParameter("valor"));

            ArrayList<Milhar> elementos = new ArrayList();
            if (Objects.nonNull(milhar01)) {
                elementos.add(milhar01);
            }

            if (Objects.nonNull(milhar02)) {
                elementos.add(milhar02);
            }

            if (Objects.nonNull(milhar03)) {
                elementos.add(milhar03);
            }

            if (Objects.nonNull(milhar04)) {
                elementos.add(milhar04);
            }
            if (Objects.nonNull(milhar05)) {
                elementos.add(milhar05);
            }

            if (Objects.nonNull(milhar06)) {
                elementos.add(milhar06);
            }

            if (Objects.nonNull(milhar07)) {
                elementos.add(milhar07);
            }

            if (Objects.nonNull(milhar08)) {
                elementos.add(milhar08);
            }

//            if (Objects.nonNull(milhar09)) {
//                elementos.add(milhar09);
//            }
//
//            if (Objects.nonNull(milhar10)) {
//                elementos.add(milhar10);
//            }
            int qtd = 0;
            qtd = elementos.size() / 8;
            if (elementos.size() == 8 && !elementos.isEmpty()) {
                if (cs.inserirMilharParaPessoa(idCompra, idPessoa, elementos)) {
                    cs.modificarQtd(idCompra, qtd, qtd * valor);
                    msg = "Numeros inseridos com sucesso!";
                    Compra compra = cs.obterCompra(idCompra);
                    System.out.println(compra);
                    request.setAttribute("compraModificada", compra);
                    elementos.clear();
                } else {
                    valid = " Ou Existe numeros repitidos ou lista está vazia!";
                }

            } else {
                valid = "Pode existir milhar repitido na lista.";
            }
            request.setAttribute("msg", msg);
            request.setAttribute("valid", valid);
        } catch (Exception e) {
            System.out.println(e);

        }
        Compra compra = cs.obterCompra(idCompra);
        return "controller?operacao=ConsultasController&consulta=compras&buscar="
                + compra.getPessoa().getLocal().getIdLocal();
    }

    public String cadastrarCartela(HttpSession session, HttpServletRequest request, List<Milhar> elementos,
            HttpServletResponse response) {
        String info = "";
        String valid = "";

        try {
            if (elementos.isEmpty()) {
                request.setAttribute("valid", "lista está vazia");
            } else {
                if (elementos.size() % Integer.parseInt(request.getParameter("qtd_cartela")) == 0) {
                    Pessoa pessoa = criarPessoa(request, elementos);

                    compra = cs.obterCompraPorClienteId(pessoa.getIdPessoa());
                    session.setAttribute("endereco", pessoa.getLocal());
                    if (Objects.isNull(compra)) {
                        compra = this.carregarCartela(compra, request, pessoa, elementos);
                        Compra minhaVenda = cs.save(compra, elementos);
                        if (Objects.nonNull(minhaVenda.getApostas())) {
                            request.setAttribute("vendaEnviadaCliente", minhaVenda);
                            info = "As informações da cartela de " + compra.getPessoa().getNome()
                                    + " contendo os números foram cadastrada com sucesso! ";
                        } else {
                            valid = "As informações da aposta não forão enviadas."
                                    + "\nTente novamente! \nCaso erro continue contate ao administrador.";
                            cs.removerCompras(compra.getIdCompra());
                            ps.delete(pessoa.getIdPessoa());
                        }

                    }
                } else {
                    valid = "A quantidade de milhar digitado não é igual a quantidade no talão. É preciso Corrige!";
                }
                carregarSessionItens(request, Integer.valueOf(request.getParameter("qtd_cartela")));
                request.setAttribute("msg", info);
                request.setAttribute("valid", valid);
            }
            elementos.clear();
            session.setAttribute("meuCarrinho", elementos);
            return "controller?operacao=CarrinhoController&carrinho=loja";
        } catch (Exception e) {
            request.setAttribute("valid",
                    "Pode ser erro no servidor.\n  Se não cadastrou!\n Tente novamente cadastrar.\n Contate o programador! "
                    + e);
            return "controller?operacao=CarrinhoController&carrinho=loja";
        }

    }

    protected void invalidSession() {
        session.invalidate();
    }

    public Pessoa criarPessoa(HttpServletRequest request, List<Milhar> numeros) {
        try {
            String nome = request.getParameter("nome");
            Integer id = Integer.valueOf(request.getParameter("idLocal"));
            Local local = ls.get(id);
            Pessoa pessoa = ps.referenciaCartela(numeros.get(0).getValue());

            Informacoes.SOP(pessoa);
            if (Objects.isNull(pessoa)) {
                pessoa = new Pessoa();
                pessoa.setNome(nome);
                pessoa.setContato(numeros.get(0).getValue());
                pessoa.setReferencia(numeros.get(0).getValue());
                pessoa.setLocal(local);
                pessoa = ps.save(pessoa);
                Informacoes.SOP(pessoa);
            } else {
                request.setAttribute("valid", "Este cliente já esta cadastrado: " + pessoa.getNome());
            }
            return pessoa;
        } catch (Exception e) {
            System.out.println("Pessoa não cadastrada: " + e.getMessage());
            return null;
        }

    }

    public double calcularValorCompra(double valor, int size, int qtdCartelas, double desconto) {
        try {
            return (valor * (size / qtdCartelas)) - desconto;
        } catch (Exception e) {
            return 0;
        }

    }

    public void carregarSessionItens(HttpServletRequest request, Integer qtd_cartela) {
        session.setAttribute("premio", request.getParameter("premio"));
        session.setAttribute("qtd_cartela", qtd_cartela);
        session.setAttribute("valor", request.getParameter("valor"));

    }

    public Compra carregarCartela(Compra venda, HttpServletRequest request, Pessoa pessoa, List sequencia_numeros) {

        try {
            venda = new Compra();
            int qtd_cartela = pegarQuantidade(request.getParameter("qtd_cartela"));
            venda.setPessoa(pessoa);
            Funcionario funcionarioLogado = fs
                    .getFuncionario((Integer) request.getSession().getAttribute("chave_acesso"));
            venda.setFuncionario(funcionarioLogado);
            venda.setPagou(false);
            venda.setDesconto(Double.parseDouble(request.getParameter("desconto")));
            venda.setValor(calcularValorCompra(DataSourceUtil.convertType(request.getParameter("valor")),
                    sequencia_numeros.size(), qtd_cartela, venda.getDesconto()));
            venda.setNumero_cartela(pessoa.getContato());
            venda.setPremio(request.getParameter("premio"));
            venda.setValorBilhete(DataSourceUtil.convertType(request.getParameter("valor")));
            venda.setQtd_cartela(sequencia_numeros.size() / qtd_cartela);
            venda.setPagou(request.getParameter("situacao").equals("Sim"));
            return venda;
        } catch (Exception e) {
            return venda;
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

    public String meuCarrinhoView(HttpServletRequest request) {
        request.setAttribute("locais", ls.getLocals());
        return "views/carrinho/carrinho.jsp";
    }

    public List<Milhar> agregarElemento(HttpServletRequest request) {
        List<Milhar> milhars = new ArrayList<>();
        milhars.clear();
        try {
            Milhar milhar01 = ms.getJogo(request.getParameter("milhar01"));
            Milhar milhar02 = ms.getJogo(request.getParameter("milhar02"));
            Milhar milhar03 = ms.getJogo(request.getParameter("milhar03"));
            Milhar milhar04 = ms.getJogo(request.getParameter("milhar04"));
            Milhar milhar05 = ms.getJogo(request.getParameter("milhar05"));
            Milhar milhar06 = ms.getJogo(request.getParameter("milhar06"));
            Milhar milhar07 = ms.getJogo(request.getParameter("milhar07"));
            if (Objects.nonNull(milhar01)) {
                milhars.add(milhar01);
            }

            if (Objects.nonNull(milhar02)) {
                milhars.add(milhar02);
            }

            if (Objects.nonNull(milhar03)) {
                milhars.add(milhar03);
            }

            if (Objects.nonNull(milhar04)) {
                milhars.add(milhar04);
            }

            if (Objects.nonNull(milhar05)) {
                milhars.add(milhar05);
            }
            if (Objects.nonNull(milhar06)) {
                milhars.add(milhar06);
            }

            if (Objects.nonNull(milhar07)) {
                milhars.add(milhar07);
            }

            return milhars;
        } catch (Exception e) {
            System.out.println("Log:" + e.getLocalizedMessage());
            return milhars;
        }

    }

    @SuppressWarnings("unchecked")
    public String agregarElementos(HttpSession session, HttpServletRequest request, List<Milhar> products) {
        try {

            products = (ArrayList<Milhar>) request.getSession().getAttribute("meuCarrinho");
            List<Milhar> elementos = agregarElemento(request);
            if (elementos.size() == 5) {
                products = carregandoCarrinho(products, elementos);
                session = request.getSession(true);
                session.setAttribute("meuCarrinho", products);
                request.setAttribute("msg", " A sequência de " + products.size()
                        + " numeros está valida siga para o preenchimento do formulário. ");

            } else {
                request.setAttribute("valid", "Existe apenas " + (5-elementos.size())
                        + " milhar(s) indisponível na sequência. É preciso Corrige!");
            }
        } catch (Exception e) {
            System.out.println("invalido!");
        }
        return "controller?operacao=CarrinhoController&carrinho=loja";

    }

    public List<Milhar> dobroDeElemento(HttpServletRequest request) {
        ArrayList<Milhar> dobroElementos = new ArrayList();
        dobroElementos.clear();
        Milhar milhar1 = ms.getJogo(request.getParameter("milhar01"));
        Milhar milhar2 = ms.getJogo(request.getParameter("milhar02"));
        Milhar milhar3 = ms.getJogo(request.getParameter("milhar03"));
        Milhar milhar4 = ms.getJogo(request.getParameter("milhar04"));
        Milhar milhar5 = ms.getJogo(request.getParameter("milhar05"));
        Milhar milhar6 = ms.getJogo(request.getParameter("milhar06"));
        Milhar milhar7 = ms.getJogo(request.getParameter("milhar07"));
        Milhar milhar8 = ms.getJogo(request.getParameter("milhar08"));
         Milhar milhar9 = ms.getJogo(request.getParameter("milhar09"));
        Milhar milhar10 = ms.getJogo(request.getParameter("milhar10"));
        if (Objects.nonNull(milhar1)) {
            dobroElementos.add(milhar1);
        }

        if (Objects.nonNull(milhar2)) {
            dobroElementos.add(milhar2);
        }

        if (Objects.nonNull(milhar3)) {
            dobroElementos.add(milhar3);
        }

        if (Objects.nonNull(milhar4)) {
            dobroElementos.add(milhar4);
        }

        if (Objects.nonNull(milhar5)) {
            dobroElementos.add(milhar5);
        }

        if (Objects.nonNull(milhar6)) {
            dobroElementos.add(milhar6);
        }

        if (Objects.nonNull(milhar7)) {
            dobroElementos.add(milhar7);
        }
        
        if (Objects.nonNull(milhar8)) {
            dobroElementos.add(milhar8);
        }
        
        if (Objects.nonNull(milhar9)) {
            dobroElementos.add(milhar9);
        }
        
        if (Objects.nonNull(milhar10)) {
            dobroElementos.add(milhar10);
        }

        return dobroElementos;
    }

    public String dobroDeElementos(HttpSession session, List<Milhar> products, HttpServletRequest request) {
        try {

            List<Milhar> elementos = dobroDeElemento(request);
            if (elementos.size() == 10) {
                products = carregandoCarrinho(products, elementos);
                session = request.getSession(true);
                session.setAttribute("meuCarrinho", products);
                request.setAttribute("msg", " A sequência de " + products.size()
                        + " numeros está valida siga para o preenchimento do formulário. ");
            } else {
                request.setAttribute("valid", "Existe " + (10-elementos.size())
                        + " milhar(s) indisponível na sequência. É preciso Corrige!");
            }

            return "controller?operacao=CarrinhoController&carrinho=loja";

        } catch (Exception e) {
            request.setAttribute("valid", "Erro na sequência não está completa!");
            System.out.println(e.getLocalizedMessage());
            return "controller?operacao=CarrinhoController&carrinho=loja";
        }
    }

    public String descarrengandoCarrinho(HttpServletRequest request, List<Milhar> jogos) {
        String value = ms.getJogo(request.getParameter("idJogo")).getValue();
        System.out.println("Numero para exclusão: " + value);
        jogos.remove(posicao(ms.getJogo(value), jogos));
        return "controller?operacao=CarrinhoController&carrinho=loja";
    }

    public List<Milhar> carregandoCarrinho(List<Milhar> products, Milhar jogo) {
        if (Objects.isNull(products)) {
            products = new ArrayList<Milhar>();
        }

        if (seNãoExiste(jogo.getValue(), products) && !Objects.equals(jogo.getValue(), "")
                && jogo.getValue().length() == 4) {
            products.add(jogo);
        }

        return products;
    }

    public List<Milhar> carregandoCarrinho(List<Milhar> products, Collection<Milhar> all) {

        if (Objects.isNull(products)) {
            products = new ArrayList<Milhar>();
            products.clear();
        }
        for (Milhar action : all) {
            if (seNãoExiste(action.getValue(), products)) {
                products.add(action);
            }
        }

        return products;
    }

    private static boolean validarIgual(String value, String value2) {
        return Objects.equals(value, value2);
    }

    public int posicao(Milhar milhar, List<Milhar> jogos) {
        int pos = -1;
        for (int i = 0; i < jogos.size(); i++) {
            Milhar jogo = jogos.get(i);
            // (71) 99902-6825 galega
            if (validarIgual(jogo.getValue(), milhar.getValue())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    private boolean seNãoExiste(String value, List<Milhar> jogos) {
        boolean validate = false;
        for (Milhar jogo : jogos) {
            if (validarIgual(value, jogo.getValue())) {
                validate = true;
            }
        }
        if (validate) {
            System.out.println("Existe o numero");
        }
        return !validate;
    }

    private String carregarLojadeMilhar(HttpServletRequest request) {
        try {
            request.setAttribute("enderecos", ls.getLocals());
            request.setAttribute("compras", sc.selecioneCartelasVendidasNoDia());

        } catch (Exception e) {
            System.err.println("Erro:" + e);

        }
        return "views/cartela/compras.jsp";

    }

}
