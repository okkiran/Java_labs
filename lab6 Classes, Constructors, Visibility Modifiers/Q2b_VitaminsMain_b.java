import java.util.Scanner;

public class VitaminsMain_b {

	public static void main(String[] args) {
		
		// declaration of variables
		String name, brand;
		int noOfCapsul, codeNumber;
		
		// for getting user input
		Scanner scanner = new Scanner(System.in); 
		
		// getting user inputs
		System.out.print("Enter Name: ");
		name = scanner.nextLine();
		System.out.print("Enter Brand Name: ");
		brand = scanner.nextLine();
		System.out.print("Enter the Number of Capsules: ");
		noOfCapsul = scanner.nextInt();
		System.out.print("Enter the Code Number: ");
		codeNumber = scanner.nextInt();

		// Way 1: Using non-default constructor to instantiate the object of type Vitamins with arguments
		// Vitamins vitamin = new Vitamins(name, noOfCapsul, brand, codeNumber);
		
		// Way 2: Using no-arg constructor to instantiate the object of type Vitamins and then
		// setting vitamin object's data member values by using Vitamins class' setters
		Vitamins vitamin = new Vitamins();
		vitamin.setName(name);
		vitamin.setBrand(brand);
		vitamin.setNumOfCapsul(noOfCapsul);
		vitamin.setCodeNumber(codeNumber);
		
		// since we have overridden the toString method in the Vitamins class,
		// the toString method will be automatically invoked even we use object as parameter
		System.out.println(vitamin);

	}

}
