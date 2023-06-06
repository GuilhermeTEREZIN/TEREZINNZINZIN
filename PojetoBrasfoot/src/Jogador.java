public class Jogador {
    private String nome;
    private String pais;
    private int idade;
    private String posicao;
    private int overall;
    private int numero;

    public Jogador(String nome, String pais, int idade, String posicao,int overall, int numero){
        this.nome = nome;
        this.pais = pais;
        this.idade = idade;
        this.posicao = posicao;
        this.overall = overall;
        this.numero = numero;
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
