package classi_con_SOLID;

import java.util.List;

public class GestioneTurni {
    private final List<ICombattente> squadraGiocatori;
    private final List<ICombattente> squadraNemici;
    private int turnoAttuale = 1;

    public GestioneTurni(List<ICombattente> giocatori, List<ICombattente> nemici) {
        this.squadraGiocatori = giocatori;
        this.squadraNemici = nemici;
    }

    public void avvioCombattimento() {
        System.out.println("--- INIZIO COMBATTIMENTO ---");

        List<ICombattente> tutti = new ArrayList<>(squadraGiocatori);
        tutti.addAll(squadraNemici);
        tutti.sort((a, b) -> Integer.compare(b.getVelocita(), a.getVelocita()));

        while (!combattimentoFinito()) {
            for (ICombattente p : tutti) {
                if (p.isVivo()) {
                    p.eseguiTurno();
                }
                if (combattimentoFinito()) break;
            }
            turnoAttuale++;
        }
        notificaVincitore();
    }
}