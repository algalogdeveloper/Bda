package org.logcod.lojajogos.service;
import java.util.LinkedHashSet;
import org.logcod.lojajogos.model.entity.Milhar;

public class CarrinhoService {

    private static CarrinhoService carrinhoService;

    public static CarrinhoService createCarrinho() {
        return (carrinhoService == null) ? new CarrinhoService() : carrinhoService;
    }

    public LinkedHashSet<Milhar> carrinhoUiAdd(LinkedHashSet<Milhar> carrinho, Milhar milhar) {
        if (carrinho == null) {
            carrinho = new LinkedHashSet<>();
        }
        if (milhar.getValue().length() > 0) {
            if (!validandoNumero(milhar.getValue(), carrinho)) {
                carrinho.add(milhar);
            }
        }
        return carrinho;
    }

    public LinkedHashSet<Milhar> update(LinkedHashSet<Milhar> carrinho, Milhar newNumero, Milhar oldNumero) {
        for (Milhar milhar : carrinho) {
            if (milhar.getValue().equals(oldNumero.getValue())) {
                milhar.setIdMilhar(newNumero.getIdMilhar());
                milhar.setValue(newNumero.getValue());
                break;
            }
        }
        return carrinho;
    }

    public boolean validandoNumero(String numero, LinkedHashSet<Milhar> numeros) {
        for (Milhar n : numeros) {
            if (n.getIdMilhar().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public boolean excluirNumero(LinkedHashSet<Milhar> numeros, String chave) {
        try {
           
            return numeros.removeIf(r -> r.getIdMilhar() == Integer.parseInt(chave));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public LinkedHashSet<Milhar> removerMilhar(LinkedHashSet<Milhar> carrinhoCliente, String numero) {
        for (Milhar milhar : carrinhoCliente) {
            if (milhar.getValue().equalsIgnoreCase(numero)) {
                carrinhoCliente.remove(milhar);
                break;
            }
        }
        return carrinhoCliente;

    }
}
