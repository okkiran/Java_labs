import java.util.Scanner;

public class FootballTeamSys {

	// data members
	private static final int WIN_POINT = 3; // 3 constant value assignment for win
	private static final int MAX_SIZE = 3; // 3 constant value assignment for array length
	private static FootballTeam[] teams = new FootballTeam[MAX_SIZE]; // initialization of the array of 3 elements
	private static int count = 0; // array index, assigning initial value to 0
	
	// member methods
	public static void createTeams() { // creating football team members of the array
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// variable declarations and initial value assignments
		FootballTeam team;
		String input = ""; // user input, we assign a string value with no characters to the input variable
		
		// getting the initial assignment of the input variable from the user for the loop's condition
		System.out.print("Do you want to enter a new football team (y: yes, n: no)? ");
		input = scanner.next();
		
		// iterate the loop as long as user enters yes and array index is less then the array length
		while (input.equalsIgnoreCase("y") && count < MAX_SIZE) {
			
			// setting the object element at the count. index of the array by getting input from the user
			System.out.println("Enter " + (count + 1) + ". team: ");
			
			team = new FootballTeam(); // object initialization of type FootballTeam
			team.getInput(); // assigning object's data members with getInput method
			
			// assigning initialized and data members filled object to the count. index of the array
			// then incrementing the count (index) for other array elements
			teams[count++] = team; 
			
			// updating the assignment of the input variable from the user for the loop's condition
			System.out.print("Do you want to enter a new football team (y: yes, n: no)? ");
			input = scanner.next();
			
		}
		
		// displaying the number of teams entered by the user
		System.out.println("You entered \"" + count + "\" team(s).");
		
		// checking if count (index) has reached to the maximum size after the loop,
		// if so displaying maximum size is reached message at the console
		if (count == MAX_SIZE) {
			System.out.println("Maximum size is reached! Can't add a new team!");
		}
		
	}
	
	public static void displayTeams() { // writing football team members to the console
		
		String result = "\nHere is the list of football teams you created:"; // initial assignment of the result variable for string concatenation in the loop
		
		// Way 1:
		/*
		// iterate the loop for all elements of the array 
		for (int i = 0; i < teams.length; i++) {
			if (teams[i] != null) { // means there is a team object entered by the user at i. index
				result += teams[i].toString() + "\n"; // get team information and concatenate it to the result variable
			}
		}  
		*/
		
		// Way 2:
		// iterate the loop for the number of teams (count) entered by the user
		for (int i = 0; i < count; i++) {
			result += teams[i].toString() + "\n"; // get team information and concatenate it to the result variable
		}
		
		System.out.println(result); // write the result variable to the console
		
	}
	
	// assigning each team's total points by the calculation of win point with win counts and tie counts 
	public static void calculateTotalPoints() { 
		
		// declaration of the variable to use in the loop
		int totalPoints;
		
		// iterate the loop for the number of teams (count) entered by the user
		for (int i = 0; i < count; i++) {
			
			// multiply the win count by 3 (win point) for matches won and tie count by 1 for matches tied,
			// we don't need to write 1 in total tie points calculation since it will have no effect in multiplication,
			// we also don't need to do any calculations for losing because the lose point is 0
			totalPoints = WIN_POINT * teams[i].getMatchWinCount() + teams[i].getMatchTieCount();
			
			// setting the team's total points at the i. index
			teams[i].setTotalPoints(totalPoints);
			
		}
		
	}
	
	public static FootballTeam searchTeam(int id) { // searching team by id parameter
		
		FootballTeam foundTeam = null; // for beginning we assume that team is not found
		
		// iterate the loop for the number of teams (count) entered by the user
		for (int i = 0; i < count; i++) {
			if (teams[i].getId() == id) { // if id parameter equals to the team's id, team is found
				foundTeam = teams[i]; // assign found element object of the array to the foundTeam reference variable
				break; // terminate the loop since we don't need to iterate through other array elements
			}
		}
		
		return foundTeam; // method will return the team if found by id, method will return null if not found by id 
		
	}
	
	public static FootballTeam searchTeam(String name) { // searching team by name parameter
		
		FootballTeam foundTeam = null; // for beginning we assume that team is not found
		
		// iterate the loop for the number of teams (count) entered by the user
		for (int i = 0; i < count; i++) {
			if (teams[i].getName().equalsIgnoreCase(name)) { // if name parameter equals (case insensitive) to the team's name, team is found
				foundTeam = teams[i]; // assign found element object of the array to the foundTeam reference variable
				break; // terminate the loop since we don't need to iterate through other array elements
			}
		}
		
		return foundTeam; // method will return the team if found by name, method will return null if not found by name 
		
	}
	
}
