import java.util.Scanner;

public class FootballTeamMain {

	public static void main(String[] args) {
		
		// variable declarations
		int id;
		String name;
		FootballTeam team;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// creating football teams by getting inputs from the user
		FootballTeamSys.createTeams();
		
		// calculating each football team's total points
		FootballTeamSys.calculateTotalPoints();
		
		// displaying football teams at the console
		FootballTeamSys.displayTeams();
		
		// searching football team by id
		System.out.print("Enter the id of the football team you want to search: ");
		id = scanner.nextInt();
		team = FootballTeamSys.searchTeam(id);
		
		// displaying search result at the console
		if (team == null) { // football team object not found
			System.out.println("Football team could not be found by id: " + id);
		} else { // football team object found
			System.out.println("Football team found:" + team); // team.toString() can also be written instead of team
		}
		
		// We need to use scanner's skip method here for the return (enter key on keyboard) escape sequence
		// because we are using scanner's nextLine method below.
		// If we don't write scanner's skip method here, "Enter the name of the football team you want to search: "
		// will be written to the console and the application will not wait for input from the user.
		// You can see scanner's skip method's effect by commenting the 42. line below and running the application, 
		// then removing the comment and running the application again.
		scanner.skip("\\R"); 
		
		// searching football team by name
		System.out.print("\nEnter the name of the football team you want to search: ");
		name = scanner.nextLine();
		team = FootballTeamSys.searchTeam(name);
		
		// displaying search result at the console
		if (team == null) { // football team object not found
			System.out.println("Football team could not be found by name: " + name);
		} else { // football team object found
			System.out.println("Football team found:" + team); // team.toString() can also be written instead of team
		}
	}

}
