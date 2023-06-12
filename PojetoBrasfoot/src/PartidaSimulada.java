import java.util.Random;

//partidas que não serão mostradas ao player
public class PartidaSimulada extends Partida {

    public PartidaSimulada(Time time1,Time time2){
        super(time1,time2);
//        this.gols = new int[2];
        resetarGols();
    }

    @Override
    public void simularParida() throws Exception{
        if(getTime1().getTitulares().size()<11||getTime2().getTitulares().size()<11){
            throw new Exception();
        }
        resetarGols();

        for(int i = 0; i<=90;i++){
            Random r = new Random();
            if (r.nextInt(8) == 0){
                chanceGol(17);
            }
        }
        //placar();

    }


}
