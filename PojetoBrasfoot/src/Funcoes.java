import java.util.ArrayList;

public abstract class Funcoes {
    public static void iniciarnovoJogo(){
        CopiaCsv.Copiar("save");
        CopiaCsv.Copiar("jogadores");
        CopiaCsv.Copiar("Calendario");
        CopiaCsv.Copiar("times");
        TabelaConfrontos.gerarLiga();
        //TabelaConfrontos.gerarCopa();
    }
    public static void carregarjogo(Player p){
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
            System.out.println(e);
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
}

