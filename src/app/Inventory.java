package app;

import java.util.Scanner;

public class Inventory {	
	
			// Player stats	
		static int weapon = 0;
		static int boots = 0;
		static int shield = 0;
		static String slot1 = "Empty";
		static String slot2 = "Empty";
		static String slot3 = "Empty";		
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
		boolean validresponse = true;
		int hprestored;
		
		System.out.println("What do you wish to do?");
		System.out.print("Exit inventory [E] || Drink Health Potions [H] ");
		if(potinfo[0] != ""){
			System.out.print("|| Use Potions [P]");		
		}
		System.out.println();
		
		do {
			multiresponse = input.nextLine();
			switch (multiresponse) {
			case "E":
			case "e":
				break;
			case "H":
			case "h":				
				if(hppotions > 0) {					
					System.out.println("You drank a health potion.");
					System.out.println("You have " + hppotions + " health potions left.");
					hppotions -= 1;
					hprestored = (int) ((Math.random()*35)+15);
					hp += hprestored;
					System.out.println("Health restored: " + hprestored);
					System.out.println("Current health: " + hp);
				} else {
					System.out.println("You don't have any health potions to drink.");
				}
				invaction();
				break;
			case "P":
			case "p":
				switch(potinfo[2]) {
				case "0":
					poteffect[1] = (int) ((Math.random()*7)+3);
					poteffect[2] = 0;
					break;
				case "1":
					poteffect[1] = (int) ((Math.random()*8)+4);
					poteffect[2] = 1;
					break;
				case "2":
					poteffect[1] = (int) ((Math.random()*6)+4);
					poteffect[2] = 2;
					break;
				case "3":
					poteffect[1] = (int) ((Math.random()*6)+2);
					poteffect[2] = 3;
					break;
				case "4":
					poteffect[1] = (int) ((Math.random()*5)+3);
					poteffect[2] = 4;
					break;
				case "5":
					poteffect[1] = 4;
					poteffect[2] = 5;
					break;
				case "6":
					poteffect[1] = 99;
					poteffect[2] = 6;
				case "7":
					poteffect[1] = 0;
					poteffect[2] = 7;
				case "8":
					poteffect[1] = (int) ((Math.random()*8)+1);
					poteffect[2] = 8;
				case "9":
					poteffect[1] = Levels.dungeonsize;
					poteffect[2] = 9;
					break;
				}
				invaction();
			default:
				System.out.println("Please input a valid response.");
				validresponse = false;
				break;
			}
		} while (validresponse == false);
		
	}
	
	static void slotfill(String item) {
		
		Scanner input = new Scanner(System.in);
		
		String response;
		boolean boolresponse;
		boolean validresponse = true;
		
		if(slot1 != "Empty" & slot2 != "Empty" & slot3 != "Empty") {
			System.out.println("All your slots are full. Do you wish to discard an older item and put your new item in it's place?");
			boolresponse = Engine.request();
			if(boolresponse == true) {
				System.out.println("Which item would you like to discard?");
				System.out.println("[1]: " + slot1);
				System.out.println("[2]: " + slot2);
				System.out.println("[3]: " + slot3);
				System.out.println("Don't discard [D]");
				do {
					response = input.nextLine();				
					switch(response) {
					case "1":
						itemdiscard(slot1, "slot");	
						slot1 = item;
						break;
					case "2":
						itemdiscard(slot2, "slot");	
						slot2 = item;
						break;
					case "3":
						itemdiscard(slot3, "slot");	
						slot3 = item;
						break;
					case "D":
					case "d":
						System.out.println("Are you sure you don't want to discard any items?");
					default:
						System.out.println("Please input a valid response.");
						validresponse = false;
						break;
					}
				} while (validresponse == false);
				validresponse = true;
			} else System.out.println("None of the current items will be discarded.");
			
		} else {
			
			System.out.println("Which slot do you want to equip your item to?");
			System.out.println("[1]: " + slot1);
			System.out.println("[2]: " + slot2);
			System.out.println("[3]: " + slot3);
			do {
				response = input.nextLine();
				switch(response) {
				case "1":
					if(slot1 == "Empty") {
						slot1 = item;
						System.out.println(item + " Equipped in slot 1.");
					} else {
						System.out.println("Slot is full. Please select another slot.");
						slotfill(item);
					}
					break;
				case "2":
					if(slot2 == "Empty") {
						slot2 = item;
						System.out.println(item + " Equipped in slot 1.");
					} else {
						System.out.println("Slot is full. Please select another slot.");
						slotfill(item);
					}
					break;
				case "3":
					if(slot3 == "Empty") {
						slot3 = item;
						System.out.println(item + " Equipped in slot 1.");
					} else {
						System.out.println("Slot is full. Please select another slot.");
						slotfill(item);
					}
					break;
				default:
					System.out.println("Please input a valid response.");
					validresponse = false;
				}
			} while (validresponse ==false);
		}
		gearstatus();
	}
	
	static void itemdiscard(String discitem, String itemtype) {
		
		boolean boolresponse;
		boolean validresponse = true;
		
		System.out.println("Are you sure you want to discard " + discitem + "?");
		boolresponse = Engine.request();
		if(boolresponse == true) {			
			switch(itemtype) {
			case "slot":
				discitem = "Empty";
				break;
			case "wep":
				discitem = "0";
				break;
			case "armour":
				discitem = "0";
				break;
			case "shield":
				discitem = "0";
				break;				
			default:
				System.out.println("Please input a valid response.");
				validresponse = false;
			}
			System.out.println(discitem + " has been discarded.");
		} else System.out.println(discitem + " has not been discarded.");
	}
	
	static void abilities() {
		// TODO Abilities
	}
	static void effects() {
		// TODO Effects
	}
}
