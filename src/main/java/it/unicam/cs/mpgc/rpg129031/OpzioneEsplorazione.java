package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class OpzioneEsplorazione implements Opzioni {
    private String descrizione;

    public OpzioneEsplorazione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public void esegui(Giocatore giocatore, Scanner scanner, InAtto atto) {
        System.out.println("\nStai esplorando l'area circostante...");
        System.out.println("Non hai trovato nulla di particolare, ma la via è libera.");
    }
}