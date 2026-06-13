package it.unicam.cs.mpgc.rpg129031;

import java.util.*;
import java.io.*;

public class CaricatoreJson {
    public static List<StatisticheAtto> carica(String nomeFile) {

        try (InputStream is = CaricatoreJson.class.getClassLoader().getResourceAsStream(nomeFile)) {
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String json = s.hasNext() ? s.next() : "";
            return parseManuale(json);
        } catch (Exception e) {
            System.err.println("Errore caricamento JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static List<StatisticheAtto> parseManuale(String json) {
        return new ArrayList<>();
    }
}