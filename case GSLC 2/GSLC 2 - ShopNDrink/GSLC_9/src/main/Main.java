package main;

import java.util.Scanner;
import java.util.Vector;

import models.Coffee;
import models.Drink;
import models.SoftDrink;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	private Vector<Drink> drinks = new Vector<>();
	private final Scanner scan = new Scanner(System.in);
	
	private void AddDrink() {
		int type = 0;
		String name = "";
		int price = 0;
		String brand = "";
		double caffeine = 0;
		
		while(true) {
			System.out.println(" What kind of drink do you want to add?");
			System.out.println(" 1. Soft Drink");
			System.out.println(" 2. Coffee");
			System.out.print(" >> ");
			type = scan.nextInt(); scan.nextLine();
			if(!(type == 1 || type == 2)) {
				System.out.println(" Please input either 1 or 2");
				continue;
			}
			break;
		}
		System.out.println();
		
		while(true) {
			System.out.print(" Input drink name [> 3 characters long]: ");
			name = scan.nextLine();
			if(name.length() <= 3) {
				System.out.println(" Drink name must be > 3 characters long");
				continue;
			}
			break;
		}
		System.out.println();
		
		while(true) {
			System.out.print(" Input drink price [1.000 - 100.000]: ");
			price = scan.nextInt(); scan.nextLine();
			if(price < 1000 || price > 100000) {
				System.out.println(" Drink price must be 1.000 - 10.0000");
				continue;
			}
			break;
		}
		System.out.println();
		
		if(type == 1) {
			while(true) {
				System.out.print(" Input drink brand [must not be blank]: ");
				brand = scan.nextLine();
				if(brand.isBlank()) {
					System.out.println(" Drink brand must not be blank");
					continue;
				}
				break;
			}
			System.out.println();
		}
		else {
			while(true) {
				System.out.print(" Input drink caffeine [>= 10]: ");
				caffeine = scan.nextDouble(); scan.nextLine();
				if(caffeine < 10) {
					System.out.println(" Caffeine must be >= 10");
					continue;
				}
				break;
			}
			System.out.println();
		}
		
		System.out.println(" Successfully added new drink!");
		
		if(type == 1) {
			SoftDrink sd = new SoftDrink(name, price, brand);
			drinks.add(sd);
			sd.showDetails();
		}
		else {
			Coffee cf = new Coffee(name, price, caffeine);
			drinks.add(cf);
			cf.showDetails();
		}
		
		System.out.println();
		
	}
	
	private void DeleteDrink() {
		if(drinks.isEmpty()) {
			System.out.println(" There are no drinks yet!");
			return;
		}
		for(int i = 0; i < drinks.size(); i++) {
			System.out.printf(" %2d. ", i + 1);
			drinks.get(i).showDetails();
		}
		while(true) {
			System.out.printf(" Choose drink to delete [1 - %d]: ", drinks.size());
			int idx = scan.nextInt(); scan.nextLine();
			
			if(idx < 1 || idx > drinks.size()) {
				System.out.printf(" Choose between 1 - %d!\n", drinks.size());
				continue;
			}
			
			Drink drink = drinks.get(idx - 1);
			drinks.remove(idx - 1);
			System.out.println(" Successfully removed drink");
			drink.showDetails();
			System.out.println();
			break;
		}
	}
	
	private void MainMenu() {
		while(true) {
			System.out.println(" ShopNDrink");
			System.out.println(" 1. Add Drink");
			System.out.println(" 2. Delete Drink");
			System.out.println(" 3. Exit");
			System.out.print(" >> ");
			int input = scan.nextInt();
			System.out.println();
			
			switch (input) {
			case 3:
				return;
			case 2:
				DeleteDrink();
				break;
			case 1:
				AddDrink();
				break;
			default:
				break;
			}
		}
	}
	
	public Main() {
		MainMenu();
	}
	
}
