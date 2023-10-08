import java.util.Scanner;

public class BillMain {

	public static void main(String[] args) {
		
		Bill bill;
        int billNb;
        
		Scanner scanner = new Scanner(System.in);
        
		BillSys.addBill();
		
        System.out.println("Here is the list of Bills:");
        System.out.println(BillSys.display());

        System.out.println("Calculate and display the bills:  ");
        BillSys.calcBill();
        System.out.println(BillSys.display());

        // search the bill by bill number until it is found
        System.out.print("Enter bill number to search a bill: ");
        billNb = scanner.nextInt();
        
        bill = null;
        
        while (bill == null) {
            
            bill = BillSys.searchBill(billNb);

            if (bill != null) {
                System.out.println(bill);
            } else {
                System.out.println(billNb + " not found");
                System.out.print("Enter bill number to search a bill: ");
                billNb = scanner.nextInt();
            }
            
        }

	}

}
