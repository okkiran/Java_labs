import java.util.Scanner;

public abstract class Festival {
	
	// data members
	protected String name;
    protected String date;
    protected String place;
    protected double ticketPrice;

    // no-arg constructor
    public Festival() {
    }

    // getter
    public String getName() {
        return name;
    }

    // abstract member method definition
    public abstract double getSale();
    
    // member methods
    public void getInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Festival Name: ");
        name = sc.nextLine();
        System.out.print("Enter Festival Date: ");
        date = sc.next();
        System.out.print("Enter Festival Place: ");
        place = sc.next();
        System.out.print("Enter Festival Ticket Price: ");
        ticketPrice = sc.nextDouble();   
    }
    
    @Override
    public String toString() {
        return "\nName= " + name + "\nDate= " + date + "\nPlace= " + place + "\nTicket Price= " + ticketPrice;
    }
    
}
