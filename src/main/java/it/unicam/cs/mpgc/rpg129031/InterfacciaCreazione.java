package classi_con_SOLID;

public class InterfacciaCreazione {
    public Giocatore avvia(Scanner scanner) {
        String nome = scanner.nextLine();
        return CreazioneGiocatore.creaGiocatore(nome);
    }
}
