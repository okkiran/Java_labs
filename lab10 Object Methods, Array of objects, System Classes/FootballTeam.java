import java.util.Scanner;

public class FootballTeam {

	// data members
	private int id;
	private String name;
	private int foundationYear;
	private int matchWinCount;
	private int matchTieCount;
	private int totalPoints;
	
	private static int lastUsedId = 1; // initial value assignment
	
	// constructors
	public FootballTeam() {
		id = lastUsedId++; // increment the lastUsedId static field and assign it to the id field for unique ids
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMatchWinCount() {
		return matchWinCount;
	}
	
	public int getMatchTieCount() {
		return matchTieCount;
	}
	
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	// member methods
	public void getInput() {
		
		// getting input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter team name: ");
		name = scanner.nextLine();
		System.out.print("Enter foundation year: ");
		foundationYear = scanner.nextInt();
		System.out.print("Enter number of matches won: ");
		matchWinCount = scanner.nextInt();
		System.out.print("Enter number of matches tied: ");
		matchTieCount = scanner.nextInt();
		
	}
	
	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "\nTeam Id: " + id 
			+ "\nName: " + name
			+ "\nFoundation Year: " + foundationYear
			+ "\nMatches Won: " + matchWinCount
			+ "\nMatches Tied: " + matchTieCount
			+ "\nTotal Points: " + totalPoints;
	}
	
}
