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
        return switch (this) {
            case ATTO_0 -> "Prologo: Il risveglio";
            case ATTO_1 -> "Atto 1: La foresta dei sussurri";
            case ATTO_2 -> "Atto 2: Le rovine dimenticate";
            case ATTO_3 -> "Atto 3: Il confronto finale";
        };
    }

    @Override
    public List<Opzioni> getOpzioni() {
        return switch (this) {
            case ATTO_0 -> List.of(new OpzioneCombattimento("1. Affronta l'Uccello che ti blocca la strada"));
            case ATTO_1 -> List.of(new OpzioneEsplorazione("1. Addentrati nella Capitale"));
            case ATTO_2 ->
                    List.of(new OpzioneCombattimento("1. Affronta il Guardiano delle Rovine"));
            case ATTO_3 -> List.of(new OpzioneCombattimento("1. Affronta il Boss Finale"));
        };
    }

    @Override
    public int getNumeroAtto() { return this.ordinal(); }

}