import java.util.Scanner;

public class CourseMain {

	public static void main(String[] args) {
		
		// declaration of variables
		StringBuffer stringBuffer;
		int weeklyPriceIndex;
		String input; // course user input
		String[] splitInput; // course user input parts split by * from input variable
		
		// the * character for splitting the input that the user enters
		String delimiter = "\\*";
		
		// constant number of courses that the user will enter
		final int COURSES_LENGTH = 3;
		
		// initialization of scanner reference variable of type Scanner for getting user input
		Scanner scanner = new Scanner(System.in);
				
		// initialization of the courses array of COURSES_LENGTH (3) elements
		Course[] courses = new Course[COURSES_LENGTH];
				
		// loop for getting user input of each course
		for (int i = 0; i < COURSES_LENGTH; i++) {
			
			// getting course input separated with '*' from the user
			System.out.println("\nEnter " + (i + 1) + ". string:");
			input = scanner.nextLine(); // for example, Elementary*12*150
			
			// splitting input variable by * delimiter to store each split part in the elements of splitInput array 
			splitInput = input.split(delimiter); 
			
			// using StringBuffer object to insert " Level" at the end of the first splitInput element
			stringBuffer = new StringBuffer(splitInput[0]);
			stringBuffer.insert(splitInput[0].length(), " Level");
			splitInput[0] = stringBuffer.toString(); // splitInput[0] = new String(stringBuffer); can alternatively be written
			
			// assigning the courses array's element at index i
			courses[i] = new Course(splitInput[0], Integer.parseInt(splitInput[1]), Double.parseDouble(splitInput[2]));
		}
		
		// loop for displaying information of courses
		for (int i = 0; i < courses.length; i++) {
			
			// displaying the course element at index i by using toString method of the Course class
			System.out.println(courses[i]);
			
			// getting weekly price index from the result of the course element's toString method 
			// Way 1:
			/*
			weeklyPriceIndex = courses[i].toString().indexOf(String.valueOf(courses[i].getWeeklyPrice()));
			*/
			// Way 2:
			// We converted the double result of getWeeklyPrice method to string by 
			// concatenating with a string of no characters.
			weeklyPriceIndex = courses[i].toString().indexOf("" + courses[i].getWeeklyPrice());
			
			// displaying the weekly price index and monthly pay
			if (weeklyPriceIndex == -1) { // -1 means indexOf method couldn't find the string specified as parameter
				System.out.println("No price Info!..");
			} else {
				System.out.println("Price's position is at " + weeklyPriceIndex);
				System.out.println("Monthly pay is " + courses[i].getWeeklyPrice() * 4 + " TL");
			}
		}

	}

}
