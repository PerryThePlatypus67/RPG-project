package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public class AttoConfigurazione implements InAtto {
    private final int numeroAtto;
    private final int vita, attacco, difesa, velocita, critRate, critDMG, attaccoElementare;
    private final String elemento;
    private final String descrizione, nomeFile;
    private final String catalogoMostri;


    public AttoConfigurazione(int numeroAtto, int vita, int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare, String elemento, String descrizione, String nomeFile, String catalogoMostri) {
        this.numeroAtto = numeroAtto;
        this.vita = vita;
        this.attacco = attacco;
        this.difesa = difesa;
        this.velocita = velocita;
        this.critRate = critRate;
        this.critDMG = critDMG;
        this.attaccoElementare = attaccoElementare;
        this.elemento = elemento;
        this.descrizione = descrizione;
        this.nomeFile = nomeFile;
        this.catalogoMostri = catalogoMostri;
    }

    public int getNumeroAtto() {
        return numeroAtto;
    }

    public int getVita() {
        return vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getCritRate() {
        return critRate;
    }

    public int getCritDMG() {
        return critDMG;
    }

    public int getAttaccoElementare() {
        return attaccoElementare;
    }

    @Override
    public String getElemento() {
        return this.elemento;
    }

    @Override
    public List<Opzioni> getOpzioni() {
        return List.of();
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    @Override
    public String getNomeFileStoria() {
        return "";
    }

    @Override
    public CatalogoMostri getCatalogoMostri() {
        return null;
    }
}
