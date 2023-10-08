import java.util.Scanner;

public class LG2_Q2 {

	public static void main(String[] args) {
		
		// declaration of variables
		String itemType; // food, textile or electronic item type options (input)
		int itemNumber; // how many items that the user will enter the costs (input)
		double itemCost; // the costs of each item that user enters (input)
		
		// initial assignment of variables
		double totalCost = 0; // total cost that will be calculated for the costs entered for items
		double totalVat = 0; // total VAT according to item type that will be calculated for total cost
		Scanner scanner = new Scanner(System.in);
		
		// initial assignments of VAT constants
		final double FOODVAT = 0.08;
		final double TEXTILEVAT = 0.12;
		final double ELECTRONICVAT = 0.05;
		
		// displaying food, textile, electronic options and getting input,
		// if wrong input is entered by the user, displaying the options until the user enters the correct input
		do {
			System.out.print("\nF. Food\nT. Textile\nE. Electronic\nEnter the type of item (F/f: Food, T/t: Textile, E/e: Electronic): ");
			itemType = scanner.next();
		} while (!(itemType.equalsIgnoreCase("f") || itemType.equalsIgnoreCase("t") || itemType.equalsIgnoreCase("e")));
		
		// displaying number of items for entering costs and getting input
		System.out.print("\nHow many items you want to enter: ");
		itemNumber = scanner.nextInt();
		
		// asking the cost of each item
		for (int i = 1; i <= itemNumber; i++) { // i: loop counter
			System.out.print("Enter " + i + ". item's cost in TL: ");
			itemCost = scanner.nextDouble();
			totalCost += itemCost; // calculating total cost by adding the item cost to it in each loop iteration
		}
		
		// VAT operation according to item type
		switch (itemType.toLowerCase()) {
			case "f": totalVat = totalCost * FOODVAT;
				break;
			case "t": totalVat = totalCost * TEXTILEVAT;
				break;
			default: totalVat = totalCost * ELECTRONICVAT;
				break;
		}
		
		// displaying total cost and total VAT for 2 decimals
		System.out.printf("\nTotal cost: %.2f TL", totalCost);
		System.out.printf("\nTotal VAT: %.2f TL", totalVat);
	}

}
