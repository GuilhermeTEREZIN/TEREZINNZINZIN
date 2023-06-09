import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MenuSwing.iniciarInterface();
        Player p = new Player();
        PartidaSimulada f = new PartidaSimulada();
        Funcoes.carregarjogo(p);
        int[] gols = {0,0};
        try {
            for (int i=0;i<20;i++){
                gols[0] = 0;gols[1] = 0;
                f.simularParida(p.getTimes().get(0),p.getTimes().get(1),gols);

            }
        }catch (Exception e){
            System.out.println(e);
        }
//        System.out.println(p.getTimes().get(0).overDefesa(true));

    }
}