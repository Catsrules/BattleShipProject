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
		//There needs to be instructions added to the user knows what to do. 
		//There also needs to be inputs for the user to setup the game and play it. 
	   Scanner input = new Scanner (System.in);
	   int row;
	   int colm;
	   BattleShip p1 = new BattleShip();
	   System.out.print("What Row do you want your Ship to be in?:");
	   row = translateGrid(input.nextInt());
	   System.out.println();
	   input.nextLine();
	   System.out.println("What column do you want your Ship to be in?:");
	   colm = translateGrid(input.nextLine());
	   
	   if (!p1.addShipP1(row, colm, true, 2)) {//Testing adding ships We need to get it so it is all user input. For example 1 ,2 would need to be 2C. To start the ship and True is saying it IS vertical
		   System.out.print("Bad location");//It addShipP1 returns false it will display "Bad Location" In need to make this a loop. So it asks the user again for a correct location.  
	   }
	   if (!p1.addShipP1(row, colm, false, 4)) {//Testing adding a second ship. 
		   System.out.print("Bad location");
	   }
	   if (!p1.addShipP1(row, colm, true, 3)) {//Testing Adding a third ship that interfears with the second ship. (This should be a bad location.)  
		   System.out.print("Bad location");
	   }
	   p1.SetupDisplay();//This just displayes the players board.
	   //p1.player1Display();//This prints player1 and player1's view of players2's board.  
	}
	private static void multiPlayer()
	{
	   System.out.print("Comming Soon");
	}
	private static int translateGrid (int row2) {
		int row1 = row2 - 1;
		
		return row1;
		
	}
	private static int translateGrid (String col) {
		int colm1;
		if (col == "a") {
			colm1 = 0;
		}
		else if (col == "b") {
			colm1 = 1;
		}
		else if (col == "c") {
			colm1 = 2;	
		}
		else if (col == "d") {
			colm1 = 3;	
		}
		else if (col == "e") {
			colm1 = 4;	
		}
		else 
			colm1 = -1000; //-1000 for error
		return colm1;
	}
}
