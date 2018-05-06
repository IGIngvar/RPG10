
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Inspectable,Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String description;
	private List<Door> doors = new ArrayList<Door>();
	private List<NPC> NPCs = new ArrayList<NPC>();
	private Player player = null;
	
	public List<NPC> getNPCs() {
		return NPCs;
	}
	public void setNPCs(List<NPC> nPCs) {
		NPCs = nPCs;
	}
		
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Door> getDoors() {
		return doors;
	}
	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}
	
	public Room(String description) {
		this.description = description;
	}
	public void addDoor(Door d) {
		doors.add(d);
	}
	public void addNPC(NPC d) {
		NPCs.add(d);
	}
	@Override
	public void inspect() {
		System.out.println(description);
		
	}
	

	
	
}
