
public class RadioMain_b {

	public static void main(String[] args) {
		
		Radio r1 = new Radio(); // r1 object initialization with no-arg constructor
		Radio r2 = new Radio("Power FM", "Pop", 104.8); // r2 object initialization with constructor using arguments
		Radio r3 = new Radio("NRK", "Jazz", 82.5); // r3 object initialization with constructor using arguments
		Radio r4 = new Radio("Joy FM", "Pop", 75.8); // r4 object initialization with constructor using arguments

		// displaying r1 object of type Radio data member values
		System.out.println("Name: " + r1.name);
		System.out.println("Frequency: " + r1.frequency);
		System.out.println("Type: " + r1.type);

		// displaying r2 object of type Radio data member values
		System.out.println("\nName: " + r2.name);
		System.out.println("Frequency: " + r2.frequency);
		System.out.println("Type: " + r2.type);

		// displaying r3 object of type Radio data member values
		System.out.println("\nName: " + r3.name);
		System.out.println("Frequency: " + r3.frequency);
		System.out.println("Type: " + r3.type);

		// displaying r4 object of type Radio data member values
		System.out.println("\nName: " + r4.name);
		System.out.println("Frequency: " + r4.frequency);
		System.out.println("Type: " + r4.type);

		// assigning new value to r1 object's frequency
		r1.frequency = 68.9;
		
		// displaying r1 object of type Radio updated frequency data member value
		System.out.println("\nThe new frequency of the radio 1 object is " + r1.frequency);

	}

}
