import java.util.ArrayList;

import static java.lang.Math.round;

public class Time {
  private int id;
  private Pais pais;
  private String nome;
  private ArrayList<Jogador> jogadores;
  private ArrayList<Jogador> titulares;

  private int pontos;
  private int jogos;
  private int golsmarcados;
  private int golsofridos;


  public Time(int id, String nome, int pontos,int jogos,int golsmarcados,int golsofridos) {
    this.nome = nome;
    this.id = id;
    this.pais = Pais.BRA;
    this.pontos = pontos;
    this.jogos = jogos;
    this.golsmarcados = golsmarcados;
    this.golsofridos = golsofridos;
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
  public void addTitular(Jogador j){jogadores.add(j);}

  public ArrayList<Jogador> getJogadores() {
    return jogadores;
  }

  public ArrayList<Jogador> getTitulares() {
    return titulares;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public void setTitulares(ArrayList<Jogador> titulares) {
    this.titulares = titulares;
  }

  public int getGolsofridos() {
    return golsofridos;
  }

  public int getGolsmarcados() {
    return golsmarcados;
  }

  public int getPontos() {
    return pontos;
  }

  public int getJogos() {
    return jogos;
  }

  public Pais getPais() {
    return pais;
  }

  public void setGolsofridos(int golsofridos) {
    this.golsofridos = golsofridos;
  }

  public void setGolsmarcados(int golsmarcados) {
    this.golsmarcados = golsmarcados;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
  }

  public void setJogos(int jogos) {
    this.jogos = jogos;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setJogadores(ArrayList<Jogador> jogadores) {
    this.jogadores = jogadores;
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


