package battleShip;

import java.util.Scanner;

public class battleshipApp {

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
		System.out.println("Wellcome to Battleship!!!");
		System.out.println();
		System.out.println("Press 1 for Single Player");
		System.out.println("Press 2 for Muliplayer (Comming Soon!!)");
		System.out.println("Press 0 to Exit");
		System.out.print("Your choice: ");
	}
	private static void singlePlayer()
	{
	   Scanner input = new Scanner (System.in);
	   BattleShip p1 = new BattleShip();
	   if (!p1.addShipP1(1, 2, true, 2)) {
		   System.out.print("Bad location");
	   }
	   if (!p1.addShipP1(0, 1, false, 4)) {
		   System.out.print("Bad location");
	   }
	   if (!p1.addShipP1(0, 0, true, 3)) {
		   System.out.print("Bad location");
	   }
	   p1.player1Display();
	}
	private static void multiPlayer()
	{
	   System.out.print("Comming Soon");
	}
}