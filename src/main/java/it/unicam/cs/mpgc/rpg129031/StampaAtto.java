package it.unicam.cs.mpgc.rpg129031;

public class StampaAtto {
    public void stampa(InAtto atto) {
        System.out.println("\n=========================================");
        System.out.println(" ATTO " + atto.getNumeroAtto() + ": " + atto.getDescrizione());
        System.out.println("=========================================");
    }
}