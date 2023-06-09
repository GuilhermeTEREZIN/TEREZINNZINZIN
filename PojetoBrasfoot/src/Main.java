import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MenuSwing.iniciarInterface();
        Player p = new Player();
        PartidaPlayer f = new PartidaPlayer();
        Funcoes.carregarjogo(p);
        int[] gols = {0,0};
        try {
            f.simularParida(p.getTimes().get(0),p.getTimes().get(1),gols);


        }catch (Exception e){
            System.out.println(e);
        }


    }
}