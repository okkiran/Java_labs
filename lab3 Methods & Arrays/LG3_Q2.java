import java.util.Scanner;

public class LG3_Q2 {

	public static void main(String[] args) {
		
		// for getting user number inputs
		Scanner scanner = new Scanner(System.in);
		
		// user choice input variable
		String input;
		
		double number1, number2; // double numbers that user will enter for using in methods as parameters
		
		double result; // result of the fracPart and roundNum methods that we will display
		
		do {
			
			// displaying the menu to the user and getting user choice input
			input = menu();
			
			if (input.equalsIgnoreCase("a")) { 
				// if user enters "a" as input, we ask two double numbers, call fracPart method 
			    // for each of them, take the sum of the results and display the sum result
				
				System.out.println("Enter two double numbers");
				number1 = scanner.nextDouble();
				number1 = fracPart(number1); // updating number1 value with the result of fracPart method
				number2 = scanner.nextDouble();
				number2 = fracPart(number2); // updating number2 value with the result of fracPart method
				result = number1 + number2;
				System.out.printf("%.4f + %.4f = %.4f", number1, number2, result);
				
			} else if (input.equalsIgnoreCase("b")) { 
				// if user enters "b" as input, we ask a double number, call roundNum method
			    // for the number and display the result
				
				System.out.print("Enter a double number: ");
				number1 = scanner.nextDouble();
				result = roundNum(number1);
				System.out.printf("The number %.4f converted to the integer number %.0f", number1, result);
			
			}
			
			System.out.println("\n"); // displaying new line
			
		} while (!input.equalsIgnoreCase("c")); // iterate the loop until user enters "c" as input
		
	}

	// method that displays the menu, validates the user input and returns the user choice
	public static String menu() {
		
		// for getting user choice input
		Scanner scanner = new Scanner(System.in);
		
		// user choice input variable
		String input;
		
		// displaying the menu to the user
		System.out.println("\t\tMENU");
		System.out.println("**************************************");
		System.out.println("A. Add fractional parts of two numbers (maximum 4 decimal digits for each number)");
		System.out.println("B. Convert a double number to integer");
		System.out.println("C. QUIT");
		
		// getting and validating user choice input
		do {
			// asking user's choice
			System.out.print("Enter your choice: ");
			
			// getting user choice input
			input = scanner.next();
			
		// Way 1:
		//} while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c"))
		// Way 2:
		} while (!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c")));
		// writing the whole correct condition then using not with the whole correct condition is an easier way
		
		return input; // returning the correct user choice input
		
	}
		
	// method that takes a decimal number with maximum 4 decimal places as parameter and
	// returns only the decimal places (fractional part) 
	public static double fracPart(double number) {
		
		// whole part variable that will be assigned by casting number to integer
		int wholePart = (int)number; 
		
		// by subtracting the wholePart from the number we get the fractional part
		double fractionalPart = number - wholePart; 
		
		//return fractionalPart; 
		// if we return fractionalPart here, we may get too many decimal places so we
		// round the fractional part by 10000 since the problem asks us to use 
		// maximum 4 decimal digits for the number parameter,
		// so we return the result of the calculation below
		return (double)Math.round(fractionalPart * 10000) / 10000;
	
	}
	
	// method that takes a decimal number as a parameter and rounds the decimal number to integer
	public static int roundNum(double number) {
		
		// Way 1 (if):
		if (fracPart(number) >= 0.5) { // if fractional part of the number is greater than or equal to 0.5
			return (int)number + 1; // return integer number + 1
		}
		return (int)number; // return integer number
		
		// Alternative Way 2 (ternary operator): condition ? operation1 : operation2
		/*
		return fracPart(number) >= 0.5 ? (int)number + 1 : (int)number;
		*/
	}
}
