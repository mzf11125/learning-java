package main;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.ICanFly;
import interfaces.ICanSwim;
import model.Animal;
import model.Bird;
import model.Fish;
import model.Lion;


public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Animal> animals = new ArrayList<>();

    private void createAnimal() {
        System.out.println("\n=== Create Animal ===");
        System.out.println("1. Lion");
        System.out.println("2. Fish");
        System.out.println("3. Bird");
        int choice = -1;
        do {
        	System.out.print("Choose an animal to create (Enter number, or 0 to go back): ");
        	choice = -1;
        	try {
        		choice = scanner.nextInt();
        		scanner.nextLine();
        	} catch (Exception e) {
        		scanner.nextLine();
        		continue;
        	}
        	if (choice == 0) return;
        	if (choice >= 1 && choice <= 3) {
                break;
            }
		} while (true);

        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();

        Animal animal = null;
        switch (choice) {
            case 1:
                animal = new Lion(name);
                break;
            case 2:
                animal = new Fish(name);
                break;
            case 3:
                animal = new Bird(name);
                break;
            default:
                System.out.println("Invalid type. Animal not created.");
                return;
        }

        animals.add(animal);
        System.out.println(name + " has been added to the zoo.");
    }

    private void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("\nNo animals in the zoo.");
            return;
        }

        System.out.println("\n=== Animals in the Zoo ===");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).getName());
        }

        int choice = -1;
        do {
        	System.out.print("Choose an animal to interact with (Enter number, or 0 to go back): ");
        	choice = -1;
        	try {
        		choice = scanner.nextInt();
        		scanner.nextLine();
        	} catch (Exception e) {
        		scanner.nextLine();
        		continue;
        	}
        	if (choice == 0) return;
        	if (choice >= 1 && choice <= animals.size()) {
                break;
            }
		} while (true);

        Animal selectedAnimal = animals.get(choice - 1);
        System.out.println("\nInteracting with " + selectedAnimal.getName());
        selectedAnimal.makeSound();
        if (selectedAnimal instanceof ICanSwim) {
            ((ICanSwim) selectedAnimal).swim();
        }
        if (selectedAnimal instanceof ICanFly) {
            ((ICanFly) selectedAnimal).fly();
        }
    }

    private void deleteAnimal() {
        if (animals.isEmpty()) {
            System.out.println("\nNo animals to delete.");
            return;
        }

        System.out.println("\n=== Delete Animal ===");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).getName());
        }

        int choice = -1;
        do {
        	System.out.print("Choose an animal to delete (Enter number, or 0 to go back): ");
        	choice = -1;
        	try {
        		choice = scanner.nextInt();
        		scanner.nextLine();
        	} catch (Exception e) {
        		scanner.nextLine();
        		continue;
        	}
        	if (choice == 0) return;
        	if (choice >= 1 && choice <= animals.size()) {
                break;
            }
		} while (true);

        Animal removedAnimal = animals.remove(choice - 1);
        System.out.println(removedAnimal.getName() + " has been removed from the zoo.");
    }
    
    

    public static void main(String[] args) {
    	new Main();
    }

    public Main() {
        while (true) {
            System.out.println("\n\n=== Zoo Management Menu ===");
            System.out.println("1. Create Animal");
            System.out.println("2. View All Animals");
            System.out.println("3. Delete Animal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = -1;
            try {
            	choice = scanner.nextInt();
            	scanner.nextLine();
			} catch (Exception e) {
				scanner.nextLine();
				continue;
			}

            switch (choice) {
                case 1:
                    createAnimal();
                    break;
                case 2:
                    viewAnimals();
                    break;
                case 3:
                    deleteAnimal();
                    break;
                case 4:
                    System.out.println("Exiting Zoo Management. Goodbye!");
                    return;
                default:
                    break;
            }
        }
    }
}

