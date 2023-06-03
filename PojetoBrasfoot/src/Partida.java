import java.util.Random;

import static java.lang.Math.round;

public class Partida {
    //fazer um método estatico calcularBonus que tenha como entrada time1 e time2
    //se a diferença entre o poder de ataque do time1 e o poder de defesa do time 2 for positiva

        //retorna a metade dessa diferença

    //exibir placar Time time1, Time time2,int[] gols
        //System.out.println(time1.getNome()+" "+t1gols+" X "+t2gols+" "+time2.getNome());

    //void static Mostrar Mensagens entra um time e o minuto do gol e mostra uma msg diferente dependendo do minuto
        //exemplo: minuto 90- no finalzinho
         //exemplo código: System.out.println(minuto+"' - "+"Gol do "+time.getNome());
    public static void simularPartida(Time time1, Time time2){
        Random r = new Random();
        int[] gols = new int[2];
        gols[0] = 0;
        gols[1] = 0;
        System.out.println("------------------------------------------");
        System.out.println(time1.getNome()+" X "+ time2.getNome() );
        int x = 0;
        for(int i = 0;i<=45;i++) {
            x = r.nextInt(6);
            if (x == 0) {
                chanceGol(time1, time2,gols,i);
            }
        }
        for(int i = 46;i<=90;i++) {
            x = r.nextInt(4);
            if (x == 0) {
                chanceGol(time1, time2,gols,i);
            }
        }
        System.out.println("Fim do Primeiro Tempo");
        System.out.println("Fim de Jogo");
        System.out.println("\nResultado final:");
        System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());
    }

    private static void chanceGol(Time time1, Time time2,int[] gols,int minuto){
        Random r = new Random();
        int chance;
        int t1 = 0;
        int t2 = 0;
        t1 = r.nextInt(100);
        t2 = r.nextInt(100);
        if (t1> t2){ //chance do time 1
            chance = r.nextInt(100);
            if (chance<= 20){  //fez o gol
                gols[0] +=1;
                System.out.println(minuto+"' - "+"Gol do "+time1.getNome());
                System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());

            }else{
                chance = r.nextInt(5);
                if (chance==0){ // chance de contra ataque
                    chance = r.nextInt();
                    if(chance<=20){ // gol de contra ataque
                        gols[1] += 1;
                        System.out.println(minuto+"' - "+"Gol de contra ataque do "+time2.getNome());
                        System.out.println(ConsoleColors.RED+time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
                    }
                }
            }
        } else if (t2>t1) {//chance do time 2
            chance = r.nextInt(100);
            if (chance<= 20){  //fez o gol
                gols[1] +=1;
                System.out.println(minuto+"' - "+"Gol do "+time2.getNome());
                System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());
            }else{
                chance = r.nextInt(5);
                if (chance==0){ // chance de contra ataque
                    chance = r.nextInt();
                    if(chance<=20){ // gol de contra ataque
                        gols[0] += 1;
                        System.out.println(minuto+"' - "+"Gol de contra ataque do "+time1.getNome());
                        System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());
                    }
                }
            }
        }


        }


}

