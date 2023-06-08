public class Jogador {
    private int id;
    private String nome;
    private String pais;
    private int idade;
    private String posicao;
    private int overall;
    private int numero;
    private String clube;

    public Jogador(int id,String nome, int idade, String clube,String posicao, int numero,int overall,String pais){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.clube = clube;
        this.posicao = posicao;
        this.numero = numero;
        this.overall = overall;
        this.pais = pais;
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

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
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
