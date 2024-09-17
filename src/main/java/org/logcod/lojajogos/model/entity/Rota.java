
package org.logcod.lojajogos.model.entity;

import java.util.LinkedHashSet;

public class Rota {
    private int idRota;
    private int numeroRota;
    private LinkedHashSet<Local> locais;

    public Rota() {
    }

    public Rota(int idRota, int numeroRota) {
        this.idRota = idRota;
        this.numeroRota = numeroRota;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public int getNumeroRota() {
        return numeroRota;
    }

    public void setNumeroRota(int numeroRota) {
        this.numeroRota = numeroRota;
    }

    public void setLocais(LinkedHashSet<Local> locais) {
        this.locais = locais;
    }

    public LinkedHashSet<Local> getLocais() {
        return locais;
    }
    
    
    
}
