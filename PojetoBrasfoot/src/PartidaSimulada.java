import java.util.Random;
import java.util.concurrent.TimeUnit;

//partidas que não serão mostradas ao player
public class PartidaSimulada extends Partida {

    public PartidaSimulada(Time time1,Time time2){
        super(time1,time2);
        int[] g = {0,0};
        setGols(g);
    }
    @Override
    public void simularParida() throws Exception{
        System.out.println("oi");
        if(this.getTime1().getTitulares().size()<11||this.getTime2().getTitulares().size()<11){
            throw new Exception();
        }
        System.out.println("oi");
        for(int i = 0; i<=90;i++){
            Random r = new Random();
            if (r.nextInt(10) == 0){
                chanceGol(15);
            }
        }
        placar(getTime1(),getTime2(),getGols());

    }

    @Override
    public void chanceGol(int chance) {
        Random r = new Random();
        int[] gols = getGols();
        int t1 = r.nextInt(81)+calcularBonus(getTime1(),getTime2());
        int t2 = r.nextInt(81)+calcularBonus(getTime2(),getTime1());
        if(t1 == 80){
            chance = 80;
        }else if(t2 == 80){
            chance = 80;
        }

        if (t1>t2){
            chance = chance + r.nextInt(10) - calcularBonus(getTime1(),getTime2());
           if( r.nextInt(100)<chance){
               gols[0]+=1;
           }
        }else if (t2>t1){
            chance = chance + r.nextInt(10) - calcularBonus(getTime2(),getTime1());
            if( r.nextInt(100)<chance){
                gols[1]+=1;
            }
        }

    }
}
