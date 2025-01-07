package model;

public class Thief extends Entity implements AbleToSteal{

	public Thief(int hP, int baseDamage) {
		super(hP, baseDamage);
	}

	@Override
	public void attack(Entity e) {
		int randomizedDmg = e.takeDamage(this.getBaseDamage());
		System.out.println("  Thief attack you for " + randomizedDmg + " HP");
	}

	@Override
	public boolean stealWeapon(Player p) {
		if(p.getCurrentItem() == null) return false;
		p.removeItem();
		return true;
	}


}
