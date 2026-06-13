package it.unicam.cs.mpgc.rpg129031;

import java.io.Serializable;
import java.util.List;

public class Giocatore extends Statistiche implements InCombattimento, Serializable {
    private static final long serialVersionUID = 1L;
    private Arma armaEquipaggiata;

    public Giocatore(String nome, int hpMax, int attacco, int difesa, int velocita) {
        super(nome, hpMax, attacco, difesa, velocita);
        this.setHpAttuali(hpMax);
    }

    public Giocatore(String nome, int hpAttuali) {
        super(nome, hpAttuali, 10, 5, 5);
        this.setHpAttuali(hpAttuali);
    }
    private List<StatisticheAtto> listaStatistiche;

    public void setListaStatistiche(List<StatisticheAtto> lista) {
        this.listaStatistiche = lista;
    }

    public void adeguaStatistichePerAtto(int numeroAtto) {
        if (listaStatistiche == null) return;

        StatisticheAtto stats = listaStatistiche.stream()
                .filter(s -> s.numero == numeroAtto)
                .findFirst()
                .orElse(null);

        if (stats != null) {
            this.setHpMax(stats.vita);
            this.setHpAttuali(stats.vita);
            this.setAttacco(stats.attacco);
            this.setDifesa(stats.difesa);
            this.setVelocita(stats.velocita);
        }
    }

    public void equipaggiaArma(Arma nuovaArma) {
        this.armaEquipaggiata = nuovaArma;
        System.out.println("Hai equipaggiato: " + nuovaArma.getNome());
    }

    public Arma getArmaEquipaggiata() { return armaEquipaggiata; }


    @Override
    public void subisciDanno(int danno) {
        this.setHpAttuali(this.getHpAttuali() - danno);
        System.out.println(this.getNome() + " ha subito " + danno + " danni! HP: " + this.getHpAttuali());
    }

    @Override
    public boolean isVivo() { return this.getHpAttuali() > 0; }

    @Override
    public void eseguiTurno() { }
}