package main;

import model.*;

public class logic extends Main {
    public void displayAllMember() {
        for (int i = 0; i < memberList.size(); i++) {
            System.out.printf("|%s|%s|%s|", memberList.get(i).getName(), memberList.get(i).getID(), memberList.get(i).getUserStorage());
        }
    }
    public void displayAllToys() {
            for (int i = 0; i < toysStore.size(); i++) {
            	if(toysStore.get(i) instanceof onlineToys) {
            		System.out.printf("|%s|%s|", toysStore.get(i).getCode(), toysStore.get(i).getTitle());
            	}
            	else {
            		System.out.printf("|%s|%s|%d|", toysStore.get(i).getCode(), toysStore.get(i).getTitle(), ((physicalToys)toysStore.get(i)).getAvailableCopies());
            	}
            }
    }

    public void addNewMembers() {
        System.out.println("Enter new member details:");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("ID: ");
        String id = scan.nextLine();
        scan.nextLine(); // consume newline character

        member newMember = new member(name, id, null);
        memberList.add(newMember);
        System.out.println("New member added successfully!");
    }

    public void addNewToys() {
        int n = 0;
        System.out.println("What type of toys do you want to add?");
        System.out.println("1. Physical toys");
        System.out.println("2. Online toys");
        n = scan.nextInt();
        scan.nextLine(); // consume newline character

        switch (n) {
            case 1:
                addNewPhysicalToys();
                break;
            case 2:
                addNewOnlineToys();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public void addNewPhysicalToys() {
        System.out.print("Enter new physical toy name: ");
        String name = scan.nextLine();
        System.out.print("Enter toy ID: ");
        String id = scan.nextLine();
        System.out.print("Enter available copies: ");
        int copies = scan.nextInt();
        scan.nextLine(); // consume newline character

        physicalToys newToy = new physicalToys(name, id, copies);
        toysStore.add(newToy);
        System.out.println("New physical toy added successfully!");
    }

    public void addNewOnlineToys() {
        System.out.print("Enter new online toy name: ");
        String name = scan.nextLine();
        System.out.print("Enter toy ID: ");
        String id = scan.nextLine();
        System.out.print("Enter toys file size: ");
        int toysFileSize = scan.nextInt();
        System.out.print("Enter download link: ");
        String downloadLink = scan.next();
        scan.nextLine(); 

        onlineToys newToy = new onlineToys(id, name, toysFileSize, downloadLink);
        toysStore.add(newToy);
        System.out.println("New online toy added successfully!");
    }
    public void borrow() {
        System.out.println("Enter member details:");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("ID: ");
        String id = scan.nextLine();

        // Validate member
        member borrowingMember = null;
        for (member m : memberList) {
            if (m.getName().equals(name) && m.getID().equals(id)) {
                borrowingMember = m;
                break;
            }
        }

        if (borrowingMember == null) {
            System.out.println("Invalid member name or ID.");
            return;
        }

        // Check if member has already borrowed 2 toys
        if (borrowingMember.getUserStorage().size() >= 2) {
            System.out.println("Member has already borrowed the maximum of 2 toys.");
            return;
        }

        // Add toy to member's storage
        System.out.print("Enter toy code: ");
        String toyCode = scan.nextLine();
        boolean toyFound = false;
        for (toys t : toysStore) {
            if (t.getCode().equals(toyCode)) {
                borrowingMember.getUserStorage().add(t);
                toyFound = true;
                break;
            }
        }

        if (!toyFound) {
            System.out.println("Toy with the given code not found.");
            return;
        }

        System.out.println("Toy borrowed successfully!");
    }

}