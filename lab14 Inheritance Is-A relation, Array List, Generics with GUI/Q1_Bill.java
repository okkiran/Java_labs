import java.util.Scanner;

public class Bill {
	
	// data members
	protected int billNb;
    protected String nameSurname;
    protected double billPrice;
    
    protected final double UNITPRICE = 26.5;

    // no-arg constructor
    public Bill() {
        this.billNb = 0;
        this.nameSurname = "";
        this.billPrice = 0;
    }

    //getters & setters
    public double getUNITPRICE() {
        return UNITPRICE;
    }

    public void setBillNb(int billNb) {
        this.billNb = billNb;
    }

    public void setBillPrice(double billPrice) {
        this.billPrice = billPrice;
    }

    // member methods
    @Override
    public String toString() {
        return "\nBill Number= " + billNb
	        + "\nName Surname= " + nameSurname
	        + "\nBill Price= " + billPrice;
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name and surname: ");
        nameSurname = scanner.nextLine();
    }

    public boolean findBillNb(int billNb) {
        return this.billNb == billNb;
    }
}
