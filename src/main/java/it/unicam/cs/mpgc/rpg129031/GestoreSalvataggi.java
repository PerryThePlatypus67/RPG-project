package it.unicam.cs.mpgc.rpg129031;

import java.io.*;

public class GestoreSalvataggi {
    private static final String FILE_SALVATAGGIO = "partita.dat";

    public static void salva(Giocatore g, InAtto attoAttuale) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SALVATAGGIO))) {
            oos.writeObject(g);
        }
    }

    public static Giocatore carica() throws IOException, ClassNotFoundException {
        File file = new File(FILE_SALVATAGGIO);
        if (!file.exists()) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SALVATAGGIO))) {
            return (Giocatore) ois.readObject();
        }
    }
}