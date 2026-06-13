package it.unicam.cs.mpgc.rpg129031;

public class CalcolatoreCombattimento {


    public static int calcola(Statistiche attacco, Statistiche difesa, Arma arma) {
        int dannoArma = (arma != null) ? arma.getDanno() : 0;
        return calcolaDannoFisico(attacco, difesa) + dannoArma;
    }

    private static int calcolaDannoFisico(Statistiche att, Statistiche dif) {
        return Math.max(0, att.getAttacco() - (dif.getDifesa() / 10));
    }
}