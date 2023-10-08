import java.util.ArrayList;

public class BillSys {
	
	// data members:
	// array list of Bill objects
	public static ArrayList<Bill> arr = new ArrayList<Bill>();

	// member methods:
	// this method checks whether the bill number parameter exists or not in the objects of the array list
	// and returns false if it exists, true if it doesn't exist
    public static boolean checkBillNb(int billNb) {
    	boolean result = true;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).findBillNb(billNb)) {
                result = false;
                break;
            }
        }
        return result;
    }

    // this method adds a water or electricity bill without the same bill number of the objects in the array list
    public static boolean addBill(String billType, int billNb, String nameSurname, double m3orKwh) {
    	Bill bill;
        
    	if (!checkBillNb(billNb)) {
            return false;
    	}
        
        if (billType.equalsIgnoreCase("water")) {
            bill = new WaterBill(billNb, nameSurname, m3orKwh);
        } else {
            bill = new ElectricityBill(billNb, nameSurname, m3orKwh);
        }
        arr.add(bill);
        
        return true;  
    }

    // this method searches the bill number of objects in the array list by the parameter
    // and returns null if the bill is not found, otherwise returns the bill
    public static Bill searchBill(int billNbSearch) {
    	Bill bill = null;
    	
    	for (Bill b : arr) {
    		if (b.findBillNb(billNbSearch)) {
    			bill = b;
    			break;
    		}
    	}
    	
    	return bill;
    }
    
    // this method displays the bill information of the objects in the array list
    public static String display() {
        Bill bill;
        String output = "";
        
        for (int i = 0; i < arr.size(); i++) {
    		bill = (Bill)arr.get(i); // casting the WaterBill or ElectricityBill object of the array list to type Bill
            output += bill + "\n\n";
        }
        
        return output;
    }

    // this method calculates the bill prices of the objects in the array list
    public static void calcBill() {

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) instanceof WaterBill) { // if the type of the object of the array list is WaterBill
            	// cast the object to type WaterBill and set the bill price by multiplying unit price with used m3
                arr.get(i).setBillPrice(arr.get(i).getUNITPRICE() * ((WaterBill)arr.get(i)).getUsedM3());
            } else { // if the type of the object of the array list is ElectricityBill
            	// cast the object to type ElectricityBill and set the bill price by multiplying unit price with used kw/h
                arr.get(i).setBillPrice(arr.get(i).getUNITPRICE() * ((ElectricityBill)arr.get(i)).getUsedKWH());
            }

        }
    }
}
