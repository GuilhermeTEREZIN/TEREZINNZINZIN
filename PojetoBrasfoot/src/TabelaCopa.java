import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaCopa {

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        // Adicione os 16 times aqui
        teams.add("Time 1");
        teams.add("Time 2");
        teams.add("Time 3");
        teams.add("Time 4");
        teams.add("Time 5");
        teams.add("Time 6");
        teams.add("Time 7");
        teams.add("Time 8");
        teams.add("Time 9");
        teams.add("Time 10");
        teams.add("Time 11");
        teams.add("Time 12");
        teams.add("Time 13");
        teams.add("Time 14");
        teams.add("Time 15");
        teams.add("Time 16");

        // Embaralhe a lista de times para gerar confrontos aleatórios
        Collections.shuffle(teams);

        List<String> roundOf16 = generateRoundOf16(teams);
        List<String> quarterfinals = generateQuarterfinals(roundOf16);
        List<String> semifinals = generateSemifinals(quarterfinals);
        List<String> finals = generateFinals(semifinals);
        String champion = generateChampion(finals);

        saveFixtureTable(roundOf16, "confrontos.csv");

        System.out.println("Tabela de confrontos gerada e salva no arquivo 'confrontos.csv'.");
        System.out.println("Campeão: " + champion);
    }

    public static List<String> generateRoundOf16(List<String> teams) {
        List<String> roundOf16 = new ArrayList<>();
        for (int i = 0; i < teams.size(); i += 2) {
            String homeTeam = teams.get(i);
            String awayTeam = teams.get(i + 1);
            String match = homeTeam + "," + awayTeam;
            roundOf16.add(match);
        }
        return roundOf16;
    }

    public static List<String> generateQuarterfinals(List<String> previousRound) {
        List<String> quarterfinals = new ArrayList<>();
        for (int i = 0; i < previousRound.size(); i += 2) {
            String homeTeam = getWinner(previousRound.get(i));
            String awayTeam = getWinner(previousRound.get(i + 1));
            String match = homeTeam + "," + awayTeam;
            quarterfinals.add(match);
        }
        return quarterfinals;
    }

    public static List<String> generateSemifinals(List<String> previousRound) {
        List<String> semifinals = new ArrayList<>();
        for (int i = 0; i < previousRound.size(); i += 2) {
            String homeTeam = getWinner(previousRound.get(i));
            String awayTeam = getWinner(previousRound.get(i + 1));
            String match = homeTeam + "," + awayTeam;
            semifinals.add(match);
        }
        return semifinals;
    }

    public static List<String> generateFinals(List<String> previousRound) {
        List<String> finals = new ArrayList<>();
        String homeTeam = getWinner(previousRound.get(0));
        String awayTeam = getWinner(previousRound.get(1));
        String match = homeTeam + "," + awayTeam;
        finals.add(match);
        return finals;
    }

    public static String generateChampion(List<String> previousRound) {
        return getWinner(previousRound.get(0));
    }

    public static String getWinner(String match) {
        // Simule a lógica para determinar o vencedor do confronto
        // Neste exemplo, o vencedor é sempre o time da casa
        String[] teams = match.split(",");
        return teams[0];
    }

    public static void saveFixtureTable(List<String> fixtureTable, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Time da Casa,Time Visitante");
            for (String fixture : fixtureTable) {
                writer.println(fixture);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
