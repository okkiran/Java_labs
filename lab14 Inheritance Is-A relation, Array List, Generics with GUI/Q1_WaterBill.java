import java.util.Scanner;

public class WaterBill extends Bill {
	
	// data members
	private double usedM3;

	// no-arg constructor
    public WaterBill() {
    	super();
        this.usedM3 = 0;
    }

    // getters
    public double getUsedM3() {
        return usedM3;
    }

    // member methods
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter used M3: ");
        usedM3 = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Water Bill" + super.toString() + "\nUsed M3= " + usedM3;
    }
}
