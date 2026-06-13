package it.unicam.cs.mpgc.rpg129031;

import java.io.Serial;
import java.io.Serializable;

public class Arma implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String nome;
    private final int danno;

    public Arma(String nome, int danno) {
        this.nome = nome;
        this.danno = danno;
    }

    public String getNome() { return nome; }
    public int getDanno() { return this.danno; }
}