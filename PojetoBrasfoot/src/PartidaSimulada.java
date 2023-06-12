import java.util.Random;

//partidas que não serão mostradas ao player
public class PartidaSimulada extends Partida {

    @Override
    public void simularParida(Time time1,Time time2,int[] gols) throws Exception{
        if(time1.getTitulares().size()<11||time2.getTitulares().size()<11){
            throw new Exception();
        }
        for(int i = 0; i<=90;i++){
            Random r = new Random();
            if (r.nextInt(8) == 0){
                chanceGol(time1,time2,gols,17);
            }
        }
        placar(time1,time2,gols);

    }


}
