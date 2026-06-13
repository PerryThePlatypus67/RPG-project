package it.unicam.cs.mpgc.rpg129031;

import java.io.Serializable;

public class Arma implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int danno;
    private String elemento; // 1. Aggiungi il campo

    public Arma(String nome, int danno) {
        this.nome = nome;
        this.danno = danno;
        this.elemento = elemento;
    }

    public String getNome() { return nome; }
    public int getDanno() { return danno; }
    public String getElemento() {
        return this.elemento;
    }
}