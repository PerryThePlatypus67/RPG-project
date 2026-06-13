package classi_con_SOLID;

import it.unicam.cs.mpgc.rpg129031.Main;

import java.util.Scanner;

public class GestoreCombattimento {

    public void avvia(ICombattente giocatore, ICombattente nemico, Scanner scanner) {
        System.out.println("\n--- INIZIO COMBATTIMENTO ---");

        while (giocatore.isVivo() && nemico.isVivo()) {
            stampaStato(giocatore, nemico);

            if (!eseguiTurnoGiocatore(giocatore, nemico, scanner)) return;

            if (nemico.isVivo()) {
                eseguiTurnoNemico(nemico, giocatore);
            }
        }

        if (!giocatore.isVivo()) {
            System.out.println(Main.ROSSO + "Sei stato sconfitto..." + Main.RESET);
        }
    }

    private void eseguiTurnoNemico(ICombattente nemico, ICombattente giocatore) {
        int danno = CalcolatoreCombattimento.calcola(nemico, giocatore, nemico.getElementoInCombattimento(), null);
        giocatore.subisciDanno(danno);
        System.out.println("Il " + nemico.getNome() + " ti ha inflitto " + danno + " danni!");
    }

    private boolean eseguiTurnoGiocatore(ICombattente giocatore, ICombattente nemico, Scanner scanner) {
        System.out.println("\n1. Attacca");
        System.out.print("Scelta: ");
        if ("1".equals(scanner.nextLine())) {
            int danno = CalcolatoreCombattimento.calcola(giocatore, nemico, giocatore.getElementoInCombattimento(), null);
            nemico.subisciDanno(danno);
            System.out.println("Hai inflitto " + danno + " danni!");
            return true;
        }
        return false;
    }

    private void stampaStato(ICombattente g, ICombattente n) {
        System.out.println("\n" + n.getNome() + ": " + BarraUI.genera(n));
        System.out.println("TU:           " + BarraUI.genera(g));
    }
}