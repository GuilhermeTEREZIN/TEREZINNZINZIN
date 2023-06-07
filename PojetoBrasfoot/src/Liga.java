import java.util.ArrayList;

public class Liga implements Tabela{
    String[][] tabela = new String[20][6];
    //id - nome - pontos - jogos - golsfeitos - golsofridos
    //
    public Liga(){
    }
    String getNome(int id);
    void setNome(int id);
    int getPontos(int id);
    void setPontos(int id);
    int getGolsfeitos(int id);
    void setGolsfeitos(int id);
    int getGolssofridos(int id);
    void setGolssofridos(int id);
    void setJogos(int id);
    int getJogos(int id);
}
