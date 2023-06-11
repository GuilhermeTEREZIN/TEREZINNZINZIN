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

    public static void simularRodada(Player p){
        try {
            Scanner sc = new Scanner(System.in);
            PartidaPlayer Playerp =  new PartidaPlayer();
            PartidaSimulada Simulp = new PartidaSimulada();
            Time time1 = p.getTime();
            Time time2 = p.getTime();
            int[] gols = {0,0};
            String[][] rodada = importarCsv.Confrontos(p.getRodada());
            int count = 0;
            System.out.println(ConsoleColors.GREEN_BOLD+"Rodada: "+p.getRodada()+" do Campeonato Brasileiro"+ConsoleColors.RESET);

            for (int i = 0;i<10;i++) {
                gols[0] = 0;
                gols[1] = 0;
                for (Time t : p.getTimes()) {
                    if (t.getNome().equals(rodada[i][2])) {
                        time1 = t;
                    } else if (t.getNome().equals(rodada[i][3])) {
                        time2 = t;
                    }
                }
                //partida simulada ou com o time do player
                if (time1.getNome().equals(p.getTime().getNome())||time2.getNome().equals(p.getTime().getNome())) {
                    System.out.println(ConsoleColors.CYAN_UNDERLINED+"-------------------------------------\nPróximo Jogo(Digite Algo Para Continuar)"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN+ time1.getNome()+" x "+time2.getNome());
                    sc.next();
                    Playerp.simularParida(time1,time2,gols);
                    System.out.println("(Digite Algo Para Continuar)");
                    sc.next();
                }else {
                    Simulp.simularParida(time1,time2,gols);
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
                } else if (gols[1]>gols[0]){
                    time2.setPontos(time2.getPontos()+3);

                }else {
                    time1.setPontos(time1.getPontos()+1);
                    time2.setPontos(time2.getPontos()+1);
                }
                TimeUnit.SECONDS.sleep(2);

            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Esquema de Apostas descoberto, rodada cancelada");
        }
    }
}

