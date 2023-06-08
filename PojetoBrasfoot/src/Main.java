import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Time> times = new ArrayList<>();
//        MenuSwing.iniciarInterface();
//        Funcoes.iniciarnovoJogo();
        try {
            times = Funcoes.inserirJogadoresTime(importarCsv.times(),importarCsv.jogadores());
        }catch (Exception e){
            System.out.println("F");
        }

        System.out.println(times.get(0).getJogadores().size());
    }
}