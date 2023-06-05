import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static java.lang.Math.round;

public class Partida {
    //fazer um método privado estatico calcularBonus que tenha como entrada time1 e time2
    //se a diferença entre o poder de ataque do time1 e o poder de defesa do time 2 for positiva

        //retorna a metade essa diferença

    //exibir placar Time time1, Time time2,int[] gols
        //System.out.println(ConsoleColors.BLUE+time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);

    //void static Mostrar Mensagens entra um time e o minuto do gol e mostra uma msg diferente dependendo do minuto
        //exemplo: minuto 90- no finalzinho
         //exemplo código: System.out.println(minuto+"' - "+"Gol do "+time.getNome());


    //private static int acrescimos: pega um número aleatório de até 100, se esse número for menor q 5(sem acrescimo), se for menor que 15 = 1 min, menor que 30 = 2 min,
    //menor que 50 = 3 min, menor que 70 = 4 min, menor que 80 = 5 min, menor que 85 = 6, menor que 90 = 7, menor que 93 = 8, menor que 96 = 9, menor que 100 = 10,
    //retorna o valor de acrescimo
    private static void simularEtapa(Time time1, Time time2, int gols[],int inicio,int fim,int ChanceJogada){
        Random r = new Random();
        int x = 0;
        for(int i = inicio;i<=fim;i++) {
            System.out.println(i+"' - ");
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println(e);
            }
            x = r.nextInt(ChanceJogada);
            //System.out.println(x+ " Chance de jogada "+i);
            if (x == 0) {

                chanceGol(time1, time2,gols,i);
                //System.out.println("---------------------------------------------");
            }
        }
    }
    public static void simularPartida(Time time1, Time time2, boolean penalti){
        Random r = new Random();
        int[] gols = new int[2];
        gols[0] = 0;gols[1] = 0;
        int acrescimos = 0;
        System.out.println("Inicio do Jogo");

        simularEtapa(time1,time2,gols,0,45,10);
        acrescimos = 5;
        if(acrescimos>0){
            System.out.println("Acrescimos: "+acrescimos+" Minutos");
            simularEtapa(time1,time2,gols,46,45+acrescimos,5);
        }
        System.out.println("Fim do Primeiro Tempo\n");
        simularEtapa(time1,time2,gols,46,90,8);
        if(acrescimos>0){
            System.out.println("Acrescimos: "+acrescimos+" Minutos");
            simularEtapa(time1,time2,gols,91,90+acrescimos,5);
        }

        System.out.println("Fim de Jogo");
        System.out.println("\nResultado final:");
        System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());

        if (penalti == true){

        }


    }

    private static void chanceGol(Time time1, Time time2,int[] gols,int minuto){
        Random r = new Random();
        int chance;
        int t1 = 0;
        int t2 = 0;
        t1 = r.nextInt(80);
        t2 = r.nextInt(80);

        //System.out.println("Jogada VS"+t1+" x "+ t2);
        if (t1> t2){ //chance do time 1
            chance = r.nextInt(100);
            //System.out.println("Chance gol time 1 "+chance);
            if (chance<= 15){  //fez o gol
                gols[0] +=1;
                System.out.println(minuto+"' - "+"Gol do "+time1.getNome());
                System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());

            }else{
                chance = r.nextInt(4);
                //System.out.println("Chance Contra Ataque time 2: "+chance);
                if (chance==0){ // chance de contra ataque
                    chance = r.nextInt();
                    if(chance<=20){ // gol de contra ataque
                        gols[1] += 1;
                        System.out.println(minuto+"' - "+"Gol de contra ataque do "+time2.getNome());
                        System.out.println(ConsoleColors.BLUE+time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
                    }
                }
            }
        } else if (t2>t1) {//chance do time 2
            chance = r.nextInt(100);
            //System.out.println("Chance gol time 2 "+chance);
            if (chance<= 15){  //fez o gol
                gols[1] +=1;
                System.out.println(minuto+"' - "+"Gol do "+time2.getNome());
                System.out.println(time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome());
            }else{
                chance = r.nextInt(4);
                //System.out.println("Chance Contra Ataque time 1: "+chance);
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
    3
    
}




