
public class RadioMain_c {

	public static void main(String[] args) {
		
		Radio radio = new Radio(); // initialization of radio object of type Radio with no-arg constructor
		
		radio.display(); // invoking radio object's display method

		radio.setFrequency(36.6); // setting new frequency of the radio object
		System.out.println("\nFrequency of the object is " + radio.getFrequency()); // getting and displaying the new frequency
	}

}
