package main;

import animals.*;
import abilities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Animal> animals;
    private Scanner scanner;
    
    public Main() {
        animals = new ArrayList<>();
        scanner = new Scanner(System.in);
        start(); // Call start method in constructor
    }
    
    public static void main(String[] args) {
        new Main(); // Create an instance to start the program
    }
    
    public void start() {
        while (true) {
            displayMainMenu();
            int choice = getValidInput(1, 4);
            
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
                    System.out.println("Goodbye!");
                    scanner.close(); // Close the scanner to prevent resource leak
                    return;
            }
        }
    }
    
    private void displayMainMenu() {
        System.out.println("\nZoo Management System");
        System.out.println("1. Create Animal");
        System.out.println("2. View All Animals");
        System.out.println("3. Delete Animal");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private void createAnimal() {
        System.out.println("\nCreate Animal Menu");
        System.out.println("1. Lion");
        System.out.println("2. Bird");
        System.out.println("3. Fish");
        System.out.print("Enter your choice: ");
        
        int choice = getValidInput(1, 3);
        System.out.print("Enter animal name: ");
        String name = scanner.next();
        
        Animal newAnimal = switch (choice) {
            case 1 -> new Lion(name);
            case 2 -> new Bird(name);
            case 3 -> new Fish(name);
            default -> null;
        };
        
        if (newAnimal != null) {
            animals.add(newAnimal);
            System.out.println(name + " has been added to the zoo!");
        }
    }
    
    private void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo!");
            return;
        }
        
        listAnimals();
        System.out.print("Select an animal to interact with (1-" + animals.size() + "): ");
        int choice = getValidInput(1, animals.size());
        
        Animal selected = animals.get(choice - 1);
        System.out.println("\nInteracting with " + selected.getName() + " the " + selected.getType());
        System.out.println("Sound: " + selected.makeSound());
        
        if (selected instanceof Flyable) {
            System.out.println("Action: " + ((Flyable) selected).fly());
        } else if (selected instanceof Swimmable) {
            System.out.println("Action: " + ((Swimmable) selected).swim());
        }
    }
    
    private void deleteAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals to delete!");
            return;
        }
        
        listAnimals();
        System.out.print("Select an animal to delete (1-" + animals.size() + "): ");
        int choice = getValidInput(1, animals.size());
        
        Animal removed = animals.remove(choice - 1);
        System.out.println(removed.getName() + " has been removed from the zoo!");
    }
    
    private void listAnimals() {
        System.out.println("\nAnimals in the zoo:");
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.println((i + 1) + ". " + animal.getName() + " the " + animal.getType());
        }
    }
    
    private int getValidInput(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); 
            }
        }
    }
}