import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = new ArrayList<>();
//        System.out.println("=-----=-----=BrasFoot 2.0=-----=-----=");
////        Menu.menu();
//        Partida.simularPartida(new Time(1,"santos"),new Time(2,"flamengo"),false);
        try {
            jogadores = importarCsv.jogadores();
        }catch (Exception e){
            System.out.println(e);
        }
        for (Jogador j:jogadores){

            System.out.println(j.getNome());;
        }
//
//        for (Time t :times){
//            System.out.println(t.getNome()+t.getId());
//        }


    }
}