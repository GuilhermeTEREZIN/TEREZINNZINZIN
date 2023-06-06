public class Player {
    //nome
    //time
    //rodada
    //dinheiro
    //temporada

    //gets e sets
    public void iniciarnovoJogo(){
        CopiaCsv.Copiar("save");
        CopiaCsv.Copiar("jogadores");
        CopiaCsv.Copiar("Calendario");
        CopiaCsv.Copiar("Liga");
        TabelaConfrontos.gerarLiga();
        TabelaConfrontos.gerarCopa();
    }
}
