import java.io.Serializable;

public class Door implements getThroughDoor,Serializable{

	private static final long serialVersionUID = 1L;
	private String description;
	private Room leadsTo;
	private Room leadsFrom;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Room getLeadsTo() {
		return leadsTo;
	}
	public void setLeadsTo(Room leadsTo) {
		this.leadsTo = leadsTo;
	}
	public Room getLeadsFrom() {
		return leadsFrom;
	}
	public void setLeadsFrom(Room leadsFrom) {
		this.leadsFrom = leadsFrom;
	}
	public Door(String description,Room from, Room to ) {
		this.description = description;
		this.leadsTo = to;
		this.leadsFrom = from; 
	}
	public Door(String description) {
		this.description = description;
	}
	@Override
	public Room getThrough(Room currentRoom) {
		Room a = this.getLeadsTo();
		Room b = this.getLeadsFrom();
		if (currentRoom.equals(a)){
			b.setPlayer(a.getPlayer());
			a.setPlayer(null);
			return b;
		}else {
			//change player location
			a.setPlayer(b.getPlayer());
			b.setPlayer(null);
			return a;
		}
		//Possible exception
		
	}

	
}
