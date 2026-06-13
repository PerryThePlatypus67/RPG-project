package classi_con_SOLID;

public interface InCombattimento {
        String getNome();
        int getHpAttuali();
        void subisciDanno(int danno);
        boolean isVivo();

        Elemento getElementoInCombattimento();
    private boolean combattimentoFinito() {
        return !squadraViva(squadraGiocatori) || !squadraViva(squadraNemici);
    }

    private boolean squadraViva(List<ICombattente> squadra) {
        return squadra.stream().anyMatch(ICombattente::isVivo);
    }

    private void notificaVincitore() {
        boolean vittoria = squadraViva(squadraGiocatori);
        System.out.println(vittoria ? "Vittoria!" : "Sconfitta!");
    }
}
