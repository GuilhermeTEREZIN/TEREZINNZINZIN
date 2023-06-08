import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String nome;
    private Time time;
    private int rodada;
    private float dinheiro;
    private int temporada;

    public Player(){

    }
    //gets e sets

    public void addSave(String nome,String time){
        
    }
    public void carregarjogo(){
        try {
            importarCsv.CarregarSave();
            ArrayList<Time> times = importarCsv.times();
            ArrayList<Jogador> jogadores = importarCsv.jogadores();
            Funcoes.inserirJogadoresTime(times,jogadores);

        }catch (Exception e){

        }

    }
}
