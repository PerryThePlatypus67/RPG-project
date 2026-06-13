package it.unicam.cs.mpgc.rpg129031;

import java.util.ArrayList;
import java.util.List;

public class CatalogoArmi {
    private List<Arma> listaArmi;

    public CatalogoArmi() {
        this.listaArmi = new ArrayList<>();
        // Aggiungi le tue armi qui manualmente
        listaArmi.add(new Arma("Spada", 10));
        listaArmi.add(new Arma("Ascia", 15));
        listaArmi.add(new Arma("Daga", 7));
    }

    public Arma getArma(String nome) {
        for (Arma a : listaArmi) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null; // O restituisci un'arma base se non la trova
    }
}