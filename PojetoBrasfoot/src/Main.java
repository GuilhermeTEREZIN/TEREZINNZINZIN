import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MenuSwing.iniciarInterface();
        Player p = new Player();
        Funcoes.carregarjogo(p);
        try {
//            System.out.println(p.getTimes().get(5).getNome()+" "+p.getTimes().get(5).getPontos()+" "
//                    +p.getTimes().get(5).getGolsmarcados()+" "+p.getTimes().get(5).getGolsofridos());
            Funcoes.simularRodada(p);
//            System.out.println(p.getTimes().get(5).getNome()+" "+p.getTimes().get(5).getPontos()+" "
//                    +p.getTimes().get(5).getGolsmarcados()+" "+p.getTimes().get(5).getGolsofridos());
        }catch (Exception e) {
            System.out.println(e);
        }
//        int[] gols = {0,0};
//
//        for (int i = 0;i<20;i = i+2){
//            try {
//                gols[0] = 0;
//                gols[1] = 0;
//                f.simularParida(p.getTimes().get(i),p.getTimes().get(i+1),gols);
//
//
//            }catch (Exception e){
//                System.out.println(e);
//            }
//
//        }



    }
}