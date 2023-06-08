import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaCsv {

    public static void Copiar(String nomeArquivo) {
        String arquivoOrigem = "./PojetoBrasfoot/base/"+nomeArquivo+".csv";
        String arquivoDestino = "./PojetoBrasfoot/save/"+nomeArquivo+".csv";

        try {
            copiarArquivoCSV(arquivoOrigem, arquivoDestino);
            //System.out.println("Arquivo CSV copiado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao copiar o arquivo CSV: " + e.getMessage());
        }
    }

    public static void copiarArquivoCSV(String arquivoOrigem, String arquivoDestino) throws IOException {
        BufferedReader leitor = null;
        BufferedWriter escritor = null;

        try {
            leitor = new BufferedReader(new FileReader(arquivoOrigem));
            escritor = new BufferedWriter(new FileWriter(arquivoDestino));

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }
        } finally {
            if (leitor != null) {
                leitor.close();
            }
            if (escritor != null) {
                escritor.close();
            }
        }
    }
}
