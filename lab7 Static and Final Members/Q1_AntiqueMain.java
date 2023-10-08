import java.util.Scanner;

public class AntiqueMain {

	public static double calculatePrice(int century, String damageDegree) {
		
		// variable declaration
		double price;
		
		if(century < 17) { // if century is less than 17, then set price to 185000
			price = 185000;
			if (damageDegree.equalsIgnoreCase("high")) { // if damage is high, then multiply price by 0.3
				return price * 0.3;
			} else if (damageDegree.equalsIgnoreCase("medium")) { // if damage is medium, then multiply price by 0.6
				return price * 0.6;
			} else { // if damage is low, then use price initial value
				return price;
			}
		} else { // if century is greater than or equals to 17, then set price to 155000
			price = 155000;
			if (damageDegree.equalsIgnoreCase("high")) { // if damage is high, then multiply price by 0.8
				return price * 0.8;
			} else if (damageDegree.equalsIgnoreCase("medium")) { // if damage is medium, then multiply price by 0.6
				return price * 0.6;
			} else { // if damage is low, then use price initial value
				return price;
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // for getting user input
		
		// variable declarations
		String input;
		Antique antique;
		
		// getting yes or other as user input
		System.out.print("Do you want to check the antiques' price (Yes/No): ");
		input = scanner.next();
		
		while (input.equalsIgnoreCase("yes")) { // as long as user enters yes
			
			// instantiate a new object of type Antique
			antique = new Antique(); 
			
			// invoke getInput method of the object for getting data member values from the user
			antique.getInput(); 
			
			// according to antique's century and damage degree parameters, calculate price by invoking setPrice method
			antique.setPrice(calculatePrice(antique.getCentury(), antique.getDamageDegree()));
			
			// display the price to the user
			System.out.println("\nThe antique's price is " + antique.getPrice());
			
			// update while loop's condition by getting new input from the user
			System.out.print("\nDo you want to check the antiques' price (Yes/No): ");
			input = scanner.next();
		}
		
		// displaying number of instantiated Antique objects
        System.out.print("\nThere are " + Antique.getCountOfAntiques() + " antiques.");
	}

}
