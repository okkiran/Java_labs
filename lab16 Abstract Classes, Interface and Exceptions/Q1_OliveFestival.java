import java.util.Scanner;

public class OliveFestival extends Festival implements FestivalInterface {

	// data member
	private String programCoordinator;
	
	// no-arg constructor
	public OliveFestival() {
    }
	
	// member method implementations from Festival
	@Override
	public double getSale() {
		if (place.equalsIgnoreCase("Edremit"))
            return 12;
        return 7;
	}
	
	@Override
	public void getInput() {
        Scanner sc = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter Program Coordinator: ");
        programCoordinator = sc.next();
    }
	
	@Override
    public String toString() {
        return "\nOliveFestival" + super.toString() + "\nProgramCoordinator= " + programCoordinator;
    }
	
	// member method implementation from FestivalInterface
	@Override
	public void addVat() {
		ticketPrice += ticketPrice * 0.08;
	}

}
