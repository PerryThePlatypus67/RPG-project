package it.unicam.cs.mpgc.rpg129031;

import java.util.List;

public enum Atto implements InAtto {
    ATTO_0, ATTO_1, ATTO_2, ATTO_3;

    @Override
    public String getNomeFileStoria() {
        return this.name().toLowerCase();
    }

    @Override
    public String getDescrizione() {
        switch (this) {
            case ATTO_0: return "Prologo: Il risveglio";
            case ATTO_1: return "Atto 1: La foresta dei sussurri";
            case ATTO_2: return "Atto 2: Le rovine dimenticate";
            case ATTO_3: return "Atto 3: Il confronto finale";
            default: return "Sconosciuto";
        }
    }

    @Override
    public List<Opzioni> getOpzioni() {
        switch (this) {
            case ATTO_0:
                return List.of(new OpzioneCombattimento("1. Affronta l'Uccello che ti blocca la strada"));
            case ATTO_1:
                return List.of(new OpzioneEsplorazione("1. Addentrati nella Capitale"));
            case ATTO_2:
                // Qui inseriamo il nuovo combattimento specifico per l'Atto 2
                return List.of(new OpzioneCombattimento("1. Affronta il Guardiano delle Rovine"));
            case ATTO_3:
                return List.of(new OpzioneCombattimento("1. Affronta il Boss Finale"));
            default:
                return List.of();
        }
    }

    @Override
    public CatalogoMostri getCatalogoMostri() {
        return new CatalogoMostri("catalogoMostri.json");
    }

    @Override
    public int getNumeroAtto() { return this.ordinal(); }

    @Override
    public String getElemento() { return ""; }
}