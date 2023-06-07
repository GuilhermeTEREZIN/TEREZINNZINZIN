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

    public static ArrayList<Jogador> jogadores() throws Exception
    {

        ArrayList<Jogador>  jogadores = new ArrayList<>(); // cria uma lista de jogadores
        String nomeJogador[];//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/base/jogadores.CSV"); // abre o arquivo csv
        //System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
        // sc.useDelimiter(",");   //sets the delimiter pattern
        //String teste=sc.next();
        //System.out.println(teste);// Separa o id do nome do time
        while (sc.hasNext())  //returns a boolean value
        {
            nomeJogador = sc.next().split(",");

            //nomeTime[0] = id
            //nomeTime[1] = nome
            //nomeTime[2] = idade
            //nomeTime[3] = clube
            //nomeTime[4] = posicao
            //nomeTime[5] = numerocamisa
            //nomeTime[6] = overral
            //nomeTime[7] = nacionalidade

            //jogadores.add(new Jogador(Integer.parseInt(nomeJogador[0].strip()),nomeJogador[1].strip(),nomeJogador[2].strip(),nomeJogador[3].strip(),nomeJogador[4].strip(),nomeJogador[5].strip(),nomeJogador[6].strip(),nomeJogador[7].strip()));//adciona o time a lista de times
        }
        sc.close();  //closes the scanner
        return jogadores; //retorna a lista de times

    }
}
