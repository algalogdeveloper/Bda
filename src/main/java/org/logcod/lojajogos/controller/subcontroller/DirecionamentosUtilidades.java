package org.logcod.lojajogos.controller.subcontroller;

public class DirecionamentosUtilidades {

    public double calcularValorCompra(double valor, int size, int qtdCartelas) {
        try {
            return valor * (size / qtdCartelas);
        } catch (Exception e) {
            return 0;
        }

    }

    public static Integer pegarQuantidade(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            System.out.println("Erro: " + e.getLocalizedMessage());
            return 0;
            // TODO: handle exception
        }
    }

}
