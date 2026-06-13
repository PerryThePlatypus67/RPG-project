package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public interface Opzioni {

    String getDescrizione();
    void esegui(Giocatore p, Scanner s, InAtto a);
}