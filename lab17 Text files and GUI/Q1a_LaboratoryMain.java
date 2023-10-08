import java.util.Scanner;

public class LaboratoryMain {

	public static void main(String[] args) {
		
		String input, labName, labMaintainer;
        int size, renewYear;
        Scanner scanner = new Scanner(System.in);
        Laboratory lab;
        boolean result;
        
        // reading the content of the text file
        LaboratorySys.readTxt("labs.txt");
        
        // displaying the content of the text file
        System.out.println("Display the content of the text file");
        System.out.println(LaboratorySys.display());

        // adding new laboratories
        System.out.print("Do you want to add Laboratory(Y/N): ");
        input = scanner.nextLine();
        while (input.equalsIgnoreCase("y")) {
            System.out.print("Enter the name of the lab: ");
            labName = scanner.nextLine();
            
            // Way 1:
            /*
            System.out.print("Enter the size of the lab: ");
            size = scanner.nextInt();
            System.out.print("Enter the renew year: ");
            renewYear = scanner.nextInt();
            scanner.skip("\\R");
            */
            
            // Way 2:
            System.out.print("Enter the size of the lab: ");
            size = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the renew year: ");
            renewYear = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter the Laboratory maintainer: ");
            labMaintainer = scanner.nextLine();
            lab = new Laboratory(labName, size, renewYear, labMaintainer);
            result = LaboratorySys.addLaboratory(lab);
            if (result) {
                System.out.println("The laboratory added to the system");
            } else {
                System.out.println("The laboratory already exists in the system");
            }
            System.out.print("\nDo you want to add Laboratory(Y/N): ");
            input = scanner.nextLine();
        }

        // displaying the laboratory names
        System.out.println("\nDisplay only Laboratory names: ");
        System.out.println(LaboratorySys.getLabNames());

        // searching a laboratory
        System.out.println("Search Laboratory:");
        System.out.print("Enter a Laboratory name to search: ");
        labName = scanner.nextLine();

        lab = LaboratorySys.searchLaboratory(labName);
        if (lab == null) {
            System.out.println("There is no such laboratory in the system");
        } else {
            System.out.println(lab);
        }

	}

}
