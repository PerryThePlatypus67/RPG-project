package it.unicam.cs.mpgc.rpg129031;


public class Player extends Statistiche implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private StatisticheArmi armaEquipaggiata;
    private int livello;

    public Player(String nome, int hpMax,int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare) {
        super(nome, hpMax, attacco, difesa, velocita, critRate, critDMG, attaccoElementare);
    }

    public void equipaggiaArma(StatisticheArmi nuovaArma) {
        this.armaEquipaggiata = nuovaArma;
    }

    public StatisticheArmi getArmaEquipaggiata() {
        return armaEquipaggiata;
    }

    @Override
    public Elemento getElementoInCombattimento(){
        if(this.armaEquipaggiata != null){
            return this.armaEquipaggiata.getElemento();
        }
        return Elemento.NEUTRO;
    }

    @Override
    public void eseguiTurno() {

    }

    public boolean isVivo(){
        return this.getHpAttuali() > 0;
    }

}
