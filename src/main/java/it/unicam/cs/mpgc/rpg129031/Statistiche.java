package classi_con_SOLID;
import classi_senza_SOLID.Elemento;

import java.io.Serializable;
public abstract class Statistiche implements Serializable, ValoreMisurabile {

    private static final long serialVersionUID = 1L;

    private String nome;
    private int hpMax;
    private int hpAttuali;
    private int attacco;
    private int attaccoElementare;
    private int difesa;
    private int velocita;
    private int critRate;
    private int critDMG;
    public abstract Elemento getElementoInCombattimento();
    public abstract void eseguiTurno();

    // --- COSTRUTTORE ---
    public Statistiche(String nome, int hpMax, int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hpAttuali = hpMax;
        this.attacco = attacco;
        this.attaccoElementare = attaccoElementare;
        setDifesa(difesa);
        this.velocita = velocita;
        this.critRate = critRate;
        this.critDMG = critDMG;
    }

    @Override
    public int getValoreAttuale() { return this.hpAttuali; }

    @Override
    public int getValoreMassimo() { return this.hpMax; }

    public abstract Elemento getElementoInCombattimento();
    public abstract void eseguiTurno();

    public void rigeneraCompletamente() {
        this.hpAttuali = this.hpMax;
    }
    public void preparaPerCombattimento() {
        this.hpAttuali = this.hpMax;
    }


    // --- GETTER ---
    public String getNome() { return nome; }
    public int getHpMax() { return hpMax; }
    public int getHpAttuali() { return hpAttuali; }
    public int getAttacco() { return attacco; }
    public int getAttaccoElementare() { return attaccoElementare; }
    public int getDifesa() { return difesa; }
    public int getVelocita() { return velocita; }
    public int getCritRate() { return critRate; }
    public int getCritDMG() { return critDMG; }

    // --- SETTER ---
    public void setNome(String nome) { this.nome = nome; }
    public void setHpMax(int hpMax) { this.hpMax = hpMax; }

    public final void setHpAttuali(int nuoviHP) {
        if (nuoviHP < 0) {
            this.hpAttuali = 0;
        } else if (nuoviHP > this.hpMax) {
            this.hpAttuali = this.hpMax;
        } else {
            this.hpAttuali = nuoviHP;
        }
    }

    public void setAttacco(int attacco) { this.attacco = attacco; }
    public void setAttaccoElementare(int attaccoElementare) { this.attaccoElementare = attaccoElementare; }

    public final void setDifesa(int difesa) {
        if (difesa < 0) {
            this.difesa = 0;
        } else if (difesa > 100) {
            this.difesa = 100;
        } else {
            this.difesa = difesa;
        }
    }
    public void setVelocita(int velocita) { this.velocita = velocita; }
    public void setCritRate(int critRate) { this.critRate = critRate; }
    public void setCritDMG(int critDMG) { this.critDMG = critDMG; }

    public boolean isVivo() {
        return this.hpAttuali > 0;
    }
}
