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
            p.printarTimes();
            int i = 0;
            for (Time t : p.getTimes()) {
//                System.out.println(i);
//                i++;
                arq.write("\n"+t.getId()+","+t.getNome()+","+t.getPontos()+","+t.getJogos()+","+t.getGolsmarcados()+","+t.getGolsofridos()+","+ t.getVitorias()+","+t.getDerrotas()+","+t.getEmpates());
            }
            arq.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
