package it.unicam.cs.mpgc.rpg129031;

public class Opzione {
    private String descrizione;
    private Runnable azione;

    public Opzione(String descrizione, Runnable azione) {
        this.descrizione = descrizione;
        this.azione = azione;
    }

    public String getDescrizione() { return descrizione; }
    public void esegui() { azione.run(); }
}