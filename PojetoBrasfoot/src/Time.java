import java.util.ArrayList;

import static java.lang.Math.round;

public class Time {
  private int id;
  private String nome;
  private ArrayList<Jogador> jogadores;
  private ArrayList<Jogador> titulares;


  public Time(int id, String nome) {
    this.nome = nome;
    this.id = id;
    jogadores = new ArrayList<>();
    titulares = new ArrayList<>();

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

  public void addJogador(Jogador j) {
    jogadores.add(j);
  }

  public int over(boolean titulares) {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    if (titulares){
      jogadores = this.titulares;
    }else {
      jogadores = this.jogadores;
    }
    int Over = 0;
    int Contador = 0;
    for (Jogador j : jogadores) {
      Over += j.getOverall();
      Contador += 1;
    }
    return Integer.valueOf(Over / Contador);

  }

  public int overDefesa(boolean titulares) {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    if (titulares){
      jogadores = this.titulares;
    }else {
      jogadores = this.jogadores;
    }
    int Over = 0;
    int Contador = 0;
    for (Jogador j : jogadores) {
      if (j.getPosicao() == "ZAG" || j.getPosicao() == "GO" || j.getPosicao() == "LD" || j.getPosicao() == "LE") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Integer.valueOf(Over / Contador);

  }

  public int overMeio(boolean titulares) {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    if (titulares){
      jogadores = this.titulares;
    }else {
      jogadores = this.jogadores;
    }
    int Over = 0;
    int Contador = 0;
    for (Jogador j : jogadores) {
      if (j.getPosicao() == "VOL" || j.getPosicao() == "MLG" || j.getPosicao() == "MEI") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Integer.valueOf(Over / Contador);
  }
  public int overAtaque(boolean titulares) {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    if (titulares){
      jogadores = this.titulares;
    }else {
      jogadores = this.jogadores;
    }
    int Over = 0;
    int Contador = 0;
    for (Jogador j : jogadores) {
      if (j.getPosicao() == "CA" || j.getPosicao() == "PTE" || j.getPosicao() == "PTD") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Integer.valueOf(Over / Contador);
  }
   public int calcularForcaAtaque(){
      return round((overAtaque(true)+overMeio(true))/2);
   }
   public int calcularForcaDefesa(){
     return overDefesa(true);
  }

}


