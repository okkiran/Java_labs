import java.util.Scanner;

public class LG2_Q3 {

	public static void main(String[] args) {
		
		// declaration of variables
		int randomNumber; // random number that will be generated 
		int userNumber; // number that the user enters as input
		String playOrExit; // input that the user enters for playing or exiting the game

		// initial assignment of variables
		Scanner scanner = new Scanner(System.in); // for user input
		
		// displaying menu options
		System.out.println("P. Play the number guessing game");
		System.out.println("E. Exit game");
		
		// setting playOrExit variable according to the user input
		playOrExit = scanner.next();
		
		System.out.println(); // move to the next line
		
		if (playOrExit.equalsIgnoreCase("p") || playOrExit.equalsIgnoreCase("e")) { // user chose to play or exit
			
			if (playOrExit.equalsIgnoreCase("e")) { // user chose to exit
				System.out.println("Exit successful.");	 // showing exit message
			} else { // user chose to play
				
				randomNumber = (int)(Math.random() * 10 + 1); // setting random number between 1 and 10
				
				System.out.println(randomNumber); // We can see and test the game for the random number. If no errors, we should comment this line.
				
				// setting user input number to userNumber variable
				System.out.print("Please guess a number between 1 and 10 : ");
				userNumber = scanner.nextInt();
				
				System.out.println(); // move to the next line
				
				if (randomNumber == userNumber) { // if random generated number is equal to user input number
					
					// displaying the user guessed correctly message
					System.out.println("Congratulations, you have guessed number " + randomNumber + " correctly.");
				
				} else { // the random number is different than the user input number
					
					// displaying the user guessed wrong message
					System.out.println("You couldn't guess correctly, the number is " + randomNumber + "\nSee you again next time.");
				
				}
				
			}
		} else { // user enters an incorrect input
			System.out.println("Incorrect input!"); // displaying wrong input message
		}
	
	
	
		// ALTERNATIVE SOLUTION (Comment the code above and uncomment the code below to run):
		/*
		int randomNumber; 
		int userNumber; 
		String playOrExit; 

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("P. Play the number guessing game");
		System.out.println("E. Exit game");
		
		playOrExit = scanner.next();
		
		System.out.println();
		
		switch (playOrExit) {
			case "E":
			case "e":
				System.out.println("Exit successful.");	
				break;
			case "P":
			case "p":
				randomNumber = (int)(Math.random() * 10 + 1); 
					
				System.out.println(randomNumber); 
					
				System.out.print("Please guess a number between 1 and 10 : ");
				userNumber = scanner.nextInt();
					
				System.out.println();
					
				if (randomNumber == userNumber)
					System.out.println("Congratulations, you have guessed number " + randomNumber + " correctly.");
				else 
					System.out.println("You couldn't guess correctly, the number is " + randomNumber + "\nSee you again next time.");
				break;
			default:
				System.out.println("Incorrect input!");
				break;
		}
		*/
		
	
		
	}

}
