import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		System.out.println("Hello!\nWelcome to Tic Tac Toe (^_^)");
		//Add scanner so that the user can use the input function
		Scanner sc = new Scanner(System.in);
		
		String gamer	= "O";
		String computer = "X";
		
		//Game instructions
		System.out.println("\nGame instructions\nEvery field has a number. Choose the desired filed by typing in the correct number.");
		System.out.println("[1][2][3]\n[4][5][6]\n[7][8][9]");
		System.out.println("You are playing against the Computer [X]\nYour symbol will be [O]");
		
		System.out.println("\nPress [s] to strat the game!");
		boolean start = sc.hasNext();
		
		if(start)
		{
			System.out.println("");
			//Gamefield creation
			String [] gamefield = new String[9];
			
			for(int i = 0; i< gamefield.length;i++) 
			{
				
				boolean pcInput = true;
				while(pcInput)
				{
					double random = Math.random()*gamefield.length;
					int field = (int) random;
					
					if(gamefield[field]==null)
					{
						gamefield[field]= computer;
						pcInput = false;
					}
					
				}
				int counter = 1;
				for( int j = 0; j < gamefield.length; j++)
				{
					System.out.print("["+ gamefield [j] + "]");
					if(counter%3==0)
					{
						System.out.println();	
					}
					counter++;
				}
				System.out.println();
			}
		}
	
	}

}
