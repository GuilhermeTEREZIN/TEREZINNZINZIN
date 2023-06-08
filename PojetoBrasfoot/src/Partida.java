public abstract class Partida {

    public static void simularParida(Time time1,Time time2,int[] gols )throws Exception;
    public static void chanceGol(Time time1,Time time2,int[] gols,int chance);


    //Mostra o placar em azul
    public static void placar(Time time1, Time time2,int[] gols) {
        System.out.println(ConsoleColors.BLUE  +time1.getNome()+" "+gols[0]+" X "+gols[1]+" "+time2.getNome()+ConsoleColors.RESET);
    }

    //Calcula bonus para jogadas de gol
    public static int calcularBonus(Time Time1, Time Time2) {
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

}




