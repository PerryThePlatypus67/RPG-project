package classi_con_SOLID;

import java.io.*;

public class SalvataggioFile implements IServizioSalvataggio {
    private final String percorsoFile;

    public SalvataggioFile(String percorsoFile) {
        this.percorsoFile = percorsoFile;
    }

    @Override
    public void salva(DatiSalvataggio dati) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(percorsoFile))) {
            oos.writeObject(dati);
        }
    }

    @Override
    public DatiSalvataggio carica() throws IOException, ClassNotFoundException {
        File file = new File(percorsoFile);
        if (!file.exists()) {
            throw new FileNotFoundException("File di salvataggio non trovato: " + percorsoFile);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (DatiSalvataggio) ois.readObject();
        }
    }
}
