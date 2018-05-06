import java.util.Random;

public class NPC extends Character implements Inspectable,Actions{
	
	private Boolean friendly=true;
	public Boolean getFriendly() {
		return friendly;
	}
	public void setFriendly(Boolean friendly) {
		this.friendly = friendly;
	}
	public NPC(String name) {
		super(name);
	}
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("Hi, my name is "+this.getName());
	}
	@Override
	public void attacked(Player player) {
		// TODO Auto-generated method stub
		this.setHealth(this.getHealth()-player.getStrength());
		player.setHealth(player.getHealth()-this.getStrength());
		this.setFriendly(false);
		System.out.println("You've received: "+this.getStrength()+" damage");
		System.out.println("You've delt: "+player.getStrength()+ " damage");
	}
	@Override
	public void persuade(Player player) {
		// TODO Auto-generated method stub
		System.out.println("You are trying to convince " + this.getName() + " that he doesn't need his lockpick");
		Random rand = new Random();
		if (rand.nextInt(10)>3) {
			player.setLockPick(player.getLockPick()+rand.nextInt(3));
			System.out.println("You convinced "+ this.getName() +" to share some of his lockpicks");
		}else {
			player.setHealth(getHealth()-this.getStrength()/2);
			System.out.println("You weren't very convincing and "+ this.getName()+ " punched you in the face. You received "+ this.getStrength()/2 +" damage");
		}
	}
	@Override
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("Name:" + this.getName());
		System.out.println("Health:" + this.getHealth());
		System.out.println("Strength:" + this.getStrength());
		System.out.println("Friendly:"+ this.getFriendly());
	}
}
