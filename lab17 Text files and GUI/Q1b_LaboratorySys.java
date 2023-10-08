import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaboratorySys {

	// data member
	private static ArrayList<Laboratory> arr = new ArrayList<Laboratory>();

	// member methods
    public static void readTxt(String fileName) {
    	File file = new File(fileName);
        Scanner scanner;
        String labName, labMaintainer;
        int size, renewYear;
        Laboratory lab;
        
        try {
        	scanner = new Scanner(file);
            while (scanner.hasNext()) {

                labName = scanner.next();
                size = scanner.nextInt();
                renewYear = scanner.nextInt();
                labMaintainer = scanner.nextLine();

                lab = new Laboratory(labName, size, renewYear, labMaintainer);
                arr.add(lab);
            }
        } catch (FileNotFoundException exc) {
            Logger.getLogger(LaboratorySys.class.getName()).log(Level.SEVERE, null, exc);
        }
    }

    public static Laboratory searchLaboratory(String labName) {
    	Laboratory existingLab;
    	Laboratory foundLab = null;
        boolean found = false;
    	for (int i = 0; i < arr.size() && !found; i++) {
    		existingLab = arr.get(i);
            if (existingLab.findLabName(labName)) {
                foundLab = existingLab;
            	found = true;
            }
        }
        return foundLab;
    }
    
    public static boolean addLaboratory(Laboratory lab) {
    	Laboratory existingLab = searchLaboratory(lab.getLabName());
    	if (existingLab != null) {
    		return false;
    	}
    	arr.add(lab);
    	return true;
    }

    public static String display() {
        String output = "";
        for (Laboratory lab : arr) {
            output += lab.toString() + "\n";
        }
        return output;
    }

    public static String[] getLabNames() {
        String[] output = new String[arr.size()];
        for (int i = 0; i < output.length; i++) {
        	output[i] = arr.get(i).getLabName();
        }
        return output;
    }
    
    public static ArrayList<Laboratory> getArr() {
    	return arr;
    }
    
}
