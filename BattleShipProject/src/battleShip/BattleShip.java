package battleShip;

import java.util.ArrayList;
import java.util.Random;

//This is fun!
//starts game with blank battlefield
public class BattleShip {
	//Alex: I would like these to be dynamic 
	//this is player 1 battlefield.
	//	private char[][] battlefieldP1 = {
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'}
	//			};
	//	//This is player 1 view of player's 2 battlefield.
	//	private char[][] battlefieldP1viewP2 = {
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'}
	//			};
	//	//this is player 2 battlefield.
	//	private char[][] battlefieldP2 = {
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'}
	//			};
	//	//This is player 1 view of player's 2 battlefield.
	//	private char[][] battlefieldP2viewP1 = {
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'},
	//			{'-','-','-','-','-'}
	//			};
	//	
	
	private static char[][] battlefieldP1 = new char [8][8];
	private static char[][] battlefieldP1viewP2 = new char [8][8];
	private static char[][] battlefieldP2 = new char [8][8];
	private static char[][] battlefieldP2viewP1 = new char [8][8];
	//This is player 1 view of player's 2 battlefield.
	public void createbattlefield () {
		createbattlefieldhelper(battlefieldP1);
		createbattlefieldhelper(battlefieldP1viewP2);
		createbattlefieldhelper(battlefieldP2);
		createbattlefieldhelper(battlefieldP2viewP1);
	}
	
	
	public static void createbattlefieldhelper(char[][] battlefield){
	      for(int r = 0; r < battlefield.length; r++){
	         for(int c = 0; c < battlefield[0].length; c++){
	        	 battlefield[r][c] = '~';
	         }
	      }
	      
	   }
	public BattleShip() {
		//ToDo Something With
	}
	//this is for adding a ship to Player 1 battlefield. It needs to position to start the ship.
	//the direction the ship is going and the length of the ship
	public boolean addShipP1 (int row1, int col1, boolean vertical, int shipLength) {
		boolean okLocation = true;
		
		//check to see if selected location is available
		if (battlefieldP1 [row1][col1] == '~') { //for vertical ships
			if (vertical) {
				if (battlefieldP1.length <= row1 + shipLength) {
					return false;
				}
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP1[row1 + 1][col1] != '~') {
						okLocation = false;
						break;
					};
				}
			}
			else { //for horizontal ships
				if (battlefieldP1[0].length <= col1 + shipLength) {
					return false;
				}
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP1[row1][col1 + i] != '~') {
						okLocation = false;
						break;
					};
				}
			}
		}
		else {
			okLocation = false;
		}
		if (okLocation) {
			if (vertical) {
				for (int i = 0; i < shipLength; i++) {
					battlefieldP1[row1 + i][col1] = '@';
				}
			}
			else { //for horizontal ships
				for (int i = 0; i < shipLength; i++) {
					battlefieldP1[row1][col1 + i] = '@';
				}
			}
		}
		return okLocation;
	}
	public boolean addShipP2 (int row1, int col1, boolean vertical, int shipLength) {
		boolean okLocation = true;
		
		//check to see if selected location is available
		if (battlefieldP2 [row1][col1] == '~') { //for vertical ships
			if (vertical) {
				if (battlefieldP2.length <= row1 + shipLength) {
					return false;
				}
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP2[row1 + 1][col1] != '~') {
						okLocation = false;
						break;
					};
				}
			}
			else { //for horizontal ships
				if (battlefieldP2[0].length <= col1 + shipLength) {
					return false;
				}
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP2[row1][col1 + i] != '~') {
						okLocation = false;
						break;
					};
				}
			}
		}
		else {
			okLocation = false;
		}
		if (okLocation) {
			if (vertical) {
				for (int i = 0; i < shipLength; i++) {
					battlefieldP2[row1 + i][col1] = '@';
				}
			}
			else { //for horizontal ships
				for (int i = 0; i < shipLength; i++) {
					battlefieldP2[row1][col1 + i] = '@';
				}
			}
		}
		return okLocation;
	}
	public void player1Display () {
		System.out.println();
		System.out.println();
		System.out.println("Opponents Battlefield"); //name of the battlefield
		System.out.println("  A B C D E F G H");//adding the top row
		for (int i = 0; i < battlefieldP1viewP2.length; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < battlefieldP1viewP2[0].length; j++) {
				System.out.print(battlefieldP1viewP2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Your Battlefield"); //name of the battlefield
		System.out.println("  A B C D E F G H");//adding the top row
		for (int i = 0; i < battlefieldP1.length; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < battlefieldP1[0].length; j++) {
				System.out.print(battlefieldP1[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void showbattleFieldP1 () {
		System.out.println();
		System.out.println();

		System.out.println("Your Battlefield"); //name of the battlefield
		System.out.println("  A B C D E F G H");//adding the top row
		for (int i = 0; i < battlefieldP1.length; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < battlefieldP1[0].length; j++) {
				System.out.print(battlefieldP1[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void showbattleFieldP2 () {//testing only
		System.out.println();
		System.out.println();

		System.out.println("Player2 Battlefield"); //name of the battlefield
		System.out.println("  A B C D E F G H");//adding the top row
		for (int i = 0; i < battlefieldP2.length; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < battlefieldP2[0].length; j++) {
				System.out.print(battlefieldP2[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void setupPlayer2() {
		Random rand = new Random();
		int row, colm;
		boolean isVertical,isvalid;
		int [] shipSize = {5,4,3};
		
		
		for (int i = 0; i < shipSize.length; i++) {
			isvalid = false;
			do{
			isVertical = rand.nextBoolean();
//			if (isVertical){
//				colm = rand.nextInt(6);
//				row = rand.nextInt(6 - shipSize[i]);
//			}
//			else {
//				colm = rand.nextInt(6 - shipSize[i]);
//				row = rand.nextInt(6);	
//			}
			row = rand.nextInt(5);
			colm = rand.nextInt(5);
			isvalid = addShipP2(row,colm,isVertical,shipSize[i]);
			}while(!isvalid);
				
			
		}
		showbattleFieldP2(); //testing only

		
	}
	public boolean player1Fire(int row, int colm) {
if ((battlefieldP2.length < row) || (battlefieldP2[0].length < colm)) {//check for bad location
			//System.out.println("Bad Location try again");
			return false;
		}
		if (battlefieldP2[row][colm] == '#') { //check for allready hit the location
			//System.out.println("Your have attacked that location allready!!!");
			return false;
		};
		if (battlefieldP2[row][colm] == '@') { //check for hit
			System.out.println("Player 1 HIT!!!");
			battlefieldP2[row][colm] = '#';
			battlefieldP1viewP2[row][colm] = '#';
			return true;
		};
		if (battlefieldP2[row][colm] == '~') { //check for hit
			System.out.println("Player 1 Miss");
			battlefieldP2[row][colm] = '*';
			battlefieldP1viewP2[row][colm] = '*';
			return true;
		};
		
		return true;

	}
	public boolean ScanPlayer2Battlefield() {//scans p2 battlefield for ships returns true if ships exists. 
		for (int i = 0; i < battlefieldP2.length; i++) {
			for (int j = 0; j < battlefieldP2[0].length; j++) {
				if (battlefieldP2[i][j] =='@') {
					return true;
				}		
			}
		}
		return false;
		
	}


	public boolean player2Fire() {
		int row,colm;
		Random rand = new Random();
		row = rand.nextInt(8);
		colm = rand.nextInt(8);
		if ((battlefieldP1.length < row) || (battlefieldP1[0].length < colm)) {//check for bad location
			System.out.println("Bad Location try again");
			return false;
		}
		if (battlefieldP1[row][colm] == '#') { //check for allready hit the location
			System.out.println("Your have attacked that location allready!!!");
			return false;
		};
		if (battlefieldP1[row][colm] == '@') { //check for hit
			System.out.println("Player 2 HIT!!!");
			battlefieldP1[row][colm] = '#';
			return true;
		};
		if (battlefieldP1[row][colm] == '~') { //check for hit
			System.out.println("Player 2 Miss :(");
			battlefieldP1[row][colm] = '*';
			return true;
		};
		
		return true;
		
	}
		
}
