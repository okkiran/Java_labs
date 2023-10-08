import java.util.Scanner;

public class Salesman {
	
	// data members
	private String name;
	private int workDay;
	private double salary;
	private int insuranceStartYear;
	private double retirementSalary;   
	
	private static int salesmanCount = 0;

	// no-arg constructor
	public Salesman() {
		name = "No Name";
		salesmanCount++;
	}

	// member methods
	public static int getSalesmanCount() {
	    return salesmanCount;
	}
	
	public double getSalary() { // getter
	    return salary;
	}

	public double getRetirementSalary() { // getter
	    return retirementSalary;
	}

	public int getWorkDay() { // getter
		return workDay;
	}

	public int getInsuranceStartYear() { // getter
	    return insuranceStartYear;
	}

	public void setRetirementSalary(double retirementSalary) { // setter
	    this.retirementSalary = retirementSalary;
	}

	public void getInput() {
	    Scanner scanner = new Scanner(System.in);
	
	    System.out.print("\nEnter Name: ");
	    name = scanner.nextLine();
	    System.out.print("Enter total worked day: ");
		workDay = scanner.nextInt();
		System.out.print("Enter your current salary: ");
		salary = scanner.nextInt();
		System.out.print("Enter the insurance start year: ");
	    insuranceStartYear = scanner.nextInt();
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
	    return "Salesman"
			+ "\nName= " + name
			+ "\nWorked Day= " + workDay
			+ "\nSalary= " + salary
			+ "Insurance Start Year= " + insuranceStartYear;
	}
	
}
