import java.util.Scanner;

public class FestivalMain {

	public static void main(String[] args) {

		String output, festType, festName;
		Scanner sc = new Scanner(System.in);

		// adding festivals
		FestivalSys.addFestival();
		System.out.println("\nAll festivals are added!\n");
		
		// searching a festival by type
		System.out.print("Enter Festival Type to search: ");
		festType = sc.nextLine();
		output = FestivalSys.getSelectedFestival(festType);
		System.out.println(output);
		
		// deleting a festival by name
		System.out.print("\nEnter Festival Name to delete: ");
		festName = sc.nextLine();
		FestivalSys.removeFestival(festName);

		// displaying all festivals
		System.out.println("\nContent of ArrayList");
		output = FestivalSys.getAllFestival();
		System.out.println(output);

	}

}
