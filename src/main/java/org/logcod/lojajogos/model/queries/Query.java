package org.logcod.lojajogos.model.queries;

public class Query {

    public static String createQueryMilharVinculadoAhPessoa() {
        String query = "select j.idjogo as idjogo, j.numero as numero, j.disponivel as disponivel from pessoa p inner join compra c"
                + " on p.idpessoa = c.idpessoa inner join aposta a"
                + " on c.idcompra = a.idcompra inner join jogo j "
                + " on a.idjogo = j.idjogo where j.numero like ? and not j.disponivel ";
        return query;

    }
}
