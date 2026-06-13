package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public class Prologo implements InAtto {

    public Prologo() {
    }

    @Override
    public int getNumeroAtto() {
        return 0;
    }

    @Override
    public List<Opzioni> getOpzioni() {
        return List.of();
    }

    @Override
    public String getDescrizione() {
        return "Prologo: L'inizio dell'avventura";
    }

    @Override
    public String getNomeFileStoria() {
        return "prologo";
    }

 }