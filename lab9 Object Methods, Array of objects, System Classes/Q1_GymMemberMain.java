import java.util.Scanner;

public class GymMemberMain {

	public static void main(String[] args) {
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// adding gym members by getting inputs from the user
		GymMemberSys.addGymMember();

		// displaying gym members
        System.out.println("-----------------");
        System.out.println("Here is a list of the Gym Members: ");
        GymMemberSys.display();

        // updating gym member fees and displaying gym members
        System.out.println("\n------------------");
        System.out.println("Fee of all Gym Members: ");
        GymMemberSys.calculateFee();
        GymMemberSys.display();
        
        // searching gym member by id
        System.out.println("\n------------------");
        System.out.print("Which member would you like to search? Enter his/her id: ");
        GymMember gymMember = GymMemberSys.searchGymMember(scanner.nextInt());

        // displaying search result
        if (gymMember != null) { // gym member object found
            System.out.println("Here is the member you were looking for...\n" + gymMember.toString());
        } else { // gym member object not found
            System.out.println("There is no such member in the array");
        }

	}

}
