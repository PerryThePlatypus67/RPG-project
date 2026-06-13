package classi_con_SOLID;

import classi_senza_SOLID.CatalogoMostri;
import classi_senza_SOLID.Elemento;

public class AttoConfigurazione implements InAtto {
    private final int numeroAtto;
    private final int vita, attacco, difesa, velocita, critRate, critDMG, attaccoElementare;
    private final Elemento elemento;
    private final String descrizione, nomeFile;
    private final CatalogoMostri catalogoMostri;


    public AttoConfigurazione(int numeroAtto, int vita, int attacco, int difesa, int velocita, int critRate, int critDMG, int attaccoElementare, Elemento elemento, String descrizione, String nomeFile, CatalogoMostri catalogoMostri) {
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

    public Elemento getElemento() {
        return elemento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public CatalogoMostri getCatalogoMostri() {
        return catalogoMostri;
    }
}
