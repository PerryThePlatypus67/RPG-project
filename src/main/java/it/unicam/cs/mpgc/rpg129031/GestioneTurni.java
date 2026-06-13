package it.unicam.cs.mpgc.rpg129031;

public class GestioneTurni {
    private final InCombattimento giocatore;
    private final InCombattimento nemico;

    public GestioneTurni(InCombattimento giocatore, InCombattimento nemico) {
        this.giocatore = giocatore;
        this.nemico = nemico;
    }

    public void avvioCombattimento() {
        System.out.println("--- INIZIO COMBATTIMENTO ---");

        // Ciclo finché entrambi sono vivi
        while (giocatore.isVivo() && nemico.isVivo()) {

            // Turno del Giocatore
            System.out.println("\nTurno di: " + ((Statistiche)giocatore).getNome());
            giocatore.eseguiTurno();

            // Controllo se il nemico è ancora vivo prima di farlo attaccare
            if (nemico.isVivo()) {
                System.out.println("\nTurno di: " + ((Statistiche)nemico).getNome());
                nemico.eseguiTurno();
            }
        }

        notificaVincitore();
    }

    private void notificaVincitore() {
        if (giocatore.isVivo()) {
            System.out.println("\n[!] Vittoria! " + ((Statistiche)giocatore).getNome() + " ha vinto!");
        } else {
            System.out.println("\n[!] Sconfitta... " + ((Statistiche)nemico).getNome() + " ha vinto!");
        }
    }
}