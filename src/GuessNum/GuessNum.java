package GuessNum;
import java.util.Scanner;
import GuessNum.InvalidInputException;


public class GuessNum {

	public static String ans = "";
	public static String userGuess = "";
	private static String[] arg;

	public static void main(String args []){
		// for reuse main
		arg = args;
		
		//set the random number
		ans = String.format("%04d", (int)(Math.random()*10000));
		
		//make sure no repeat number in the ans
		for(int i = 0 ; i < ans.length();i++) {
			for( int j = i+1 ; j < ans.length(); j++) {
				if (ans.charAt(i) == ans.charAt(j)) {
					
					main(args);
				}
			}
		} 
		input();
	}

	public static void input() {
		// user input
		System.out.print("Please type in 4 digit number: ");
		Scanner userInput = new Scanner(System.in);
		userGuess = userInput.next();


		// make sure user input length
		if(userGuess.length()!=4){
			System.out.println("invalid input");
			input();
		}
		//make sure no user input has repeat number
		for(int i = 0 ; i < userGuess.length();i++) {
			for( int j = i+1 ; j < userGuess.length(); j++) {
				if (userGuess.charAt(i)== userGuess.charAt(j)) {
					System.out.println("No Repeated digit");
					input();
				}
			}
		}

		clue();
	}
	
	
	public static void clue(){
		//generate the clue
		int a = 0;
		int b = 0;
		for(int i = 0 ; i<4; i++){
			if(ans.charAt(i)== userGuess.charAt(i)){
				a++;
			}
			for(int j = 0; j<4;j++) {
				if(ans.charAt(i) != userGuess.charAt(i) && userGuess.charAt(i) == ans.charAt(j)) {
					b++;
					break;
				}
			}

		}

		System.out.println(a+"A"+b+"B");
		
		//if right ans, say congrats and start a new game
		if(a == ans.length()) {
			System.out.println("Congrats!! you got the right answer");
			main(arg);
		}

	}


}

