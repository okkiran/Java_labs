import java.util.Scanner;

public class Birthday extends Organization { // sub (child) class,
											 // Birthday is an Organization (is-a relationship)

	// data member
	private boolean includeEntertainment;

	// member methods
    public void getInput() {
        super.getInput(); // invoking the getInput method of the super (Organization) class to get organization information from the user
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to include entertainment(Y/N): ");
        String input = scanner.next();
        
        // Way 1:
        /*
        if (input.equalsIgnoreCase("Y")) {
            includeEntertainment = true;
        } else {
            includeEntertainment = false;
        }
        */
        
        // Way 2:
        includeEntertainment = input.equalsIgnoreCase("Y");
    }

    // overriding calculate method of the super (Organization) class to change the price calculation for child (Birthday) class
    @Override
    public void calculate(double hourlyPrice) {
        super.calculate(hourlyPrice); // invoking the calculate method of the super (Organization) class first
        
        // then updating the price of the super (Organization) class according to entertainment
        if (includeEntertainment) {
            super.price += 150;
        }
    }

    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
        return "\nBirthday\n"
            + super.toString() // invoking the toString method of the super (Organization) class for organization information
            
            + "\nInclude Entertainment= " + includeEntertainment + "\n";
        	/*
        	+ "\nInclude Entertainment= " + (includeEntertainment ? "Yes" : "No") + "\n"; can also be written instead of writing true or false in the string returned
        	*/
    }
	
}
