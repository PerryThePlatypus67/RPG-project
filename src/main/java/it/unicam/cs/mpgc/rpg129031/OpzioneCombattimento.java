package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class OpzioneCombattimento implements Opzioni {
    private String descrizione;

    public OpzioneCombattimento(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String getDescrizione() { return descrizione; }


    @Override
    public void esegui(Giocatore g, Scanner scanner, InAtto atto) {
        GestoreCombattimento gestore = new GestoreCombattimento();
        String nomeNemico;

        if (atto.getNumeroAtto() == 0) {
            nomeNemico = "Uccello";
        } else if (atto.getNumeroAtto() == 2) {
            nomeNemico = "Guardiano delle Rovine";
        } else {
            nomeNemico = "Uccello del Malefuffaguru";
        }

        gestore.avviaCombattimento(g, scanner, nomeNemico);
    }
}