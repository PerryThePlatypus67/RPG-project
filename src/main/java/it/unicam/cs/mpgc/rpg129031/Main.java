package it.unicam.cs.mpgc.rpg129031;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String ROSSO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String GIALLO = "\u001B[33m";
    public static final String CIANO = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Giocatore giocatore = null;
        InAtto attoAttuale = null;

        boolean menuIniziale = true;
        while (menuIniziale) {
            System.out.println("\n" + CIANO + "---------- ARCANE SOLARIUM ----------" + RESET);
            System.out.println("1. Nuova Partita | 2. Continua | 3. Esci");
            String scelta = scanner.nextLine();

            if (scelta.equalsIgnoreCase("esci") || scelta.equals("3")) {
                System.out.println("Chiusura gioco...");
                System.exit(0);
            } else if (scelta.equals("1")) {
                CatalogoArmi catalogo = new CatalogoArmi();
                giocatore = InizializzatoreGioco.creaNuovoGiocatore(scanner, catalogo);
                attoAttuale = Atto.ATTO_0;
                menuIniziale = false;
            } else if (scelta.equals("2")) {
                try {
                    Giocatore salvataggio = GestoreSalvataggi.carica();
                    if (salvataggio != null) {
                        giocatore = salvataggio;
                        attoAttuale = Atto.ATTO_0;
                        System.out.println(VERDE + "Partita caricata con successo!" + RESET);
                        menuIniziale = false;
                    } else {
                        System.out.println(ROSSO + "Nessun salvataggio trovato." + RESET);
                    }
                } catch (Exception e) {
                    System.out.println(ROSSO + "Errore nel caricamento: " + e.getMessage() + RESET);
                }
            }
        }

        stampaScheda(giocatore, attoAttuale);

        try {
            while (giocatore.isVivo()) {
                HubControl hub = new HubControl();
                hub.avviaHub(giocatore, attoAttuale, scanner);
                AttoStoria storia = new AttoStoria(attoAttuale);
                storia.avviaNarrazione(scanner, giocatore);

                if (attoAttuale instanceof Atto) {
                    Atto a = (Atto) attoAttuale;
                    int prossimoIndice = a.ordinal() + 1;
                    if (prossimoIndice < Atto.values().length) {
                        attoAttuale = Atto.values()[prossimoIndice];
                        giocatore.adeguaStatistichePerAtto(prossimoIndice);
                    } else {
                        System.out.println(VERDE + "Hai completato il gioco!" + RESET);
                        break;
                    }
                }
            }
        } catch (Uscita e) {
            try {
                GestoreSalvataggi.salva(giocatore, attoAttuale);
            } catch (IOException ex) {
                System.out.println(ROSSO + "Errore salvataggio." + RESET);
            }
        }
    }

    static void stampaScheda(Giocatore g, InAtto a) {
        System.out.println(CIANO + "\n--- SCHEDA EROE ---" + RESET);
        System.out.println("Nome: " + g.getNome() +
                " | HP: " + g.getHpAttuali() + "/" + g.getHpMax() +
                " | ATK: " + g.getAttacco() +
                " | VEL: " + g.getVelocita() +
                " | DEF: " + g.getDifesa());
    }
}