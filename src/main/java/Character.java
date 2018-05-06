
import java.io.Serializable;
import java.util.Random;

public class Character implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private String name;
	private int health;
	private int strength;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public Character(String name) {
		this.name = name;
		Random rand = new Random();
		this.health = rand.nextInt(15) + 10;
		this.strength = rand.nextInt(4) + 3;
	}
}	
