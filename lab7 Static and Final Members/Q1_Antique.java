import java.util.Scanner;

public class Antique {

	// data members
	private String name;
	private int century;
	private String damageDegree;
	private double price;
	
	private static int countOfAntiques = 0;
	
	// no-arg constructor
	public Antique() {
		name = "No name";
		damageDegree = "No Level";
		countOfAntiques++;
	}

	// member methods
	public static int getCountOfAntiques() {
		return countOfAntiques;
	}
	
	public void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nEnter the antique's name: ");
		name = scanner.nextLine();
		System.out.print("Enter century: ");
		century = scanner.nextInt();
		System.out.print("Enter the damage degree(High/Medium/Low): ");
		
		// The skip method of the Scanner class skips the pattern specified in an input, which is \\R: carriage return (or enter) here.
		// Therefore, we can get the damage degree in the main method of AntiqueMain class with a new line.
		// You may comment the line below and then uncomment it to see its effect.
		scanner.skip("\\R");
		
		damageDegree = scanner.nextLine();
	}

	public int getCentury() { // getter
		return century;
	}

	public String getDamageDegree() { // getter
		return damageDegree;
	}

	public double getPrice() { // getter
		return price;
	}

	public void setPrice(double price) { // setter
		this.price = price;
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "Antique"
			+ "\nName=\" + name"
			+ "\nCentury=" + century 
			+ "\nDamageDegree=" + damageDegree;
	}
	
}
