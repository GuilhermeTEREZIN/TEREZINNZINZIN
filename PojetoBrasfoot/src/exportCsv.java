import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class exportCsv {
    public static void main(String[] args) {
        try {
            //nome
            //time
            //rodada
            //dinheiro
            //temporada

            FileWriter arq = new FileWriter("./PojetoBrasFoot/save/save.csv");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite seu nome: ");
            String entrada = scanner.nextLine();
            System.out.print("Digite seu time: ");
            String entrada2 = scanner.nextLine();
            System.out.print("Digite sua rodada: ");
            String entrada3 = scanner.nextLine();
            System.out.print("Digite o valor: ");
            String entrada4 = scanner.nextLine();
            System.out.print("Digite a temporada: ");
            String entrada5 = scanner.nextLine();

            arq.write( "Nome,Time,rodada,Dinheiro,Temporada");
            arq.write("\n"+entrada+","+entrada2+","+entrada3+","+entrada4+","+entrada5 );
            arq.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}