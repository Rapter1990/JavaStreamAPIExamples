package footballteambyleagueandteamtype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FootballTeamTest {

	public static void main(String[] args) {
		
		List<FootballTeam> data = FootballTeamTestData.getFootBallTeamData();

		//1. Group teams by the league.
		Map<League, List<FootballTeam>> teamsByLeague = groupByLeague(data);
		System.out.println("\n1.Grouping by league : " +teamsByLeague);

		// Grouping by league : {LA_LIGA=[Real Sociedad, Villareal, Atletico Madrid], CHAMPIONS_LEAGUE=[Bayern, Atletico Madrid, Liverpool], BUNDESLIGA=[Bayern, RB Leipzig, Dortmund], PREMIER_LEAGUE=[Leicester City, Tottenham, Liverpool]}

				
		//2. grouping imperative style.
		imperativeGrouping(data);
		
		//3. counting total teams in each league.
		Map<League, Long> totalTeamsByLeague = totalTeamsInEachLeague(data);
		System.out.println("\n3.Total teams in each league : " +totalTeamsByLeague);

		// 3.Total teams in each league : {LA_LIGA=3, CHAMPIONS_LEAGUE=3, BUNDESLIGA=3, PREMIER_LEAGUE=3}
		
		//4. total goals in each league
		Map<League,Integer> goalsByLeague = totalGoalsInEachLeague(data);
		System.out.println("\n4.Total goals in each league : " + goalsByLeague);

		// 4.Total goals in each league : {LA_LIGA=50, CHAMPIONS_LEAGUE=24, BUNDESLIGA=57, PREMIER_LEAGUE=55}
		
	    //5.partition teams by the ones in the champions league and the ones that are not.
		
		Map<Boolean,List<FootballTeam>> partitionedByChampionsLeague 
		                                = partitionByCL(data);		                                    		
		System.out.println("\n5.Partition:"+ partitionedByChampionsLeague);

		// 5.Partition:{false=[Leicester City, Tottenham, Liverpool, Real Sociedad, Villareal, Atletico Madrid, Bayern, RB Leipzig, Dortmund], true=[Bayern, Atletico Madrid, Liverpool]}
		
		
		//6. grouping team by attacking,defensive/
	
		/*ATTACKING = [Team1,Team2], DEFENSIVE = [Team3,Team4]*/
		Map<FootballTeamType,List<FootballTeam>> byStyle = groupByAttackDefense(data);		
		System.out.println("\n6.Grouping by style(attacking,defensive) : "+byStyle);

		// 6.Grouping by style(attacking,defensive) : {DEFENSIVE=[Leicester City, Tottenham, Liverpool, Villareal, Atletico Madrid, RB Leipzig, Dortmund, Bayern, Atletico Madrid, Liverpool], ATTACKING=[Real Sociedad, Bayern]}
		

		
		Map<League, Map<FootballTeamType,List<FootballTeam>>> byStyleInEachLeague = 
						groupByAttackDefenseLeague(data);
				
		System.out.println("\n7.Grouping by style(attacking,defensive) in league :"
								  +byStyleInEachLeague);

		// 7.Grouping by style(attacking,defensive) in league :{LA_LIGA={DEFENSIVE=[Villareal, Atletico Madrid], ATTACKING=[Real Sociedad]}, CHAMPIONS_LEAGUE={DEFENSIVE=[Bayern, Atletico Madrid, Liverpool]}, BUNDESLIGA={DEFENSIVE=[RB Leipzig, Dortmund], ATTACKING=[Bayern]}, PREMIER_LEAGUE={DEFENSIVE=[Leicester City, Tottenham, Liverpool]}}

		//8. IntSummaryStatistics in each league.
		Map<League, IntSummaryStatistics> goalByLeague = intSummaryStatistics(data);
		System.out.println("\n8.Statistics : "+goalByLeague);

		// 8.Statistics : {LA_LIGA=IntSummaryStatistics{count=3, sum=50, min=13, average=16,666667, max=20}, CHAMPIONS_LEAGUE=IntSummaryStatistics{count=3, sum=24, min=4, average=8,000000, max=12}, BUNDESLIGA=IntSummaryStatistics{count=3, sum=57, min=15, average=19,000000, max=27}, PREMIER_LEAGUE=IntSummaryStatistics{count=3, sum=55, min=18, average=18,333333, max=19}}
		
		//9. comma separated team names
		String teamNames = commaSeparatedNamesOfTeams(data);		
		System.out.println("\n9.Names of the teams(comma separated) : "+ teamNames);

		// 9.Names of the teams(comma separated) : [Leicester City,Tottenham,Liverpool,Real Sociedad,Villareal,Atletico Madrid,Bayern,RB Leipzig,Dortmund,Bayern,Atletico Madrid,Liverpool]
		

		Map<League,String> csTeamNamesByLeague = commaSeparatedTeamsByLeague(data);
		System.out.println("\n10.League wise, team names with comma " + csTeamNamesByLeague);

		// 10.League wise, team names with comma {LA_LIGA=Real Sociedad,Villareal,Atletico Madrid, CHAMPIONS_LEAGUE=Bayern,Atletico Madrid,Liverpool, BUNDESLIGA=Bayern,RB Leipzig,Dortmund, PREMIER_LEAGUE=Leicester City,Tottenham,Liverpool}
		
		//11.multi level partition.
	 	Map<Boolean,Map<League,List<FootballTeam>>> partitionMultiLevelByChampionsLeague 
		                               = multiLevelPartCL(data);
		System.out.println("\n11.Multi level partition"+partitionMultiLevelByChampionsLeague);

		// 11.Multi level partition{false={LA_LIGA=[Real Sociedad, Villareal, Atletico Madrid], BUNDESLIGA=[Bayern, RB Leipzig, Dortmund], PREMIER_LEAGUE=[Leicester City, Tottenham, Liverpool]}, true={CHAMPIONS_LEAGUE=[Bayern, Atletico Madrid, Liverpool]}}
	
	}

	public static Map<FootballTeamType,List<FootballTeam>> groupByAttackDefense(List<FootballTeam> data) {
		return data.stream()
				   .collect(Collectors.groupingBy(team -> getStyleOfTeam(team)));
	}
	
	private static FootballTeamType getStyleOfTeam(FootballTeam team) {
		   if(team.getGoalsFor() >=20 ) return FootballTeamType.ATTACKING;
			return FootballTeamType.DEFENSIVE;
	}
	
	public static Map<League,Map<FootballTeamType,List<FootballTeam>>> groupByAttackDefenseLeague(List<FootballTeam> data) {
	
		return data.stream()
				   .collect(Collectors.groupingBy(
		    		                       FootballTeam::getLeague, 
		    		                       Collectors.groupingBy(team -> getStyleOfTeam(team))
		    		                      )
		    		); 
	}
	
	public static Map<League, Integer> totalGoalsInEachLeague(List<FootballTeam> data) {
		return data.stream()
		           .collect(Collectors.groupingBy
		        		              (
		        		                  FootballTeam::getLeague,
		    		                      Collectors.summingInt(FootballTeam::getGoalsFor)
		    		                  )
		    		       );
	}

	public static Map<League, IntSummaryStatistics> intSummaryStatistics(List<FootballTeam> data) {
		return data.stream()
		           .collect(Collectors.groupingBy(FootballTeam::getLeague, 
		    		                               Collectors.summarizingInt(FootballTeam::getGoalsFor)
		    		                             )
		        		   );
	}	

	public static Map<League, Long> totalTeamsInEachLeague(List<FootballTeam> data) {
		return data.stream()
				   .collect(Collectors.groupingBy(FootballTeam::getLeague,
						                          Collectors.counting()
						                         )
				           );
	}

	public static Map<League, List<FootballTeam>> groupByLeague(List<FootballTeam> data) {
		return data.stream()
				   .collect(Collectors.groupingBy(FootballTeam::getLeague));
	}
	
	public static Map<Boolean, List<FootballTeam>> partitionByCL(List<FootballTeam> data){
		return data.stream()
				   .collect(Collectors.partitioningBy(team -> isTeamInChampionsLeague(team)));
	}

	public static Map<Boolean, Map<League, List<FootballTeam>>> multiLevelPartCL(List<FootballTeam> data) {
			return data.stream()
			           .collect(Collectors.partitioningBy
			        		     (
		        		     	    team -> isTeamInChampionsLeague(team),
		        		     		Collectors.groupingBy(FootballTeam ::getLeague)
		    		         	 )
		        		       );
	}
	
	private static boolean isTeamInChampionsLeague(FootballTeam footballTeam) {
		return footballTeam.getLeague() == League.CHAMPIONS_LEAGUE;
	}

	public static String commaSeparatedNamesOfTeams(List<FootballTeam> data) {
		return data.stream()
		           .map(team -> team.getName())
		           .collect(Collectors.joining(",","[","]"));
	}


	/*10.Fetch names of the teams,separate them by comma but group them by league.
	 
	{ LA_LIGA=Real Sociedad,Villareal,Atletico Madrid, 
	  BUNDESLIGA=Bayern,RB Leipzig,Dortmund, 
	  PREMIER_LEAGUE=Leicester City,Tottenham,Liverpool, 
	  CHAMPIONS_LEAGUE=Bayern,Atletico Madrid,Liverpool
	}		
	*/
	public static Map<League,String> commaSeparatedTeamsByLeague(List<FootballTeam> data) {
		return data.stream()
				   .collect(Collectors.groupingBy(						    
						   FootballTeam::getLeague, 
						   Collectors.mapping(team -> team.getName(), Collectors.joining(","))
						                    )
						  );
	}		
	
	public static void imperativeGrouping(List<FootballTeam> data) {
		
		Map<League,List<FootballTeam>> group = new HashMap<>();

		data.stream().forEach(
				team -> {
					League league = team.getLeague();
					List<FootballTeam> teamList = group.computeIfAbsent(league, k ->new ArrayList<>());
					teamList.add(team);
				}
		);

		System.out.println("\\nList : " + group);

		// List : {LA_LIGA=[Real Sociedad, Villareal, Atletico Madrid], CHAMPIONS_LEAGUE=[Bayern, Atletico Madrid, Liverpool], BUNDESLIGA=[Bayern, RB Leipzig, Dortmund], PREMIER_LEAGUE=[Leicester City, Tottenham, Liverpool]}
		
	}


}
