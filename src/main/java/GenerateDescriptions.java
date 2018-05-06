import java.util.ArrayList;
import java.util.List;

public class GenerateDescriptions{
	private List<String> roomDescriptions = new ArrayList<String>();
	private List<String> npcDescriptions = new ArrayList<String>();
	private List<String> doorDescriptions = new ArrayList<String>();
	
	public List<String> getRoomDescriptions() {
		return roomDescriptions;
	}
	public void setRoomDescriptions(List<String> roomDescriptions) {
		this.roomDescriptions = roomDescriptions;
	}
	public List<String> getNpcDescriptions() {
		return npcDescriptions;
	}
	public void setNpcDescriptions(List<String> npcDescriptions) {
		this.npcDescriptions = npcDescriptions;
	}
	public List<String> getDoorDescriptions() {
		return doorDescriptions;
	}
	public void setDoorescriptions(List<String> doorescriptions) {
		this.doorDescriptions = doorescriptions;
	}
	public void addRoomDescription(String s) {
		roomDescriptions.add(s);
	}
	public void addNPCDescription(String s) {
		npcDescriptions.add(s);
	}

	public void addDoorDescription(String s) {
		doorDescriptions.add(s);
	}
	public void addDescriptions() {
		this.addDoorDescription("Blue Door");
		this.addDoorDescription("Red Door");
		this.addDoorDescription("Black Door");
		this.addDoorDescription("Door with a skull");
		this.addDoorDescription("Ancient door");
		
		this.addNPCDescription("Sandro");
		this.addNPCDescription("Crag Hack");
		this.addNPCDescription("Solmir");
		this.addNPCDescription("Adelaide");
		this.addNPCDescription("Adela");
		this.addNPCDescription("Gelu");
		this.addNPCDescription("Cyra");
		this.addNPCDescription("Xsi");
		this.addNPCDescription("Loynis");
		
		this.addRoomDescription("Cove");
		this.addRoomDescription("Cave");
		this.addRoomDescription("Cemetry");
		this.addRoomDescription("Treasury");
		this.addRoomDescription("Library");
		this.addRoomDescription("Eating Hall");
	}
}
