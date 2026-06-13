package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class InterfacciaCreazione {
    public Giocatore avvia(Scanner scanner) {
        System.out.print("Inserisci il nome del tuo personaggio: ");
        String nome = scanner.nextLine();

        CatalogoArmi catalogo = new CatalogoArmi();
        return CreazioneGiocatore.creaGiocatore(nome, catalogo);
    }
}