package it.unicam.cs.mpgc.rpg129031;

public class CalcolatoreCombattimento {


    public static int calcola(Statistiche attacco, Statistiche difesa, String elemento, StatisticheArmi arma) {
        int dannoArma = (arma != null) ? arma.getDanni() : 0;
        return calcolaDannoFisico(attacco, difesa) + dannoArma + calcolaDannoElementale(attacco, difesa, elemento);
    }

    private static int calcolaDannoFisico(Statistiche att, Statistiche dif) {
        return Math.max(0, att.getAttacco() - (dif.getDifesa() / 10));
    }

    private static int calcolaDannoElementale(Statistiche att, Statistiche dif, String elemento) {
        return GestoreElementi.VantaggioElementale(elemento, dif.getElementoInCombattimento())
                ? att.getAttaccoElementare()
                : 0;
    }
}