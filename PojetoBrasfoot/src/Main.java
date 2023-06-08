import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        try {
//            Funcoes.iniciarnovoJogo();

            Funcoes.carregarjogo(player);

//            PartidaSimulada p = new PartidaSimulada(player.getTimes().get(0),player.getTimes().get(1));
//
//            for (Jogador t:player.getTime().getJogadores()){
//                System.out.println(t.getNome()+t.getPosicao());
//            }
//
//            p.simularParida();
            for (Time t : player.getTimes()){
                System.out.println("------------------------------------------------------");
                System.out.println(t.getNome());
                for(int i = 0; i<player.getTimes().size();i++){
                    System.out.println(player.getTimes().get(i).getJogadores().get(0).getNome());
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
}