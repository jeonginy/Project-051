package prj051;

import java.util.Scanner;
class DiceGame{
	int diceFace;
	int userGuess;
	
	
	private void RollDice() {
		diceFace = (int)(Math.random() * 6) + 1;	
	}
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	private void checkUsersGuess() {
		if( diceFace == userGuess )
			System.out.println( "You are correct" );
		else
			System.out.println( "It's not correct " );
		}
	public void startPlaying() {
		userGuess = getUserInput( "Enter expected value : ");
		RollDice();
		checkUsersGuess();
	}
	
}

public class DiceGameTest {
	public static void main(String [] args) {
		
		DiceGame game = new DiceGame();
		game.startPlaying();
		
	}
	
}








