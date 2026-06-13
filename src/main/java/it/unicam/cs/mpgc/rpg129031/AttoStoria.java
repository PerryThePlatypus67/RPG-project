package classi_con_SOLID;

import java.util.List;
import java.util.Scanner;

public class AttoStoria {
    private final List<IOpzione> opzioniDisponibili = List.of(new OpzioneDojo(), new OpzioneCaverna());

    public void avviaNarrazione(Scanner scanner, Player giocatore) {

        for (int i = 0; i < opzioniDisponibili.size(); i++) {
            System.out.println((i + 1) + ". " + opzioniDisponibili.get(i).getDescrizione());
        }

        int sceltaIndex = Integer.parseInt(scanner.nextLine()) - 1;

        opzioniDisponibili.get(sceltaIndex).esegui(giocatore, scanner, attoAttuale);
    }
}