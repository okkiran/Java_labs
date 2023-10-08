import java.util.Scanner;

public class DriverLicense extends License {

	// data members
	private String type;
    private double testScore;

    // no-arg constructor
    public DriverLicense() {
        super();
    }

    // getters
    public String getType() {
        return type;
    }

    public double getTestScore() {
        return testScore;
    }
    
    // member methods
    public void getInput() {
        Scanner sc = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter license type(A/B/D): ");
        type = sc.nextLine();
        System.out.print("Enter test score: ");
        testScore = sc.nextInt();
    }

    @Override
    public String toString() {
        return "\nDriver License"
                + super.toString()
                + "\nType= " + type
                + "\nTest Score= " + testScore;
    }
    
}
