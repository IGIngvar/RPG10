import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Game {
	private Scanner var;
		
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Game game = new Game();
		//Getting a list of descriptions
		GenerateDescriptions descriptions = new GenerateDescriptions();
		descriptions.addDescriptions();
		
		//Creating a player and starting location
		Player player = new Player("Alider");
		Room room = new Room("StartRoom");
		room.setPlayer(player);
				
		//Generating a dungeon
		GenerateMap map = new GenerateMap();
		map.generateMap(room, 0, descriptions);
		
		//Starting the game
		game.playGame(room,map);
		
	}
	
	//List of possible actions
	public void printActions() {
		System.out.println("(-1) Give up");
		System.out.println("(0) Look around");
		System.out.println("(1) Look for a way out");
		System.out.println("(2) Look for company");
		System.out.println("(3) QuickSave");
		System.out.println("(4) QuickLoad");
		System.out.println("(5) Save");
		System.out.println("(6) Load");
		System.out.println("(7) Print Map");
	}
	
	public void printNpcActions(String name) {
		System.out.println(" You can inspect(0), talk(1), attack(2) or persuade(3) " + name + " or do nothing(-1)");
		
	}
	
	//int scanner
	public int getInput() {
		var = new Scanner(System.in);
		try {
			return var.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Please chooce an option from the screen");
			return getInput();
		} 
	}
	
	
	public void playGame(Room room, GenerateMap map) throws IOException, ClassNotFoundException {
		int i = 0;
		List<NPC> removeList = new ArrayList<NPC>();
		for (NPC allNPCs:room.getNPCs()) {
			if (allNPCs.getHealth() <= 0) {
				System.out.println(allNPCs.getName()+" died");
				removeList.add(allNPCs);
			}
		}
		//Removing dead NPCs
		room.getNPCs().removeAll(removeList);
		for (int j=0;j<removeList.size();j++) {
			removeList.remove(j);
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Your Health: " + room.getPlayer().getHealth());
		System.out.println("Your strength: " + room.getPlayer().getStrength() );
		System.out.println("You have " + room.getPlayer().getLockPick()+" lockpicks");
		System.out.println("------------------------------------------------------");
		if (room.getPlayer().getHealth() <= 0) {
			System.out.println("Wasted");
			return;
		}
		printActions();
		
		//Switch for possible actions
		switch (getInput()) {
		case -1:
			System.out.println("You gave up");
			break;
		//get room description
		case 0:
			room.inspect();
			playGame(room,map);
			break;
		//get all possible doors
		case 1:
			i = 0;
			for (Door allDoors:room.getDoors()) {
				System.out.println("("+i+") "+allDoors.getDescription());
				i++;
			}
			System.out.println("Which door do you take ? ( -1 : stay here) ");
			int doorChoice = getInput();
			if (doorChoice==-1) {
				playGame(room,map);
			}else if(doorChoice > i-1) {
				System.out.println("It seems you walked into a wall");
				playGame(room,map);
			}else {
				playGame(room.getDoors().get(doorChoice).getThrough(room),map);
				
			}
			break;
		//Get all characters
		case 2:
			i = 0;
			for (Character allChar:room.getNPCs()) {
				System.out.println("("+i+") "+allChar.getName());
				i++;
			}
			if (i==0) {
				System.out.println("You are alone in this room");
				playGame(room,map);
			}else {
				System.out.println("With whom do you want to interact ? ( -1 : do nothing) ");
				int charChoice = getInput();
				if (charChoice == -1) {
					playGame(room,map);
				}else if (charChoice > i-1) {
					System.out.println("You tried to talk to a person, but he vanished in the air. Maybe he was your hallucination... ");
					playGame(room,map);
				}else {
					printNpcActions(room.getNPCs().get(charChoice).getName());
					//Choosing NPC actions
					switch (getInput()) {
					case -1: 
						playGame(room,map);
						break;
					case 0:
						room.getNPCs().get(charChoice).inspect();
						playGame(room,map);
						break;
					case 1:
						room.getNPCs().get(charChoice).talk();
						playGame(room,map);
						break;
					case 2:
						if (room.getNPCs().get(charChoice).getFriendly()==true) {
							System.out.println("You are going to attack a friendly NPC. If you attack him he will be hostile to you. This action is irreversible.(Type -1 if you want to stop and attack, any other number otherwise");
						if (getInput()==-1)
							playGame(room,map);
						}
						
						
						room.getNPCs().get(charChoice).attacked(room.getPlayer());
						playGame(room, map);
						break;
					case 3:
						room.getNPCs().get(charChoice).persuade(room.getPlayer());
						playGame(room,map);
						break;
					default:
						System.out.println("You tried to perform ancient Zulu dance but "+ room.getNPCs().get(charChoice).getName() +" didn't respond. Maybe you should select more conventional action");
						playGame(room,map);
						break;
					}
					
				}
			}
		//Save/loading for cases 3-6
		case 3:
			this.quickSave(map);
			System.out.println("Game is saved");
			playGame(room,map);
			break;
		case 4:
			this.quickLoad();
			break;
		case 5:
			this.save(map);
			playGame(room,map);
			break;
		case 6:
			this.load(room,map);
			break;
		//Printing a "Map"
		case 7:
			map.printMap();
			playGame(room,map);
			break;
		default: 
			System.out.println("It seems you've chosen an incorrect action");
			playGame(room,map);
			break;
		
		}
	}
	//Two saves methods
	public void quickSave(GenerateMap map) throws IOException {
		Save quickSave = new Save();
		quickSave.quickSave(map);
	}
	public void save(GenerateMap map) throws IOException {
		Save quickSave = new Save();
		quickSave.save(map);
	}
	//Two load methods
	public void quickLoad() throws IOException, ClassNotFoundException{
		
	    GenerateMap map = new GenerateMap();
	    FileInputStream fis = new FileInputStream("src/main/java/nl/rug/oop/introduction/saves/quicksave.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    map = (GenerateMap) ois.readObject();
	    ois.close();
	    Room startRoom = new Room("");
	    for (Room allRoom:map.getRoom()) {
	    	if (allRoom.getPlayer()!=null){
	    		startRoom = allRoom;
	    	}
	    }
	    this.playGame(startRoom, map);
	}
	public void load(Room room, GenerateMap map ) throws ClassNotFoundException, IOException {
		File folder = new File("src/main/java/nl/rug/oop/introduction/saves/");
		File[] listOfFiles = folder.listFiles(new FilenameFilter(){
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".ser");
		    }
		});
		for (int i = 0; i < listOfFiles.length; i++) {
		   if (listOfFiles[i].isFile()) {
		        System.out.println("File "+"("+i+")" + listOfFiles[i].getName());
		   } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		   }
		System.out.println("Choose which file do you want to load(-1 to stay in this game)");
		int choice = getInput();
		if (choice ==-1) {
			this.playGame(room, map);
		}else if (choice>listOfFiles.length-1) {
			System.out.println("You chose incorrect file. Returning to main menu");
			this.playGame(room, map);
		}else {
			GenerateMap map2 = new GenerateMap();
			FileInputStream fis = new FileInputStream(listOfFiles[choice]);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    map2 = (GenerateMap) ois.readObject();
		    ois.close();
		    Room startRoom = new Room("");
		    for (Room allRoom:map2.getRoom()) {
		    	if (allRoom.getPlayer()!=null){
		    		startRoom = allRoom;
		    	}
		    }
		    this.playGame(startRoom, map2);
		}
	}
	
}
	
