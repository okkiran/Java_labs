import java.util.Scanner;

public class HousingProjectMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // for getting user input
		
		HousingProject housingProject; // declaration of housingProject variable
		
		// other variable declarations
		String input;
		int discountPercentage;

		// getting yes or no as user input
		System.out.print("Do you want to add Housing Project (Yes/No): ");
		input = scanner.next();

		while (input.equalsIgnoreCase("yes")) { // as long as user enters case insensitive yes as input
			
			housingProject = new HousingProject(); // initializing a new object of type HousingProject in each iteration of the loop
			
			housingProject.getInput(); // getting input from the user for object's data member values

			// getting discount percentage input from the user
			System.out.print("Enter the discount percentage: ");
			discountPercentage = scanner.nextInt();

			housingProject.discount(discountPercentage); // updating price according to the discount percentage by invoking discount method

			// displaying discounted price
			System.out.println("\nPrice after discount: ");
			
			// Way 1:
			//System.out.println(housingProject.toString());
			// Way 2: can also be used because we have overridden the toString method of HousProject class
			System.out.println(housingProject);

			// updating while loop's condition by getting new input from the user as yes or other
			System.out.print("\nDo you want to add Housing Project (Yes/No): ");
			input = scanner.next();

		}

		System.out.println("Program terminated"); // end of the program

	}

}
