import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PartidaPlayer extends Partida{
    @Override
    public void simularParida(Time time1,Time time2,int[] gols) throws Exception {

    }
//    public  void simularParida(Time time1,Time time2,int[] gols,int[] golsPenalti)throws Exception{
//
//    }
//
    @Override
    public void chanceGol(Time time1,Time time2,int[] gols,int chance) {

    }
    public void simularEtapa();
    //sobrecarga
    public void placar(Time time1, Time time2, int[] gols, int[] golsPenalti){
        System.out.println(ConsoleColors.CYAN+time1.getNome()+" "+gols[0]+"("+golsPenalti[0]+") X "+gols[1]+"("+golsPenalti[1]+") "+time2.getNome()+ConsoleColors.RESET);

    }
//   @Override
//    public void chanceGol(Time time1,Time time2,int[] gols,int chance) {
//        Random r = new Random();
//        int t1 = r.nextInt(81)+calcularBonus(time1,time2);
//        int t2 = r.nextInt(81)+calcularBonus(time2,time1);
//        if(t1 == 80){
//            chance = 80;
//        }else if(t2 == 80){
//            chance = 80;
//        }
//
//        if (t1>t2){
//            chance = chance + r.nextInt(10) - calcularBonus(time1,time2);
//           if( r.nextInt(100)<chance){
//               gols[0]+=1;
//           }
//        }else if (t2>t1){
//            chance = chance + r.nextInt(10) - calcularBonus(time2,time1);
//            if( r.nextInt(100)<chance){
//                gols[1]+=1;
//            }
//        }
//
//    }
        //private static int acrescimos: pega um número aleatório de até 100, se esse número for menor q 5(sem acrescimo), se for menor que 15 = 1 min, menor que 30 = 2 min,
        //menor que 50 = 3 min, menor que 70 = 4 min, menor que 80 = 5 min, menor que 85 = 6, menor que 90 = 7, menor que 93 = 8, menor que 96 = 9, menor que 100 = 10,
        //retorna o valor de acrescimo

        //jogador que fez o gol
        //atacante
        //meio
        //def
}