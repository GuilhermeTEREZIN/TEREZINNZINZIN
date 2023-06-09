import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PartidaPlayer extends Partida{
    @Override
    public void simularParida(Time time1,Time time2,int[] gols) throws Exception {
        if(time1.getTitulares().size()<11||time2.getTitulares().size()<11){
            throw new Exception("Partida Cancelada");
        }

        simularEtapa(time1,time2,gols,10,15,1,45);
        System.out.println("Fim do Primeiro Tempo\n");
        TimeUnit.SECONDS.sleep(5);
        simularEtapa(time1,time2,gols,10,15,46,90);
        System.out.println("Fim da Partida");
        placar(time1,time2,gols);

    }

    public void simularEtapa(Time time1,Time time2,int[] gols,int qtdeJogadas, int chanceGol,int inicio,int fim){
        Random r = new Random();

        for(int i = inicio; i<=fim;i++){
            System.out.println(i+"'");

            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch (Exception e){}

            if (r.nextInt(qtdeJogadas) == 0){
                chanceGol(time1,time2,gols,chanceGol);
            }
        }
        int acrescimos = 5;
        if(acrescimos>0){
            System.out.println("Acrescimos: +"+acrescimos );
            for ( int i = fim+1;i<=fim+acrescimos;i++){
                System.out.println(fim+"+"+(i-fim)+"'");

                try {
                    TimeUnit.MILLISECONDS.sleep(0);
                }catch (Exception e){}

                if (r.nextInt(qtdeJogadas) == 0){
                     chanceGol(time1,time2,gols,chanceGol/2);
                }
            }
        }

    }
    @Override
    public void chanceGol(Time time1,Time time2,int[] gols,int chance) {
        Random r = new Random();
        int t1 = r.nextInt(50)+calcularBonus(time1,time2);
        int t2 = r.nextInt(50)+calcularBonus(time2,time1);
        //System.out.println(t1 +" "+ t2);
        if (t1>t2){
            if( r.nextInt(100)<chance){
                gols[0]+=1;
            }else if( r.nextInt(5)==0){ // chance de contra-ataque
                if ( r.nextInt(100)<chance){
                    gols[1]+=0;

                }
            }
        }else if (t2>t1){
            if( r.nextInt(100)<chance){
                gols[1]+=1;
            }else if( r.nextInt(5)==0){//chance de contra-ataque
                if ( r.nextInt(100)<chance){
                    gols[0]+=0;
                }
            }
        }
        placar(time1,time2,gols);

    }
    //sobrecarga
    public void placar(Time time1, Time time2, int[] gols, int[] golsPenalti){
        System.out.println(ConsoleColors.CYAN+time1.getNome()+" "+gols[0]+"("+golsPenalti[0]+") X "+gols[1]+"("+golsPenalti[1]+") "+time2.getNome()+ConsoleColors.RESET);

    }
        //private static int acrescimos: pega um número aleatório de até 100, se esse número for menor q 5(sem acrescimo), se for menor que 15 = 1 min, menor que 30 = 2 min,
        //menor que 50 = 3 min, menor que 70 = 4 min, menor que 80 = 5 min, menor que 85 = 6, menor que 90 = 7, menor que 93 = 8, menor que 96 = 9, menor que 100 = 10,
        //retorna o valor de acrescimo

        //jogador que fez o gol
        //atacante
        //meio
        //def
}
