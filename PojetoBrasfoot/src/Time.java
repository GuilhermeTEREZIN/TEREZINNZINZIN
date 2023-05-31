import java.util.ArrayList;

public class Time {
  private int id;
  private String nome;
  private ArrayList<Jogador> jogadores;


  public Time(int id,String nome){
    this.nome = nome;
    this.id = id;
    jogadores = new ArrayList<>();

  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }
  public void addJogador(Jogador j){
    jogadores.add(j);
  }

}
