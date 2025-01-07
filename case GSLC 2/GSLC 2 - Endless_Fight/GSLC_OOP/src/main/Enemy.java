package main;

import java.util.ArrayList;
import java.util.Random;

import spell.DamageOverTime;

public class Enemy {
	
	Random rand = new Random();

	private String name;
	private int hp;
	private int dmg;
	private int reward;
	private ArrayList<DamageOverTime> dot;
	
	public Enemy(String name) {
		super();
		this.name = name;
		this.hp = (rand.nextInt(101)) + 100;
		this.dmg = (rand.nextInt(21)) + 10;
		this.reward = (rand.nextInt(31)) + 20;
		this.dot = new ArrayList<>();
	}
	
	public void takeDmg(int dmg) {
		System.out.println("The enemy took " + dmg + " dmg");
		this.hp -= dmg;
	}
	
	public void attack(Game game) {
		System.out.println("The enemy dealt " + this.dmg + " dmg to you!");
		game.hp -= this.dmg;
	}
	
	public void takeDOT() {
		for (int i = dot.size() - 1; i >= 0; i--) {
	        dot.get(i).applyDamageOverTime(this);
//	        System.out.print(dot.get(i).getClass().getSimpleName() + " ");
	        if (dot.get(i).getDuration() <= 0) {
	            dot.remove(i);
	        }
	    }
	    System.out.println();
	}
	
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public int getDmg() {
		return dmg;
	}
	public int getReward() {
		return reward;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public ArrayList<DamageOverTime> getDot() {
		return dot;
	}

	public void setDot(DamageOverTime dot) {
		this.dot.add(dot);
	}
}
