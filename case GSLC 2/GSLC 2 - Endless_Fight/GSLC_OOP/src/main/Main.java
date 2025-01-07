package main;

import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		Boolean runner = true;
		while(runner) {
			System.out.println("=====================");
			System.out.println("||  ENDLESS FIGHT  ||");
			System.out.println("=====================");
			System.out.println("1. START");
			System.out.println("2. Exit");
			System.out.print(">> ");
			int choose = 0;
			try {
				choose = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("Has to be a number");
				scan.nextLine();
			}
			switch(choose) {
				case 1:
					new Game();
					break;
				case 2:
					runner = false;
					break;
				default: break;
			}
		}
	}

}
