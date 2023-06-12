import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PartidaPlayer extends Partida{

    public PartidaPlayer(Time time1,Time time2){
        super(time1,time2);
//        getGols() = new int[2];
        resetarGols();
    }

    @Override
    public void simularParida() throws Exception {
        if(getTime1().getTitulares().size()<11||getTime2().getTitulares().size()<11){
            throw new Exception();
        }
        resetarGols();

        System.out.println("Inicio da Partida");
        simularEtapa(10,15,1,45);
        System.out.println("Fim do Primeiro Tempo\n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Inicio do Segundo Tempo");
        simularEtapa(10,15,46,90);
        System.out.println("Fim da Partida");
        placar();
    }

    public void simularEtapa(int qtdeJogadas, int chanceGol,int inicio,int fim){
        Random r = new Random();

        for(int i = inicio; i<=fim;i++){
            System.out.println(i+"' - ");

            try {
//                TimeUnit.MILLISECONDS.sleep(600);
            }catch (Exception e){}

            if (r.nextInt(qtdeJogadas) == 0){
                chanceGol(chanceGol);
            }
        }
        int acrescimos = 5;
        if(acrescimos>0){
            System.out.println("Acrescimos: +"+acrescimos );
            for ( int i = fim+1;i<=fim+acrescimos;i++){
                System.out.println(fim+"+"+(i-fim)+"' - ");

                try {
//                    TimeUnit.MILLISECONDS.sleep(800);
                }catch (Exception e){}

                if (r.nextInt(qtdeJogadas) == 0){
                     chanceGol(chanceGol/2);
                }
            }
        }

    }
    public String statusPartida(){
        if (getGols()[0] == getGols()[1]){
            return  "EMPATE";

        }else if (getGols()[0] < getGols()[1]){
            return  "TIME2";

        } else if (getGols()[0] > getGols()[1]){
            return  "TIME1";

        }
        return "DESCONHECIDO";
    }

    @Override
    public void chanceGol(int chance) {
        Random r = new Random();

        int t1 = r.nextInt(50)+calcularBonus(getTime1(),getTime2());
        int t2 = r.nextInt(50)+calcularBonus(getTime1(),getTime2());
        //System.out.println(t1 +" "+ t2);
        if (t1>t2){
            if( r.nextInt(100)<chance){
                setGols1(getGols()[0]+1);
            }else if( r.nextInt(5)==0){ // chance de contra-ataque
                if ( r.nextInt(100)<chance){
                    if(statusPartida().equals("EMPATE")){
                        //naração de virada
                    }else {
                        //naração de contra atauqe
                    }
                    getGols()[1]+=1;
                }
            }
        }else if (t2>t1){
            if( r.nextInt(100)<chance){
               getGols()[1]+=1;
            }else if( r.nextInt(5)==0){//chance de contra-ataque
                if ( r.nextInt(100)<chance){
                    getGols()[0]+=1;
                }
            }
        }
       // placar(time1,time2,gols);

    }
    @Override
    public void placar() {
        System.out.println(ConsoleColors.CYAN_BOLD  +getTime1().getNome()+" "+getGols()[0]+" X "+getGols()[1]+" "+getTime2().getNome()+ConsoleColors.RESET);
    }
    //sobrecarga
    public void placar( int[] golsPenalti){
        System.out.println(ConsoleColors.CYAN_BOLD+getTime1().getNome()+" "+getGols()[0]+"("+golsPenalti[0]+") X "+getGols()[1]+"("+golsPenalti[1]+") "+getTime2().getNome()+ConsoleColors.RESET);

    }
    //private static void naracaoChance(Time time1,int minuto,int[]gols,boolean contrAtaque)
    //private static void narracao(Time time1,int minuto,int[] gols,boolean contraAtaque)
    //private static void narracao(Time time1,Time time2,int minuto, int[] gols,boolean contraAtaque)
    //
        //private static int acrescimos: pega um número aleatório de até 100, se esse número for menor q 5(sem acrescimo), se for menor que 15 = 1 min, menor que 30 = 2 min,
        //menor que 50 = 3 min, menor que 70 = 4 min, menor que 80 = 5 min, menor que 85 = 6, menor que 90 = 7, menor que 93 = 8, menor que 96 = 9, menor que 100 = 10,
        //retorna o valor de acrescimo

        //jogador que fez o gol
        //atacante
        //meio
        //def
}
