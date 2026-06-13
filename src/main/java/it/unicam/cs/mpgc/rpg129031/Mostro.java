package it.unicam.cs.mpgc.rpg129031;

public class Mostro extends Statistiche implements InCombattimento {


    public Mostro(String nome, int hpMax, int attacco, int difesa, int velocita) {
        super(nome, hpMax, attacco, difesa, velocita);
        this.setHpAttuali(hpMax);
    }

    @Override
    public void subisciDanno(int danno) {
        int nuovaVita = Math.max(0, this.getHpAttuali() - danno);
        this.setHpAttuali(nuovaVita);
        System.out.println(this.getNome() + " ha subito " + danno + " danni!");
    }

    @Override
    public boolean isVivo() {
        return this.getHpAttuali() > 0;
    }

    @Override
    public void eseguiTurno() {

    }
}