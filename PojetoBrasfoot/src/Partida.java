import java.util.Random;

public abstract class Partida {

    public abstract void simularParida(Time time1,Time time2,int[] gols )throws Exception;
    public void chanceGol(Time time1,Time time2,int[] gols,int chance){
        Random r = new Random();
        int t1 = r.nextInt(81)+calcularBonus(time1,time2);
        int t2 = r.nextInt(81)+calcularBonus(time2,time1);
        if (t1>t2){
            if( r.nextInt(100)<chance){
                gols[0]+=1;
            }
        }else if (t2>t1){
            if( r.nextInt(100)<chance){
                gols[1]+=1;
            }
        }
    }
    //Mostra o placar em azul
    public static void placar(Time time1, Time time2,int[] gols) {
        System.out.println(ConsoleColors.BLUE  +time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
    }

    //Calcula bonus para jogadas de gol
    public static int calcularBonus(Time Time1, Time Time2) {
        int diferenca = Time1.calcularForcaAtaque() - Time2.calcularForcaDefesa();
        if (diferenca > 0) {
            return diferenca;
        } else {
            return 0;
        }
    }


}




