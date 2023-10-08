
public class GiftCardMain {

	// Member method to update the object of type GiftCard according to the cardId.
	// Since giftCard parameter is a reference to the object of type GiftCard,
	// object's values will be updated in this method and the updated object will be used
	// in the main method after invoking this method.
	public static void checkCard(GiftCard giftCard) {
		
		if (giftCard.getCardId() % 10 == 5) {
			giftCard.setAmount(giftCard.getAmount() * 2);
		} else if (giftCard.getCardId() % 10 == 7) {
			giftCard.setRemainingDay(4);
		}
		
	}

	// main method
	public static void main(String[] args) {

		// initializing gift card objects using constructors with parameters
		GiftCard giftCard1 = new GiftCard(15685, 10, 2, 150);
		GiftCard giftCard2 = new GiftCard(12547, 61, 4, 2000);

		// adding stores to the gift card objects
		giftCard1.addStore("Zara");
		giftCard1.addStore("Ipekyol");

		giftCard2.addStore("Columbia");
		giftCard2.addStore("LG");
		giftCard2.addStore("Teknosa");
		giftCard2.addStore("Adidas");

		// for testing number of gift card objects created
		//System.out.println("Number of Gift Cards: " + GiftCard.getCountOfGC() + "\n");

		// displaying gift card objects
		System.out.println("Information of Gift Cards");
		System.out.println(giftCard1); // could also be written as System.out.println(giftCard1.toString());
		System.out.println(giftCard2);

		// updating gift card objects by using their references according to the cardIds
		checkCard(giftCard1);
		checkCard(giftCard2);

		// displaying updated gift card objects
		System.out.println("\nInformation of Updated Gift Cards");
		System.out.println(giftCard1);
		System.out.println(giftCard2);

	}

}
