
import java.util.Random;

public class trapDoor extends Door implements getThroughDoor {
	public trapDoor(String description,Room from, Room to){
		super(description,from,to);
	}
	public String getDescription() {
		return super.getDescription()+". It seems that the door is trapped";
	}
	public Room getThrough(Room currentRoom) {
		Room a = this.getLeadsTo();
		Room b = this.getLeadsFrom();
		Random rand = new Random();
		if (currentRoom.equals(a)){
			
			//change player location
			
			b.setPlayer(a.getPlayer());
			b.getPlayer().setHealth(b.getPlayer().getHealth()-rand.nextInt(3));
			System.out.println("The door was trapped, you received some damage");
			a.setPlayer(null);
			return b;
		}else {
		
			//change player location
			a.setPlayer(b.getPlayer());
			a.getPlayer().setHealth(a.getPlayer().getHealth()-rand.nextInt(3));
			System.out.println("The door was trapped, you received some damage");
			b.setPlayer(null);
			return a;
		}
		//Possible exception
	}
}
