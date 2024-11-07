package main;

import java.util.Scanner;
import java.util.Vector;
import model.*; //Database query * = all

public class Main {
	Vector<toys> toysStore = new Vector<>();
	Vector<member> memberList = new Vector<>();
	Scanner scan = new Scanner(System.in);
	private logic logicInstance = new logic(); 
	
	public Main() {
		addDummy();
		int n = 0; 
		do {
			try {
				n = scan.nextInt();
				switch (n) {
				case 1:
					logicInstance.addNewMembers();
					break;
				case 2:
					logicInstance.addNewToys();
					break;
				case 3:
					logicInstance.borrow();
					break;
				case 4:
					logicInstance.displayAllToys();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Data type error");
			}
		} while (n < 5 || n > 1);
		scan.close();
	}

	public void addDummy() {
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	    toysStore.add(new onlineToys("1", "test", 100, "download"));
	}
	
	public static void main(String[] args) {
		new Main();//Sama
	}

}
