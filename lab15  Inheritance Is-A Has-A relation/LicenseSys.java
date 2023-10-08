import java.util.ArrayList;
import java.util.Scanner;

public class LicenseSys {

	// data member
	private static ArrayList<License> arr = new ArrayList<License>();

	// member methods
    public static boolean isLicenseExists(int id) {
        License license;
        boolean found = false;
    	for (int i = 0; i < arr.size(); i++) {
            license = arr.get(i);
            if (license.checkId(id)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void addLicense() {
    	Scanner sc = new Scanner(System.in);
        String userOpp = "";
        DriverLicense dl;
        SoftwareLicense sl;
        int id;
        do {
            System.out.print("\nWhich type of License do you want to take (Driver/Software/Stop)? ");
            userOpp = sc.next();
            if (userOpp.equalsIgnoreCase("stop")) {
                System.out.println("Stopped!!");
            } else {
                System.out.print("Enter the id: ");
                id = sc.nextInt();
            	if (!isLicenseExists(id)) {
                    if (userOpp.equalsIgnoreCase("driver")) {
                        dl = new DriverLicense();
                        dl.getInput();
                        dl.setId(id);
                        arr.add(dl);
                    } else {
                        sl = new SoftwareLicense();
                        sl.getInput();
                        sl.setId(id);
                        arr.add(sl);
                    }
        		} else {
                    System.out.println("License Id already existing!!");
                }
            }
        } while (!userOpp.equalsIgnoreCase("stop"));
    }

    public static License searchLicense(int id) {
    	License license = null;
    	for (License l : arr) {
    		if (l.checkId(id)) {
    			license = l;
    			break;
    		}
    	}
    	return license;
    }
    
    public static boolean removeLicense(int id) {
    	License license = searchLicense(id);
    	if (license != null) {
    		arr.remove(license);
    		return true;
    	}
    	return false;
    }

    public static String display() {
        License temp;
        String out = "";
        
        // Way 1:
        /*
        for (int i = 0; i < arr.size(); i++) {
    		temp = (License)arr.get(i); // casting the object of the array list of type License
            out += temp.toString() + "\n\n";
        }
        */
        
        // Way 2:
        for (License l : arr) {
            out += l.toString() + "\n\n";
        }

        return out;
    }

    public static void calculateFee() {
        double fee = 0;
        for (License l : arr) {
            if (l instanceof DriverLicense) { // if l is of type DriverLicense
            	if (((DriverLicense)l).getType().equalsIgnoreCase("a")) { // casting l to DriverLicense
                    fee = 200;
                } else if (((DriverLicense)l).getType().equalsIgnoreCase("b")) { 
                    fee = 300;
                } else if (((DriverLicense)l).getType().equalsIgnoreCase("d")) { 
                    fee = 500;
                }
        		if (((DriverLicense)l).getTestScore() > 60) {
                    fee *= 0.93;
                }
            } else { // if l is of type SoftwareLicense
                if (((SoftwareLicense)l).getVersion().equalsIgnoreCase("v1")) { // casting l to SoftwareLicense
                    fee = 200;
                } else if (((SoftwareLicense)l).getVersion().equalsIgnoreCase("v2")){
                    fee = 300;
                }
            }
            l.setFee(fee);
        }
    }
    
}
