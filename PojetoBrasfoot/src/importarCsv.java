import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class importarCsv
{
    public static ArrayList<Time> times() throws Exception
    {
        ArrayList<Time>  times = new ArrayList<>(); // cria uma lista de times
        String nomeTime[];//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/base/time.csv"); // abre o arquivo csv
//        System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
       // sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            nomeTime = sc.next().split(","); // Separa o id do nome do time
            //nomeTime[0] = id
            //nomeTime[1] = nome do time
            times.add(new Time(Integer.parseInt(nomeTime[0].strip()),nomeTime[1].strip()));//adciona o time a lista de times
        }
        sc.close();  //closes the scanner
        return times; //retorna a lista de times

    }

    //public static ArrayList<Jogador> jogadores() throws Exception
}
