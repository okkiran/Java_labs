import java.util.Scanner;

public class Organization { // super (base or parent) class

	// data members
	protected String companyName;
    protected String ownerName;
    protected double price;
    protected int duration;

    // member methods
    public void calculate(double hourlyPrice) {
        price = duration * hourlyPrice;
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Company Name: ");
        companyName = scanner.nextLine();
        System.out.print("Enter owner name: ");
        ownerName = scanner.nextLine();
        System.out.print("Enter the organization duration: ");
        duration = scanner.nextInt();
    }

    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
        return "Company Name= " + companyName
	        + "\nOwner Name= " + ownerName
	        + "\nPrice= " + price
	        + "\nDuration= " + duration;
    }
	
}
