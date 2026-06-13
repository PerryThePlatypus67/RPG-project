package classi_con_SOLID;

import it.unicam.cs.mpgc.rpg129031.Main;

public class BarraUI {
    private static final int LUNGHEZZA = 10;

    public static String genera(IValoreMisurabile valore) {
        int attuale = valore.getValoreAttuale();
        int max = valore.getValoreMassimo();

        if (max <= 0) max = 1;

        attuale = Math.max(0, Math.min(attuale, max));

        int quadrantiPieni = (int) ((double) attuale / max * LUNGHEZZA);

        StringBuilder sb = new StringBuilder("[");

        String colore = ((double) attuale / max <= 0.3) ? Main.ROSSO : Main.VERDE;

        sb.append(colore);
        for (int i = 0; i < LUNGHEZZA; i++) {
            sb.append(i < quadrantiPieni ? "■" : " ");
        }
        sb.append(Main.RESET).append("]");
        return sb.toString();
    }
}