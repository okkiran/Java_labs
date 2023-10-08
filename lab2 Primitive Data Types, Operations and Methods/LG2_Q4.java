import java.util.Scanner;

public class LG2_Q4 {

	// variables can also be declared and assigned directly in a class,
	// constant declarations and assignments
	public static final double VAKIF = 1.34;
	public static final double YAPI = 1.55;
	public static final double GARANTI = 1.69;
	public static final double SEKER = 1.51;
	
	public static void main(String[] args) {
		
		// declaration and initial assignment of variables
		double creditAmount, percentage = 0.0, totalAmount = 0, monthlyPayment; // percentage: interest rate
		int maturity = 0; // the month number that the monthly loan payments will be paid
		int bankChoice;
		
		Scanner scanner = new Scanner(System.in);
		
		// asking credit amount to the user
		System.out.print("Enter your credit amount (TL): ");
		creditAmount = scanner.nextDouble();
		
		// asking the month number that the monthly loan payments will be paid to the user
		System.out.print("Enter your maturity (months): ");
		maturity = scanner.nextInt();
		
		// getting the bank that user selects
		bankChoice = menu();
		
		// determining the percentage according to the user's bank choice and constants
		switch (bankChoice) {
			case 1: 
				percentage = VAKIF;
				break;
			case 2: 
				percentage = YAPI;
				break;
			case 3: 
				percentage = GARANTI;
				break;
			default: // SEKER
				percentage = SEKER;
				break;
		}
		
		// calculating the total amount that the user will have to pay
		totalAmount = calculateTotal(creditAmount, percentage);
		
		// calculating the monthly payment according to the total amount that the user will have to pay 
		monthlyPayment = totalAmount / maturity;
		
		// displaying the total amount and monthly payment to the user
		System.out.printf("\nTotal money you will pay is %.2f", totalAmount);
		System.out.printf("\nMonthly pay is %.2f", monthlyPayment);
	}

	// display the bank menu to the user
	public static int menu() {
		
		// declaration of variables
		int menuChoice;
		
		// initial assignment of variables
		Scanner scanner = new Scanner(System.in); // this scanner variable has different scope of the scanner variable in main method above, therefore same variable name can be used
				
		// displaying bank menu
		System.out.println("\tMENU\t");
		System.out.println("1. VAKIFBANK");
		System.out.println("2. YAPIKREDI");
		System.out.println("3. GARANTI");
		System.out.println("4. SEKERBANK");
		
		// getting initial input from the user
		System.out.print("Select one of the banks: ");
		menuChoice = scanner.nextInt();
		
		while (menuChoice < 1 || menuChoice > 4) { // invalid bank choice
			System.out.print("Select one of the banks: "); // display the message again
			menuChoice = scanner.nextInt(); // getting updated input from the user
		}
		
		return menuChoice; // returning the bank choice of the user from the method 
	}
	
	// calculate and return the total amount by credit and percentage parameters
	public static double calculateTotal(double credit, double percentage) {
		double total = credit * percentage;
		return total;
	}

}
