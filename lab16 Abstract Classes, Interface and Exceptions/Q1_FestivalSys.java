import java.util.ArrayList;
import java.util.Scanner;

public class FestivalSys {
	
	// data member
	private static ArrayList<Festival> festList = new ArrayList<Festival>();
	
	// member methods
	public static void addFestival() {
		JazzFestival jazz;
		OliveFestival olive;
		
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many festival do you want to join: ");
        int number = sc.nextInt();
        
        for (int i = 1; i <= number; i++) {
            System.out.print("\nEnter type of festival: ");
            String type = sc.next();
            
            if(type.equalsIgnoreCase("jazz")) {
                jazz = new JazzFestival();
                jazz.getInput();
                jazz.addVat();
                festList.add(jazz);
            }
            else {
                olive = new OliveFestival();
                olive.getInput();
                olive.addVat();
                festList.add(olive);
            }
        }   
    }

    public static boolean removeFestival(String name) {
    	boolean removed = false;
        for (int i = 0; i < festList.size(); i++) {
            if (festList.get(i).getName().equalsIgnoreCase(name)) {
                festList.remove(i);
                removed = true;
                break;
            }
        }
        return removed;
    }
    
    public static String getAllFestival() {
        String result = "";
        for (Festival festival : festList) {
            result += festival.toString();
        }
        return result;
    }

    public static String getSelectedFestival(String type) {
        String result = "";

        switch (type.toLowerCase()) {
            case "jazz":
                for (Festival festival : festList) {
                    if (festival instanceof JazzFestival) {
                        result += "Sale:" + festival.getSale();
                        result += festival.toString();
                    }
                }
                break;
            case "olive":
                for (Festival festival : festList) {
                    if (festival instanceof OliveFestival) {
                        result += "Sale:" + festival.getSale();
                        result += festival.toString();
                    }
                }
                break;
        }
        return result;
    }
    
}
