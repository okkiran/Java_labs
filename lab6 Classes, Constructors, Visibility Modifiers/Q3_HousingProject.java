import java.util.Scanner;

public class HousingProject {
	
	// data members
	private String brand;
	private String city;
	private double price;
	private int numberOfPayment;
	private String housePlan;

	// constructors
	public HousingProject() {
		brand = "No brand";
		city = "No city";
		housePlan = "No house plan";
		
		// Since data members with numeric value data types will be automatically assigned to 0 when instantiating a new object,
		// we don't need to assign them here.
		// Moreover, data members with boolean value data type will be automatically assigned to false, 
		// data members with reference data types such as string, array or class will be automatically assigned to null.
		//price = 0;
		//numberOfPayment = 0;
	}

	public HousingProject(String brand, String city, double price, int numberOfPayment, String housePlan) {
		this.brand = brand;
		this.city = city;
		this.price = price;
		this.numberOfPayment = numberOfPayment;
		this.housePlan = housePlan;
	}

	// member methods
	public void getInput() { // member method to get input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the brand: ");
		brand = scanner.nextLine(); // nextLine method can be used to get the whole line as a string input
		System.out.print("Enter the city: ");
		city = scanner.nextLine();
		System.out.print("Enter the price: ");
		price = scanner.nextDouble();
		System.out.print("Enter number of payments: ");
		numberOfPayment = scanner.nextInt();
		System.out.print("Enter the house plan: ");
		
		// The skip method of the Scanner class skips the pattern specified in an input, which is \\R: carriage return (or enter) here.
		// Therefore, we can get the discount percentage in the main method of HousingProjectMain class with a new line.
		// You may comment the line below and then uncomment it to see its effect.
		scanner.skip("\\R");
		
		housePlan = scanner.nextLine();
	}

	public void discount(int percentage) {
		price = price - price * percentage / 100;
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "Housing Project"
			+ "\nName : " + brand
			+ "\nCity: " + city
			+ "\nPrice: " + price
			+ "\nNumber of Payments: " + numberOfPayment
			+ "\nHouse Plan: " + housePlan;
	}
}
