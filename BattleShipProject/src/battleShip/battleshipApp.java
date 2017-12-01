//Things to do

//Create an computer player. 
	//It needs to be able to auto place ships. (This might be very hard. if it is we can just do a few preset ship locations)
	//We need it to randomly pick locations on the players grid to attack. 
			//(two random numbers picking locations. Wraped in a checker to make sure it hasn't hit that spot previously

//Create new class with ships and there define Length (Distroyer = 4 Units)
		//if this doesnt work We can add a new calss that will be single player move all single player data into that.
//Add code to show hits and misses between the two players. 

//Finish the game menu system.
	//Single Player UI. 
	//Add Messages to the user when playing for example "A4 is a Hit"




package battleShip;
 
import java.util.Scanner;

public class battleshipApp {

	public static void main(String[] args) {
		SinglePlayer s1 = new SinglePlayer();
	    Scanner input = new Scanner (System.in);
	    int selection;
	    do {
	    	menuPrompt();
	    	selection = input.nextInt();
	    	
	    	switch(selection) {
	    	case 1: battleShip.SinglePlayer.SinglePlayerMain();
	    	
	    		break;
	    	case 2: multiPlayer();
	    		break;
	    	case 0: System.out.println("Good Bye");
	    		break;
	    	default: System.out.println("You Entered a wrong value");
	    	}
	    }
	    while(selection !=0);
  	}	
	private static void menuPrompt()
	{
		System.out.println("Welcome to Battleship!!!");
		System.out.println();
		System.out.println("Press 1 for Single Player");
		System.out.println("Press 2 for Muliplayer (Comming Soon!!)");
		System.out.println("Press 0 to Exit");
		System.out.print("Your choice: ");
	}
<<<<<<< HEAD
	
=======
	private static void SinglePlayer()
	{
		SinglePlayer s1 = new SinglePlayer();
		String[][] board = new String[8][8];
	      int torps = 15;
	      int hits = 0;
		s1.createBoard(board);
		//This creates an Instance of the BattleShip game, Contains all of the data on where ships are for both players
		BattleShip p1 = new BattleShip();

		//There needs to be a Computer player Method added. 
		//There needs to be instructions added to the user knows what to do. 
		//There also needs to be inputs for the user to setup the game and play it.
		
		

		int row;
		int colm;
		boolean isVertical;
		//This is the first round of adding a ship. This needs to be looped or something as we have duplicate code.
		p1.SetupDisplay();//This just displayes the players board.
		isVertical= orientation();

		//This askes the user what Row do you what the ship to be in
		System.out.print("What Row do you want your Ship to be in?:");
		//This captures the users answer, and translates the Human entered number into the correct number (See transLateGrid Method)
		row = translateGrid(input.nextInt());
		
		System.out.println();
		//This is here to fix Java issues with input.nextLine
		input.nextLine();
		//This askeds the user what Column they want there ship to be in. 
		System.out.println("What column do you want your Ship to be in?:");
		//The captures the users answer and translates the Human entered Letter in the a number that the computer can understand. (See transLateGrid Method)
		colm = translateGrid(input.nextLine());

		if (!p1.addShipP1(row, colm, isVertical, 2)) {//Testing adding ships We need to get it so it is all user input. For example 1 ,2 would need to be 2C. To start the ship and True is saying it IS vertical
			System.out.print("Bad location");//It addShipP1 returns false it will display "Bad Location" In need to make this a loop. So it asks the user again for a correct location.  
		}
		//This is the second round of adding a ship This needs to be looped or something as we have duplicate code.
		p1.SetupDisplay();//This just displayes the players board.
		isVertical= orientation();
		System.out.print("What Row do you want your Ship to be in?:");
		row = translateGrid(input.nextInt());
		System.out.println();
		input.nextLine();
		System.out.println("What column do you want your Ship to be in?:");
		colm = translateGrid(input.nextLine());

		if (!p1.addShipP1(row, colm, isVertical, 3)) {//Testing adding ships We need to get it so it is all user input. For example 1 ,2 would need to be 2C. To start the ship and True is saying it IS vertical
			System.out.print("Bad location");//It addShipP1 returns false it will display "Bad Location" In need to make this a loop. So it asks the user again for a correct location.  
		}

		p1.SetupDisplay();//This just displayes the players board.
		
//		p1.player1Display();//This prints player1 and player1's view of players2's board.

	}
>>>>>>> branch 'master' of https://github.com/Catsrules/BattleShipProject.git
	private static void multiPlayer()
	{
	   System.out.print("Comming Soon");
	}

	
}
