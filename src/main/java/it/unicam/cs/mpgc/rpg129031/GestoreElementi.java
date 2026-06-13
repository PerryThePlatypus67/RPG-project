package it.unicam.cs.mpgc.rpg129031;

public class GestoreElementi {

    public static boolean VantaggioElementale(String attaccante, String difensore) {
        if (attaccante == null || difensore == null ||
                attaccante.equalsIgnoreCase("NEUTRO") || difensore.equalsIgnoreCase("NEUTRO")) {
            return false;
        }

        return switch (attaccante.toUpperCase()) {
            case "VENTO"    -> difensore.equalsIgnoreCase("TERRA");
            case "NEBBIA"   -> difensore.equalsIgnoreCase("BESTIA");
            case "BESTIA"   -> difensore.equalsIgnoreCase("SERPENTE");
            case "SERPENTE" -> difensore.equalsIgnoreCase("FIORE");
            case "AMORE"    -> difensore.equalsIgnoreCase("NEBBIA");
            default         -> false;
        };
    }
}