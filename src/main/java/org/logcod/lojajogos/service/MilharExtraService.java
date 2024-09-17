
package org.logcod.lojajogos.service;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.MilharExtra;
import org.logcod.lojajogos.repository.MilharExtraRepository;
import static org.logcod.lojajogos.service.CompraService.ms;
import static org.logcod.lojajogos.service.CompraService.repositoryCompra;

@AllArgsConstructor
public class MilharExtraService {
    
    private MilharExtraRepository mr;
    
    public boolean enviandoMilharExtra(MilharExtra me){
        return mr.enviarMilharExtra(me);
    }
    
    public Set<MilharExtra> buscarMilharExtra(String value){
        return mr.buscarMilharExtraPorNumero(value);
    }
    
    public Set<MilharExtra> buscarMilharId(int value){
        return mr.buscarMilharExtraPorId(value);
    }
    
    public boolean enviandoNumerosExtra(int idcompra, String numerosExtras[]) {
        Compra compra = repositoryCompra.obterCompra(idcompra);
        boolean envia = false;
        for (String ne : numerosExtras) {
            MilharExtra me = new MilharExtra(compra, ms.getJogo(ne).getValue());
            envia = enviandoMilharExtra(me);
        }
        System.out.println("envia:" + envia);
        return envia;
    } 
}
