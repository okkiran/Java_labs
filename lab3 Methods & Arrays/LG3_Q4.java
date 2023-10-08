import java.util.Scanner;

public class LG3_Q4 {

	public static final int SIZE = 10; // the constant size of the array
	
	public static void main(String[] args) {
		
		// initialization of the array variable for 10 elements
		int[] numbers = new int[SIZE];
		
		// length of the numbers array
		int length = numbers.length; // initial assignment of the variable for the case in switch
		
		int input, foundIndex; // user choice input, index of the element that will be found in the array
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		do {
		
			// displaying the menu
			input = menu();
			
			// calling methods according to the user choice input
			switch (input) {
				case 1: 
					initialize(numbers); // sending numbers array reference to be filled with 0 in the method 
					System.out.println("All elements are initialized by zero\n");
					break;
				case 2: 
					System.out.println("Enter the elements of the array:");
					length = fillArray(numbers); // sending numbers array reference to be filled by the user in the method
					System.out.println("The size of the array: " + length + "\n");
					break;
				case 3:
					displayArray(numbers, length); // displays all numbers on screen by using length parameter
					break;
				case 4:
					System.out.print("Enter the value that will be searched: ");
					input = scanner.nextInt();
					foundIndex = findPos(numbers, input); // finds the index of the input value in numbers
					if (foundIndex == -1) { // means we couldn't find the input value in numbers
						System.out.println("The array does NOT contain the searched number!\n");
					} else { // means we found the input value in numbers
						System.out.println("Position of the value is: " + foundIndex + "\n");
					}
					break;
			}
			
		} while (input != 5); // iterate the loop until user enters 5 as input
	}
	
	// method that displays the menu on the screen, reads and validates the user choice input
	public static int menu() {
		
		// user choice input variable
		int input = 0; // initial assignment of the variable for the conditions in the loop
		
		// displaying the menu
		System.out.println("\tMENU");
		System.out.println("1. Initialize array");
		System.out.println("2. Input array elements");
		System.out.println("3. Output array elements");
		System.out.println("4. Search a value");
		System.out.println("5. Exit program");
		
		System.out.println();
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// getting and validating user choice input
		do {
			System.out.print("Enter your choice: ");
			input = scanner.nextInt();
		} while(input < 1 || input > 5);
		
		return input; // returning valid input from the method
	}

	// Setting array's elements to 0, which is passed to this method as a reference parameter.
	// Before we initialized the array in the main method as numbers then sent it as a reference parameter to this method
	// therefore, since array is a reference type in Java, changes to the array in this method will be reflected
	// to the main method's numbers variable.
	public static void initialize(int[] array) {
		
		// setting array elements to 0
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		
	}
	
	// Filling array's elements by user input, which is passed to this method as a reference parameter and
	// returning the length (element count) of the array.
	public static int fillArray(int[] array) {
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// initialization of the loop variables
		int index = 0;
		int element = scanner.nextInt();
		
		// iterate until element is zero or index is greater then the array length
		while (element != 0 && index <= array.length) { 
			array[index] = element; 
			
			// updating loop variables
			element = scanner.nextInt();
			index++;
		}
		
		return index; // returning the last index as the length of elements in the array
	}
	
	// method that will display the elements of the array parameter according to the length parameter
	public static void displayArray(int[] array, int length) {
		
		for (int i = 0; i < length; i++) {
			System.out.printf("%d ", array[i]);
		}
		
		System.out.println("\n"); // displaying new line
	}
	
	// method that will find and return the index of the value in the array parameter,
	// the value parameter is the user input,
	// if no elements are found, method will return -1
	public static int findPos(int[] array, int value) {
		
		// index of the value that will be found in the array,
		// method will return -1 if value will not be found in the array
		int foundIndex = -1; 
		
		// Way 1:
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				foundIndex = i; // assigning loop index to foundIndex
				break; // since we found and don't need to iterate through other elements in the loop, we break the loop
			}
		}
		return foundIndex;
		
		// Alternative Way 2:
		/*
		Boolean found = false; // flag that will be set to true if the value will be found in the array
		
		// the loop will iterate until found will be set to true or index will be greater than or equal to the array length
		for (int i = 0; i < array.length && !found; i++) { 
			if (array[i] == value) {
				foundIndex = i; // assigning loop index to foundIndex
				found = true; // since we found, we update the flag as true to terminate the loop
			}
		}
		return found ? foundIndex : -1; // by using ternary operator if found is true return foundIndex else -1
		*/
	}
}
