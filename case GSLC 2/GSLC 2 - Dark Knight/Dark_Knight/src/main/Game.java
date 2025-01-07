package main;

import java.util.Random;
import java.util.Scanner;

import model.Entity;
import model.Excalibur;
import model.Goblin;
import model.Player;
import model.RingOfHealth;
import model.Thief;

public class Game {
	private String name;
	private Player player;
	private Entity enemy;
	Scanner scan = new Scanner(System.in);
	private void init() {
		player = new Player(100, 20);
	}
	
	private void play() {
		String enemyName = "";
		System.out.println("  Welcome to Dark Knight, " + name);
		System.out.println("  Press Enter to continue...");
		scan.nextLine();
		Thief thief;
		
		while (player.getHP() > 0) {
			player.resetHP();
			Random rand = new Random();
			int randVal = rand.nextInt()%2;
			
			if (randVal == 0) {
				enemy = new Goblin(80, 20);
				enemyName = "Goblin";
			}else {
				enemy = new Thief(80, 15);
				enemyName = "Thief";
			}
			
			while(enemy.getHP() > 0 &&  player.getHP() > 0) {
				Helper.cls();
				Helper.gameDisplay(player.getHP(), player.getBaseDamage(), enemyName, enemy.getHP());
				
				if (enemy instanceof Thief) {
					
					randVal = rand.nextInt() % 4;
					if (randVal == 1) {
						thief = (Thief) enemy;
						boolean hehe = thief.stealWeapon(player);
						if (hehe) {
							System.out.println("  Oh no... Somehow you lost your weapon");
							System.out.println("  Press enter to continue...");
							scan.nextLine();
						}
					}
				}
				
				player.attack(enemy);
				enemy.attack(player);
				System.out.println("  Press enter to continue...");
				scan.nextLine();
			}
			randVal = rand.nextInt() % 4;
			if (randVal == 2 && player.getCurrentItem()==null) {
//			if (true && player.getCurrentItem()==null) {
				randVal = rand.nextInt() % 2;
				if (randVal == 0) {
					System.out.println("  You obtained Excalibur!");
					player.setCurrentItem(new Excalibur());
				}else {
					System.out.println("  You obtained Ring of Health!");
					player.setCurrentItem(new RingOfHealth());
				}
				System.out.println("  Press enter to continue...");
				scan.nextLine();
			}
			
		}
		System.out.println("  You died...");
		scan.nextLine();
		
	}

	public Game(String name) {
		super();
		this.name = name;
		this.init();
		this.play();
	}

}
