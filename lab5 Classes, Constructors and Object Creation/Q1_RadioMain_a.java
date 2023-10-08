
public class RadioMain_a {

	public static void main(String[] args) {
		
		Radio radio = new Radio(); // object creation
		
		radio.initialize(); // invoking the initialize method of the object of type Radio
		
		// displaying object of type Radio data member values
		System.out.println("Name: " + radio.name);
		System.out.println("Type: " + radio.type);
		System.out.println("Frequency: " + radio.frequency);
	}

}
