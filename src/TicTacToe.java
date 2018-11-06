import java.util.Scanner;

public class TicTacToe {
	
	
	
	public static void main(String[] args) {

		System.out.println("Hello!\nWelcome to Tic Tac Toe (^_^)");
		// Add scanner so that the user can use the input function
		Scanner sc = new Scanner(System.in);

		// Game figure
		String gamer = "O";
		String computer = "X";
			
		// Game instructions
		System.out.println("\nGame instructions:\nEvery field has a number. Choose the desired filed by typing in the correct number.");
		System.out.println("[1][2][3]\n[4][5][6]\n[7][8][9]");
		System.out.println("You are playing against the Computer [X]\nYour symbol will be [O]");
		System.out.println("\nPress [s] then [Enter] to start the game!");
			

		// The game does not start until the Gamer presses any charakter.
		String start = sc.next();
		
		
		// Programm will start if the user press S or S. toLowerCase()converts the user. input into small chars.equals checks a defined String with the user input.
		if (start.toLowerCase().equals("s")) {
			
			// lnbreak between the gamefields
			System.out.println();
		
			
			// Gamefield creation Deklariert
			String[] gamefield = new String[9];			
			
			//starts the game loop with exactly 9 iterations because we only have 9 fields to choose from
			for (int i = 0; i < gamefield.length; i++) {
				
//////////////////////////////////////////////////////Computer///////////////////////////////////////////////	

				while (true) {

					double random = Math.random() * gamefield.length;
					
					//casting a double into integer (forcing an integer to accept a double)
					int field = (int) random;
					
					// If the field is empty, the PC can choose the field if not the PC has to
					// choose another field
					if (gamefield[field] == null) {
						
						gamefield[field] = computer;
						
						//breaks the loop 
						break;
					}
				}
						
				
				// Überprüfung
				System.out.println("Computer: ");
				
				//draws the gamefield with all engtries to the console
				outputGamefield(gamefield);
				
				if(checkWin(gamefield) || checkDraw(gamefield)) {
					//breaks the game loop because a player has won
					break;
				}
////////////////////////////////////////////////////// Computer///////////////////////////////////////////////////////////////////
				
/////////////////////////////////////////////// Gamer ////////////////////////////////////////////////////////////////////////////
				
				while (true) {
					
					System.out.print("Your turn: ");
					//register gamer input
					int chosenField = sc.nextInt();
					//Array index is 0-8, the user has option 1-9 so I have to make -1 evertime to choose correct field for user
					chosenField--;
					
					if (gamefield[chosenField] != null) {
						System.out.println("Please Choose a unmanned field\n");
					}else
					{
						gamefield[chosenField] = gamer;
						break;
					}
				}			
				//Überprüfung					
				//draws the gamefield with all engtries to the console
				outputGamefield(gamefield);
				
				if(checkWin(gamefield) || checkDraw(gamefield)) 
				{
					//breaks the game loop because a player has won
					break;
				}

				// lnbreak between the gamefields
				System.out.println();
///////////////////////////////////////////////Gamer///////////////////////////////////////////////////////////////////////////////
			}
		}
	}

	
	//checks if the game ended in a draw
	public static boolean checkDraw(String[] gamefield) {
	
		
		for (int i = 0; i < gamefield.length; i++) {
			
			if(gamefield[i] == null) {
				return false;				
			}
			
		}
		System.out.println("*** The Game has ended in a Draw ***");
		return true;
	}
	
	//Finds the winning player
	public static void getWinner(String player) 
	{
		if (player.equals("X")) 
		{
			System.out.println("+*The Computer has Won*+");
		}
		else if(player.equals("O")) 
		{
			System.out.println("+* Congratulation You have won *+");
		}
			
	}
	
	// checks the gamefield of a winning situation
	public static boolean checkWin (String[] gamefield) 
	{
		//returns true if a winning situation has been found and the rest of the code will not be executed
		
		if(gamefield[0] != null && gamefield[1] != null && gamefield[2] != null && gamefield[0].equals(gamefield[1]) && gamefield[1].equals(gamefield[2]))
		{
			//executing getWinner method to find out wich winner has won
			getWinner(gamefield[0]);
			return true;
		}
		if(gamefield[3] != null && gamefield[4] != null && gamefield[5] != null && gamefield[3].equals(gamefield[4]) && gamefield[4].equals(gamefield[5])) 
		{
			getWinner(gamefield[3]);
			return true;	
		}
		if(gamefield[6] != null && gamefield[7] != null && gamefield[8] != null && gamefield[6].equals(gamefield[7]) && gamefield[7].equals(gamefield[8]))
		{
			getWinner(gamefield[6]);
			return true;
		}	
		if(gamefield[0] != null && gamefield[3] != null && gamefield[6] != null && gamefield[0].equals(gamefield[3]) && gamefield[3].equals(gamefield[6]))
		{
			getWinner(gamefield[0]);
			return true;
		}	
		if(gamefield[1] != null && gamefield[4] != null && gamefield[7] != null && gamefield[1].equals(gamefield[4]) && gamefield[4].equals(gamefield[7]))
		{
			getWinner(gamefield[1]);
			return true;
		}	
		if(gamefield[2] != null && gamefield[5] != null && gamefield[8] != null && gamefield[2].equals(gamefield[5]) && gamefield[5].equals(gamefield[8]))
		{
			getWinner(gamefield[2]);
			return true;
		}	
		if(gamefield[0] != null && gamefield[4] != null && gamefield[8] != null && gamefield[0].equals(gamefield[4]) && gamefield[4].equals(gamefield[8]))
		{
			getWinner(gamefield[0]);
			return true;
		}	
		if(gamefield[2] != null && gamefield[4] != null && gamefield[6] != null && gamefield[2].equals(gamefield[4]) && gamefield[4].equals(gamefield[6]))
		{
			getWinner(gamefield[2]);
			return true;
		}
		
	
		return false;
	}
	
	//Draws the gamefield with all entries to the console
	public static void outputGamefield(String[] gamefield) {
		
		//needed to draw a beautiful gamefiled
		int counter = 1;
		
		for (int j = 0; j < gamefield.length; j++) {
			//puts out 
			if (gamefield[j] == null) {
				System.out.print("[ ]");
			} else {
				
				System.out.print("[" + gamefield[j] + "]");
			}
			
			//sclices the one dimensional array into three seperate lines on the console
			if (counter % 3 == 0) {
				System.out.println();
			}
			counter++;
		}
	}
}
