import java.util.Random;

public class Player {
    private String nome;
    private Time time;
    private int rodada;
    private float dinheiro;
    private int temporada;
    //nome
    //time
    //rodada
    //dinheiro
    //temporada

    public Player(){

    }
    //gets e sets
    public void iniciarnovoJogo(){
        CopiaCsv.Copiar("save");
        CopiaCsv.Copiar("jogadores");
        CopiaCsv.Copiar("Calendario");
        CopiaCsv.Copiar("Liga");
        TabelaConfrontos.gerarLiga();
        //TabelaConfrontos.gerarCopa();
    }
    public void addSave(String nome,String time){
        
    }
    public void carregarjogo(){

    }
}
