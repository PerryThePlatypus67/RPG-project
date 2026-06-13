package classi_con_SOLID;

import classi_senza_SOLID.Elemento;

public class CalcolatoreCombattimento {


    public static int calcola(Statistiche att, Statistiche dif, Elemento el, StatisticheArmi arma) {
        int dannoArma = (arma != null) ? arma.getDanni() : 0;
        return calcolaDannoFisico(att, dif) + dannoArma + calcolaDannoElementale(att, dif, el);
    }

    private static int calcolaDannoFisico(Statistiche att, Statistiche dif) {
        return Math.max(0, att.getAttacco() - (dif.getDifesa() / 10));
    }

    private static int calcolaDannoElementale(Statistiche att, Statistiche dif, Elemento el) {
        return GestoreElementi.VantaggioElementale(el, dif.getElementoInCombattimento())
                ? att.getAttaccoElementare()
                : 0;
    }
}