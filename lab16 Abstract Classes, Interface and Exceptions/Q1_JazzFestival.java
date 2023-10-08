import java.util.Scanner;

public class JazzFestival extends Festival implements FestivalInterface {

	// data member
	public String musician;
	
	// no-arg constructor
	public JazzFestival() {
    }
	
	// member method implementations from Festival
	@Override
	public void getInput()
    {
        Scanner sc = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter Musician: ");
        musician = sc.nextLine();
    }
	
	@Override
    public String toString() {
        return "\nJazz Festival " + super.toString() + "\nMusician= " + musician;
    }
	
	@Override
	public double getSale() {
		if (musician.equalsIgnoreCase("Wynton Marsalis"))
            return 50;
        return 25;
	}
	
	// member method implementation from FestivalInterface
	@Override
	public void addVat() {
		ticketPrice += ticketPrice * 0.25;
	}

}
