import java.util.Scanner;

public class ElectricityBill extends Bill {
	
	// data members
	private double usedKWH;

	// no-arg constructor
    public ElectricityBill() {
    	super();
        this.usedKWH = 0;
    }

    // getters
    public double getUsedKWH() {
        return usedKWH;
    }
    
    // member methods
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter used KWH: ");
        usedKWH = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Electricity Bill" + super.toString() + "\nUsed KWH= " + usedKWH;
    }
}
