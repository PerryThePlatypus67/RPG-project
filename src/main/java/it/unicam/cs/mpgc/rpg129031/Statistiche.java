package it.unicam.cs.mpgc.rpg129031;

import java.io.Serial;
import java.io.Serializable;

public abstract class Statistiche implements Serializable, ValoreMisurabile {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    private int hpMax;
    private int hpAttuali;
    private int attacco;
    private int difesa;
    private int velocita;


    public Statistiche(String nome, int hpMax, int attacco, int difesa, int velocita) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hpAttuali = hpMax;
        this.attacco = attacco;
        this.difesa = difesa;
        this.velocita = velocita;
    }

    @Override
    public int getValoreAttuale() { return this.hpAttuali; }

    @Override
    public int getValoreMassimo() { return this.hpMax; }

    public boolean isVivo() {
        return this.hpAttuali > 0;
    }

    public String getNome() { return nome; }
    public int getHpMax() { return hpMax; }
    public int getHpAttuali() { return hpAttuali; }
    public int getAttacco() { return attacco; }
    public int getDifesa() { return difesa; }
    public int getVelocita() { return velocita; }

    public void setNome(String nome) { this.nome = nome; }
    public void setHpMax(int hpMax) { this.hpMax = hpMax; }
    public final void setHpAttuali(int nuoviHP) {
        this.hpAttuali = Math.max(0, Math.min(nuoviHP, this.hpMax));
    }
    public void setAttacco(int attacco) { this.attacco = attacco; }
    public final void setDifesa(int difesa) {
        this.difesa = Math.max(0, Math.min(difesa, 100));
    }
    public void setVelocita(int velocita) { this.velocita = velocita; }

}