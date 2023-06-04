import java.util.ArrayList;

public abstract class Campeonato {
    private String nome;
    private ArrayList<Time> times;

    public String getNome() {
        return nome;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }
    public Time getTime(int id){
        return times.get(id);

    }

}
