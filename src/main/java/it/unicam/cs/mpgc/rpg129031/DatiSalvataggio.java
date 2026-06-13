package classi_con_SOLID;

public class DatiSalvataggio implements Serializable {
    private final Player player;
    private final Atto atto;

    public DatiSalvataggio(Player player, Atto atto) {
        this.player = player;
        this.atto = atto;
    }
}

public interface IServizioSalvataggio {
    void salva(DatiSalvataggio dati) throws IOException;
    DatiSalvataggio carica() throws IOException, ClassNotFoundException;
}
