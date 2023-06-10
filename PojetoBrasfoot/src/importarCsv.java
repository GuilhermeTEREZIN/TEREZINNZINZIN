import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class importarCsv {
    public static ArrayList<Time> times() throws Exception {
        ArrayList<Time> times = new ArrayList<>(); // cria uma lista de times
        String nomeTime[];//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/save/times.csv"); // abre o arquivo csv
//        System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
        nomeTime = sc.next().split(","); //retira a primeira linha
        while (sc.hasNext())  //returns a boolean value
        {
            nomeTime = sc.next().split(","); // Separa o id do nome do time
            //nomeTime[0] = id
            //nomeTime[1] = nome do time
            //nomeTime[2] = pontos
            //nomeTime[3] = jogos
            //nomeTime[4] = golsfeitos
            //nomeTime[5] = golsofridos

            times.add(new Time(Integer.parseInt(nomeTime[0].strip()),
                    nomeTime[1].strip(),
                    Integer.parseInt(nomeTime[2].strip()),
                    Integer.parseInt(nomeTime[3].strip()),
                    Integer.parseInt(nomeTime[4].strip()),
                    Integer.parseInt(nomeTime[5].strip())));
            //adciona o time a lista de times
        }
        sc.close();  //closes the scanner
        return times; //retorna a lista de times

    }

    public static ArrayList<Jogador> jogadores() throws Exception {

        ArrayList<Jogador> jogadores = new ArrayList<>(); // cria uma lista de jogadores
        String nomeJogador[];//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/base/jogadores.csv"); // abre o arquivo csv
        //System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
        // sc.useDelimiter(",");   //sets the delimiter pattern

        while (sc.hasNext())  //returns a boolean value
        {
            nomeJogador = sc.next().split(",");
//            System.out.println(nomeJogador[0]+nomeJogador[1]+nomeJogador[2]+nomeJogador[3]+nomeJogador[4]
//            +nomeJogador[5]+nomeJogador[6]+nomeJogador[7]);

            //nomeTime[0] = id
            //nomeTime[1] = nome
            //nomeTime[2] = idade
            //nomeTime[3] = clube
            //nomeTime[4] = posicao
            //nomeTime[5] = numerocamisa
            //nomeTime[6] = overral
            //nomeTime[7] = nacionalidade

            jogadores.add(new Jogador(Integer.parseInt(nomeJogador[0].strip()),
                    nomeJogador[1].strip(),
                    Integer.parseInt(nomeJogador[2].strip()),
                    nomeJogador[3].strip(),
                    nomeJogador[4].strip(),
                    Integer.parseInt(nomeJogador[5]),
                    Integer.parseInt(nomeJogador[6].strip()),
                    nomeJogador[7].strip()));//adciona o time a lista de times
        }
        sc.close();  //closes the scanner
        return jogadores; //retorna a lista de times

    }

    public static String[] CarregarSave() throws Exception{
        String CarregarSave[];//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/save/save.csv"); // abre o arquivo csv
        //System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
        // sc.useDelimiter(",");   //sets the delimiter pattern
        CarregarSave = sc.next().split(",");

        while (sc.hasNext())  //returns a boolean value
        {
            //nomeTime[0] = nome
            //nomeTime[1] = time
            //nomeTime[2] = rodada
            //nomeTime[3] = dinheiro
            //nomeTime[4] = temporada

            CarregarSave = sc.next().split(",");

        }
        return CarregarSave;

    }

    public static String[][] Confrontos(int rodada) throws Exception{
        String[][] retorno = new String[10][4];
        String[] Confrontos;//Variavel para auxiliar na extração dos dados

        File file = new File("./PojetoBrasFoot/save/confrontosLiga.csv"); // abre o arquivo csv
        //System.out.println(file.exists());
        Scanner sc = new Scanner(file);//inicia a classe scanner
        // sc.useDelimiter(",");   //sets the delimiter pattern
        Confrontos = sc.next().split(",");
        while (sc.hasNext())  //returns a boolean value
        {
            Confrontos = sc.next().split(",");

            //nomeTime[0] = rodada
            //nomeTime[1] = jogo
            //nomeTime[2] = time1
            //nomeTime[3] = time2
            if(Integer.parseInt(Confrontos[0]) == rodada){
                retorno[Integer.parseInt(Confrontos[1])-1][0] = Confrontos[0];
                retorno[Integer.parseInt(Confrontos[1])-1][1] = Confrontos[1];
                retorno[Integer.parseInt(Confrontos[1])-1][2] = Confrontos[2];
                retorno[Integer.parseInt(Confrontos[1])-1][3] = Confrontos[3];

            }
            //System.out.println(Confrontos[0] + Confrontos[1] + Confrontos[2] + Confrontos[3]);

        }
        return retorno;
    }


}
