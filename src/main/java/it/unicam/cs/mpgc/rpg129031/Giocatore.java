package it.unicam.cs.mpgc.rpg129031;

import java.io.Serializable;

public class Giocatore extends Statistiche implements InCombattimento, Serializable {
    private static final long serialVersionUID = 1L;
    private Arma armaEquipaggiata;
    private int livello;

    public Giocatore(String nome, int hpMax, int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare) {
        super(nome, hpMax, attacco, difesa, velocita, critRate, critDMG, attaccoElementare);
        this.setHpAttuali(hpMax);
        this.livello = 1;
    }

    public Giocatore(String nome, int hpAttuali) {
        // Valori di default per le statistiche non presenti nel salvataggio
        super(nome, hpAttuali, 10, 5, 5, 0, 0, 0);
        this.setHpAttuali(hpAttuali);
        this.livello = 1;
    }

    public void adeguaStatistichePerAtto(int numeroAtto) {
        switch (numeroAtto) {
            case 0: // ATTO 0
                this.setAttacco(10);
                this.setDifesa(5);
                break;
            case 1: // ATTO 1
                this.setAttacco(20);
                this.setDifesa(10);
                break;
            case 2: // ATTO 2
                this.setAttacco(35);
                this.setDifesa(20);
                break;
            default:
                this.setAttacco(50);
                break;
        }
        System.out.println("Statistiche aggiornate per l'Atto " + numeroAtto);
    }

    public void equipaggiaArma(Arma nuovaArma) {
        this.armaEquipaggiata = nuovaArma;
        System.out.println("Hai equipaggiato: " + nuovaArma.getNome());
    }

    public Arma getArmaEquipaggiata() { return armaEquipaggiata; }

    @Override
    public String getElementoInCombattimento() {
        return (this.armaEquipaggiata != null) ? this.armaEquipaggiata.getElemento() : "NEUTRO";
    }

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