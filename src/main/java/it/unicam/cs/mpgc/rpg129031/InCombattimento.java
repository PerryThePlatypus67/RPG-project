package it.unicam.cs.mpgc.rpg129031;

public interface InCombattimento extends ValoreMisurabile {
    String getNome();
    void subisciDanno(int danno);
    boolean isVivo();
    void eseguiTurno();
}