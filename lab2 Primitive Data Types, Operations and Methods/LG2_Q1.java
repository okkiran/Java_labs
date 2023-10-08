import java.util.Scanner;

public class LG2_Q1 {

	public static void main(String[] args) {
		
		// declaration of variables
		int courseHours; // total hours of the course (input)
		int absentHours; // total hours which the student is absent (input)
		
		int mustAttendHours; // total hours the student must attend
		int attendedHours; // total hours that the student attended
		
		// initial assignments of variables
		final double MUSTATTEND = 0.70; // constant
		Scanner scanner = new Scanner(System.in);
		
		// getting inputs from the user
		System.out.print("Please enter the total number of course hours : ");
		courseHours = scanner.nextInt();
		
		System.out.print("Please enter the hours the student is absent : ");
		absentHours = scanner.nextInt();
		
		// attended hour operations
		attendedHours = courseHours - absentHours;
		mustAttendHours = (int)(courseHours * MUSTATTEND);
		
		// if student's attendance hours is smaller than the total attendance hours of the course
		if (attendedHours < mustAttendHours) {
			// displaying a message that student failed because of attendance
			System.out.println("\nStudent failed the course!"); 
		} else {
			// showing available hours to student that she/he can still attend
			System.out.println("\nStudent has " + (attendedHours - mustAttendHours) + " more hours."); 
		}
	}

}
