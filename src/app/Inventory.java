package app;

import java.util.Scanner;

public class Inventory {	
	
			// Player stats	
	static int playerlevel = 1;
	static int playerxp = 0;
	static int xpreqmodifier = 20;
	static int playerxpreq = xpreqmodifier;
	static int weapon = 0;
	static int boots = 0;
	static int shield = 0;
	static String slot1 = "Empty";
	static int slot1type = 0;	
	static String slot2 = "Empty";
	static int slot2type = 0;	
	static String slot3 = "Empty";
	static int slot3type = 0;	
	static int maxhp = 100;
	static int hp = 100;
		
		// Item - specific variables
	static int hppotions = 0;
	static int gold = 0;
	static int[] poteffect = {0,0};	// Duration - Effect					
	static String[] potinfo = {"", "", ""};
		 
		 
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
		System.out.println(slot1);		
		System.out.println();
		Engine.sleep(1);
		
		System.out.println("Second slot:");
		System.out.println(slot2);			
		System.out.println();
		
		Engine.sleep(1);		
		System.out.println("Third slot:");
		System.out.println(slot3);	
		System.out.println();
		Engine.sleep(1);
		
		if(hp > 80) {	// States the player HP and displays the value
			System.out.println("You feel healthy! " + hp + " HP.");
		} else if(hp > 50) {
			System.out.println("You have certainly taken a hit. " + hp + " HP.");
		} else if(hp >= 20) {
			System.out.println("You don't feel too well. " + hp + " HP.");			
		} else if(hp < 20) {
			System.out.println ("You're almost dead. " + hp + " HP.");
		}
		Engine.sleep(1);
		System.out.println("Current gold: " + gold);
		Engine.sleep(1);
		System.out.println("Health potions: " + hppotions);
		
		invaction();
		
		
	}
	
	static void invaction() {
		
		Scanner input = new Scanner(System.in);
		
		String multiresponse;
		boolean validresponse;
		int hprestored;
		
		System.out.println("What do you wish to do?");
		System.out.print("Exit inventory [E] ");
		if(hppotions > 0) System.out.print("|| Drink Health Potions [H] ");
		if(potinfo[0] != "") System.out.print("|| Use Potions [P]");		
		System.out.println();
		
		do {
			validresponse = true;
			multiresponse = input.nextLine();
			switch (multiresponse) {
			case "E":
			case "e":
				break;
			case "H":
			case "h":				
				if(hppotions > 0 & hp <= maxhp) {					
					System.out.println("You drank a health potion.");
					System.out.println("You have " + hppotions + " health potions left.");
					hppotions -= 1;
					hprestored = (int) ((Math.random()*35)+15);
					hp += hprestored;
					System.out.println("Health restored: " + hprestored);
					System.out.println("Current health: " + hp);
				} else {
					if(hppotions < 0)System.out.println("You don't have any health potions to drink.");
					if(hp >= maxhp)System.out.println("You're healthy enough.");
				}
				invaction();
				break;
			case "P":
			case "p":
				//if (slot1 || slot2 || slot3) {
					switch(potinfo[2]) {
					case "0":
						poteffect[0] = (int) ((Math.random()*7)+3);
						poteffect[1] = 0;
						potreset();
						break;
					case "1":
						poteffect[0] = (int) ((Math.random()*8)+4);
						poteffect[1] = 1;
						potreset();
						break;
					case "2":
						poteffect[0] = (int) ((Math.random()*6)+4);
						poteffect[1] = 2;
						potreset();
						break;
					case "3":
						poteffect[0] = (int) ((Math.random()*6)+2);
						poteffect[1] = 3;
						potreset();
						break;
					case "4":
						poteffect[0] = (int) ((Math.random()*5)+3);
						poteffect[1] = 4;
						potreset();
						break;
					case "5":
						poteffect[0] = 4;
						poteffect[1] = 5;
						potreset();
						break;
					case "6":
						poteffect[0] = 99;
						poteffect[1] = 6;
						potreset();
					case "7":
						poteffect[0] = 0;
						poteffect[1] = 7;
						potreset();
						break;
					case "8":
						poteffect[0] = (int) ((Math.random()*8)+1);
						poteffect[1] = 8;
						potreset();
						break;
					case "9":
						poteffect[0] = Levels.dungeonsize;
						poteffect[1] = 9;
						potreset();
						break;
					}					
				
				invaction();
				break;
			default:
				System.out.println("Please input a valid response.");
				validresponse = false;
				break;
			}
		} while (validresponse == false);
		
	}
	static void potreset() {
		for (int i = 0; i < 3; i++) potinfo[i] = "";

	}
	
	static void slotfill(String item) {
		
		Scanner input = new Scanner(System.in);
		
		String response;
		boolean boolresponse;
		boolean validresponse;
		
		System.out.println("Which slot do you want to equip your item to?");
		System.out.println("[1]: " + slot1);
		System.out.println("[2]: " + slot2);
		System.out.println("[3]: " + slot3);
		do {
			validresponse = true;
			response = input.nextLine();
			switch(response) {
			case "1":
				if(slot1 == "Empty") {
					slot1 = item;
					System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
				} else if(slot1 != "Empty") {
					System.out.println("Slot is full. Do you want to replace it?");
					boolresponse = Engine.request();
					if (boolresponse == true) {
						slot1 = item;
						System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
					} else System.out.println("\"" + slot1  +"\""+ " has not been replaced.");
				}
				break;
			case "2":
				if(slot2 == "Empty") {
					slot2 = item;
					System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
				} else if(slot2 != "Empty") {
					System.out.println("Slot is full. Do you want to replace it?");
					boolresponse = Engine.request();
					if (boolresponse == true) {
						slot2 = item;
						System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
					} else System.out.println("\"" + slot2  +"\""+ " has not been replaced.");
				}
				break;
			case "3":
				if(slot3 == "Empty") {
					slot3 = item;
					System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
				} else if(slot3 != "Empty") {
					System.out.println("Slot is full. Do you want to replace it?");
					boolresponse = Engine.request();
					if (boolresponse == true) {
						slot3 = item;
						System.out.println("\"" + item +"\"" + " Equipped in slot 1.");
					} else System.out.println("\"" + slot3  +"\""+ " has not been replaced.");
				}
				break;
			default:
				System.out.println("Please input a valid response.");
				validresponse = false;
			}
		} while (validresponse == false);
	}
			
	
	static void itemdiscard(String discitem, String itemtype) {
		
		boolean boolresponse;
		boolean validresponse;
		
		System.out.println("Are you sure you want to discard " + discitem + "?");
		do {
			validresponse = true;
			boolresponse = Engine.request();
			if(boolresponse == true) {			
				switch(itemtype) {
				case "slot":
					System.out.println(discitem + " has been discarded.");
					discitem = "Empty";
					break;
				case "wep":
					System.out.println(discitem + " has been discarded.");
					discitem = "0";
					break;
				case "armour":
					System.out.println(discitem + " has been discarded.");
					discitem = "0";
					break;
				case "shield":
					System.out.println(discitem + " has been discarded.");
					discitem = "0";
					break;				
				default:
					System.out.println("Please input a valid response.");
					validresponse = false;
				}					
			} else System.out.println(discitem + " has not been discarded.");
		} while (validresponse == false);
	}
	
	static void abilities() {
		// TODO Abilities
	}
	static void effects() {
		// TODO Effects
	}
}
