public class Partida {
    private Time time1;
    private Time time2;


    public Partida(Time time1,Time time2){
        this.time1 = time1;
        this.time2 = time2;
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void simularPartida(){
        System.out.println("------------------------------------------");
        System.out.println(time1.getNome()+" X "+ time2.getNome() );
        

    }

}
