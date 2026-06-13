package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public interface InAtto {
    String getNomeFileStoria();
    CatalogoMostri getCatalogoMostri();
    int getNumeroAtto();

    String getElemento();

    List<Opzioni> getOpzioni();

    String getDescrizione();
}