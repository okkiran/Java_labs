import java.util.Scanner;

public class Wedding extends Organization { // sub (child) class,
											// Wedding is an Organization (is-a relationship)

	// data member
	private String foodPackage;

	// member methods
    public void getInput() {
    	super.getInput(); // invoking the getInput method of the super (Organization) class to get organization information from the user
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter food package(Chicken/Meat): ");
        foodPackage = scanner.nextLine();
    }

    // overriding calculate method of the super (Organization) class to change the price calculation for child (Wedding) class
    @Override
    public void calculate(double hourlyPrice) {
        super.calculate(hourlyPrice); // invoking the calculate method of the super (Organization) class first
        
        // then updating the price of the super (Organization) class according to the food package
        if (foodPackage.equalsIgnoreCase("Chicken")) {
            super.price += 100;
        } else {
            super.price += 200;
        }
    }
    
    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
        return "\nWedding\n"
            + super.toString() // invoking the toString method of the super (Organization) class for organization information
            + "\nFood Package= " + foodPackage + "\n";
    }
	
}
