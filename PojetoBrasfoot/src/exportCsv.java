import java.io.FileWriter;
import java.io.IOException;

public class exportCsv {
    public static void exportSave(String nome,String time,int rodada, float dinheiro, int temporada) {
        try {
            //nome
            //time
            //rodada
            //dinheiro
            //temporada
            FileWriter arq = new FileWriter("./PojetoBrasFoot/save/save.csv");
            arq.write( "Nome,Time,rodada,Dinheiro,Temporada");
            ///////
            arq.write("\n"+nome+","+time+","+rodada+","+dinheiro+","+temporada );
            arq.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}