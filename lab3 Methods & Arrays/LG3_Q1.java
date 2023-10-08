import java.util.Scanner;

public class LG3_Q1 {

	public static void main(String[] args) {
		
		// variable declarations and initial assignments
		String user; // user input (p: paper, r: rock and s: scissor)
		String machine; // the character that will be randomly produced
		String message; // the message that will be set according to win, lose or tie conditions
		int score = 0; // the score that will be calculated for each game turn
		Scanner scanner = new Scanner(System.in);
		
		// displaying choices
		System.out.print("Choose (p)aper, (r)ock, (s)cissor or (q)uit: ");
		
		// after getting input from the user, we assign the input variable by lowering the case 
		user = scanner.next().toLowerCase();
		
		while (!user.equals("q")) { // as long as the user input is not quit
			machine = machineChoice(); // calling the method to get the random character
			
			// determining win, lose or tie conditions
			message = "It's a tie!"; // initial assignment of tie message for each loop iteration
			if (user.equals("p")) { // if user input is paper
				if (machine.equals("r")) { // if computer generates rock
					message = "The machine chooses rock. Paper covers rock. You win!";
					score++; // incrementing score by 1 for winning
				} else if (machine.equals("s")) { // if computer generates scissor
					message = "The machine chooses scissor. Scissor cuts paper. You lose!";
					score--; // decrementing score by 1 for losing
				}
			} else if (user.equals("r")) { // if user input is rock
				if (machine.equals("p")) { // if computer generates paper
					message = "The machine chooses paper. Paper covers rock. You lose!";
					score--; // decrementing score by 1 for losing
				} else if (machine.equals("s")) { // if computer generates scissor
					message = "The machine chooses scissor. Rock breaks scissor. You win!";
					score++; // incrementing score by 1 for winning
				}
			} else if (user.equals("s")) { // if user input is scissor
				if (machine.equals("p")) { // if computer generates paper
					message = "The machine chooses paper. Scissor cuts paper. You win!";
					score++; // incrementing score by 1 for winning
				} else if (machine.equals("r")) { // if computer generates rock
					message = "The machine chooses rock. Rock breaks scissor. You lose!";
					score--; // decrementing score by 1 for losing
				}
			} else { // if user input is other than p, r, s or q
				message = "Invalid input!";
			}
			
			// displaying the game turn result and score to the user
			System.out.println(message + " Your score: " + score);
			
			// getting the while condition's update input from the user
			System.out.print("\nChoose (p)aper, (r)ock, (s)cissor or (q)uit: ");
			user = scanner.next().toLowerCase();
		}
	}
	
	// method that randomly generates a number between 1 and 3, returns a string according to this number  
	public static String machineChoice() {
		
		// string array that contains 3 elements (p: paper, r: rock and s: scissor)
		String[] characters = new String[]
		{
			"p",
			"r",
			"s"
		};
		
		// generating a random number between 1 and 3
		int randomNumber = (int)(Math.random() * 3 + 1);
		
		// by subtracting 1 from the random number, we use it as index for the characters array and 
		// return the element at this index
		return characters[randomNumber - 1];
		
		/* 
		ALTERNATIVE SOLUTION:
		String character;
		switch (randomNumber) {
			case 1: character = "p";
				break;
			case 2: character = "r";
				break;
			default: character = "s";
				break;
		}
		return character;
		*/
		
	}

}
