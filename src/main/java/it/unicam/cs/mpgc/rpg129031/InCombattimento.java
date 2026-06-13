package it.unicam.cs.mpgc.rpg129031;

public interface InCombattimento extends ValoreMisurabile {
    String getNome();
    int getHpAttuali();
    void subisciDanno(int danno);
    boolean isVivo();
    String getElementoInCombattimento();

    void eseguiTurno();
}