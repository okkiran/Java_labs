
public class Vitamins {
	
	// data members
	private String name;
	private int numOfCapsul;
	private String brand;
	private int codeNumber;

	// constructors
	public Vitamins() {
		name = "No Name";
		brand = "No Brand";
		
		// Since data members with numeric value data types will be automatically assigned to 0 when instantiating a new object,
		// we don't need to assign them here.
		// Moreover, data members with boolean value data type will be automatically assigned to false, 
		// data members with reference data types such as string, array or class will be automatically assigned to null.
		//numOfCapsul = 0;
		//codeNumber = 0;
	}

	public Vitamins(String name, int numOfCapsul, String brand, int codeNumber) {
		this.name = name;
		this.numOfCapsul = numOfCapsul;
		this.brand = brand;
		this.codeNumber = codeNumber;
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "\nVitamin Info:" + 
			"\nName= " + name + 
			"\nNumOfCapsul= " + numOfCapsul + 
			"\nBrand= " + brand + 
			"\nCodeNumber= " + codeNumber;
	}
}
