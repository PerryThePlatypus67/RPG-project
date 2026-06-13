package it.unicam.cs.mpgc.rpg129031;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String ROSSO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String CIANO = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Giocatore giocatore = null;
        InAtto attoAttuale = null;

        List<StatisticheAtto> listaStatistiche = new ArrayList<>();

        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("configurazione.json")) {
            if (is == null) {
                throw new Exception("File configurazione.json non trovato in src/main/resources!");
            }
            try (Reader reader = new InputStreamReader(is)) {
                ConfigurazioneAtti config = new Gson().fromJson(reader, ConfigurazioneAtti.class);
                listaStatistiche = config.giocatore_pre_set;
            }
        } catch (Exception e) {
            System.out.println(ROSSO + "Errore critico: " + e.getMessage() + RESET);
            System.exit(1);
        }

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
                giocatore.setListaStatistiche(listaStatistiche);
                attoAttuale = Atto.ATTO_0;
                menuIniziale = false;
            } else if (scelta.equals("2")) {
                try {
                    giocatore = GestoreSalvataggi.carica();
                    if (giocatore != null) {
                        giocatore.setListaStatistiche(listaStatistiche);
                        attoAttuale = Atto.ATTO_0;
                        menuIniziale = false;
                    } else {
                        System.out.println(ROSSO + "Nessun salvataggio trovato." + RESET);
                    }
                } catch (Exception e) {
                    System.out.println(ROSSO + "Errore caricamento: " + e.getMessage() + RESET);
                }
            }
        }


        if (giocatore != null) {
            stampaScheda(giocatore, attoAttuale);
        }
    }

    static void stampaScheda(Giocatore g, InAtto a) {
        if (g == null) return;
        System.out.println(CIANO + "\n--- SCHEDA EROE ---" + RESET);
        System.out.println("Nome: " + g.getNome() +
                " | HP: " + g.getHpAttuali() + "/" + g.getHpMax() +
                " | ATK: " + g.getAttacco() +
                " | DEF: " + g.getDifesa());
    }
}