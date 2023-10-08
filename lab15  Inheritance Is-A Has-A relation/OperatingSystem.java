import java.util.Scanner;

public class OperatingSystem {

	// data members
	private String name;
    private String version;

    // no-arg constructor
    public OperatingSystem() {
    }

    // member methods
    public void getInput(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Operating System name: ");
        name=sc.nextLine();
        System.out.print("Enter version: ");
        version=sc.nextLine();
    }
    
    @Override
    public String toString() {
        return "\n\tOperating System\n"
                + "\tName= " + name
                + "\n\tVersion = " + version;
    }
    
}
