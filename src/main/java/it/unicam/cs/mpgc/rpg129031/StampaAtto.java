package classi_con_SOLID;

public class StampaAtto {
    public void stampa(InAtto atto) {
        System.out.println("\n=========================================");
        System.out.println(" ATTO " + atto.getNumeroAtto() + ": " + atto.getDescrizione());
        System.out.println("=========================================");
    }
}