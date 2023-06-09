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
  public int over(boolean titulares) {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    //Opção de pegar somente os titulares ou todos os jogadores
    if (titulares){
      jogadores = this.titulares;
    }else {
      jogadores = this.jogadores;
    }
    int Over = 0;
    int Contador = 0;
    for (Jogador j : jogadores) { //laço de repetição que itera todos os jogadores do time
      Over += j.getOverall();
      Contador += 1;
    }
    return Over / Contador; ///retorna a média de over geraç

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
      //somente conta os defensores
      if (j.getPosicao().equals("ZAG") || j.getPosicao().equals("GO") || j.getPosicao().equals("LD") || j.getPosicao().equals("LE")) {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;//retorna a média de over dos defensores

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
      //conta somente os meio-campistass
      if (j.getPosicao().equals("VOL") || j.getPosicao().equals("MLG") || j.getPosicao().equals("MEI")) {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;//retorna a média dos meio-campos
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
      //conta somente os atacantes
      if (j.getPosicao().equals("CA") || j.getPosicao().equals("PTE") || j.getPosicao().equals("PTD")) {
        Over += j.getOverall();
        Contador += 1;
      }
    }
    return Over / Contador;//retorna média dos atacantes
  }
   public int calcularForcaAtaque(){
      return (overAtaque(true)+overMeio(true))/2;
   }
   public int calcularForcaDefesa(){
     return overDefesa(true);
  }

  public Pais getPais() {
    return pais;
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
  public void setNome(String nome) {
    this.nome = nome;
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
  public void setPais(Pais pais) {
    this.pais = pais;
  }
  public void setTitulares(ArrayList<Jogador> titulares) {
    this.titulares = titulares;
  }

}


