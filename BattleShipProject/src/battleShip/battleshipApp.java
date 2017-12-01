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
	
	private static void multiPlayer()
	{
	   System.out.print("Comming Soon");
	}

	
}
