package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import spell.FireBall;
import spell.HealthDrain;
import spell.PoisonMist;
import spell.Spell;
import spell.ThunderBolt;

public class Game {

	public int hp;
	public int score = 0;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	Enemy enemy = null;
	private ArrayList<String> enemyNames;
	private ArrayList<Spell> spells = new ArrayList<>();
	
	public Game() {
		hp = 100;
		
		generateAllSpell();
		
		while(hp > 0) {
			if(enemy == null) enemy = generateEnemy();
			else {
				if(!checkEnemy(enemy)) {
					System.out.println(enemy.getName() + " Has Been Slain!");
					this.score += enemy.getReward();
					enemy = null;
					continue;
				}
				
				enemy.attack(this);
				enemy.takeDOT();
				if(!checkEnemy(enemy)) {
					System.out.println(enemy.getName() + " Has Been Slain!");
					this.score += enemy.getReward();
					enemy = null;
					continue;
				}
			}
			
			if(hp <= 0) break;
			
			System.out.println("=====================");
			System.out.println(enemy.getName());
			System.out.println("Enemy HP: " + enemy.getHp());
			System.out.println("=====================");
			System.out.println("Score: " + this.score);
			System.out.println("Your HP: " + this.hp);
			System.out.println("1. Cast Spell");
			System.out.println("2. Give Up");
			int choose = 0;
			choose = scan.nextInt(); scan.nextLine();
			
			if(choose == 1) {
				Spell currSpell = spells.get(rand.nextInt(spells.size()));
				System.out.println("Casting " + currSpell.getName());
				currSpell.castSpell(enemy, this);
			}
			else if(choose == 2) break;
			else System.out.println("You missed your chance to attack!!");
		}
		System.out.println("YOU DIED!");
		System.out.println("GAME ENDED WITH SCORE: " + this.score);
	}
	
	public Enemy generateEnemy() {
		enemyNames = new ArrayList<>(Arrays.asList(
	            "Goblin", "Orc", "Troll", "Dragon", "Zombie",
	            "Vampire", "Werewolf", "Slime", "Skeleton", "Witch"
	        ));
		System.out.println("Summoning a new one");
		String randomName = enemyNames.get(rand.nextInt(enemyNames.size()));
        return new Enemy(randomName);
	}
	
	public void generateAllSpell() {
		spells.add(new FireBall(25, 2, 10));
		spells.add(new ThunderBolt(35));
		spells.add(new PoisonMist(5, 4, 25));
		spells.add(new HealthDrain(15));
	}
	
	public void heal(int heal) {
		System.out.println("Healing yourself for " + heal + " hp");
		hp += heal;
	}
	
	Boolean checkEnemy(Enemy e) {
		return e.getHp() > 0;
	}

}
