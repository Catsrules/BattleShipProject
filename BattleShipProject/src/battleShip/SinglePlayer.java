package battleShip;




import java.util.*;
import java.util.Scanner;
public class SinglePlayer{
	static void SinglePlayerMain(){
		//This creates an Instance of the BattleShip game, Contains all of the data on where ships are for both players
		BattleShip p1 = new BattleShip();
		boolean checkLocation;
		//int carrier = 5, destroyer = 4, submarine =3;
		p1.createbattlefield ();
		p1.setupPlayer2();
		
		//This is the first round of adding a ship. This needs to be looped or something as we have duplicate code.
		;//This just displayes the players board.
		checkLocation = false;
		do {
			p1.showbattleFieldP1();
			checkLocation = placeship("carrier");
		}while(!checkLocation);
		checkLocation = false;
		do {
			p1.showbattleFieldP1();
			checkLocation = placeship("destroyer");
		}while(!checkLocation);
		checkLocation = false;
		do {
			p1.showbattleFieldP1();
			checkLocation = placeship("submarine");
		}while(!checkLocation);
		
		//System.out.println("Game is Ready");
		System.out.println("Game is starting");
		
		p1.showbattleFieldP1();
		
		singlePlayerPlaying();

	}
	
	
	
	private static void singlePlayerPlaying() {
		int gameResult = 3; //1 is player won, 2 is computer won, 3 game in play
		int row,colm;
		int round = 1;
		boolean valid,player1StillAlive = true,player2StillAlive = true;
		BattleShip p1 = new BattleShip();
		Scanner input = new Scanner (System.in);
		do {
			System.out.println();
			System.out.println("________________________________________________________");
			System.out.printf("Round %d%n", round);
			
			p1.player1Display();
			do{
			//This askes the user what Row do you what to attack
			System.out.print("What Row (1-8) do you want to attack?:");
			//This captures the users answer, and translates the Human entered number into the correct number (See transLateGrid Method)
			row = translateGrid(input.nextInt());
			System.out.println();
			//This is here to fix Java issues with input.nextLine
			input.nextLine();
			//This askeds the user what Column they want there ship to be in. 
			System.out.print("What column (A-H) do you want to attack?:");
			//The captures the users answer and translates the Human entered Letter in the a number that the computer can understand. (See transLateGrid Method)
			colm = translateGrid(input.nextLine());			
				valid = p1.player1Fire(row, colm);
			}while(!valid);
			valid = false;
			player2StillAlive = p1.ScanPlayer2Battlefield();
			if (player2StillAlive) {
				do{
					valid = p1.player2Fire();
				}while(!valid);
				valid = false;
				player1StillAlive = p1.ScanPlayer2Battlefield();
			}
			if (!player2StillAlive) {
				gameResult = 1;
			}
			if (!player1StillAlive) {
				gameResult = 2;
			}
			round++;	
		}while(gameResult == 3);
		if (gameResult == 1) {
			System.out.println();
			System.out.println("________________________________________________________");
			System.out.printf("YOU WIN!!!!");
			System.out.println("________________________________________________________");
		}
		if (gameResult == 2) {
			System.out.println();
			System.out.println("________________________________________________________");
			System.out.printf("YOU LOOSE!!!!");
			System.out.println("________________________________________________________");
		}
		if (gameResult == 3) {
			System.out.println("error");
		}
		//return gameResult;
	}
	
	
	
	
	private static boolean placeship(String shipName) {
		BattleShip p1 = new BattleShip();
		Scanner input = new Scanner (System.in);
		int shipSize;
		int row;
		int colm;
		boolean isVertical;
		if (shipName.equalsIgnoreCase("carrier")) {
			shipSize = 5;
		}
		else if (shipName.equalsIgnoreCase("destroyer")) {
			shipSize = 4;
		}
		else if (shipName.equalsIgnoreCase("submarine")) {
			shipSize = 3;	
		}
		else 
			shipSize = -1000; //-1000 for error 
		isVertical = orientation(shipName);
		
		//This askes the user what Row do you what the ship to be in
		System.out.print("What Row (1-8) do you want your Ship to be in?:");
		//This captures the users answer, and translates the Human entered number into the correct number (See transLateGrid Method)
		row = translateGrid(input.nextInt());
		System.out.println();
		//This is here to fix Java issues with input.nextLine
		input.nextLine();
		//This askeds the user what Column they want there ship to be in. 
		System.out.println("What column (A-H) do you want your Ship to be in?:");
		//The captures the users answer and translates the Human entered Letter in the a number that the computer can understand. (See transLateGrid Method)
		colm = translateGrid(input.nextLine());
		if (!p1.addShipP1(row, colm, isVertical, shipSize)) {//Testing adding ships We need to get it so it is all user input. For example 1 ,2 would need to be 2C. To start the ship and True is saying it IS vertical
			System.out.print("Bad location try again");//It addShipP1 returns false it will display "Bad Location" In need to make this a loop. So it asks the user again for a correct location.  
			return false;
		}
		return true;
	}
	
	
	
	//This handles the menu for the orientation and returns the boolean value
	private static boolean orientation(String shipName) {
		boolean isVertical = true;
	    Scanner input = new Scanner (System.in);
	    int selection;
	    do {
	    	System.out.printf("What orientation do you want your %s to be in?:%n",shipName);
			System.out.println("Press 1 for Vertical");
			System.out.println("Press 2 for Horizontal");
			System.out.println("Press 0 for more information");
	    	selection = input.nextInt();
	    	switch(selection) {
	    	case 1: isVertical = true;
	    		break;
	    	case 2: isVertical = false;
	    		break;
	    	case 0: System.out.println("you need to place your ship on the battlefield!!");
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
		else if (col.equalsIgnoreCase("f")) {
			colm1 = 5;	
		}
		else if (col.equalsIgnoreCase("g")) {
			colm1 = 6;	
		}
		else if (col.equalsIgnoreCase("h")) {
			colm1 = 7;	
		}
		
		else 
			colm1 = -1000; //-1000 for error
		return colm1;
	}
}