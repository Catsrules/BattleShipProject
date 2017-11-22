package battleShip;

import java.util.ArrayList;

//starts game with blank battlefield
public class BattleShip {
	//this is player 1 battlefield.
	private char[][] battlefieldP1 = {
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'}
			};
	//This is player 1 view of player's 2 battlefield.
	private char[][] battlefieldP1viewP2 = {
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'}
			};
	//this is player 2 battlefield.
	private char[][] battlefieldP2 = {
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'}
			};
	//This is player 1 view of player's 2 battlefield.
	private char[][] battlefieldP2viewP1 = {
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'},
			{'-','-','-','-','-'}
			};
	

	public BattleShip() {
		//ToDo Something With ¯\_(:))_/¯
	}
	//this is for adding a ship to Player 1 battlefield. It needs to position to start the ship.
	//the direction the ship is going and the length of the ship
	public boolean addShipP1 (int row1, int col1, boolean vertical, int shipLength) {
		boolean okLocation = true;
		//check to see if selected location is available
		if (battlefieldP1 [row1][col1] == '-') { //for vertical ships
			if (vertical) {
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP1[row1][col1 + i] != '-') {
						okLocation = false;
						break;
					};
				}
			}
			else { //for horizontal ships
				for (int i = 0; i < shipLength; i++) {
					if (battlefieldP1[row1 + i][col1] != '-') {
						okLocation = false;
						break;
					};
				}
			}
		}
		if (okLocation) {
			if (vertical) {
				for (int i = 0; i < shipLength; i++) {
					battlefieldP1[row1][col1 + i] = '@';
				}
			}
			else { //for horizontal ships
				for (int i = 0; i < shipLength; i++) {
					battlefieldP1[row1 + i][col1] = '@';
				}
			}
		}
		return okLocation;
	}
	public void player1Display () {
		System.out.println();
		System.out.println();
		System.out.println("Opponents Battlefield"); //name of the battlefield
		System.out.println("  A B C D E");//adding the top row
		for (int i = 0; i < 5; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 5; j++) {
				System.out.print(battlefieldP1viewP2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Your Battlefield"); //name of the battlefield
		System.out.println("  A B C D E");//adding the top row
		for (int i = 0; i < 5; i++) {//printing out the side bar and the 
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 5; j++) {
				System.out.print(battlefieldP1[i][j] + " ");
			}
			System.out.println();
		}
	}
		
}
