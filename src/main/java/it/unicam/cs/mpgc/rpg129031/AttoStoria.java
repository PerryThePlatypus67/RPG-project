package it.unicam.cs.mpgc.rpg129031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class AttoStoria {

    private final InAtto atto;

    public AttoStoria(InAtto atto) {
        this.atto = atto;
    }

    public void avviaNarrazione(Scanner scanner, Giocatore giocatore) {
        System.out.println("=== " + atto.getDescrizione().toUpperCase() + " ===");
        mostraStoriaDaFile();

        List<Opzioni> opzioni = atto.getOpzioni();
        if (opzioni == null || opzioni.isEmpty()) return;

        System.out.println("\n--- COSA VUOI FARE? (Scrivi 'ESCI' per chiudere) ---");
        for (int i = 0; i < opzioni.size(); i++) {
            System.out.println((i + 1) + ". " + opzioni.get(i).getDescrizione());
        }

        System.out.print("\nInserisci il numero della tua scelta: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("esci")) {
            throw new Uscita();
        }

        try {
            int sceltaIndex = Integer.parseInt(input) - 1;
            if (sceltaIndex >= 0 && sceltaIndex < opzioni.size()) {
                opzioni.get(sceltaIndex).esegui(giocatore, scanner, this.atto);
            } else {
                System.out.println("Scelta fuori range! Riprova.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input non valido!");
        }
    }
    private void mostraStoriaDaFile() {
        String nomeFile = atto.getNomeFileStoria() + ".txt";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nomeFile)) {
            if (inputStream == null) {
                System.err.println("DEBUG: File non trovato nel classpath: " + nomeFile);
                return;
            }

            System.out.println("\n--- STORIA ---");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                reader.lines().forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println("Errore critico durante la lettura del file " + nomeFile + ": " + e.getMessage());
        }
    }
}