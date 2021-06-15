package app;

public class Levels {
					// Dungeon-specific variables
	static int dungeonsize;
	static int dungeontype;
	static double dungeondiff;	// 0: easy, 1: Difficult, 2: Hard, 3: Brutal?
	static int hubcount;
					// Level-specific variables
	static int roomsize;
	static int roomtype;
	static int enemycount;
	static int dangerlevel;
					// General variables
	static boolean response;
	static double[] dungeonrewards = {0,0,0};
	// x gold, x experience, x items, 
		
	static void DungeonGen() {	// Responsible for the dungeon type generation. Two to not burn out.
		
		//dungeontype = (int) (Math.random() * 3); //Scrapped for debugging
		dungeontype = 0;
		
		switch(dungeontype) {
		case 0:
			System.out.println("	Debug: DungeonGen passed");
			Dungeonforgotten();			
			break;
		case 1:
			System.out.println("DUNGEON GEN TEST");
			break;			
		}
	}
	
	static void Crossroads() {
		switch (dungeontype) {
		case 0:
			dungeonrewards[0] = 250 * dungeondiff;
			dungeonrewards[1] = 300 * dungeondiff;
			dungeonrewards[2] = 0;
		case 1:
		}
		System.out.println("Dungeon complete!");
		Engine.sleep(1);
		System.out.println("Items recieved this run:");
		Engine.sleep(1);
		System.out.println(dungeonrewards[0] + " Gold");
		Inventory.gold += (int) dungeonrewards[0];
		Engine.sleep(1);
		System.out.println(dungeonrewards[1] + " Experience");
		Engine.leveling( (int) dungeonrewards[1]);
		Engine.sleep(1);		
		Engine.savewrite();
		System.out.println("Diving into a brand new adventure!");
		System.out.print("Loading");
		for(int i = 0; i <= 3 ; i++) {
			System.out.print(".");
			Engine.sleep(1);
		}
		DungeonGen();
	}
	
	
	static void Dungeonforgotten() {	// Responsible for the Forgotten Dungeon progression
		
		int[] lvldata;
		System.out.println();
		System.out.println("Fate has chosen...");
		System.out.println("|| The Forgotten dungeon ||");
		System.out.println();
		System.out.println("The Forgotten dungeon is an EASY dungeon in which every book you find contains sacred text of a civilization,\n whose language is long forgotten, but their magical powers have anything but dwindled.");
		System.out.println("By completing this dungeon you will increase your ability to read their language,\n and thus, understand their arcane arts.");
		
		dungeonsize = (int) (Math.random() * 12) + 5;
		dungeondiff = 0.7;
		hubcount = (int) (Math.random() * 3) + 1;	
		lvldata = LevelGen();
		for(int i = 0; i < dungeonsize; i++) {
			if (lvldata[i] == 000) {
				Engine.hublogic();
			} else Engine.roomaction(lvldata[i]);			
			// TODO Forgotten progression
		}
		Crossroads();
		Engine.savewrite();
		
		if(Engine.devmode == true) System.out.println("	Debug: DungeonForgotten passed");
	}	
	
	static void Dungeoncadet() {	// Responsible for the tutorial dungeon.		
				
		//int lvldata[] = {00, 10, 21, 11, 30, 31, 00};
		dungeondiff = 0.5;
		System.out.println("You wake up in your comfortable bed");
		switch(Progresslog.cadetplaytime) {
		case 0:
			break;
		case 1:
			System.out.println("You feel like you've been here before. Strange...");
			break;
		case 2:
			System.out.println("How many times have you seen this room?");
			break;
		case 3:
			System.out.println("You have certainly been more than enough. However, this may be your last.");
			break;	
		default:
			System.out.println("Well uhh... This wasn't supposed to happen.");
			System.out.println("If you're reading this something has most definitely gone horriby wrong. Sorry 'bout that.");
		}
		
		System.out.println();
		Progresslog.cadetplaytime++;
		if(Engine.devmode == true) System.out.println("Cadet playtime: " + Progresslog.cadetplaytime);
		System.out.println("On your table lies three items.");
		System.out.println("A sword, a pair of boots and a shield.");
		System.out.println("Do you pick them up?");
		response = Engine.request();
		if(response == true) {
			System.out.println("A wise choice.");
			Inventory.weapon = 4;
			Inventory.boots = 3;
			Inventory.shield = 3;
		} else {
			System.out.println("You never needed crutches anyway.");
		}
		
		System.out.println("You leave your house with the following possessions:");
		Inventory.gearstatus();
		System.out.println();
		Engine.sleep(1);
		System.out.println("As you swing your door open, you realize that you are in a small town.");
		System.out.println("These towns are called HUBS. ");
		Engine.sleep(2);
		System.out.println("In these hubs you can buy items, improve your current ones and much more.");
		System.out.println("Your possible actions in those hubs depend on your HUB LEVEL.");
		Engine.sleep(5);
		System.out.println("Your hub level increases as you encounter more and more hubs.");
		System.out.println("As your hub level increases, your options in these hubs increase aswell.");
		System.out.println("Your current Hub level is: " + Progresslog.hublevel);
		Engine.sleep(5);
		Engine.hublogic();		
		System.out.println("Your progress is saved after you rest, so be sure to rest before you set off.");
		System.out.println("You leave the hub and step into the dungeon.");
		System.out.println();
		System.out.println("This place is treacherous and you should always be wary of your surroundings and plan ahead.");
		Engine.sleep(1);
		System.out.println("You enter your first room in the dungeon.");
		Engine.sleep(1);
		System.out.println("Under normal circumstances, level progression is generated randomly.");
		Engine.sleep(2);
		System.out.println("So there is a high probability that you will encounter an enemy.");
		Engine.sleep(2);
		System.out.println("However these are not normal circumstances.");
		Engine.sleep(1);
		System.out.println("You find yourself in a small room.");
		Engine.sleep(1);
		System.out.println("It does appear to have ");
		Engine.sleep(1);
		Engine.roomaction(100);
	}
	
	static int[] LevelGen() { 	// Responsible for level generation.
			
/* 				DOCUMENTATION
 *  0yz is the value for the hub
 * 	1yz is the value for the small room
 *  2yz is the value for the medium room
 *  3yz is the value for the large room
 *  	x1z specifies if the room has an enemy
 * 		x2z specifies if the room has a strong enemy
 *  	x3z specifies if the room has a Boss enemy 
 *  		xy0 specifies that there is no event in this room.
 *  		xy1 specifies that there is a trap in this room.
 *  		xy2 specifies that there is no event in this room.
 *  		xy3 specifies that there is small treasure in this room.
 *  		xy4 specifies that there is medium treasure in this room.
 *  		xy5 specifies that there is large treasure in this room.
 *  Format: 000 xyz xyz ... xyz 000
 */		
		System.out.println("Dungeon size integer: " + dungeonsize);
		int lvldata[];		
		int enemychance;
		int spawnthreshold = 70;
		int eventtype;
		lvldata = new int[dungeonsize];				
		for(int i = 0; i < dungeonsize; i++) {
			lvldata[i] = (int) ((Math.random() * 4) + 1);	// Sets the dungeon type
			lvldata[i] *= 100;	// Adjusts the value
			enemychance = (int) (Math.random() * 101);
			lvldata[i] += (int) (Math.random() * 6);
			
			if (enemychance > 40) {
				lvldata[i] += 10;
			}
			if (enemychance > 60) {
				lvldata[i] += 20;
			}
			if (enemychance > 90) {
				lvldata[i] += 30;
			}
			if (Engine.devmode == true) {
				System.out.println("Enemy spawn threshold: " + spawnthreshold);	
				System.out.println();
				System.out.println("--Loop " + (i + 1) + "--");
				System.out.print("Leveldata: " + lvldata[i] +", ");			
				System.out.print("Enemychance: " + enemychance);
				System.out.print(", Roomtype: " + lvldata[i] / 100);
				System.out.print(", Enemylocation: " + (lvldata[i]/10) % 10);
				System.out.print(", Eventtype: " + (lvldata[i] % 100) % 10);
				System.out.println("	LevelGen cycle " + i + " passed");
			}
		}
		lvldata[0] = 000;	// Sets the first and the last as hubs
		lvldata[(dungeonsize-1)] = 000;		
		return lvldata;
	}	
	
	static void mainmenu() {	// Responsible for the main progression			
			// Main menu
		
		System.out.println("Welcome. This is a rogue-like text-based RPG game.");
		Engine.sleep(1);
		System.out.println("You control your character by entering your desired action when prompted.");
		Engine.sleep(1);
		System.out.println("Do you want to start your journey?");
		System.out.println();
		System.out.println("   y: yes      		n: no		");
		response = Engine.request();
		if(response == false) {
			System.out.println("W-What are you doing here then? If you're not here to play the game then what do you even want to do?");
			System.out.println("To start, write \"Y\" or \"y\" in the console ");
			System.out.println("I won't ask again. Do you want to start your journey?");
			response = Engine.request();
			if(response == false) {
				System.out.println("I am not here to judge your decision. Farewell.");
				System.exit(1);
			} else {
				System.out.println("Glad you came to your senses.");		
			}
		} else {
			System.out.println("Very well.");
		}
		System.out.println();		
		if(Engine.devmode == true) System.out.println("	Debug: StartMenu passed");
		
			// Cadet dungeon check
		
		if(Progresslog.cadetplaytime < 3) {
			System.out.println("You seem to be new at the game. Would you like to play through a more tailored experience,\n"
					+ "which is designed for inexperienced players and introduces you to the game's mechanics?");
			if(Engine.devmode == true) System.out.println("Cadet playtime: " + Progresslog.cadetplaytime);
			response = Engine.request();
			if(response == true) {
				System.out.println("Alright then.");
				Dungeoncadet();
			} else DungeonGen();			
		} else DungeonGen();	
		
	}
}