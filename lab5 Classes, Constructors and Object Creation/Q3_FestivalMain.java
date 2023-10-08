
public class FestivalMain {

	public static void main(String[] args) {
		
		Festival festival1 = new Festival(); // festival1 object initialization with no-arg constructor
		Festival festival2 = new Festival("Jazz Festival", "C", 200.50); // festival2 object initialization with constructor using arguments
		Festival festival3 = new Festival("Coffee Festival", "O", 40.6); // festival3 object initialization with constructor using arguments

		// invoking festival1, festival2 and festival3 objects' display methods
		festival1.display();
		festival2.display();
		festival3.display();

		// invoking festival2 and festival3 objects' calculateExtraPrice methods
		festival2.calculateExtraPrice();
		festival3.calculateExtraPrice();

		// displaying festival2 and festival3 objects' updated prices
		System.out.println("Price of festival after adding extra prices - if any:");
		System.out.println(festival2.festivalName + " costs " + festival2.price);
		System.out.println(festival3.festivalName + " costs " + festival3.price);

	}

}
