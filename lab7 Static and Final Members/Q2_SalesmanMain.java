import java.util.Scanner;

public class SalesmanMain {

	public static double calculateRetirementSalary(int insuranceStartYear, int totalWorkDay, double salary) {

		// variable declaration
		double retirementSalary;

		if (insuranceStartYear < 2000) { // if insurance start year is less than 2000, apply the calculation below
			double yearlySalary = 12 * salary / 1000;
			retirementSalary = yearlySalary * 1200 * 0.06;
		} else { // if insurance start year is greater than or equals to 2000, apply the calculation below
			double factor = 12 * salary / (totalWorkDay / 360);
			retirementSalary = factor * 120 * 0.01;
		}

		return retirementSalary;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // for getting user input
		
		// variable declarations
		String input;
		Salesman salesman;
		
		// getting user input
		System.out.print("Do you want to check the retirement salary for a salesman (Yes/No): ");
		input = scanner.next();
		
		while (input.equalsIgnoreCase("yes")) { // as long as user enters yes
			
			// initialize a new object of type Salesman
			salesman = new Salesman();
			
			// getting user input to set object's data member values
			salesman.getInput();

			// invoking setRetirementSalary method using calculated retirement salary result 
			// by invoking calculateRetirementSalary method with insurance start year, work day and salary result parameters
			salesman.setRetirementSalary(calculateRetirementSalary(salesman.getInsuranceStartYear(), salesman.getWorkDay(), salesman.getSalary()));

			if (salesman.getInsuranceStartYear() < 1980) { // if salesman's insurance year is below 1980 (excluded)
				if (salesman.getWorkDay() >= 5000) { // if salesman's working days are above 5000 (included)
					System.out.println("You can retire whenever you want.");
				} else { // if salesman's working days are below 5000 (excluded)
					System.out.println("You have to work " + (5000 - salesman.getWorkDay()) + " more days.");
				}
			} else {
				if (salesman.getWorkDay() >= 7200) { // if salesman's working days are above 7200 (included)
					System.out.println("You can retire whenever you want.");
				} else { // if salesman's working days are below 7200 (excluded)
					System.out.println("You have to work " + (7200 - salesman.getWorkDay()) + " more days.");
				}
			}

			// displaying retirement salary to the user
			System.out.printf("If you retire, you will be paid %.2f$ per month.\n", salesman.getRetirementSalary());

			// updating while loop's condition by getting new input from the user
			System.out.print("\nDo you want to check the retirement salary for a salesman (Yes/No): ");
			input = scanner.next();

		}

		// displaying number of instantiated Salesman objects
		System.out.print("\nThere are " + Salesman.getSalesmanCount() + " salesman.");

	}

}
