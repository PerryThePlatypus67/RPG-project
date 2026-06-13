package classi_con_SOLID;

public class HubControl {
    private final SequenzaAtti sequenza;
    private final IServizioSalvataggio servizioSalvataggio;
    private final Giocatore giocatore;

    public void avviaHub(Scanner scanner) {
        while (sequenza.haAncoraAtti()) {
            stampaMenu();
            String scelta = scanner.nextLine();


            switch (scelta) {
                case "1" -> eseguiNarrazione();
                case "2" -> GestoreSalvataggi.salva(giocatore, sequenza.corrente());
                case "3" -> System.exit(0); break;
                default -> System.out.println("Scelta non valida.");
            }
        }
        private void eseguiNarrazione() {

            InAtto attoAttuale = sequenza.corrente();
            AttoStatistiche.applica(giocatore, attoAttuale);
            AttoStoria storia = new AttoStoria(attoAttuale);
            storia.avviaNarrazione(scanner, giocatore);
            sequenza.avanza();

            System.out.println(Main.VERDE + "\n[!] Atto completato!" + Main.RESET);
        }

        private void stampaMenu() {

            var atto = sequenza.corrente();

            System.out.println("\n" + Main.CIANO + "=========================================");
            System.out.println(" HUB DI GIOCO - ATTO " + atto.getNumeroAtto());
            System.out.println(" " + atto.getDescrizione());
            System.out.println("=========================================" + Main.RESET);

            System.out.println("1. Avanza nella narrazione");
            System.out.println("2. Salva Partita");
            System.out.println("3. Esci dal gioco");
            System.out.print(Main.GIALLO + "\nScelta: " + Main.RESET);
    }

        public HubControl(IServizioSalvataggio servizio, Player giocatore) {
            this.servizioSalvataggio = servizio;
            this.giocatore = giocatore;
        }

        private void eseguiSalvataggio() {
            try {
                DatiSalvataggio dati = new DatiSalvataggio(giocatore, sequenza.corrente());
                servizioSalvataggio.salva(dati);
                System.out.println("Salvataggio completato!");
            } catch (IOException e) {
                System.err.println("Errore nel salvataggio: " + e.getMessage());
            }
        }
}

