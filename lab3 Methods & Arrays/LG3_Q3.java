import java.util.Scanner;

public class LG3_Q3 {

	public static void main(String[] args) {
		
		// initialization of the numbers array that will be filled by the user
		int[] numbers = new int[5];
		
		// variable declarations for sum and average operations
		double sum, average;

		Scanner scanner = new Scanner(System.in);
		
		// showing message and getting user inputs
		System.out.println("Enter 5 integer numbers: ");
		
		// filling array with 5 elements by user inputs
		for (int i = 0; i < 5; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		// displaying array elements and calculating the sum
		System.out.print("\nThe array content: ");
		
		// initial assignment of sum variable before the loop
		sum = 0; 
		
		// Way 1: for loop
		/*
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
			sum = sum + numbers[i];
		}
		*/
		
		// Way 2: for each loop
		for (int number : numbers) {
			System.out.print(number + " ");
			sum += number;
		}
		
		// displaying the average of numbers
		average = sum / numbers.length; 
		
		System.out.printf("\n\nSum of the numbers: %.0f. Average of the numbers: %.2f", sum, average);
		
		System.out.println("\n"); // displaying new line
		
		// displaying difference to average table
		System.out.println("index number diff. to avg");
		System.out.println("----- ------ ------------");
		
		// Way 1: for loop
		/*
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%5d %6d %12.2f", i, numbers[i], numbers[i] - average);
			System.out.println(); // displaying new line
		}
		*/
		
		// Way 2: while loop
		int j = 0; // initial loop value
		while (j < numbers.length) {
			System.out.printf("%5d %6d %12.2f", j, numbers[j], numbers[j] - average);
			System.out.println(); // displaying new line
			j++; // updating loop value
		}
	}

}
