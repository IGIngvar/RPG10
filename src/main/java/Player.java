import java.util.Random;

public class Player extends Character {

	Random rand = new Random();
	private int lockPick = rand.nextInt(10);
	
	
	public int getLockPick() {
		return lockPick;
	}


	public void setLockPick(int lockPick) {
		this.lockPick = lockPick;
	}


	public Player(String name) {
		super(name);
	}
	
}
