package footballleagueexample;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class SuperLeagueComparatorTest {

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("tr-TR"));

        sortByTeamStandingsByComparing();

    }

    public static void sortByTeamStandingsByComparing() {
        List<Team> standings = getTeamStats();

        Comparator<Team> byPoints = Comparator.comparingInt(Team::getPoints)
                .reversed();

        Comparator<Team> byGoalDiff = Comparator.comparingInt(Team::getGoalDifference)
                .reversed();

        Comparator<Team> byGoalScored = Comparator.comparingInt(Team::getGoalsScored)
                .reversed();

        Comparator<Team> BY_STANDINGS = byPoints.thenComparing(byGoalDiff)
                .thenComparing(byGoalScored);


        standings.sort(BY_STANDINGS);

        standings.forEach(System.out::println);

    }


    private static List<Team> getTeamStats() {

        List<Team> plTeams = new ArrayList<>();

        plTeams.add(new Team("Galatasaray", 33, 27, 12));
        plTeams.add(new Team("Fenerbahçe", 32, 40, 16));
        plTeams.add(new Team("Başakşehir", 30, 24, 16));
        plTeams.add(new Team("Adana Demirspor", 27, 26, 15));
        plTeams.add(new Team("Trabzonspor", 26, 22, 20));

        return plTeams;
    }

}
