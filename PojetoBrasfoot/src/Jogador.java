public class Jogador {
    private int id;
    private String nome;
    private String pais;
    private int idade;
    private Posicao posicao;
    private int overall;
    private int numero;
    private String clube;

    public Jogador(int id,String nome, String pais, int idade, Posicao posicao,int overall, int numero,String clube){
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.idade = idade;
        this.posicao = posicao;
        this.overall = overall;
        this.numero = numero;
        this.clube = clube;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
