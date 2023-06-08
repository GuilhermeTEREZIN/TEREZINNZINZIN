import java.util.ArrayList;
import java.util.Random;

public class Player{
    private String nome;
    private Time time;
    private int rodada;
    private float dinheiro;
    private int temporada;

    private ArrayList<Time> times;

    public Player(){

    }
    //gets e sets


    public String getNome() {
        return nome;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public int getRodada() {
        return rodada;
    }

    public int getTemporada() {
        return temporada;
    }

    public Time getTime() {
        return time;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public void printarTimes(){
        for(int i=0;i<getTimes().size();i++){
            System.out.println(getTimes().get(0).getNome());
        }
    }
}
