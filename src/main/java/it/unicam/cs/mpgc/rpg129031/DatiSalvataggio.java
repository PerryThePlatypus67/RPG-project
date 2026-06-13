package it.unicam.cs.mpgc.rpg129031;

import java.io.Serializable;

public class DatiSalvataggio implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Giocatore giocatore;
    private final InAtto atto;

    public DatiSalvataggio(Giocatore giocatore, InAtto atto) {
        this.giocatore = giocatore;
        this.atto = atto;
    }

    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    public InAtto getAtto() {
        return this.atto;
    }
}