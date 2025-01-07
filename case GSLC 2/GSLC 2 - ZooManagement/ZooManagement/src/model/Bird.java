package model;

import interfaces.ICanFly;

public class Bird extends Animal implements ICanFly {
	public Bird(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println(getName() + " chirps!");
	}
	
	@Override
	public void fly() {
		System.out.println(getName() + " is flying.");
	}
}

