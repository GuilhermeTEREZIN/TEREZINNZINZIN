import java.util.ArrayList;

public interface Tabela {

    String melhorDefesa(); //retorna o time com menos gols sofridos (desempate: pontos, alfabetico)
    String melhorAtaque(); //retorna o time com mais gols feitos (desempate: pontos, alfabetico)
    String lider();//retorna o time que está na lideraça
    String[] melhores4();//retorna os 4 primeiros
    String[] piores4();//retona os quatro ultimos

    Time[] getTabela();
    void printarTabela();// printa a tabela em ordem de quem tem mais pontos(desempate: golsfeitos, golsofridos,ordem alfabetica)



}
