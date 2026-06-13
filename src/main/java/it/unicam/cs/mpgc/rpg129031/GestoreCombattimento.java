package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class GestoreCombattimento {


    public void avviaControUccello(InCombattimento giocatore, Scanner scanner) {

        InCombattimento uccello = new Mostro("Uccello", 30, 5, 5,  4);

        System.out.println("\n" + Main.ROSSO + "ATTENZIONE: Un Uccello ti sbarra la strada!" + Main.RESET);

        avvia(giocatore, uccello, scanner);
    }

    public void avvia(InCombattimento giocatore, InCombattimento nemico, Scanner scanner) {
        System.out.println("\n--- INIZIO COMBATTIMENTO ---");

        while (giocatore.isVivo() && nemico.isVivo()) {
            stampaStato(giocatore, nemico);

            if (!eseguiTurnoGiocatore(giocatore, nemico, scanner)) {
                System.out.println("Fuga effettuata.");
                return;
            }

            if (nemico.isVivo()) {
                eseguiTurnoNemico(nemico, giocatore);
            }
        }

        notificaVincitore(giocatore);
    }

    private void eseguiTurnoNemico(InCombattimento nemico, InCombattimento giocatore) {
        int danno = CalcolatoreCombattimento.calcola((Statistiche) nemico, (Statistiche) giocatore, null);
        giocatore.subisciDanno(danno);
        System.out.println("Il " + nemico.getNome() + " ti ha inflitto " + danno + " danni!");
    }

    private boolean eseguiTurnoGiocatore(InCombattimento giocatore, InCombattimento nemico, Scanner scanner) {
        System.out.println("\n1. Attacca");
        System.out.print("Scelta: ");
        if ("1".equals(scanner.nextLine())) {
            int danno = CalcolatoreCombattimento.calcola((Statistiche) giocatore, (Statistiche) nemico, null);
            nemico.subisciDanno(danno);
            System.out.println("Hai inflitto " + danno + " danni!");
            return true;
        }
        return false;
    }

    private void stampaStato(InCombattimento g, InCombattimento n) {
        System.out.println("\n" + n.getNome() + ": " + BarraUI.genera(n));
        System.out.println("TU:           " + BarraUI.genera(g));
    }

    private void notificaVincitore(InCombattimento giocatore) {
        if (giocatore.isVivo()) {
            System.out.println(Main.VERDE + "Vittoria!" + Main.RESET);
        } else {
            System.out.println(Main.ROSSO + "Sei stato sconfitto..." + Main.RESET);
        }
    }
    public void avviaCombattimento(Giocatore g, Scanner scanner, String nomeNemico) {
        Mostro nemico;


        String nome = (nomeNemico != null) ? nomeNemico.trim() : "Uccello";

        switch (nome) {
            case "Guardiano delle Rovine":
                nemico = new Mostro("Guardiano delle Rovine", 50, 8, 8,  5);
                break;
            case "Uccello del malefuffaguru":
                nemico = new Mostro("Uccello del malefuffaguru", 100, 15, 10, 5);
                break;
            case "Uccello":
            default:
                nemico = new Mostro("Uccello", 30, 5, 5, 5);
                break;
        }

        System.out.println("\n" + Main.ROSSO + "ATTENZIONE: Un " + nemico.getNome() + " ti sbarra la strada!" + Main.RESET);
        avvia(g, nemico, scanner);
    }
}