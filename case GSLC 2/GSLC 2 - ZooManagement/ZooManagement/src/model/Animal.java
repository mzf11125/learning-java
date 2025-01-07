package model;

abstract public class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }

    // methods
    public abstract void makeSound();
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public String getName() {
        return name;
    }
    
}

