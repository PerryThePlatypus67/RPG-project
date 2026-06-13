package classi_con_SOLID;

import classi_senza_SOLID.Elemento;

public class StatisticheArmi implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int danni;
    private int danniElementari;
    private final Elemento elemento;

    public StatisticheArmi(String nome, int danni, int danniElementari, Elemento elemento) {
        this.nome = nome;
        this.danni = danni;
        this.danniElementari = danniElementari;
        this.elemento = elemento;
    }

    public int getDanni() { return danni; }
    public int getDanniElementari() { return danniElementari;}
    public String getNome() { return nome; }
    public Elemento getElemento() { return elemento; }
}
