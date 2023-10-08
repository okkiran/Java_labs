import java.util.Scanner;

public class GymMemberMain {

	// data members
	private static final int MAX_SIZE = 4; // 4 constant value assignment
	private static GymMember[] gymM = new GymMember[MAX_SIZE]; // initialization of the array of 4 elements
	private static int count; // array index
	
	// member methods
	public static void addGymMember() { // adding gym members to the array
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// variable declarations and initial value assignments
		boolean status = true;
		String input = ""; // user input

		do {
			if (count < MAX_SIZE) { // if array's current index is less than array size
				
				// setting the object element at the count. index of the array by getting input from the user 
				System.out.println((count + 1) + ". Member:");
				gymM[count] = new GymMember();
				gymM[count].getInput();

				// displaying result by reaching the element at count. index of the array
				System.out.println(gymM[count].getName() + " is added to the array");
				
				count++; // incrementing array index for the next element and loop's condition
				
				// update user input assignment for the loop's condition
				System.out.print("\nDo you want to continue (Y/N)? ");
				input = scanner.next();
				
				if (input.equalsIgnoreCase("n")) { // if user enters no, update status to false to terminate the loop
					status = false;
				}
			} else { // if array's current index is greater than or equal to array size, update status to false to terminate the loop
				System.out.println("\nError: Max size is reached! Cannot add any more Member");
				status = false;
			}
		} while (status); // while (status == true); can also be written but not preferred
		
	}
	
	public static void display() { // for writing gym members to the console
		
		String output = ""; // initial assignment of the output variable for string concatenation in the loop
		
		for (int i = 0; i < count; i++) {
			output += gymM[i].toString() + "\n";
		}
		
		System.out.print(output);
		
	}
	
	public static void calculateFee() { // calculation of each gym member's fee according to the weight and ideal weight
		
		double fee;
		
		for (int i = 0; i < count; i++) {
			
			fee = 1500; // setting each gym member's initial fee to 1500
			
			if (gymM[i].getWeight() - gymM[i].getIdealWeight() > 50) {
				fee += 2200; // add 2200 to the initial fee
			} else if (gymM[i].getWeight() < gymM[i].getIdealWeight()) {
				fee += 1700; // add 1700 to the initial fee
			}
			
			gymM[i].setFee(fee); // update gym member object element's fee at the i. index of the array
			
		}
		
	}
	
	public static GymMember searchGymMember(int id) { // searching gym member by id parameter
		
		GymMember foundGymMember = null; // for beginning we assume that gym member is not found
		
		// Way 1: using flag
		/*
		boolean found = false; // found: flag, for beginning we assume that gym member is not found
		
		// iterate the loop as long as array size is not reached and gym member is not found
		for (int i = 0; i < count && !found; i++) {
			if (id == gymM[i].getId()) { // if id parameter equals to the gym member's id, gym member is found
				foundGymMember = gymM[i]; // assign found element object of the array to the foundGymMember reference variable
				found = true; // update found flag to true to terminate the loop since we don't need to iterate through other array elements
			}
		}
		*/
		
		// Way 2: using break
		for (int i = 0; i < count; i++) {
			if (id == gymM[i].getId()) { // if id parameter equals to the gym member's id, gym member is found
				foundGymMember = gymM[i]; // assign found element object of the array to the foundGymMember reference variable
				break; // terminate the loop since we don't need to iterate through other array elements
			}
		}
		
		return foundGymMember;
		
	}
	
	public static void main(String[] args) {
		
		// for getting user input
		Scanner scanner = new Scanner(System.in);
		
		// adding gym members by getting inputs from the user
		addGymMember();

		// displaying gym members
        System.out.println("-----------------");
        System.out.println("Here is a list of the Gym Members: ");
        display();

        // updating gym member fees and displaying gym members
        System.out.println("\n------------------");
        System.out.println("Fee of all Gym Members: ");
        calculateFee();
        display();
        
        // searching gym member by id
        System.out.println("\n------------------");
        System.out.print("Which member would you like to search? Enter his/her id: ");
        GymMember gymMember = searchGymMember(scanner.nextInt());

        // displaying search result
        if (gymMember != null) { // gym member object found
            System.out.println("Here is the member you were looking for...\n" + gymMember.toString());
        } else { // gym member object not found
            System.out.println("There is no such member in the array");
        }
        
	}

}
