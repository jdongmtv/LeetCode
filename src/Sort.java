import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sort {
	
	static List<Team> teams = new ArrayList<>();
	
	public static void main(String[] args) {
		Team team = new Team(1);
//		teams.add(team);
//		team = new Team(0.8f);
//		teams.add(team);
//		team = new Team(0.8f);
//		teams.add(team);
//		for(int i=0;i<3;i++) {
//			team = new Team(0.6f);
//			teams.add(team);
//		}
//		team = new Team(0.4f);
//		teams.add(team);
//		team = new Team(1.2f);
//		teams.add(team);
		for(int i=0;i<10;i++) {
			team = new Team(0.5f);
			teams.add(team);
		}
		
		Collections.sort(teams);
		for(Team team1 : teams) {
			System.err.print(team1.winPercentage + ":");
		}
	}
	
	static class Team implements Comparable<Team> {
		
		float winPercentage;
		
		Team(float winPercentage) {
			this.winPercentage = winPercentage;
		}
		
		@Override
		public int compareTo(Team team) {
			if(this.winPercentage > team.winPercentage) 
				return 1;
			else
				return -1;
		}
		
	}
}
