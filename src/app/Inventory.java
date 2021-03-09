package app;

public class Inventory {	
	
		// Player stats	
		static int weapon = 0;
		static int boots = 0;
		static int shield = 0;
		static int slot1 = 0;
		static int slot2 = 0;
		static int slot3 = 0;
		static int hppotions = 0;
		static int hp = 100;
		static int gold = 0;
		 
	static void gearstatus() {	// Declares the inventory and qualities (if exist)
		
		System.out.println("Your current inventory:");
		System.out.println();
		
		if(weapon > 0) {
			System.out.println("Sword quality:");
		} else System.out.println("Weapon:");
		
		switch (weapon) {// Declares the quality of the weapon
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
		switch (boots) {	// Declares the quality of the shoes
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
		switch (shield) { // Declares the shield quality (if exists)
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
		switch (slot1) {  // Declares the first slot
		case 0:
			System.out.println("This slot is empty.");
			break;		
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Second slot:");
		switch (slot2) { // Declares the second slot
		case 0:
			System.out.println("This slot is empty.");
			break;		
		}
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Third slot:");
		switch (slot3) { // Declares the third slot
		case 0:
			System.out.println("This slot is empty.");
			break;
		}	
		System.out.println();
		Engine.sleep(1);
		
		if(hp > 80) {	// States the player HP and displays the value
			System.out.println("You feel healthy! " + hp + " HP.");
		} else if(hp > 50) {
			System.out.println("You have certainly taken a hit. " + hp + " HP.");
		} else if(hp > 20) {
			System.out.println("You don't feel too well. " + hp + " HP.");			
		} else if(hp < 20) {
			System.out.println ("You're almost dead. " + hp + " HP.");
		}
		Engine.sleep(1);
		System.out.println("Current gold: " + gold);
		Engine.sleep(1);
		System.out.println("Health potions: " + hppotions);
	}
	
	static void abilities() {
		
	}
}
