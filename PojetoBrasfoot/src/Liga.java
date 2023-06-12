import java.util.ArrayList;
public class Liga implements Tabela {
    private ArrayList<Time> tabela;

    public Liga(Player p){
        tabela = p.getTimes();
    }
    public Time melhorDefesa(){
        Time melhorDefesa = tabela.get(0);
        for (int i = 1;i<tabela.size();i++){
            if(melhorDefesa.getGolsofridos()>tabela.get(i).getGolsofridos()){
                melhorDefesa = tabela.get(i);

            }else if (melhorDefesa.getGolsofridos() == tabela.get(i).getGolsofridos()){
                if(melhorDefesa.getVitorias()<tabela.get(i).getVitorias()){
                    melhorDefesa = tabela.get(i);
                }else if(melhorDefesa.getVitorias()==tabela.get(i).getVitorias()){

                    if(melhorDefesa.getDerrotas()>tabela.get(i).getDerrotas()){
                        melhorDefesa = tabela.get(i);
                    } else if (melhorDefesa.getDerrotas()==tabela.get(i).getDerrotas()) {

                        if (melhorDefesa.getPontos()<tabela.get(i).getPontos()){///desempate = pontos
                            melhorDefesa = tabela.get(i);
                        } else if (melhorDefesa.getGolsmarcados()<tabela.get(i).getGolsmarcados()) {
                            melhorDefesa = tabela.get(i);
                        }
                    }

                }

            }
        }
        return melhorDefesa;
    } //retorna o time com menos gols sofridos (desempate: vitorias,derrotas,pontos,golsmarcados)

    public Time melhorAtaque(){
        Time melhorAtaque = tabela.get(0);
        for (int i = 1;i<tabela.size();i++){
            if(melhorAtaque.getGolsmarcados()<tabela.get(i).getGolsmarcados()) {
                melhorAtaque = tabela.get(i);
            }else if(melhorAtaque.getGolsmarcados()==tabela.get(i).getGolsmarcados()){
                if (melhorAtaque.getVitorias()<tabela.get(i).getVitorias()){
                    melhorAtaque = tabela.get(i);
                }else if (melhorAtaque.getVitorias() == tabela.get(i).getVitorias()){
                    if (melhorAtaque.getPontos()<tabela.get(i).getPontos()){///desempate = pontos
                        melhorAtaque = tabela.get(i);
                    }else if (melhorAtaque.getPontos()==tabela.get(i).getPontos()){
                        if (melhorAtaque.getGolsofridos()>tabela.get(i).getGolsofridos()){
                            melhorAtaque = tabela.get(i);

                        }
                    }
                }
            }


        }
        return melhorAtaque;
    } //retorna o time com mais gols feitos (desempate: pontos, alfabetico)

    @Override
    public void organizarTabela() {
        tabela.sort((time1, time2) -> {
            // Ordenar por pontos (em ordem decrescente)
            int pontosComparison = Integer.compare(time2.getPontos(), time1.getPontos());
            if (pontosComparison != 0) {
                return pontosComparison;
            }

            // Ordenar por vitórias (em ordem decrescente)
            int vitoriasComparison = Integer.compare(time2.getVitorias(), time1.getVitorias());
            if (vitoriasComparison != 0) {
                return vitoriasComparison;
            }

            // Ordenar por gols marcados (em ordem decrescente)
            int golsMarcadosComparison = Integer.compare(time2.getGolsmarcados(), time1.getGolsmarcados());
            if (golsMarcadosComparison != 0) {
                return golsMarcadosComparison;
            }

            // Ordenar por gols sofridos (em ordem crescente)
            int golsSofridosComparison = Integer.compare(time1.getGolsofridos(), time2.getGolsofridos());
            if (golsSofridosComparison != 0) {
                return golsSofridosComparison;
            }

            // Ordenar por derrotas (em ordem crescente)
            int derrotasComparison = Integer.compare(time1.getDerrotas(), time2.getDerrotas());
            if (derrotasComparison != 0) {
                return derrotasComparison;
            }

            // Ordenar por ordem alfabética (nome do time)
            return time1.getNome().compareTo(time2.getNome());
        });
    }



    @Override
    public void printarTabela() {
        System.out.println("id - Time - Pontos - Gols Marcados - Gols Sofridos - Vitorias - Derrotas - Empates");

        for (int i = 0;i<tabela.size();i++){
            Time t = tabela.get(i);
            System.out.println(t.getId()+" "+t.getNome()+" "+t.getPontos()+" "+t.getGolsmarcados()+" "+t.getGolsofridos()+
                    " "+t.getVitorias()+" "+t.getDerrotas()+" "+ t.getEmpates());
        }
    }
    @Override
    public Time lider(){
        organizarTabela();
        Time lider = tabela.get(0);
        return lider;
    }

    @Override
    public ArrayList<Time> getTabela() {
        organizarTabela();
        return tabela;
    }
}
