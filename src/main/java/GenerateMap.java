import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateMap implements Serializable	{
	
	private static final long serialVersionUID = 4L;
	private List<Room> room = new ArrayList<Room>();
	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}
	static int numberOfSkeletons = 0;
	
	public String getRandomItemFromList(List<String> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
	//Creating a dungeon
	public void generateMap(Room startRoom, int depthOfMap, GenerateDescriptions descriptions){
		int maxDepthOfMap = 5;
		Random rand = new Random();
		int n = rand.nextInt(3);
		if ((depthOfMap<2)&&(n==0)){
			n+=2;
		}
		Room[] newRoom = new Room[n];
		for (int i=0;i<n;i++) {
		    newRoom[i] = new Room(getRandomItemFromList(descriptions.getRoomDescriptions()));
			switch (rand.nextInt(2)) {
			case 0:
				Door door = new Door(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom[i]);
				newRoom[i].addDoor(door);
				startRoom.addDoor(door);
				break;
			case 1:
				Door door2 = new trapDoor(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom[i]);
				newRoom[i].addDoor(door2);
				startRoom.addDoor(door2);
				break;
			case 2:
				Door door3 = new lockedDoor(getRandomItemFromList(descriptions.getDoorDescriptions()),startRoom,newRoom[i]);
				newRoom[i].addDoor(door3);
				startRoom.addDoor(door3);
				break;
			}
			if (depthOfMap==0) {
				room.add(startRoom);
			}
			int m = rand.nextInt(3);
			for (int j=0; j < m; j++) {
				int l =rand.nextInt(2);
				switch(l) {
					case 0:
						NPC npc = new NPC(getRandomItemFromList(descriptions.getNpcDescriptions()));
						newRoom[i].addNPC(npc);
						break;
					case 1:
						Skeleton skel = new Skeleton("Skeleton"+numberOfSkeletons);
						numberOfSkeletons++;
						newRoom[i].addNPC(skel);
						break;
					case 2:
						DungeonKeeper dung =  new DungeonKeeper(getRandomItemFromList(descriptions.getNpcDescriptions()));
						newRoom[i].addNPC(dung);
						break;
				}
			}
			room.add(newRoom[i]);
			if (maxDepthOfMap > depthOfMap) {
				generateMap(newRoom[i],depthOfMap+1,descriptions);
			}
		}
	}
	public void printMap() {
			for (Room allRooms:room) {
				System.out.println("Description:" + allRooms.getDescription());
				System.out.println("Doors:" + allRooms.getDoors());
				System.out.println("NPCs:" + allRooms.getNPCs());
				if (allRooms.getPlayer()!=null) {
					System.out.println("IsPlayerHere:" + allRooms.getPlayer());
				}
				
			}
		
	}

	
}
	

