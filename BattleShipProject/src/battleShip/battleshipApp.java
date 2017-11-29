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
//test
	public static void main(String[] args) {
	
	    Scanner input = new Scanner (System.in);
	    int selection;
	    do {
	    	menuPrompt();
	    	selection = input.nextInt();
	    	switch(selection) {
	    	case 1: singlePlayer();
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
	private static void singlePlayer()
	{
		Scanner input = new Scanner (System.in);
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
	private static void multiPlayer()
	{
	   System.out.print("Comming Soon");
	}
	//These two modules translate the user entered coordinates in to Array coordinates 
	//This one translate the row. Rows are in number format already, however the Array starts at 0 and the rows start at 1 
		//so we need to minus 1 off the entered number
	private static int translateGrid (int row2) {
		int row1 = row2 - 1;
		
		return row1;
		
	}
	//This one translates the column. The Column is letters and we need to convert the letters into numbers. 
	private static int translateGrid (String col) {
		int colm1;
		if (col.equalsIgnoreCase("a")) {
			colm1 = 0;
		}
		else if (col.equalsIgnoreCase("b")) {
			colm1 = 1;
		}
		else if (col.equalsIgnoreCase("c")) {
			colm1 = 2;	
		}
		else if (col.equalsIgnoreCase("d")) {
			colm1 = 3;	
		}
		else if (col.equalsIgnoreCase("e")) {
			colm1 = 4;	
		}
		else 
			colm1 = -1000; //-1000 for error
		return colm1;
	}
	//This handles the menu for the orientation and returns the boolean value 
	private static boolean orientation() {
		boolean isVertical = true;
		System.out.println("Do you want your ship Vertical? y/n");
	    Scanner input = new Scanner (System.in);
	    int selection;
	    do {
	    	System.out.println("What orientation do you want your ship?");
			System.out.println("Press 1 for Vertical");
			System.out.println("Press 2 for Horizontal");
			System.out.println("Press 0 for more information");
	    	selection = input.nextInt();
	    	switch(selection) {
	    	case 1: isVertical = true;
	    		break;
	    	case 2: isVertical = false;
	    		break;
	    	case 0: System.out.println("you need to place your ships on the battlefield!!");
	    			System.out.println("To do this, you first need to select an orientation");
	    			System.out.println("Vertical is UP and Down");
	    			System.out.println("Horizontal is right and left");
	    		break;
	    	default: System.out.println("You Entered a wrong value");
	    	}
	    }
	    while((selection != 1) & (selection != 2) );	
		
		return isVertical;
	}
}
