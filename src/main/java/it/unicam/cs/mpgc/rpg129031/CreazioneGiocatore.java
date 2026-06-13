package it.unicam.cs.mpgc.rpg129031;

public class CreazioneGiocatore {

    public static Giocatore creaGiocatore(String nome, CatalogoArmi catalogo) {
        Giocatore p = new Giocatore(nome, 100, 15, 10, 5);

        Arma armaIniziale = catalogo.getArma("Spada");

        if (armaIniziale != null) {
            p.equipaggiaArma(armaIniziale);
        }

        return p;
    }
}