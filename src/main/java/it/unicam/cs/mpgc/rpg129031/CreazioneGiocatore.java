package classi_con_SOLID;

import classi_senza_SOLID.CatalogoArmi;

public class CreazioneGiocatore {
    public static Giocatore creaGiocatore(String nome) {
        Giocatore p = new Giocatore(nome, 10, 2, 5, 5, 25, 2, 0);
        p.equipaggiaArma(CatalogoArmi.SPADA.creaArma());
        return p;
    }
}
