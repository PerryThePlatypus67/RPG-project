package it.unicam.cs.mpgc.rpg129031;

public class CreazioneGiocatore {

    public static Giocatore creaGiocatore(String nome, CatalogoArmi catalogo) {
        // CORREZIONE: Devi passare 8 parametri (i valori numerici)
        // Esempio: nome, hpMax, attacco, difesa, velocita, critRate, critDMG, attaccoElementare
        Giocatore p = new Giocatore(nome, 100, 15, 10, 5, 0, 0, 0);

        // Ora puoi equipaggiare l'arma
        Arma armaIniziale = catalogo.getArma("Spada");

        if (armaIniziale != null) {
            p.equipaggiaArma(armaIniziale);
        }

        return p;
    }
}