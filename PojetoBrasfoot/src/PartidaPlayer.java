import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PartidaPlayer extends Partida{
    private int[] golsPenalti;

    public PartidaPlayer(Time time1,Time time2){
        super(time1,time2);
        int[] g = {0,0};
        setGols(g);
        setGolsPenalti(g);

    }

    @Override
    public void simularParida() throws Exception {

    }
    public  void simularParida(boolean Penalti)throws Exception{

    }

    @Override
    public void chanceGol(int chance) {

    }

    public void placar(Time time1, Time time2, int[] gols, int[] golsPenalti){
        System.out.println(ConsoleColors.CYAN+time1.getNome()+" "+gols[0]+"("+golsPenalti[0]+") X "+gols[1]+"("+golsPenalti[1]+") "+time2.getNome()+ConsoleColors.RESET);

    }



    public void setGolsPenalti(int[] golsPenalti) {
        this.golsPenalti = golsPenalti;
    }

    public int[] getGolsPenalti() {
        return golsPenalti;
    }
}
