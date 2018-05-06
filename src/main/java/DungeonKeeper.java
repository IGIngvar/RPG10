
public class DungeonKeeper extends NPC implements Actions {

	public DungeonKeeper(String name) {
		super(name);
		this.setHealth(this.getHealth()+10);
		this.setStrength(this.getStrength()+4);
		// TODO Auto-generated constructor stub
	}
	public void attacked(Player player) {
		// TODO Auto-generated method stub
		this.setHealth(this.getHealth()-player.getStrength());
		player.setHealth(player.getHealth()-this.getStrength());
		this.setFriendly(false);
		System.out.println("You've received: "+this.getStrength()+" damage");
		System.out.println("You've delt: "+player.getStrength()+ " damage");
		if (this.getHealth()<=0) {
			System.out.println("Congratulations, you've beat the dungeon keeper, but is seems that gods abondonded you. Botomless pit opened up right under your lefs. Rest in piece adventurer.");
			player.setHealth(0);
			player.setLockPick(player.getLockPick()+999);
		}
	}
	public void inspect() {
		// TODO Auto-generated method stub
		System.out.println("Dungeon Keeper usually brings most of the keys with him, but be careful attacking him may leed to a dire consequenceses");
		super.inspect();
		/*System.out.println("Name:" + this.getName());
		System.out.println("Health:" + this.getHealth());
		System.out.println("Strength:" + this.getStrength());
		System.out.println("Friendly:"+ this.getFriendly());*/
	}
}
