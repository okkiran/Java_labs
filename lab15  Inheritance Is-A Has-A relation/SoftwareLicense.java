import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareLicense extends License {

	// data members
	private String version;
    private int validityDuration;
    private ArrayList<OperatingSystem> validOpSys = new ArrayList<OperatingSystem>();

    // no-arg constructor
    public SoftwareLicense() {
        super();
    }

    // getters
    public String getVersion() {
        return version;
    }

    public int getValidityDuration() {
        return validityDuration;
    }

    // member methods
    public void getInput() {
        Scanner sc = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter version(V1/V2): ");
        version = sc.nextLine();
        System.out.print("Enter validity duration: ");
        validityDuration = sc.nextInt();
        System.out.print("How many operating system will you add: ");
        int size = sc.nextInt();
        OperatingSystem op;
        for (int i = 0; i < size; i++) {
            op = new OperatingSystem();
            op.getInput();
            validOpSys.add(op);
        }
    }

    @Override
    public String toString() {
        String opStr = "";
        for (OperatingSystem o : validOpSys) {
            opStr += o.toString() + "\n";
        }
        return "\nSoftware License" + super.toString()
                + "\nVersion= " + version
                + "\nValidity Duration= " + validityDuration
                + "\n\n\tValid Operating Systems:\n" + opStr;
    }
    
}
