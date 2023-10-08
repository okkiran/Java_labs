import java.util.Scanner;

public class LG3_AQ2 {

	public static void main(String[] args) {
		
		// displaying the menu and getting valid user choice input
		int choice = menu(); // initial assignment of the loop variable
		
		// result that will be returned from the methods for number1 or number2 parameters in switch cases
		boolean result;
		int number1, number2;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		while (choice != 3) { // iterate until choice is equal to 3
			switch (choice) {
				case 1:
					System.out.print("Enter first number: ");
                    number1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    number2 = scanner.nextInt();
                    
					result = isRelPrime(number1, number2);
					
					// Way 1: if else
					/*
					if (result == true) {
						System.out.println("Relatively Prime Numbers");
					}
					else {
						System.out.println("NOT Relatively Prime Numbers");
					}
					*/
					
					// Way 2: if else
					if (result) {
						System.out.println("Relatively Prime Numbers");
					}
					else {
						System.out.println("NOT Relatively Prime Numbers");
					}
					
					// Alternative Way 3: ternary operator
					/*
					System.out.println(result == true ? "Relatively Prime Numbers" : "NOT Relatively Prime Numbers");
					*/
					
					break;
				case 2:
					System.out.print("Enter a number: ");
                    number1 = scanner.nextInt();
                    
					result = isPerfect(number1);
					
					// Way 1: if else
					if (result)
						System.out.println("Perfect Number");
					else
						System.out.println("NOT Perfect Number");
					
					// Alternative Way 2: ternary operator
					/*
					System.out.println(result ? "Perfect Number" : "NOT Perfect Number");
					*/
					
					break;
			}
			
			System.out.println();
			
			choice = menu(); // update assignment of the loop variable
		}
		
	}
	
	// method that displays the menu, gets user's choice input, validates it
	// and if it is valid, returns the input
	public static int menu() {
		
		// user choice input
		int choice;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		do
		{
			// displaying the menu
			System.out.println("Menu");
			System.out.println("1. Is Relatively Prime");
			System.out.println("2. Is Perfect");
			System.out.println("3. Exit");
			
			System.out.print("Enter your choice: ");
			
			// getting user choice input
			choice = scanner.nextInt();
			
		} while (!(choice == 1 || choice == 2 || choice == 3)); // iterate until choice is 1 or 2 or 3
		
		// returning user choice input
		return choice;
	}

	// Method the returns true if two numbers are relatively prime,
	// returns false if they are not relatively prime.
	// If there is no integer greater than 1 that divides both number1 and number2 parameters,
	// these two numbers are relatively prime.
	public static boolean isRelPrime(int number1, int number2) {
		
		// the result that we will return from the method,
		// we set the initial value true to result
		boolean result = true; 
		
		// first we find the small number
		int small = number1;
		if (number2 < small) {
			small = number2;
		}
		
		// then we start iterating the loop with 2 since we need to iterate through integers other than 1,
		// we also increment the index by 1 until we reach the small number
		for (int n = 2; n <= small; n++) {
			
			// if n divides both number1 and number2 without a remainder, 
			// the numbers are not relatively prime
			if (number1 % n == 0 && number2 % n == 0) {
				result = false; // we set result to false
				break; // and break the loop since we don't need to iterate through other n indices
			}
		}
		
		// after the loop we return true for relatively prime or false for not relatively prime from the method
		return result;
	}
	
	// Method that returns true if sum of the divisors of the number parameter equals to the number, otherwise false.
	// Some perfect number examples: 6, 28, 496 and 8128.
	public static boolean isPerfect(int number) {
		
		// sum variable for the loop initially assigned by 0
		int sum = 0;
		
		// we will iterate the loop until the index is equal to number parameter
		for (int i = 1; i < number; i++) {
			
			// if number mod index equals to 0
			if (number % i == 0) { 
				sum += i; // since i divides the number, we will add it to sum
			}
			
		}
		
		// after the loop we will check if the sum equals to the number, if so we will return true, otherwise false
		
		// Way 1: if else
		/*
		if (sum == number) {
			return true;
		}
		else {
			return false;
		}
		*/
		
		// Way 2: return
		if (sum == number) {
			return true;
		}
		return false;
	}
}
