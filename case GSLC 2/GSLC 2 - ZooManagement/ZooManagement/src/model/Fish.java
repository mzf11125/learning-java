package model;

import interfaces.ICanSwim;

public class Fish extends Animal implements ICanSwim {
	public Fish(String name) {
	    super(name);
	}
	
	@Override
	public void makeSound() {
	    System.out.println(getName() + " does not make sound, it bubbles!");
	}
	
	@Override
	public void swim() {
	    System.out.println(getName() + " is swimming.");
	}
}

