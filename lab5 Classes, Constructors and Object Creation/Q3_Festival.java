
public class Festival {

	// data members
	String festivalName;
	String type;
	double price;

	// constructors
	Festival() {
		this.festivalName = "No Festival Name";
		this.type = "No Type";
		this.price = 0;
	}

	Festival(String festivalName, String type, double price) {
		this.festivalName = festivalName;
		this.type = type;
		this.price = price;
	}

	// member methods
	void display() {
		System.out.println("Festival"
			+ "\nFestival Name= " + festivalName
			+ "\nType= " + type
			+ "\nPrice= " + price + "\n");
	}

	void calculateExtraPrice() {
		// if festival type is concert then increment price data member value by 100
		if (type.equalsIgnoreCase("C")) {
			price += 100;
		} 
	}
	
}
