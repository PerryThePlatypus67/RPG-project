package it.unicam.cs.mpgc.rpg129031;

import java.util.Scanner;

public class HubControl {

    public void avviaHub(Giocatore g, InAtto a, Scanner scanner) {
        boolean inHub = true;

        while (inHub) {
            System.out.println("\n--- HUB DI GIOCO ---");
            System.out.println("1. Controlla Scheda | 2. Prosegui la storia | 3. Salva");
            System.out.print("Scelta: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":

                    Main.stampaScheda(g, a);
                    break;
                case "2":
                    inHub = false;
                    break;
                case "3":
                    System.out.println("Salvataggio in corso...");

                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}