

public class Skeleton extends NPC implements Actions {
	
	public Skeleton(String name) {
		super(name);
		this.setFriendly(false);
		this.setHealth(this.getHealth()+5);
		this.setStrength(this.getStrength()/2);
		// TODO Auto-generated constructor stub
	}
	public void talk() {
		System.out.println("You tried to talk with skeleton, but he was not responding");
	}
	public void persuade(Player player) {
		System.out.println("You are not very smart, are you?");
	}
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("Skeletons have a lot of health, but they are weaker than other monsters");
		super.inspect();
		/*System.out.println("Name:" + this.getName());
		System.out.println("Health:" + this.getHealth());
		System.out.println("Strength:" + this.getStrength());
		System.out.println("Friendly:"+ this.getFriendly());*/
	}
}