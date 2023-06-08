import java.util.ArrayList;

public class Funcoes {
    public static void iniciarnovoJogo(){
        CopiaCsv.Copiar("save");
        CopiaCsv.Copiar("jogadores");
        CopiaCsv.Copiar("Calendario");
        CopiaCsv.Copiar("Liga");
        TabelaConfrontos.gerarLiga();
        //TabelaConfrontos.gerarCopa();
    }
    public static ArrayList<Time> inserirJogadoresTime(ArrayList<Time> times,ArrayList<Jogador> jogadores){
        for(Time t :times){
//            System.out.println(t.getNome());
            for (Jogador j :jogadores) {
                if (t.getNome().equals(j.getClube())){
//                    System.out.println(t.getNome()+" :" + j.getClube());
                    t.addJogador(j);
                }
            }
        }
        return times;
    }
}

