import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        try {
//            Funcoes.iniciarnovoJogo();

            Funcoes.carregarjogo(player);
            PartidaSimulada p = new PartidaSimulada()
        }catch (Exception e){
            System.out.println(e);
        }

    }
}