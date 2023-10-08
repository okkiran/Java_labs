
public class Bill {
	
	// data members
	protected int billNb;
    protected String nameSurname;
    protected double billPrice;
    
    protected final double UNITPRICE = 26.5;

    // constructor
    public Bill(int billNb, String nameSurname) {
        this.billNb = billNb;
        this.nameSurname = nameSurname;
        this.billPrice = 0;
    }

    //getters & setters
    public double getUNITPRICE() {
        return UNITPRICE;
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

    public boolean findBillNb(int billNb) {
        return this.billNb == billNb;
    }
}
