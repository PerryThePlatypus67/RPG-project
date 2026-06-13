package it.unicam.cs.mpgc.rpg129031;

public class Mostro extends Statistiche implements InCombattimento {

    private String elementoNativo;
    private int dannoArma;

    public Mostro(String nome, int hpMax, int attacco, int difesa, int velocita,
                  int critRate, int critDMG, int attaccoElementare, String elementoNativo, int dannoArma) {
        super(nome, hpMax, attacco, difesa, velocita, critRate, critDMG, attaccoElementare);
        this.elementoNativo = elementoNativo;
        this.dannoArma = dannoArma;
        this.setHpAttuali(hpMax);
    }

    @Override
    public String getElementoInCombattimento() {
        return this.elementoNativo;
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

    public String getElementoNativo() { return elementoNativo; }
    public void setElementoNativo(String elementoNativo) { this.elementoNativo = elementoNativo; }
    public int getDannoArma() { return dannoArma; }
}