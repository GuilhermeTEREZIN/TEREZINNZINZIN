import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Funcoes {
    public static void iniciarnovoJogo(String nome,String time){
        CopiaCsv.Copiar("save");
        exportCsv.exportSave(nome,time,1,100f,1);
        CopiaCsv.Copiar("jogadores");
        CopiaCsv.Copiar("Calendario");
        CopiaCsv.Copiar("times");
        TabelaConfrontos.gerarLiga();
        //TabelaConfrontos.gerarCopa();
    }
    public static void carregarjogo(Player p) {
        try {
            //Carrega os jogadores nos seus respectivos times
            ArrayList<Time> times = importarCsv.times();
            ArrayList<Jogador> jogadores = importarCsv.jogadores();
            times = inserirJogadoresTime(times,jogadores);
            // times contem os times já com os jogadores

            String[] save = importarCsv.CarregarSave();//carrega as informações do save

            for (Time t:times){
                if(t.getNome().equals(save[1])){
                    p.setTime(t);
                    break;
                }
            }
            p.setNome(save[0]);
            p.setRodada(Integer.parseInt(save[2]));
            p.setDinheiro(Float.parseFloat(save[3]));
            p.setTemporada(Integer.parseInt(save[4]));
            p.setTimes(times);
            //System.out.println(p.getNome()+" "+p.getTime().getNome());

        }catch (Exception e){
            System.out.println("Erro ao Carregar o save");
            System.exit(0);
        }

    }
    public static ArrayList<Time> inserirJogadoresTime(ArrayList<Time> times,ArrayList<Jogador> jogadores){
        for(Time t :times){
            //System.out.println(t.getNome());
            for (Jogador j :jogadores) {
                if (t.getNome().equals(j.getClube())){
                    //System.out.println(t.getNome()+" :"+j.getNome() + j.getClube());
                    t.addJogador(j);
                }
            }
        }
        for (Time t:times){
            ArrayList<Jogador> titulares = new ArrayList<>();
            titulares = iniciarTitulares(t.getJogadores());
            t.setTitulares(titulares);
        }
        return times;
    }
    public static ArrayList<Jogador> iniciarTitulares(ArrayList<Jogador> jogadores){
        ArrayList<Jogador> titulares = new ArrayList<>();
        for (int i = 0;i<11;i++) {
            titulares.add(jogadores.get(i));
        }
        return titulares;

    }
    public static String[] proximoJogo(Player p) throws Exception{

        String[][] rodada = importarCsv.Confrontos(p.getRodada());
//        System.out.println(p.getTime().getNome());
        for (int i = 0;i<10;i++){
            if(p.getTime().getNome().equals(rodada[i][2])||p.getTime().getNome().equals(rodada[i][3])){
                return rodada[i];
            }
        }
        return rodada[0];
    }

    public static void proximaRodada(Player p){
        try {
            String[][] rodada = importarCsv.Confrontos(p.getRodada());
            for (int i = 0;i<10;i++){
                System.out.println(ConsoleColors.GREEN_BOLD+ "Rodada "+rodada[i][0]+" Jogo: "+rodada[i][1]+ConsoleColors.RESET+
                        "\n"+rodada[i][2]+" x "+rodada[i][3]);
            }
        }catch (Exception e){
            System.out.println("Esquema de Apostas descoberto, rodada cancelada");
        }

    }

    public static String[][] simularRodada(Player p){
        String[][] armazenaResults = new String[10][4];

        try {
            Scanner sc = new Scanner(System.in);
            Time time1 = p.getTime();
            Time time2 = p.getTime();
            int[] gols = {0,0};
            Liga l = new Liga(p);
            if (p.getRodada()>38){
                System.out.println("O campeonato acabou o Campeão foi: "+l.lider().getNome());

                /////salvar////////////////
                System.exit(0);
            }
            String[][] rodada = importarCsv.Confrontos(p.getRodada());
            int count = 0;
            System.out.println(ConsoleColors.GREEN_BOLD+"Rodada: "+p.getRodada()+" do Campeonato Brasileiro"+ConsoleColors.RESET);

            for (int i = 0;i<10;i++) {
                for (Time t : p.getTimes()) {
                    if (t.getNome().equals(rodada[i][2])) {
                        time1 = t;
                    } else if (t.getNome().equals(rodada[i][3])) {
                        time2 = t;
                    }
                }
                //partida simulada ou com o time do player
                if (time1.getNome().equals(p.getTime().getNome())||time2.getNome().equals(p.getTime().getNome())) {
                    PartidaPlayer Playerp =  new PartidaPlayer(time1,time2);
                    System.out.println(ConsoleColors.CYAN_UNDERLINED+"-------------------------------------\nPróximo Jogo"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN+ time1.getNome()+" x "+time2.getNome());
//                    sc.next();
                    Playerp.simularParida();
                    gols = Playerp.getGols();

//                    System.out.println("(Digite Algo Para Continuar)");
//                    sc.next();
//                    if (i!=9){
////                        System.out.println("Restante da Rodada");
//                    }
                }else {
                    PartidaSimulada Simulp = new PartidaSimulada(time1,time2);
                    Simulp.simularParida();
                    gols = Simulp.getGols();
                }
                //salvando informações
                time1.setJogos(time1.getJogos()+1);
                time2.setJogos(time2.getJogos()+1);
                time1.setGolsmarcados(time1.getGolsmarcados()+gols[0]);
                time2.setGolsmarcados(time2.getGolsmarcados()+gols[1]);
                time1.setGolsofridos(time1.getGolsofridos()+gols[1]);
                time2.setGolsofridos(time2.getGolsofridos()+gols[0]);


                if(gols[0]>gols[1]){
                    time1.setPontos(time1.getPontos()+3);
                    time1.setVitorias(time1.getVitorias()+1);
                    time2.setDerrotas(time2.getDerrotas()+1);
                } else if (gols[1]>gols[0]){
                    time2.setPontos(time2.getPontos()+3);
                    time2.setVitorias(time2.getVitorias()+1);
                    time1.setDerrotas(time1.getDerrotas()+1);

                }else {
                    time1.setPontos(time1.getPontos()+1);
                    time2.setPontos(time2.getPontos()+1);
                    time1.setEmpates(time1.getEmpates()+1);
                    time2.setEmpates(time2.getEmpates()+1);

                }
                armazenaResults[i][0] = time1.getNome();
                armazenaResults[i][1] = Integer.toString(gols[0]);
                armazenaResults[i][2] = time2.getNome();
                armazenaResults[i][3] = Integer.toString(gols[1]);
//                TimeUnit.SECONDS.sleep(2);
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Esquema de Apostas descoberto, rodada cancelada");
        }
        p.setRodada(p.getRodada()+1);

        return armazenaResults;

    }
    public static void salvarProgresso(String nome,String time,int rodada, float dinheiro, int temporada){
        exportCsv.exportSave(nome, time, rodada, dinheiro, temporada);
        //salvarTabela
    }
    public static void novaTemporada(String nome,String time,int rodada, float dinheiro, int temporada){
        TabelaConfrontos.gerarLiga();
        CopiaCsv.Copiar("times");
        exportCsv.exportSave(nome, time, 1, dinheiro, temporada);
    }
}

