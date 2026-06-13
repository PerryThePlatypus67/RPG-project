package it.unicam.cs.mpgc.rpg129031;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestoreStoria {

    public static List<String> caricaAtto(String nomeFile) {
        List<String> paragrafi = new ArrayList<>();

        try (InputStream is = GestoreStoria.class.getClassLoader().getResourceAsStream(nomeFile)) {

            if (is == null) {
                System.err.println("File non trovato in resources: " + nomeFile);
                return paragrafi;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String riga;
                while ((riga = br.readLine()) != null) {
                        paragrafi.add(riga);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + nomeFile);
            e.printStackTrace();
        }
        return paragrafi;
    }
}