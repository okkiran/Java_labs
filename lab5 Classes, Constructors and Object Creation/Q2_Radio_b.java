
public class Radio {
	
	// data members
	String name;
	String type;
	double frequency;
	
	// constructors
	Radio() {
		this.name = "Pal Fm";
		this.type = "Nostalgia";
		this.frequency = 92.4;
	}

	Radio(String name) {
		this.name = name;
	}

	Radio(String name, double frequency) {
		this.name = name;
		this.frequency = frequency;
	}

	Radio(String name, String type, double frequency) {
		this.name = name;
		this.type = type;
		this.frequency = frequency;
	}
}
