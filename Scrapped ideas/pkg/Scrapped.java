package pkg;

import app.Inventory;

public class Scrapped {
/*
	static void LevelGen() { 	// Responsible for level generation.
		
						DOCUMENTATION
		   0 is the value for the hub
		  	1 is the value for the small room
		   2 is the value for the medium room
		   3 is the value for the large room
		   x 0/1 specifies if the room has an enemy
		 
				 
				System.out.println("Dungeon size integer: " + dungeonsize);
				int lvldata[];
				int enemylocation[];
				int enemychance;
				lvldata = new int[dungeonsize];
				enemylocation = new int [dungeonsize];
				lvldata[0] = 0;
				enemylocation[0] = 0;
				System.out.print("Leveldata" + lvldata[0]);
				System.out.println();
				for(int i = 1; i < dungeonsize; i++) {
					lvldata[i] = (int) ((Math.random() * 4) + 1);
					enemychance = (int) ((Math.random() * 101) + 30);
					if (enemychance > 50) {
						enemylocation[i] = 1;
					} else enemylocation[i] = 0;			
					System.out.print("Leveldata: " + lvldata[i]);
					System.out.println();
					System.out.print("Enemychance: " + enemychance);
					System.out.print(", Enemylocation: " + enemylocation[i]);
					System.out.println("	Debug: LevelGen cycle " + i + " passed");
				}
				// Debug loopback
				System.out.println("DEBUG LOOPBACK");
				for (int i = 1; i <= dungeonsize; i++) {
					System.out.println("--Loop " + i + "--");
					System.out.println("Lvltype: " + lvldata[i]);
					System.out.println("Enemy:" + enemylocation[i]);
				}
			}
			
//-----------------------------------Horrible initialization-----------------------------------	
			// Initializes the gear system
		Inventory inv = new Inventory();
		int gear[] = null;
		// Initializes the main engine
		Engine core = new Engine();
		boolean response;
		
//-----------------------------------Starter area thing-----------------------------------	
		System.out.println("You woke up in the middle of some cellar."); 
		System.out.println("You notice something in front of you: a sword and a pair of shoes. Do you pick them up? [y/n]");
		response = core.request();
		if(response == true) {
			Inventory.weapon = (int) (Math.random()*5);
			Inventory.boots = (int) (Math.random()*4);
			gear = inv.invrefresh();
		}
		inv.gearstatus(gear);			
		System.out.println();
		Progresslog.xploredrooms++;
		
//-----------------------------------Moverepeat attempt-----------------------------------	
		// This was just stupid
		moverepeat = false;			
		response = Engine.request(moverepeat);
		if(response == true) {
		
		// This was just wrong. Why did i have the main function in a random location?
		public static void main(String[] args) {	// Responsible for the main progression	
			
		System.out.println("Welcome. This is a rogue-like text-based RPG game.");
		
		package app;
		
//-----------------------------------Inventory thing-----------------------------------	

public class Inventory {	
	
		// Player stats	
		static int weapon = 0;
		static int boots = 0;
		static int shield = 0;
		static int slot1 = 0;
		static int slot2 = 0;
		static int slot3 = 0;
		static int hp = 100;
		static int gold = 0;
	
	static int[] invrefresh() {		// MUST BE CALLED AFTER UPDATING ANY PLAYER STAT
		int gear[] = {weapon, boots, shield, slot1, slot2, slot3, hp, gold};
		return gear;
	}
		 
	static void gearstatus(int gear[]) {	// Declares the inventory and qualities (if exist)
		
		System.out.println("Your current inventory:");
		System.out.println();
		
		if(gear[0] > 0) {
			System.out.println("Sword quality:");
		} else System.out.println("Weapon:");
		
		switch (gear[0]) {// Declares the quality of the weapon
		case 0:
			System.out.println("Just your fists and a dream.");
			break;			
		case 1:
			System.out.println("This thing can't cut anything, but it might work as a hammer." + " [" + 2 + "]");
			break;
		case 2:
			System.out.println("It will cut if you pray hard enough." + " [" + 3 + "]");
			break;
		case 3:
			System.out.println("The sword is pretty sharp." + " [" + 4 + "]");
			break;
		case 4:
			System.out.println("The sword feels fantastic!" + " [" + 5 + "]");
			break;
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Boots quality:");
		switch (gear[1]) {	// Declares the quality of the shoes
		case 0:
			System.out.println("No shoes.");
			break;
		case 1:
			System.out.println("These things have more holes than swiss cheese." + " [" + 2 + "]");
			break;
		case 2:
			System.out.println("Your shoes are pretty comfy." + " [" + 3 + "]");
			break;
		case 3:
			System.out.println("Your shoes feel awesome!" + " [" + 4 + "]");
			break;
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Shield quality:");
		switch (gear[2]) { // Declares the shield quality (if exists)
		case 0:
			System.out.println("You don't have a shield equipped.");
			break;
		case 1:
			System.out.println("I don't think this can be even called a shield." + " [" + 1 + "]");
			break;
		case 2:
			System.out.println("It's really bad, but it can block something." + " [" + 2 + "]");
			break;
		case 3:
			System.out.println("It can really take a hit or two. Three on a good day. Probably." + " [" + 3 + "]");
			break;		
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("First slot:");
		switch (gear[3]) {  // Declares the first slot
		case 0:
			System.out.println("This slot is empty.");
			break;		
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Second slot:");
		switch (gear[4]) { // Declares the second slot
		case 0:
			System.out.println("This slot is empty.");
			break;		
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Third slot:");
		switch (gear[5]) { // Declares the third slot
		case 0:
			System.out.println("This slot is empty.");
			break;
		}	
		System.out.println();
		Engine.sleep(1);
		
		if(gear[6] > 80) {	// States the player HP and displays the value
			System.out.println("You feel healthy! " + gear[6] + " HP.");
		} else if(gear[6] > 50) {
			System.out.println("You have certainly taken a hit. " + gear[6] + " HP.");
		} else if(gear[6] > 20) {
			System.out.println("You don't feel too well. " + gear[6] + " HP.");			
		} else if(gear[6] < 20) {
			System.out.println ("You're almost dead. " + gear[6] + " HP.");
		}
		Engine.sleep(2);
		System.out.println("Current gold = " + gold);
	}
}
//-----------------------------------Inventory thing Vol.2-----------------------------------	
 *  			The second you see words "must", "don't touch", or something simillar in someone's code, run far.
 */
		/*
	static int[] invrefresh() {		// MUST BE CALLED AFTER UPDATING ANY PLAYER STAT
		int gear[] = {weapon, boots, shield, slot1, slot2, slot3, hp, gold};
		return gear;
	}
	gear = Inventory.invrefresh();
	
//-----------------------------------Hub thing-----------------------------------	
 * 
 *						Throws errors
	if(request.contentEquals("L") || request.contentEquals("l")) {
				if(reststatus == false) {
					System.out.println("Adventurer! You haven't rested in this hub!");
					System.out.println("If you leave now your progress will not be saved!");
					System.out.println("Do you wish to rest before your next journey?");
					response = request();
					if(response  == true) {
						System.out.println("Take a nap, adventurer.");
						restlogic();
					} else {
						System.out.println("Your choice.");
						visited = true;
					}
				}
				visited = true;
				System.out.println("Farewell, adventurer.");
				System.out.println();
				
			} else if(request.contentEquals("S") || request.contentEquals("s") ) {
				shoplogic();
			} else if(request.contentEquals("R") || request.contentEquals("r") ){
				restlogic();
				savewrite();
			}else if(request.contentEquals("I") || request.contentEquals("i") ){
				Inventory.gearstatus();
				visited = true;
				hublogic();
			}else {
				System.out.println("Please input a valid response.");
				response = false;
				visited = true;
				hublogic();
			}
	
	
*/	
}
