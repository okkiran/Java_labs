
public class WaterBill extends Bill {
	
	// data members
	private double usedM3;

	// constructor
    public WaterBill(int billNb, String nameSurname, double usedM3) {
    	super(billNb, nameSurname);
        this.usedM3 = usedM3;
    }

    // getters
    public double getUsedM3() {
        return usedM3;
    }

    // member methods
    @Override
    public String toString() {
        return "Water Bill" + super.toString() + "\nUsed M3= " + usedM3;
    }
}
