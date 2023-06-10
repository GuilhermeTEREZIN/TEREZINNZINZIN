import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class exportCsv {
    public static void main(String[] args) {
        try {
            FileWriter arq = new FileWriter("./PojetoBrasFoot/save/save.csv");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite algo: ");
            String entrada = scanner.nextLine();

            arq.write(entrada + "\n");
            arq.write("abre a perna que la vem pika ...");
            arq.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}