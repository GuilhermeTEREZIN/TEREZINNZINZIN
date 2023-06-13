//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class PartidaPlayer extends Partida{
//    private ArrayList<Integer> historico;
//    private int minuto;
//    public PartidaPlayer(Time time1,Time time2){
//        super(time1,time2);
////        getGols() = new int[2];
//        historico = new ArrayList<>();
//        resetarGols();
//        minuto = 0;
//    }
//
//    @Override
//    public void simularParida() throws Exception {
//        if(getTime1().getTitulares().size()<11||getTime2().getTitulares().size()<11){
//            throw new erroPartida();
//        }
//        resetarGols();
//
//        System.out.println("Inicio da Partida");
//        simularEtapa(10,15,1,45);
//        System.out.println("Fim do Primeiro Tempo\n");
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println("Inicio do Segundo Tempo");
//        simularEtapa(10,15,46,90);
//        System.out.println("Fim da Partida");
//        placar();
//    }
//
//    public void simularEtapa(int qtdeJogadas, int chanceGol,int inicio,int fim){
//        Random r = new Random();
//
//        for(int i = inicio; i<=fim;i++){
//            this.minuto = i;
//            System.out.println(ConsoleColors.CYAN_BOLD+i+"' - "+ConsoleColors.RESET);
//            if(r.nextInt(100)>90){
//                if (r.nextInt(2)==0){
//                    naracao(getTime1());
//
//                }else
//                    naracao(getTime2());
//            }
//
//            try {
//                TimeUnit.MILLISECONDS.sleep(700);
//            }catch (Exception e){}
//
//            if (r.nextInt(qtdeJogadas) == 0){ // chance de gol de algum dos times
//                chanceGol(chanceGol);
//            }
//        }
//        int acrescimos = acrescimos();
//        if(acrescimos>0){
//            System.out.println(ConsoleColors.GREEN_BOLD+"Acrescimos: +"+acrescimos+ConsoleColors.RESET );
//            for ( int i = fim+1;i<=fim+acrescimos;i++){
//                System.out.println(ConsoleColors.CYAN_BOLD+fim+"+"+(i-fim)+"' - "+ConsoleColors.RESET);
//
//                try {
//                    TimeUnit.MILLISECONDS.sleep(800);
//                }catch (Exception e){}
//
//                if (r.nextInt(qtdeJogadas) == 0){
//                     chanceGol(chanceGol/2);
//                }
//            }
//        }
//
//    }
//
//
//    @Override
//    public void chanceGol(int chance) {
//        Random r = new Random();
//
//        int t1 = r.nextInt(50)+calcularBonus(getTime1(),getTime2());
//        int t2 = r.nextInt(50)+calcularBonus(getTime1(),getTime2());
//        //System.out.println(t1 +" "+ t2);
//        if (t1>t2){
//            //chance do time 1
//            if( r.nextInt(100)<chance){ // gol
//                gol(0);
//                naracaoGol(getTime1(),getTime2(),false,true);
//
//
//                // chance de contra-ataque
//            }else if( r.nextInt(5)==0){
//                if ( r.nextInt(100)<chance+getTime2().over(true)/20){//gol do time 1 de contra ataque
//                    gol(1);
//                    naracaoGol(getTime2(),getTime1(),true,true);
//                }else {
//
//                    naracaoGol(getTime2(),getTime1(),true,false);
//
//                }
//            }else {
//                naracaoGol(getTime1(),getTime2(),false,false);
//            }
//        }else if (t2>t1){
//            if( r.nextInt(100)<chance){
//               gol(1);
//                naracaoGol(getTime2(),getTime1(),false,true);
//
//            }else if( r.nextInt(5)==0){//chance de contra-ataque
//                if ( r.nextInt(100)<chance+getTime2().over(true)/20){ // gol do time 1 de contra ataque
//                    gol(0);
//                    naracaoGol(getTime1(),getTime2(),true,true);
//
//                }else {
//                    naracaoGol(getTime1(),getTime2(),true,false);
//
//                }
//            }else {
//                naracaoGol(getTime2(),getTime1(),false,false);
//            }
//
//        }
//       placar();
//
//    }
//    @Override
//    public void placar() {
//        System.out.println(ConsoleColors.CYAN_BOLD  +getTime1().getNome()+" "+getGols()[0]+" X "+getGols()[1]+" "+getTime2().getNome()+ConsoleColors.RESET);
//    }
//    //sobrecarga
//    public void placar( int[] golsPenalti){
//        System.out.println(ConsoleColors.CYAN_BOLD+getTime1().getNome()+" "+getGols()[0]+"("+golsPenalti[0]+") X "+getGols()[1]+"("+golsPenalti[1]+") "+getTime2().getNome()+ConsoleColors.RESET);
//
//    }
//    //private static void naracaoChance(Time time,boolean contrAtaque)
//    //private static void narracao(Time time1,boolean contraAtaque) ////NARAÇÃO PRA ERRO
//    //private static void narracao(Time time1,Time time2,boolean contraAtaque) /// GOLS
//    //
//    public String statusPartida(){
//        if (getGols()[0] == getGols()[1]){
//            return  "EMPATE";
//
//        }else if (getGols()[0] < getGols()[1]){
//            return  "TIME2";
//
//        } else if (getGols()[0] > getGols()[1]){
//            return  "TIME1";
//
//        }
//        return "DESCONHECIDO";
//    }
//    public void dormir(int mls){
//        try {
//            TimeUnit.MILLISECONDS.sleep(mls);
//        }catch (Exception e){}
//    }
//    private void naracao(Time time){
//        Random r = new Random();
//        int tmZG = getZaga(time).size();
//        int tmMeio = getMeio(time).size();
//        int tmATA = getAtacante(time).size();
//        dormir(300);
//
//        if (minuto>85){
//            int i = r.nextInt(40);
//            if (statusPartida().equals("EMPATE")){
//                if (i<10){
//                    System.out.println("Imagina se sai um gol agora");
//                }else if(i<20){
//                    System.out.println("Tá acabando Mas a torcida empurra o time da casa");
//                }else {
//                    System.out.println("O pessoal aqui tá parece que estão acomodados com o empate");
//                }
//            } else {
//                if (i<10){
//                    System.out.println("Estamos nos minutos finais");
//                }else if(i<20){
//                    System.out.println("Toque de bola do "+time.getNome()+", está acabando");
//                }else if (i<30){
//                    System.out.println("O pessoal aqui Acha que o tempo já acabou, que falta de Vontade!");
//                }else if(i<40){
//                    System.out.println("Agora Vem a Famosa Cera");
//                }else {
//                    System.out.println("Está quase lá, a vitória está a vista");
//                }
//            }
//
//        }else {
//            int i = r.nextInt(50);
//            if (i<10){
//                System.out.println("Acelera o "+time.getNome()+" pelo meio de campo");
//            }else if(i<20){
//                System.out.println("Virada de jogo para a lateral");
//            }else if(i<30){
//                System.out.println("Sai jogando "+getZaga(time).get(r.nextInt(tmZG)).getNome()+" na defesa");
//            }else if(i<40){
//                System.out.println("troca de passes do "+time.getNome()+" no campo de ataque");
//            }else if(i<50){
//                System.out.println("Linda finta do "+getMeio(time).get(r.nextInt(tmMeio)).getNome()+" pra cima do adversario");
//            }
//            else {
//                System.out.println("Bela caneta do"+getMeio(time).get(r.nextInt(tmMeio)).getNome());
//            }
//        }
//        int i = r.nextInt(100);
//    }
//    private void naracaoGol(Time time,Time time2,boolean contrAtaque,boolean gol){
//        Random r = new Random();
//        int tmZG = getZaga(time).size();
//        int tmMeio = getMeio(time).size();
//        int tmATA = getAtacante(time).size();
//        String s = statusPartida();
//
//        dormir(500);
//        if(contrAtaque ){
//            int i = r.nextInt(50);
//
//            if (i<10){
//                System.out.println("E o contra-ataque se desenrola rapidamente! "+getMeio(time).get(r.nextInt(tmMeio)).getNome()+" avança em velocidade");
//                System.out.println("Cruzamento para "+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                dormir(300);
//                if (gol){
//                    if (s.equals("EMPATE")){
//                        System.out.println("Golaço, Pra Desempatar");
//                    }else {
//                        System.out.println("GOLLLLLLLLL, bela cabeçada");
//                    }
//                }else {
//                    System.out.println("Quem Pena! era uma boa chance ");
//                }
//            } else if (i<20) {
//                System.out.println("Contra ataque veloz do "+time.getNome());
//                dormir(300);
//                if (gol){
//                    System.out.println(getMeio(time).get(r.nextInt(tmMeio)).getNome()+" corre sozinho e marca um golaço");
//                }else {
//                    System.out.println("O Contra Ataque foi Morto com Falta");
//                }
//
//            } else if (i<30) {
//                System.out.println("Contra-ataque letal! "+getMeio(time).get(r.nextInt(tmMeio)).getNome()+" se lança em direção ao gol");
//                System.out.println("Tentou o Passe em Profundidade Para "+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                dormir(300);
//                if (gol){
//                    System.out.println("Que belo Passe");
//                    dormir(200);
//                    System.out.println("GOLLL!");
//
//                    if (s.equals("EMPATE")){
//                        System.out.println("Para Tirar o Empate do Placar");
//                    }
//                }else {
//                    System.out.println("O passe foi Muito Forte, Bola pela linha de fundo");
//                }
//            } else if (i<40) {
//                System.out.println("Contra ataque veloz do "+getMeio(time).get(r.nextInt(tmMeio)).getNome()+", Lucas Lima sai em velocidade");
//                System.out.println("Bela tabela com o"+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                dormir(200);
//
//                if (gol){
//                    System.out.println("GOLLLLLL! No cantinho indefensável");
//                }else {
//                    System.out.println("Que defesaçaaaa do Goleiro, Buscou no cantinho");
//                }
//            } else if (i<50) {
//                System.out.println("Roubada de bola de "+getMeio(time).get(r.nextInt(tmMeio)).getNome()+", contra ataque mortal do Santos");
//                dormir(200);
//                if (gol){
//                    System.out.println("Ele entra na área e mete um canudo no canto, o Goleiro nem viu a cor da bola");
//                }else {
//                    System.out.println("Meu Deus! Ele Perdeu, Inacreditável");
//                }
//
//            }
//
//        }else if (minuto>85){
//            int i = r.nextInt(30);
//            if (i<10){
//                System.out.println("Bate e rebate dentro da área,"+getAtacante(time).get(r.nextInt(tmATA)).getNome()+" bate pro gol");
//                dormir(200);
//                if (gol){
//                    System.out.println("golaço do "+time.getNome()+"! no finzinho da partida!");
//                }else {
//                    System.out.println("A torcida prendeu a respiração, mas o gol não saiu");
//                }
//
//            }else if(i<20){
//                System.out.println("A bola sobra pra "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+", de fora da área..");
//                dormir(200);
//                if (statusPartida().equals("EMPATE")){
//                    if (gol){
//                        System.out.println("No finalzinho, Para enlouquecer o torcedor");
//                    }else {
//                        System.out.println("UUUUUUhhhhhhh, Triscou o travessão");
//                    }
//                }else {
//                    if (gol){
//                        System.out.println("GOOOL do"+time.getNome());
//                    }else {
//                        System.out.println("UUUUUUhhhhhhh, Triscou o travessão");
//                    }
//                }
//            }else {
//                System.out.println("Escanteio pra área, "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+" de cabeça....");
//                dormir(300);
//                if (gol){
//                    if (statusPartida().equals("EMPATE")){
//                        System.out.println("Gol do "+time.getNome()+" no finalzinho, pra enlouquecer a torcida e tirar o Empate do placar!");
//
//                    }else {
//                        System.out.println("Belo gol de cabeça no ângulo");
//                    }
//                }else {
//                    System.out.println("Passa raspando a trave o cabeçeio, vai matar a torçida do coração!");
//                }
//
//            }
//
//        }else{
//            int i = r.nextInt(100);
//            if (!gol){
//                if (i<20){
//                    System.out.println("Domina "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+", bateu de fora da área, passou muito perto!");
//
//                }else if(i<40){
//                    System.out.println("Domina "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+", bateu no canto..");
//                    dormir(200);
//                    System.out.println("Na trave!");
//                }else if(i<60){
//                    System.out.println(getAtacante(time).get(r.nextInt(tmATA)).getNome()+" recebe, dribla o primeiro, dribla o segundo, bateu pro gol, pra fora!");
//                }else if(i<80){
//                    System.out.println(getAtacante(time).get(r.nextInt(tmATA)).getNome()+" recebeu um cruzamento perfeito, mas cabeceou para fora. Perdeu uma ótima chance de gol!");
//                }else {
//                    System.out.println("Chance do "+time.getNome()+", "+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                    dormir(200);
//                    System.out.println("O goleiro defende");
//                }
//            }else {
//                if (i<20){
//                    System.out.println("Domina "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+", bateu de fora da área, GOLLLLLLLLLL!");
//
//                }else if(i<30){
//                    System.out.println("Domina "+getAtacante(time).get(r.nextInt(tmATA)).getNome()+", bateu no canto..");
//                    dormir(200);
//                    System.out.println("Na trave e entrou, gollllll!");
//                }
//                else if(i<40){
//                    System.out.println("Cruzamento Para trás pro "+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                    dormir(200);
//                    System.out.println("E ele crava de carrinho");
//                }
//                else if(i<60){
//                    System.out.println(getAtacante(time).get(r.nextInt(tmATA)).getNome()+" recebe, dribla o primeiro, dribla o segundo, bateu pro gol...");
//                    dormir(200);
//                    System.out.println("E ela entrouu no cantinho, gollllllllllll");
//                }else if(i<80){
//                    System.out.println(getAtacante(time).get(r.nextInt(tmATA)).getNome()+" recebeu um cruzamento perfeito, mas o goleiro espalma. ");
//                    dormir(200);
//                    System.out.println("Ele pega o rebote e crava");
//                }else {
//                    System.out.println("Chance do "+time.getNome());
//                    dormir(200);
//                    System.out.println("Golllll "+getAtacante(time).get(r.nextInt(tmATA)).getNome());
//                }
//            }
//
//        }
//    }
//
//    private int acrescimos(){
//        Random r = new Random();
//        int i = r.nextInt(100);
//        if (i<5){
//            return 0;
//        } else if (i<15) {
//            return 1;
//        } else if (i<30) {
//            return 2;
//
//        } else if (i<50) {
//            return 3;
//        } else if (i<70) {
//            return 4;
//        } else if (i<80) {
//            return 5;
//        } else if (i<83) {
//            return 6;
//        } else if (i<87) {
//            return 7;
//        } else if (i<90) {
//            return 8;
//        } else if (i<93) {
//            return 9;
//        } else if (i<96) {
//            return 10;
//        } else if (i<=99) {
//            return 11;
//        }else {
//            return 0;
//        }
//    }
//
//     public ArrayList<Jogador> getAtacante(Time time1){
//         ArrayList<Jogador> atacantes = new ArrayList<>();
//         for (Jogador j: time1.getTitulares()){
//             if (j.getPosicao().equals("CA") || j.getPosicao().equals("PTE") || j.getPosicao().equals("PTD")) {
//                 atacantes.add(j);
//             }
//         }
//         Collections.shuffle(atacantes);
//        return atacantes;
//     }
//    public ArrayList<Jogador> getZaga(Time time1){
//        ArrayList<Jogador> zaga = new ArrayList<>();
//        for (Jogador j: time1.getTitulares()){
//            if (j.getPosicao().equals("ZAG") || j.getPosicao().equals("LD") || j.getPosicao().equals("LE")) {
//                zaga.add(j);
//            }
//        }
//        Collections.shuffle(zaga);
//        return zaga;
//    }
//    public ArrayList<Jogador> getMeio(Time time1){
//        ArrayList<Jogador> meio = new ArrayList<>();
//        for (Jogador j: time1.getTitulares()){
//            if (j.getPosicao().equals("VOL") || j.getPosicao().equals("MLG") || j.getPosicao().equals("MEI")){
//                meio.add(j);
//            }
//        }
//        Collections.shuffle(meio);
//        return meio;
//    }
//
//
//    public void addHistorico(){
//        historico.add(getGols()[0]-getGols()[1]);
//    }
//    public void gol(int ladoGol){
//        if (ladoGol == 0){
//            this.setGols1(this.getGols()[0]+1);
//
//        }else{
//            this.setGols2(this.getGols()[1]+1);
//
//        }
//        addHistorico();
//    }
//}
