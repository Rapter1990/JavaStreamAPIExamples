package footballleagueexample;

public class Team {

    private String name;
    private int points;
    private int goalsScored;
    private int goalsAgainst;
    private int goalDifference;


    public Team(String name, int points, int goalsScored, int goalsAgainst) {
        this.name = name;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalsScored - goalsAgainst;
    }


    public String getName() {
        return name;
    }


    public int getPoints() {
        return points;
    }


    public int getGoalsScored() {
        return goalsScored;
    }


    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    @Override
    public String toString() {
        return "Club:" + this.getName() +
                ", GF: " + this.getGoalsScored() +
                ", GA: " + this.getGoalsAgainst() +
                ", GD: " + this.getGoalDifference()+
                ", Pts: " + this.getPoints() + "\n";
    }




}
