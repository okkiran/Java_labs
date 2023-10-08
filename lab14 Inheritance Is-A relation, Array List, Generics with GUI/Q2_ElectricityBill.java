
public class ElectricityBill extends Bill {
	
	// data members
	private double usedKWH;

	// constructor
    public ElectricityBill(int billNb, String nameSurname, double usedKWH) {
    	super(billNb, nameSurname);
        this.usedKWH = usedKWH;
    }

    // getters
    public double getUsedKWH() {
        return usedKWH;
    }
    
    // member methods
    @Override
    public String toString() {
        return "Electricity Bill" + super.toString() + "\nUsed KWH= " + usedKWH;
    }
}
