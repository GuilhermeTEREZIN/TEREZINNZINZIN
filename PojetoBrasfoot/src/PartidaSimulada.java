//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
////partidas que não serão mostradas ao player
//public class PartidaSimulada extends Partida {
//
//    @Override
//    public void simularParida(Time time1,Time time2,int[] gols) throws Exception{
//        System.out.println("oi");
//        if(time1.getTitulares().size()<11||time2.getTitulares().size()<11){
//            throw new Exception("Partida Cancelada");
//        }
//        System.out.println("oi");
//        for(int i = 0; i<=90;i++){
//            Random r = new Random();
//            if (r.nextInt(10) == 0){
//                chanceGol(time1,time2,gols,15);
//            }
//        }
//        placar(time1,time2,gols);
//
//    }
//
//    @Override
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
//}
