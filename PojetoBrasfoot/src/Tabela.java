import java.util.ArrayList;

public interface Tabela {

    Time melhorDefesa(); //retorna o time com menos gols sofridos
    Time melhorAtaque(); //retorna o time com mais gols feitos
    Time lider();//retorna o time que está na lideraça

    ArrayList<Time> getTabela();
    void organizarTabela();
    void printarTabela();
//
//

}
