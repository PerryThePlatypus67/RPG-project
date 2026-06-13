package classi_con_SOLID;

import classi_senza_SOLID.Elemento;

public class Mostro extends Statistiche {
    private Elemento elementoNativo;
    private int dannoArma;

    public Mostro(String nome, int hpMax, int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare, Elemento elementoNativo){
        super(nome, hpMax, attacco, difesa, velocita, critRate, critDMG, attaccoElementare);
       this.elementoNativo = elementoNativo;
       this.dannoArma = dannoArma;

    }

    public Elemento getElementoNativo() { return elementoNativo; }

    public void setElementoNativo(Elemento elementoNativo) {
        this.elementoNativo = elementoNativo;
    }

    @Override
    public Elemento getElementoInCombattimento(){
        return this.elementoNativo;
    }

    @Override
    public void eseguiTurno() {
    }

    public boolean isVivo(){
        return this.getHpAttuali() > 0;
    }
    public int getDannoArma() {
        return dannoArma;
    }

}
