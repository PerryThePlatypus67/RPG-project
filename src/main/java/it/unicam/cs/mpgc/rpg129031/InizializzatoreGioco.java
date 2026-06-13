package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class InizializzatoreGioco {

    public static Giocatore creaNuovoGiocatore(Scanner scanner, CatalogoArmi catalogo) {
        System.out.print("Inserisci il nome del tuo eroe: ");
        String nome = scanner.nextLine();

        Giocatore g = new Giocatore(nome, 100, 15, 10, 5, 0, 0, 0);

        g.equipaggiaArma(catalogo.getArma("Spada"));

        return g;
    }
}