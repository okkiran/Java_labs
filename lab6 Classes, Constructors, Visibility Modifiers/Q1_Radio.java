
public class Radio {

	// data members
	private String name;
	private double frequency;
	private String type;

	// constructors
	public Radio() {
		this.name = "Pal Fm";
		this.frequency = 92.4;
		this.type = "Nostalgia";
	}
	public Radio(String name) {
		this.name = name;
	}

	public Radio(String name, double frequency) {
		this.name = name;
		this.frequency = frequency;
	}

	public Radio(String name, String type, double frequency) {
		this.name = name;
		this.frequency = frequency;
		this.type = type;
	}  
	
	// getters and setters
	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	// member methods
	public void display(){
		System.out.println("Name: " + name + "\nFrequency: " + frequency + "\nType: " + type);
	}
	
}
