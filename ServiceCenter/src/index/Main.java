package index;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Vehicle> serviceHistory = new Vector<>(); //Service history vector
	Vector<Car> carVec = new Vector<>(); //Car vehicle vector
	Vector<Motorcycle> motorVec = new Vector<>(); //Motorcycle vehicle vector
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public void clrscr() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
	public void addLine(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public void dummyData() {
		carVec.add(new Car("D3453R", "Ken", "Ost", "normal"));
		carVec.add(new Car("B1212R", "Bryan Rein", "Mitsu", "normal"));
		carVec.add(new Car("B5554T", "Norman Osborn", "Rhein", "broken"));
		carVec.add(new Car("C3333N", "Gray", "Toho", "broken"));
		
		motorVec.add(new Motorcycle("V7777S", "Miya", "Rhein"));
		motorVec.add(new Motorcycle("H8843T", "Jackie", "Rhein"));
		motorVec.add(new Motorcycle("G444T", "Ted", "Ost"));
		motorVec.add(new Motorcycle("V333RM", "Tang Vie", "Toho"));
	}
	
	public void displayCars() {
		addLine(65);
		System.out.printf("|%s|%-10s|%-10s|%-20s|%-5s|%-10s|\n",	"No.","Vehicle","Plate No.","Owner","Brand","AC");
		addLine(65);
		for (int i = 0; i < carVec.size(); i++) {
			System.out.printf("|%2d.|%-10s|%-10s|%-20s|%-5s|%-10s|\n",
					i+1,
					"Car",
					carVec.get(i).getPlateNumber(),
					carVec.get(i).getOwnerName(),
					carVec.get(i).getBrandName(),
					carVec.get(i).getACStatus());				
		}
		addLine(65);
		System.out.println();
	}
	
	public void displayMotors() {
		addLine(54);
		System.out.printf("|%s|%-10s|%-10s|%-20s|%-5s|\n",	"No.","Vehicle","Plate No.","Owner","Brand");
		addLine(54);
		for (int i = 0; i < motorVec.size(); i++) {
			System.out.printf("|%2d.|%-10s|%-10s|%-20s|%-5s|\n",
					i+1,
					"Motorcycle",
					motorVec.get(i).getPlateNumber(),
					motorVec.get(i).getOwnerName(),
					motorVec.get(i).getBrandName());				
		}
		addLine(54);
		System.out.println();
	}
	
	public void newVehicle() {
		int n;
		String tPlate, tName, tBrand, tAC;
		System.out.println("Do you want to enter a car or a motorcycle?");
		System.out.println("1. Car");
		System.out.println("2. Motorcycle");
		System.out.print("Choose: ");
		n = scan.nextInt();
		scan.nextLine();			
		
		if (n == 1) {
			do {
				System.out.print("Enter car plate number[min length: 5|max length: 10]: ");
				tPlate = scan.nextLine();
			} while (tPlate.length()<5 || tPlate.length()>10);
			
			do {
				System.out.print("Enter car owner name[max length: 20]: ");
				tName = scan.nextLine();
			} while (tName.length()>20);
			
			do {
				System.out.print("Enter car brand name[Rhein|Mitsu|Toho|Ost]: ");
				tBrand = scan.nextLine();
			} while (!tBrand.equals("Rhein") && !tBrand.equals("Mitsu") && !tBrand.equals("Toho") && !tBrand.equals("Ost"));
			
			do {
				System.out.print("Enter car AC status[normal|broken]: ");
				tAC = scan.nextLine();
			} while (!tAC.equalsIgnoreCase("normal") && !tAC.equalsIgnoreCase("broken"));
			
			carVec.add(new Car(tPlate, tName, tBrand, tAC));
		} else {
			do {
				System.out.print("Enter motorcycle plate number[min length: 5|max length: 10]: ");
				tPlate = scan.nextLine();
			} while (tPlate.length()<5 || tPlate.length()>10);
			
			do {
				System.out.print("Enter motorcycle owner name[max length: 20]: ");
				tName = scan.nextLine();
			} while (tName.length()>20);
			
			do {
				System.out.print("Enter motorcycle brand name[Rhein|Mitsu|Toho|Ost]: ");
				tBrand = scan.nextLine();
			} while (!tBrand.equals("Rhein") && !tBrand.equals("Mitsu") && !tBrand.equals("Toho") && !tBrand.equals("Ost"));
			
			motorVec.add(new Motorcycle(tPlate, tName, tBrand));
		}
		System.out.println("Successfully entered new vehicle data!");
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	
	public void serviceVehicle() {
		int n;
		System.out.println("Do you want to service a car or a motorcycle?");
		System.out.println("1. Car");
		System.out.println("2. Motorcycle");
		System.out.print("Choose: ");
		n = scan.nextInt();
		scan.nextLine();			
		
		if (n == 1) {
			serviceHistory.add(carVec.get(0));
			carVec.remove(0);
		}
		else {
			serviceHistory.add(motorVec.get(0));
			motorVec.remove(0);
		}
		
		System.out.println("Successfully service a vehicle!");
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	
	public void viewHistory() {
		if(serviceHistory.size() == 0) {
			System.out.println("There is no service history..");
		}
		else {
			addLine(65);
			System.out.printf("|%s|%-10s|%-10s|%-20s|%-5s|%-10s|\n",	"No.","Vehicle","Plate No.","Owner","Brand","AC");
			addLine(65);
			for (int i = 0; i < serviceHistory.size(); i++) {
				if(serviceHistory.get(i) instanceof Car) {
					System.out.printf("|%2d.|%-10s|%-10s|%-20s|%-5s|%-10s|\n",
							i+1,
							"Car",
							serviceHistory.get(i).getPlateNumber(),
							serviceHistory.get(i).getOwnerName(),
							serviceHistory.get(i).getBrandName(),
							((Car)serviceHistory.get(i)).getACStatus());				
				}
				else {
					System.out.printf("|%2d.|%-10s|%-10s|%-20s|%-5s|\n",
							i+1,
							"Motorcycle",
							serviceHistory.get(i).getPlateNumber(),
							serviceHistory.get(i).getOwnerName(),
							serviceHistory.get(i).getBrandName());
				}
			}
			addLine(65);
		}
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	
	public Main() {
		int m;
		dummyData();
		do {
			clrscr();
			displayCars();
			displayMotors();
			System.out.println("1. Enter new vehicle to service");
			System.out.println("2. Service a vehicle");
			System.out.println("3. View service history");
			System.out.println("4. Exit");
			do {
				System.out.print("Choose: ");
				m = scan.nextInt();
				scan.nextLine();
			} while (m < 1 || m > 4);
			
			switch (m) {
			case 1:
				newVehicle();
				break;
			case 2:
				serviceVehicle();
				break;
			case 3:
				viewHistory();
				break;
			}
			
		} while (m != 4);
	}

}
