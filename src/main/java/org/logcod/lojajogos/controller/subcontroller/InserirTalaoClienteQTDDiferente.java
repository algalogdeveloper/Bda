package org.logcod.lojajogos.controller.subcontroller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.LocalService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class InserirTalaoClienteQTDDiferente implements Action {

    LocalService ls = new LocalService();
    MilharService ms = new MilharService();
    List<Milhar> milhars = new ArrayList<>();
    CompraService cs = new CompraService();
    PessoaService ps = new PessoaService();
    FuncionarioService fs = new FuncionarioService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Local endereco = ls.get(Integer.parseInt(request.getParameter("endereco_cliente")));
        try {
            String cliente_name = request.getParameter("CLIENTE_NAME");
            String[] values = request.getParameter("lista").split(" +");
            int count = 0;
            int inserido = 0;
            for (String d : values) {
                Milhar milhar = ms.getJogo(d);
                if (Objects.nonNull(milhar)) {
                    milhars.add(milhar);
                    count++;
                } else {
                    inserido++;
                }
            }

            Pessoa pessoaValid = ps.referenciaCartela(milhars.get(0).getValue());
            if (Objects.isNull(pessoaValid)) {

                Compra compra = new Compra();
                compra.setPremio("R$ 5.500,00");
                compra.setValorBilhete( cs.menorValordoCanhoto() );
                compra.setDataJogo(Calendar.getInstance());
                Pessoa pessoa = new Pessoa(cliente_name, endereco);
                pessoa.setReferencia(milhars.get(0).getValue());
                pessoa.setContato(milhars.get(0).getValue());
                compra.setPessoa(ps.save(pessoa));
                compra.setQtd_cartela(milhars.size()/cs.menorQtdnoCanhoto());
                compra.setDesconto(0);
                compra.setQtdAlternativa(cs.menorQtdnoCanhoto());
                compra.setNumero_cartela(milhars.get(0).getValue());
                compra.setValor((compra.getValorBilhete() * compra.getQtd_cartela()) - compra.getDesconto());
                compra.setPagou(false);
                Funcionario funcionarioLogado = fs
                        .getFuncionario((Integer) request.getSession().getAttribute("chave_acesso"));
                compra.setFuncionario(funcionarioLogado);

                if (milhars.size() == count && milhars.size() < 10 && inserido == 0) {
                    Compra minhaCompra = cs.save(compra, milhars);
                    if (Objects.nonNull(minhaCompra)) {
                        request.setAttribute("msg", "As informações do talão de " + minhaCompra.getPessoa().getNome() + " foram enviadas: " + minhaCompra.getApostas()
                                .toString().replace("[", "")
                                .replace("]", ""));
                    } else {
                        request.setAttribute("valid", "Não foi possível salvar aposta!");
                    }

                } else {
                    request.setAttribute("valid", "Existe milhar vendido na sequência.");

                }

            } else {
                request.setAttribute("valid", "Existe milhar vendido na aposta!");

            }
            inserido = 0;
            return "controller?operacao=ConsultasController&consulta=compras&buscar=" + endereco.getIdLocal();
        } catch (Exception e) {
            request.setAttribute("valid", "Existe milhar vendido na sequência!");
            return "controller?operacao=ConsultasController&consulta=compras&buscar=" + endereco.getIdLocal();

        }

    }

}
