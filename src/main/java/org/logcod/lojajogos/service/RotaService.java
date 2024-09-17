
package org.logcod.lojajogos.service;

import java.util.LinkedHashSet;
import org.logcod.lojajogos.model.entity.Rota;
import org.logcod.lojajogos.repository.RepositoryRota;

public class RotaService {
    
    private RepositoryRota rr;

    public RotaService(RepositoryRota rr) {
        this.rr = rr;
    }
    
    public LinkedHashSet<Rota> listaRotasAS() {
        return rr.listaRotasAS();
    }

    public Rota buscarRotasAS(int id) {
        return rr.buscarRotasAS(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
