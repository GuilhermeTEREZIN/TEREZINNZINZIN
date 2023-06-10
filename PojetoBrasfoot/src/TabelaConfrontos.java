import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaConfrontos {

    public static void gerarLiga() {
        List<String> teams = new ArrayList<>();
        ArrayList<Time> times = new ArrayList<>();

        try {
            times = importarCsv.times();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Time t : times) {
            teams.add(t.getNome());
        }

        generateAndSaveFixtures(teams, "./PojetoBrasfoot/save/confrontosLiga.csv");
    }

    public static void generateAndSaveFixtures(List<String> teams, String filename) {
        Collections.shuffle(teams); // Embaralha a lista de times
        List<String[]> fixtureTable = generateFixtureTable(teams);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Rodada,Jogo,TimedaCasa,TimeVisitante");
            writeFixtureTable(writer, fixtureTable);
            writeFixtureTable(writer, reverseFixtureTable(fixtureTable));
            //System.out.println("Tabela de confrontos gerada e salva no arquivo '" + filename + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> generateFixtureTable(List<String> teams) {
        List<String[]> fixtureTable = new ArrayList<>();
        List<List<String>> schedule = createSchedule(teams);

        int roundNum = 1;
        for (List<String> round : schedule) {
            int matchNum = 1;
            for (int i = 0; i < round.size() - 1; i += 2) {
                String homeTeam = round.get(i);
                String awayTeam = round.get(i + 1);
                String[] fixture = {String.valueOf(roundNum), String.valueOf(matchNum), homeTeam, awayTeam};
                fixtureTable.add(fixture);
                matchNum++;
            }
            roundNum++;
        }

        return fixtureTable;
    }

    public static List<String[]> reverseFixtureTable(List<String[]> fixtureTable) {
        List<String[]> reverseFixtureTable = new ArrayList<>();
        for (String[] fixture : fixtureTable) {
            int teste = Integer.parseInt(fixture[0]) + 19;
            fixture[0] = String.valueOf(teste);
            String[] reverseFixture = {fixture[0], fixture[1], fixture[3], fixture[2]};
            reverseFixtureTable.add(reverseFixture);
        }
        return reverseFixtureTable;
    }

    public static void writeFixtureTable(PrintWriter writer, List<String[]> fixtureTable) {
        for (String[] fixture : fixtureTable) {
            writer.println(String.join(",", fixture));
        }
    }

    public static List<List<String>> createSchedule(List<String> teams) {
        if (teams.size() % 2 != 0) {
            teams.add("Bye");
        }

        int numTeams = teams.size();
        int mid = numTeams / 2;

        List<List<String>> schedule = new ArrayList<>();

        for (int i = 0; i < numTeams - 1; i++) {
            List<String> round = new ArrayList<>();
            for (int j = 0; j < mid; j++) {
                if (!teams.get(j).equals("Bye") && !teams.get(numTeams - 1 - j).equals("Bye")) {
                    round.add(teams.get(j));
                    round.add(teams.get(numTeams - 1 - j));
                }
            }
            schedule.add(round);
            teams.add(1, teams.remove(numTeams - 1));
        }

        return schedule;
    }

}


