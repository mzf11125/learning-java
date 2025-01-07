package model;

public class Player extends Entity{
	
	private Item currentItem;
	private int startHP;
	public Player(int hP, int baseDamage) {
		super(hP, baseDamage);
		this.startHP = hP;
		this.currentItem = null;
	}

	public Item getCurrentItem() {
		return currentItem;
	}
	
	public void resetHP() {
		this.HP = this.startHP;
	}

	public void setCurrentItem(Item currentItem) {
		if (currentItem instanceof RingOfHealth) {
			this.startHP += 40;
		}
		this.currentItem = currentItem;
	}
	
	public void removeItem() {
		if(currentItem instanceof RingOfHealth) {
			HP = HP - 40;
			startHP -= 40;
		}
		
		this.currentItem = null;
	}

	@Override
	public void attack(Entity e) {
		int totalDamage = this.getBaseDamage();
		if (currentItem != null) {
			if (currentItem instanceof Excalibur) {
				totalDamage += totalDamage * 10 / 100;
			}
		}
		int randomizedDmg = e.takeDamage(totalDamage);
		System.out.println("  You hit the enemy for "+ randomizedDmg + " HP");
	}
	

	
}
