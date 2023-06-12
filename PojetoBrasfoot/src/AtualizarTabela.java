import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;


public class AtualizarTabela {

    public static void AtualizarTabela(Player p) {
        try {
            FileWriter arq = new FileWriter("./PojetoBrasFoot/save/times.csv");
            arq.write("id,time,pontos,jogos,golsfeitos,golsofridos,vitorias,derrotas,empates");
            for (Time t : p.getTimes()) {
                ////escreve no arquivo
                arq.write("\n"+t.getId() + "," + t.getNome() + "," + t.getPontos() + "," + t.getJogos()+ "," + t.getGolsmarcados() +
                        "," + t.getGolsofridos() + "," + t.getVitorias() + "," + t.getDerrotas() + "," + t.getEmpates());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
