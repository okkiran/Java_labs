import java.util.Scanner;

public class LicenseMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        License license;
        int id;

        // adding and listing licenses
        LicenseSys.addLicense();
        System.out.println("\nHere is the list of Licenses:");
        System.out.println(LicenseSys.display());

        // calculating the fees of licenses and displaying them
        System.out.println("Calculate and display the fees of all Licenses:  ");
        LicenseSys.calculateFee();
        System.out.println(LicenseSys.display());

        // searching a license by id
        license = null;
        while (license == null) {
            System.out.print("Enter License id to search: ");
            id = sc.nextInt();
            license = LicenseSys.searchLicense(id);
            if (license != null) {
                System.out.println(license);
            } else {
                System.out.println(id + " not found");
            }
        }

        // deleting a license by id
        System.out.print("\nEnter License id to delete: ");
        id = sc.nextInt();
        if (LicenseSys.removeLicense(id)) {
            System.out.println(id + " is deleted");
            System.out.println("\nAfter deletion");
            System.out.println(LicenseSys.display());
        } else {
            System.out.println(id + " not found");
        }

	}

}
