
public class lockedDoor extends Door{
	
	public lockedDoor(String description,Room from, Room to){
		super(description,from,to);
	}
	public String getDescription() {
		return super.getDescription()+". It seems that the door is locked";
	}
	public Room getThrough(Room currentRoom) {
		Room a = this.getLeadsTo();
		Room b = this.getLeadsFrom();
		//Random rand = new Random();
		if (currentRoom.getPlayer().getLockPick()<0) {
			System.out.println("You don't have a lockpick for this door");
			return currentRoom;
		}
		if (currentRoom.equals(a)){
			
			//change player location
			
			b.setPlayer(a.getPlayer());
			b.getPlayer().setLockPick(b.getPlayer().getLockPick()-1);
			a.setPlayer(null);
			return b;
		}else {
		
			//change player location
			a.setPlayer(b.getPlayer());
			a.getPlayer().setLockPick(a.getPlayer().getLockPick()-1);
			b.setPlayer(null);
			return a;
		}
		//Possible exception
	}
}
