import java.util.Random;

import static java.lang.Math.round;

public class Partida {

    public static void simularPartida(Time time1, Time time2){
        Random r = new Random();
        int t1gols = 0;
        int t2gols = 0;
        int t1 = 0;
        int t2 = 0;
        System.out.println("------------------------------------------");
        System.out.println(time1.getNome()+" X "+ time2.getNome() );
        int x = 0;
        for(int i = 0;i<=90;i++){
            x = r.nextInt(5);
            if(x == 0){
                t1 = r.nextInt(100);
                t2 = r.nextInt(100);
                if (t1> t2){ //chance do time 1
                    int chance = r.nextInt(100);
                    if (chance<= 20){

                    }else{
                        if (r.nextInt(5)==0){ // chance de contra ataque

                        }
                    }
                } else if (t2>t1) {//chance do time 2

                }
                System.out.println(i+"' - ");

            }

        }


    }

}
