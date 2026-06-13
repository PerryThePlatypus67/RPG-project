package it.unicam.cs.mpgc.rpg129031;

import java.io.IOException;

public interface IServizioSalvataggio {
    void salva(DatiSalvataggio dati) throws IOException;
    DatiSalvataggio carica() throws IOException, ClassNotFoundException;
}
