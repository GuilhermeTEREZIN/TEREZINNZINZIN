import java.util.ArrayList;

import static java.lang.Math.round;

public class Time {
  private int id;
  private Pais pais;
  private String nome;
  private ArrayList<Jogador> jogadores;
  private ArrayList<Jogador> titulares;


  public Time(int id, String nome) {
    this.nome = nome;
    this.id = id;
    this.pais = Pais.BRA;
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

  public ArrayList<Jogador> getJogadores() {
    return jogadores;
  }

  public ArrayList<Jogador> getTitulares() {
    return titulares;
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
    return Over / Contador;

  }
//
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
      if (j.getPosicao().toString() == "ZAG" || j.getPosicao().toString() == "GO" || j.getPosicao().toString() == "LD" || j.getPosicao().toString() == "LE") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;

  }
//
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
      if (j.getPosicao().toString()== "VOL" || j.getPosicao().toString() == "MLG" || j.getPosicao().toString() == "MEI") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;
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
    for (Jogador j : jogadores){
      if (j.getPosicao().toString() == "CA" || j.getPosicao().toString() == "PTE" || j.getPosicao().toString() == "PTD") {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;
  }
   public int calcularForcaAtaque(){
      return round((overAtaque(true)+overMeio(true))/2);
   }
   public int calcularForcaDefesa(){
     return round(overDefesa(true));
  }

}


