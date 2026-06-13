package classi_con_SOLID;

import classi_senza_SOLID.CatalogoMostri;

public interface InAtto {
    int getNumeroAtto();
    int getVita();
    int getAttacco();
    int getDifesa();
    CatalogoMostri getCatalogoMostri();
    String getNomeFile();
    String getDescrizione();
}
