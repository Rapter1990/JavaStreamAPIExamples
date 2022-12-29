package footballteambyleagueandteamtype;

public class FootballTeam {
	
	private String name;
	private League league;
	private int goalsFor;
	private int goalsAgainst;
	private int goalDifference;
	private int points;
	
	public FootballTeam(String name,League league,int points) {
		this.name=name;
		this.league=league;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public League getLeague() {
		return league;
	}

	public int getPoints() {
		return points;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsScored) {
		this.goalsFor = goalsScored;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalDifference() {
		return goalDifference;
	}

	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}
	
	public  FootballTeamType getType() {
		if (getGoalsFor() >= 20) {
			return FootballTeamType.ATTACKING;
		}
		return FootballTeamType.DEFENSIVE;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootballTeam other = (FootballTeam) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

	
}
