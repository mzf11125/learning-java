package model;

public class Goblin extends Entity{

	public Goblin(int hP, int baseDamage) {
		super(hP, baseDamage);
	}

	@Override
	public void attack(Entity e) {
		int randomizedDmg = e.takeDamage(this.getBaseDamage());
		System.out.println("  Goblin attack you for " + randomizedDmg + " HP");
	}


}
