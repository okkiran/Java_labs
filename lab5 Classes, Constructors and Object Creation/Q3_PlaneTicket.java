
public class PlaneTicket {
	
	// data members
	String companyName;
	String passengerName;
	int passengerAge;
	int flightNb;
	String flightDay;
	double price;

	// constructors
	PlaneTicket() {
		this.companyName = "No Company Name";
		this.passengerName = "No Passenger Name";
		this.passengerAge = 0;
		this.flightNb = 0;
		this.flightDay = "No Flight Day";
		this.price = 0;
	}

	PlaneTicket(String companyName, String passengerName, int passengerAge, int flightNb, String flightDay, double price) {
		this.companyName = companyName;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.flightNb = flightNb;
		this.flightDay = flightDay;
		this.price = price;
	}

	// member methods
	void display() {
		System.out.println("Plane Ticket"
			+ "\nCompany Name= " + companyName
			+ "\nPassenger Name= " + passengerName
			+ "\nPassenger Age= " + passengerAge
			+ "\nFlight Nb= " + flightNb
			+ "\nFlight Day= " + flightDay
			+ "\nPrice= " + price + "\n");
	}

	void calculateDiscountedPrice() {
		// if passenger's age is greater than 60 then make 30% discount,
		// if passenger's age is between 0 (included) and 3 (excluded) then make 75% discount
		if (passengerAge > 60) {
			price = price - price * 30 / 100;
		} else if (passengerAge >= 0 && passengerAge < 3) {
			price = price - price * 75 / 100;
		}
	}

	void calculateBonusDiscount() {
		// if flight day is Tuesday or Thursday then make 10% discount
		if (flightDay.equalsIgnoreCase("Tuesday") || flightDay.equalsIgnoreCase("Thursday")) {
			price = price - price * 10 / 100;
		}
	}
}
