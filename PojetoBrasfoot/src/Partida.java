public abstract class Partida {
    private Time time1;
    private Time time2;
    private int[] gols;

    public Partida(Time time1,Time time2){//Método construtor
        this.time1 = time1;
        this.time2 = time2;
        int[] gols = new int[2];
        gols[0] = 0;
        gols[1] = 1;
    }
    public abstract void simularParida()throws Exception;
    public abstract void chanceGol(int chance);


    //Mostra o placar em azul
    public void placar(Time time1, Time time2,int[] gols) {
        System.out.println(ConsoleColors.BLUE  +time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
    }

    //Calcula bonus para jogadas de gol
    public int calcularBonus(Time Time1, Time Time2) {
        int diferenca = Time1.calcularForcaAtaque() - Time2.calcularForcaDefesa();
        if (diferenca > 0) {
            return diferenca / 2;
        } else {
            return 0;
        }
    }

    //private static int acrescimos: pega um número aleatório de até 100, se esse número for menor q 5(sem acrescimo), se for menor que 15 = 1 min, menor que 30 = 2 min,
//menor que 50 = 3 min, menor que 70 = 4 min, menor que 80 = 5 min, menor que 85 = 6, menor que 90 = 7, menor que 93 = 8, menor que 96 = 9, menor que 100 = 10,
//retorna o valor de acrescimo


    public int[] getGols() {
        return gols;
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setGols(int[] gols) {
        this.gols = gols;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }
}




