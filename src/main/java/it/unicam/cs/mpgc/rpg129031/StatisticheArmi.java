package it.unicam.cs.mpgc.rpg129031;

public class StatisticheArmi implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int danni;

    public StatisticheArmi(String nome, int danni) {
        this.nome = nome;
        this.danni = danni;
    }

    public int getDanni() { return danni; }
    public String getNome() { return nome; }
}
