package classi_con_SOLID;

import classi_senza_SOLID.Elemento;

public class GestoreElementi {
    public static boolean VantaggioElementale(Elemento attaccante, Elemento difensore) {
    if (attaccante == Elemento.NEUTRO || difensore == Elemento.NEUTRO) {
        return false;
    }

        return switch (attaccante) {
            case VENTO -> difensore == Elemento.TERRA;
            case NEBBIA -> difensore == Elemento.BESTIA;
            case BESTIA -> difensore == Elemento.SERPENTE;
            case SERPENTE -> difensore == Elemento.FIORE;
            case AMORE -> difensore == Elemento.NEBBIA;
            default -> false;
        };
    }
}
