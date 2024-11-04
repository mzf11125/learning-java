package main;

import java.util.Scanner;

public class Main {
	
	public Main() {
		Employee Fazle = new Employee("asu123", "Fazle", 500);
		Scanner scan = new Scanner(System.in);
		int nomor = 0;
		try {
			nomor = scan.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Bro, input the right data type");
			e.printStackTrace();
		}
		System.out.println("Nomor anda adalah: " + nomor);
		scan.next();
		scan.close();//Don't forget to close scan
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
