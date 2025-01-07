package main;

import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	

	public Main() {
		int input;
		String name; 
		do {
			Helper.Menu();
			input = scan.nextInt(); scan.nextLine();
			
			if (input==1) {
				// Play
				do {
					System.out.print("  Input name [>= 5]: ");
					name = scan.nextLine();
				} while (name.length() < 5);
				Helper.cls();
				new Game(name);
			}
			
		} while (input!=3);
	}

	public static void main(String[] args) {
		new Main();
	}

}
