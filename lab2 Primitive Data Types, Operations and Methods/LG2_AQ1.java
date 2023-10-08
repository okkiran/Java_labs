import java.util.Scanner;

public class LG2_AQ1 {

	public static void main(String[] args) {
		
		// declaration of variables
		int day, i;
		
		// initialization of the variable
		Scanner scanner = new Scanner(System.in);
		
		// getting first day of the year user inputs for the years 2018 - 2021 and displaying the calendar
		for (i = 2018; i <= 2021; i++) {
			System.out.print("Enter first day of year " + i + ": ");
			day = scanner.nextInt();
			drawCalendar(i, day);
			System.out.println("\n");
		}
		
	}
	
	// the method that draws the January month of the calendar by year and the first day of that year parameters
	public static void drawCalendar(int year, int firstDay) {
		
		// declarations and initial assignments of variables
		// day number
		int dayNo = 1;
		
		// counter that will increment by 1 in each loop iteration
		int counter = 0;
		
		// space character between day numbers
		char space = ' ';
		
		// displaying the title by year
		System.out.println("\nCALENDAR OF JANUARY " + year);
		
		// displaying the days
		System.out.println("\nSUN MON TUE WED THU FRI SAT");
		
		// displaying the separator
		System.out.println("---------------------------");
		
		// displaying the day numbers of the calendar
		
		// display the leading spaces according to the first day parameter
		for (int i = 1; i < firstDay; i++) {
			System.out.printf("%4c", space); // for each iteration add 4 spaces
			counter++; // increment the counter for empty days
		}
				
		while (dayNo <= 31) { // the loop will continue until day number is greater than 31
			if (dayNo <= 9) { // if day number has one digit
				System.out.printf("%2c", space); // add 2 spaces
			} else { // if day number has two digits
				System.out.printf("%1c", space); // add 1 space
			}
						
			System.out.print(dayNo); // display the day number 
			System.out.printf("%1c", space); // add one space
						
			dayNo++; // increment the day number for other days of the calendar
			counter++; // increment the counter for decision of the new line
			if (counter % 7 == 0) { // if counter modulus 7 equals to 0
				System.out.println(); // display new line
			}
		}
				
	}

}
