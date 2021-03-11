# Program
 Small personal RPG game project.

## Version log

### Version X, Alpha 0.x.x

Things happened, did most of the things and didn't bother to log them\
Added Main systems: Engine, Levels and Inventory\
Created The main y/n response logic\
Created the inventory system\
Created the inventory display system\
Created the Progresslog.java to store user progress variables\
Created Level generation\
Created Dungeon generation\
Created an idea file\
Added Health, a shield, slots.\

------------------------------

### Version Alpha 0.1.0
Refactored methods to static types\
Added Namings.java to facilitate all the names for things\
Created Scrapped.java because i want to keep the garbage i create so i could reflect back on it\
Integrated the Sleep command which is HUGE\

### Alpha 0.1.1
Created the main hub logic\
Migrated the main function to the Engine from the Levels class\
Refactored the Inventory to not use arrays anymore (Why did i think that was a good idea to begin with?!)\

### Alpha 0.2.0
Added the save system :D HOORAY!!!\
Added Langpack.java for potential language changing\
Added DEVMODE, which provides additional debug text when turned on, disables sleep.\
Added Resting in hubs, which saves progres. Leaving doesn't save anymore.\
Split hub method into hublogic and hubintro\
Tweaked Hub text prompts.\
Tweaked Cadet dungeon pre-hub timings\
Added the shop logic\
Added the ability to view inventory from hubs\
Minor Engine and Inventory code cleanup\
Removed the Hublogic do-while loop, as it became obsolete after splitting and creates errors.\
Fixed the y/n response to return a proper value;\

### Alpha 0.2.1
Experimented with Java swing to create a usable program interface.\
Tweaked the Y/N response to ask for Y/N\
Added more events to LevelGen\
Added more progression to the Cadet dungeon.\
Tweaked the hublogic to use switch instead of an "if" tree\
Fixed the bug when the hub shop called to hub twice\

### GUI: Alpha 0.0.2
Added more options\
Added the ability to return to the main menu from options\

### Alpha 0.2.2
Added the Alchemist's abode\
Adjusted the hublogic to accomodate Wizard tower and Alchemist's abode\
Added a few idea entries\
Added a WIP room action\

### GUI: Alpha 0.0.3a	2021-03-08
Experimented with methods in java swing\
	github test\
	github test 2\
	
### Alpha 0.3.0		2021-03-09
Migrated to github\
Experimented with command line launch\
Adjusted the LevelGen to accomodate events\
Added Potions\
Added the Room Action function\
Added the slot equipping function\
Added the item discarding function.\

### Alpha 0.3.1		2021-03-09
Tied the up the game loop. It... it's almost playable now actually.\
Converted Idea and VersionLog files to .txt\
Tweaked difficulty impact on the dungeon\
Added potion durations and tagged their effects\
Tweaked the Shop to display current user gold\
Tweaked the Shop to go back to the shop after a purchase.\
Tweaked the Inventory to display health healed and current health after healing\

### Alpha 0.3.2		2021-03-11
Removed a few unnecessary files\
Added bonus stats for devmode\
Added a few sleep statements\
Tweaked the room action to prompt inventory opening instead of doing it automatically.\
Tweaked the slot equipping to prompt replacement immediatelly.\
Tidyed up a couple of statements\
Fixed the ability to overheal\
Fixed the potion script loop\
Fixed the potion script reset\
Fixed the invalid response loop\
Cut a large portion of exess code\



