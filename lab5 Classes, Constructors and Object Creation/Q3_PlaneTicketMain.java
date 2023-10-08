
public class PlaneTicketMain {

	public static void main(String[] args) {
		
		PlaneTicket planeTicket1 = new PlaneTicket(); // planeTicket1 object initialization with no-arg constructor
		PlaneTicket planeTicket2 = new PlaneTicket("Pegasus", "Burcu Liman", 2, 1234543, "Monday", 123.5); // planeTicket2 object initialization with constructor using arguments
		PlaneTicket planeTicket3 = new PlaneTicket("Turkish Airlines", "Ibrahim Usta", 65, 643242, "Tuesday", 340.6); // planeTicket3 object initialization with constructor using arguments

		// invoking planeTicket1, planeTicket2 and planeTicket3 objects' display methods
		planeTicket1.display();
		planeTicket2.display();
		planeTicket3.display();

		// invoking planeTicket2 and planeTicket3 objects' calculateDiscountedPrice methods
		planeTicket2.calculateDiscountedPrice();
		planeTicket3.calculateDiscountedPrice();

		// invoking planeTicket2 and planeTicket3 objects' calculateBonusDiscount methods
		planeTicket2.calculateBonusDiscount();
		planeTicket3.calculateBonusDiscount();

		// displaying planeTicket2 and planeTicket3 objects' updated prices
		System.out.println("Price of the flights after discounts - if any:");
		System.out.println("Flight nb with " + planeTicket2.flightNb + " should pay " + planeTicket2.price);
		System.out.println("Flight nb with " + planeTicket3.flightNb + " should pay " + planeTicket3.price);

	}

}
