import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] jogadores;
//        System.out.println("=-----=-----=BrasFoot 2.0=-----=-----=");
////        Menu.menu();
        //Partida.simularPartida(new Time(1,"santos"),new Time(2,"flamengo"),false);
        try {
            jogadores = importarCsv.CarregarSave();
        }catch (Exception e){
            System.out.println(e);
        }
//
//        for (Time t :times){
//            System.out.println(t.getNome()+t.getId());
//        }


    }
}