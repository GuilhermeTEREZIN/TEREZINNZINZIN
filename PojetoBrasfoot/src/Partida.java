import java.util.Random;

public abstract class Partida {
    private Time time1;
    private Time time2;
    private int[] gols;

    public Partida(Time time1,Time time2){
        this.time1 = time1;
        this.time2 = time2;
        this.gols = new int[2];
        gols[0] = 0;gols[1] = 0;
    }



    public abstract void simularParida()throws Exception;
    public void chanceGol(int chance){
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
    //Mostra o placar em vermelho
    public void placar() {
        System.out.println(ConsoleColors.RED  +time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
    }

    //Calcula bonus para jogadas de gol
    public int calcularBonus(Time time1,Time time2) {
        int diferenca = time1.calcularForcaAtaque() - time2.calcularForcaDefesa();
        if (diferenca > 0) {
            return diferenca;
        } else {
            return 0;
        }
    }

    public int[] getGols() {
        return gols;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public void setGols1(int gols) {
        this.gols[0] = gols;
    }
    public void setGols2(int gols) {
        this.gols[1] = gols;
    }
    public void resetarGols(){
        setGols1(0);
        setGols2(0);
    }
}




