package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public class AttoStatistiche {

    public static void applica(Giocatore giocatore, InAtto atto) {
        List<StatisticheAtto> listaStatistiche = CaricatoreJson.carica("statistiche.json");

        StatisticheAtto stats = listaStatistiche.stream()
                .filter(s -> s.numero == atto.getNumeroAtto())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Statistiche non trovate per l'atto " + atto.getNumeroAtto()));

        giocatore.setHpMax(stats.vita);
        giocatore.setAttacco(stats.attacco);
        giocatore.setDifesa(stats.difesa);
        giocatore.setAttaccoElementare(stats.dannoelementare);
        giocatore.setCritDMG(stats.critDMG);
        giocatore.setCritRate(stats.critRate);
        giocatore.setVelocita(stats.velocita);

        System.out.println("Statistiche applicate per l'elemento: " + stats.elemento);
    }
}