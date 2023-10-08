import java.util.Scanner;

public class LG3_AQ1 {

	// the maximum elements size of the input array
	public static final int SIZE = 100;
	
	public static void main(String[] args) {
		
		// inputs integer array that the user will fill
		int[] inputs = new int[SIZE];
		
		// the length of the inputs array after the user fills
		int inputsLength;
		
		// userChoice variable that will be the result of the menu method
		int userChoice;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// asking user to fill the inputs array
		System.out.println("Enter the elements of the array: ");
		inputsLength = fillArray(inputs); // sending inputs reference variable to the method so it will be filled
		
		System.out.println();
		
		do
		{
			// displaying the menu, getting user's choice input and invoking the methods according to user's choice
			userChoice = menu();
			
			switch (userChoice) {
				case 1: 
					displayAllNumbers(inputs, inputsLength);
					break;
				case 2:
					displayEvenNumbers(inputs, inputsLength);
					break;
				case 3:
					displaySubscriptsOfOddNumbers(inputs, inputsLength);
					break;
				case 4:
					displayNumbersWithEvenSubscripts(inputs, inputsLength);
					break;
				case 5:
					displayMinimumNumber(inputs, inputsLength);
					break;
				case 6:
					displaySubscriptOfMaximumNumber(inputs, inputsLength);
					break;
			}
			
		} while (userChoice != 7); // iterate until user enters 7

	}
	
	// method that will fill the numbers array through the numbers reference variable
	// and will return the length of the array
	public static int fillArray(int[] numbers) {
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		int i = 0; // loop index initial assignment for the loop
		
		// getting number input from the user, assigning it to the element with the appropriate index
		// and incrementing the index
		int number = scanner.nextInt(); // declaration and initial assignment (for the loop) of number variable from the user input
		
		while (number != 0 && i < numbers.length) { // iterate until number is 0 or i is greater than or equal to 100
			numbers[i] = number;
			i++;
			number = scanner.nextInt(); // update assignment of number variable (for the loop) from the user input
		}
		
		return i; // returning the last index after the loop as the length of the numbers array
	}
	
	// method that displays the menu, gets and validates the user input and returns it
	public static int menu() {
		
		// variable that will be set by the user's input
		int choice;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// displaying the menu
		System.out.println("DISPLAY");
		System.out.println("1. All numbers");
		System.out.println("2. Even numbers");
		System.out.println("3. Subscripts (indices) of odd numbers");
		System.out.println("4. The numbers with even subscripts");
		System.out.println("5. Minimum number");
		System.out.println("6. Subscript of maximum number");
		System.out.println("7. Exit");
		
		// validating user input
		do
		{
			System.out.print("\nEnter your choice: ");
			choice = scanner.nextInt();
		} while (!(choice >= 1 && choice <= 7)); // iterate until input is between 1 and 7
		
		// returning the input
		return choice;
		
	}
	
	// method that will display all numbers on the screen according to numbers and numbersLength parameters
	public static void displayAllNumbers(int[] numbers, int numbersLength) {
		
		System.out.println("\nAll numbers");
		System.out.println("***********");
		
		// Way 1: for loop
		for (int i = 0; i < numbersLength; i++) {
			System.out.printf("%d ", numbers[i]);
		}
		
		System.out.println("\n");
	}
	
	// method that will display even numbers on the screen according to numbers and numbersLength parameters
	public static void displayEvenNumbers(int[] numbers, int numbersLength) {
		
		System.out.println("\nEven numbers");
		System.out.println("************");
		
		for (int i = 0; i < numbersLength; i++) { // iteration of each numbers element
			
			if (numbers[i] % 2 == 0) { // if after element is divided by 2 operation's remainder is 0 (%: modulus, mod)
				System.out.printf("%d ", numbers[i]); // the number is even, display
			}
		}
		
		System.out.println("\n");
	}
	
	// method that will display the subscripts (indices) of odd numbers on the screen
	// according to numbers and numbersLength parameters
	public static void displaySubscriptsOfOddNumbers(int[] numbers, int numbersLength) {
		
		System.out.println("\nSubscripts of odd numbers");
		System.out.println("*************************");
		
		for (int i = 0; i < numbersLength; i++) { // iteration of each numbers element
			
			if (numbers[i] % 2 != 0) { // if after element is divided by 2 operation's remainder is not 0 (%: modulus, mod)
				System.out.printf("%d ", i); // the number is odd, display the index
			}
			
		}
		
		System.out.println("\n");
	}
	
	// method that will display the numbers with even subscripts (indices)
	// according to numbers and numbersLength parameters
	public static void displayNumbersWithEvenSubscripts(int[] numbers, int numbersLength) {
		
		System.out.println("\nThe numbers with even subscripts");
		System.out.println("********************************");
		
		for (int i = 0; i < numbersLength; i++) { // iteration of each numbers element
			
			if (i % 2 == 0) { // if index mod 2 equals 0
				System.out.printf("%d ", numbers[i]); // the index is even, display the number
			}
			
		}
		
		System.out.println("\n");
	}
	
	// method that displays the minimum number according to numbers and numbersLength parameters
	public static void displayMinimumNumber(int[] numbers, int numbersLength) {
		
		System.out.println("\nMinimum number");
		System.out.println("**************");
		
		if (numbersLength > 0) { // if numbers array has no elements don't do anything
			
			int minimum = numbers[0]; // setting the minimum as the first element of numbers array
			
			for (int i = 1; i < numbersLength; i++) { // iteration of each other numbers element
				
				if (numbers[i] < minimum) { // if the element at the index is less than minimum
					minimum = numbers[i]; // update minimum as the element at the index
				}
				
			}
			
			System.out.printf("%d", minimum); // display the minimum
			System.out.println();
		}
		
		System.out.println();
	}
	
	// method that displays the maximum index of the maximum number according to numbers and numbersLength parameters 
	public static void displaySubscriptOfMaximumNumber(int[] numbers, int numbersLength) {
		
		System.out.println("\nSubscript of maximum number");
		System.out.println("***************************");
		
		if (numbersLength > 0) { // if numbers array has no elements don't do anything
			
			int maximumIndex = 0; // setting the maximum index as the first index of numbers array
			int maximum = numbers[maximumIndex]; // setting the maximum as the first element of numbers array
			
			for (int i = 1; i < numbersLength; i++) { // iteration of each other numbers element
				
				if (numbers[i] > maximum) { // if the element at the index is greater than maximum
					maximumIndex = i; // update maximum index as the index
				}
				
			}
			
			System.out.printf("%d", maximumIndex); // display the maximum index
			System.out.println();
			
		}
		
		System.out.println();
	}
}
