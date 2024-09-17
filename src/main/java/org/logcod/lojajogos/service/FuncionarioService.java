package org.logcod.lojajogos.service;

import java.util.Collection;
import java.util.Objects;

import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.repository.RepositoryFuncionario;

public class FuncionarioService {

    RepositoryFuncionario rf = new RepositoryFuncionario();

    public String createFuncionario(Funcionario f) {
        Funcionario funcionario = getFuncionario(f.getIdFuncionario());
        String message;
        if (Objects.isNull(funcionario)) {
            funcionario = rf.save(f);
            message = "Funcionario foi cadastrado com sucesso: " + f.getNome();
        } else {
            funcionario = rf.update(f);
            message = "Funcionario foi modificado com sucesso: " + f.getNome();
        }

        return message;
    }

    public Funcionario getFuncionario(int id) {
        return rf.getFuncionario(id);
    }

    public Funcionario obter(String email) {
        return rf.obter(email);
    }

    public boolean validarLogin(String login, String senha) {
        return rf.validarLogin(login, senha);
    }

    public Collection<Funcionario> getFuncionarios(int limit) {
        return rf.getFuncionarios(limit);
    }

    public Collection<Funcionario> consultarFuncionarios(String consulta) {
        return rf.consultarFuncionarios(consulta);
    }

    public Funcionario logarFuncionario(String login, String senha) {
        return rf.logar(login, senha);
    }

    static FuncionarioService fs = new FuncionarioService();

    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.setNome("Reizinho");
        // f.setEmail("bolao@gmail.com");
        f.setLogin("reizinho");
        f.setContato("AAAA-BBBB");
        f.setPermissao(0);
        f.setSenha("reizinho");
        System.out.println(f);
        System.out.println("Acesso: " + fs.logarFuncionario("reizinho", "reizinho"));
    }

}
