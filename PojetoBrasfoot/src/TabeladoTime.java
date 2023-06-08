public class TabeladoTime extends Time{
    private int pontos;
    private int jogos;
    private int golsmarcados;
    private int golsofridos;
    public TabeladoTime(int id,String nome,int pontos,int jogos,int golsmarcados, int golsofridos){
        super(id,nome);
        this.jogos = jogos;
        this.pontos = pontos;
        this.golsmarcados = golsmarcados;
        this.golsofridos = golsofridos;
    }


}
