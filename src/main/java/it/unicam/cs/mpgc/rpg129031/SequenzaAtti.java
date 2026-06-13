package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public class SequenzaAtti {
    private final List<InAtto> atti;
    private int indiceCorrente = 0;

    public SequenzaAtti(List<InAtto> atti) {
        this.atti = atti;
    }

    public InAtto corrente() {
        return atti.get(indiceCorrente);
    }

    public boolean haAncoraAtti() {
        return indiceCorrente < atti.size();
    }

    public boolean avanza() {
        if (indiceCorrente < atti.size() - 1) {
            indiceCorrente++;
            return true;
        }
        return false;
    }
}