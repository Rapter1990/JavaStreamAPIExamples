package footballteambyleagueandteamtype;

import java.util.ArrayList;
import java.util.List;

//streams grouping
public class FootballTeamTestData {

	public static List<FootballTeam> getFootBallTeamData() {
		List<FootballTeam> teams = new ArrayList<>();

		// premier league
		FootballTeam leicester = new FootballTeam("Leicester City", League.PREMIER_LEAGUE, 18);
		leicester.setGoalsFor(18);
		leicester.setGoalsAgainst(9);
		leicester.setGoalDifference(9);
		teams.add(leicester);
	

		FootballTeam tottenham = new FootballTeam("Tottenham", League.PREMIER_LEAGUE, 17);
		tottenham.setGoalsFor(19);
		tottenham.setGoalsAgainst(9);
		tottenham.setGoalDifference(10);
		teams.add(tottenham);

		FootballTeam liverpool = new FootballTeam("Liverpool", League.PREMIER_LEAGUE, 17);
		liverpool.setGoalsFor(18);
		liverpool.setGoalsAgainst(6);
		liverpool.setGoalDifference(12);
		teams.add(liverpool);

		// la liga
		FootballTeam realSociedad = new FootballTeam("Real Sociedad", League.LA_LIGA, 20);
		realSociedad.setGoalsFor(20);
		realSociedad.setGoalsAgainst(4);
		realSociedad.setGoalDifference(16);
		teams.add(realSociedad);

		FootballTeam villareal = new FootballTeam("Villareal", League.LA_LIGA, 18);
		villareal.setGoalsFor(13);
		villareal.setGoalsAgainst(9);
		villareal.setGoalDifference(4);
		teams.add(villareal);

		FootballTeam atletico = new FootballTeam("Atletico Madrid", League.LA_LIGA, 17);
		atletico.setGoalsFor(17);
		atletico.setGoalsAgainst(2);
		atletico.setGoalDifference(15);
		teams.add(atletico);

		// bundesliga
		FootballTeam bayern = new FootballTeam("Bayern", League.BUNDESLIGA, 18);
		bayern.setGoalsFor(27);
		bayern.setGoalsAgainst(11);
		bayern.setGoalDifference(16);
		teams.add(bayern);

		FootballTeam rbLeipzig = new FootballTeam("RB Leipzig", League.BUNDESLIGA, 16);
		rbLeipzig.setGoalsFor(15);
		rbLeipzig.setGoalsAgainst(4);
		rbLeipzig.setGoalDifference(11);
		teams.add(rbLeipzig);

		FootballTeam dortmund = new FootballTeam("Dortmund", League.BUNDESLIGA, 15);
		dortmund.setGoalsFor(15);
		dortmund.setGoalsAgainst(5);
		dortmund.setGoalDifference(10);
		teams.add(dortmund);

		// bayern in champions league
		FootballTeam bayernCL = new FootballTeam("Bayern", League.CHAMPIONS_LEAGUE, 9);
		bayernCL.setGoalsFor(12);
		bayernCL.setGoalsAgainst(3);
		bayernCL.setGoalDifference(9);
		teams.add(bayernCL);

		// atleti in champions league
		FootballTeam atleticoCL = new FootballTeam("Atletico Madrid", League.CHAMPIONS_LEAGUE, 4);
		atleticoCL.setGoalsFor(4);
		atleticoCL.setGoalsAgainst(7);
		atleticoCL.setGoalDifference(-3);
		teams.add(atleticoCL);
		
		FootballTeam liverpooLCl = new FootballTeam("Liverpool", League.CHAMPIONS_LEAGUE, 9);
		liverpooLCl.setGoalsFor(8);
		liverpooLCl.setGoalsAgainst(0);
		liverpooLCl.setGoalDifference(8);
		teams.add(liverpooLCl);

		return teams;

	}

}
