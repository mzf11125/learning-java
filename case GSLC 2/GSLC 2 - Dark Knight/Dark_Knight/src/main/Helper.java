package main;


public class Helper {
	
	
	public static void Menu() {
		System.out.println("  Dark Knight");
		System.out.println("  1. Play");
		System.out.println("  2. Exit");
		System.out.print("  >> ");
	}
	
	public static void gameDisplay(int pHP, int pDMG, String enemyName, int eHP) {
		System.out.println("  Your HP : " + pHP);
		System.out.println("  Your Damage : " + pDMG);
		System.out.println("  -------");
		System.out.println("  Enemy is : " + enemyName);
		System.out.println("  Enemy HP : " +eHP);
	}
	
	public static void cls() {
		for (int i = 0; i < 16; i++) {
			System.out.println("");
			
		}
	}

}
