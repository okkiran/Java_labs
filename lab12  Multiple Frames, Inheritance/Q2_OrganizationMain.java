import java.util.Scanner;

public class OrganizationMain {

	public static void main(String[] args) {
		
		double hourlyPrice;
		Scanner scanner = new Scanner(System.in);
		
		// initializing an object of type Wedding and getting input
		Wedding wedding = new Wedding();
		wedding.getInput();
		
		// calculating the price of the Wedding object
		System.out.print("Enter hourly price of the wedding: ");
		hourlyPrice = scanner.nextDouble();
		wedding.calculate(hourlyPrice);
		
		// displaying the Wedding object
		System.out.println(wedding);
		
		// initializing an object of type Birthday and getting input
		Birthday birthday = new Birthday();
		birthday.getInput();
		
		// calculating the price of the Birthday object
		System.out.print("Enter hourly price of the birthday: ");
		hourlyPrice = scanner.nextDouble();
		birthday.calculate(hourlyPrice);
		
		// displaying the Birthday object
		System.out.println(birthday);
	}

}
